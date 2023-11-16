package org.example.controller;

import org.example.bean.Music;
import org.example.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("/list")
    public String home(Model model) {
        List<Music> musics = musicService.findAll();
        model.addAttribute("musics",musics);
        return "/list" ;
    }
}
