package org.example.controller;

import org.example.bean.Product;
import org.example.bean.ProductForm;
import org.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
@PropertySource("classpath:upload_file.properties")
public class ProductController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private IProductService productService;

    @GetMapping("/home")
    public String home(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "/list";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("productForm",new ProductForm());
        return "/create";
    }


    @PostMapping("/save")
    public String saveProduct(@ModelAttribute ProductForm productForm) {

        MultipartFile multipartFile = productForm.getImg();
        String fileName= multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(productForm.getImg().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Product product = new Product(productForm.getId(), productForm.getName(),
                productForm.getDescription(), fileName);
        productService.save(product);
        return "redirect:/product/home";
    }
}
