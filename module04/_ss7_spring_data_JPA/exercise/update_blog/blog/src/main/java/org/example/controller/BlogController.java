package org.example.controller;

import org.example.bean.Blog;
import org.example.bean.BlogForm;
import org.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@PropertySource("classpath:upload_file.properties")
public class BlogController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private IBlogService blogService;

    @GetMapping("/blogs")
    public String home(Model model) {
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs", blogs);
        model.addAttribute("blog", new Blog());
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blogForm", new BlogForm());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("blogForm") BlogForm blogForm) {
        MultipartFile multipartFile = blogForm.getImg();
        String fileName= multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(blogForm.getImg().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
//        (String author, String title, String img, String description) {
        Blog blog =new Blog(blogForm.getAuthor(), blogForm.getTitle(),fileName, blogForm.getDate(),blogForm.getDescription());
        blogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/create";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable("id") int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/view";
    }

    @GetMapping("/{id}/delete")
    public String deleteForm(@PathVariable("id") int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("blog") Blog blog) {
        blogService.delete(blog.getId());
        return "redirect:/blogs";
    }

    @GetMapping("/search")
    public String search(@ModelAttribute("blog") Blog blog, Model model){
        List<Blog> blogs=blogService.fillByTitle(blog.getTitle());
        model.addAttribute("blogs",blogs);
        return "/search";
    }

}
