package com.example.demoproject2.controller;

import com.example.demoproject2.model.Product;
import com.example.demoproject2.model.Type;
import com.example.demoproject2.service.ProductService;
import com.example.demoproject2.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Controller
@Transactional
@RequiredArgsConstructor
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;
    private final TypeService typeService;

    @GetMapping("/{id}")
    public String showProduct(@PathVariable(value = "id") Long id, Model model) {
        if (!productService.productExists(id)) {
            return "redirect:/";
        }
        Optional<Product> product = productService.getOptionalProduct(id);
        ArrayList<Product> res = new ArrayList<>();
        product.ifPresent(res::add);
        model.addAttribute("title", "Info");
        model.addAttribute("product", res);
        return "productInfo";
    }

    @GetMapping("/save")
    public String showSaveProduct(Model model) {
        model.addAttribute("title", "Add new");
        Iterable<Type> types = typeService.getAllTypes();
        model.addAttribute("types", types);
        return "saveProductPage";
    }

    @PostMapping("/save")
    public String saveProduct(Model model,
                              @RequestParam String name,
                              @RequestParam Long typeId,
                              @RequestParam String desc,
                              @RequestParam int price) {
        Date now = Calendar.getInstance().getTime();
//        TODO: create check statement
        if (name.equals("") || desc.equals("") || price == 0) {
            throw new IllegalStateException();
        }
        Type type = typeService.findTypeById(typeId);

        Product product = new Product(
                null,
                name,
                type,
                desc,
                now,
                price,
                true);
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String showEditPage(@PathVariable(value = "id") Long id,
            Model model) {
        if (!productService.productExists(id)) {
            return "redirect:/";
        }
        model.addAttribute("title", "Edit info");
        Iterable<Type> types = typeService.getAllTypes();
        model.addAttribute("types", types);
        Optional<Product> optionalProduct = productService.getOptionalProduct(id);
        ArrayList<Product> res = new ArrayList<>();
        optionalProduct.ifPresent(res::add);
        model.addAttribute("product", res);
        return "editPage";
    }

    @PostMapping("/{id}/edit")
    public String editPageEditing(Model model,
                                  @PathVariable(value = "id") Long id,
                                  @RequestParam String name,
                                  @RequestParam Long typeId,
                                  @RequestParam String desc,
                                  @RequestParam int price,
                                  @RequestParam String isEnabled) {

        Product product = productService.getProduct(id);
        Type type = typeService.findTypeById(typeId);
        product.setName(name);
        product.setType(type);
        product.setDesc(desc);
        product.setPrice(price);
        if (isEnabled != null) product.setIsEnabled(!product.getIsEnabled());
        productService.saveProduct(product);
        return "redirect:/";
    }

}
