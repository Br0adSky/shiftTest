package org.test.shiftTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.test.shiftTest.models.ProductFeatures;
import org.test.shiftTest.models.Products;
import org.test.shiftTest.services.ProductService;

import javax.validation.Valid;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(("createNewProduct"))
    public String createNewProduct(Model model) {
        productService.createNewProduct(model);
        return "products/addNewProduct";
    }

    @PostMapping("addNewProduct")
    public String addNewProduct(@Valid ProductFeatures productFeatures, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productFeatures", productFeatures);
            return "products/addNewProduct";
        }
        productService.addNewProduct(productFeatures, model);
        return "products/extraFeaturesPage";
    }

    @PostMapping("extraFeatures")
    public String extraFeatures(@Valid Products product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            return "products/extraFeaturesPage";
        }
        productService.saveExtraFeatures(product);
        return "redirect:/";
    }
}
