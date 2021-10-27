package com.example.demoproject2.controller;

import com.example.demoproject2.model.Product;
import com.example.demoproject2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

@Controller
@Transactional
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {

    private final ProductService productService;

    @GetMapping
    public String index() {
        return "redirect:api";
    }

    @GetMapping("api")
    public String showMain(Model model) {
        Iterable<Product> products = productService.getEnabledProducts();
        model.addAttribute("title", "Products");
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("api/about")
    public String showAbout(Model model) {
        model.addAttribute("title", "About");
        return "about";
    }

}
