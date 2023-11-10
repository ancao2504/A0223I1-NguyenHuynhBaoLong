package org.example.controller;


import org.example.bean.Music;
import org.example.bean.MusicForm;
import org.example.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@PropertySource("classpath:upload_music.properties")
public class MusicController {
    @Autowired
    private IMusicService musicService;
    @Value("${file-upload}")
    private File fileUpload;


    @RequestMapping("/home")
    public String home(Model model) {
        List<Music> musicForm = musicService.findAll();
        model.addAttribute("musicForm",musicForm);
        return "/list";
    }
    @RequestMapping("/create")
    public String create(Model model, MusicForm musicForm) {
        model.addAttribute("musicForm",musicForm);
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MusicForm musicForm) {
        MultipartFile multipartFile =musicForm.getLink();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getLink().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Music music = new Music( musicForm.getName(), musicForm.getAuthor(),musicForm.getCategory(),fileName);
        musicService.save(music);
        return "redirect:/home";
    }

}
