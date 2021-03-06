package org.test.shiftTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.test.shiftTest.exception.SearchException;
import org.test.shiftTest.models.TypeOfProducts;
import org.test.shiftTest.services.ProductService;

@Controller
public class HomeController {
    private final ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("products",productService.replaceProducts());
        return "homePage";
    }

    @GetMapping(("replaceAllProducts/{type}"))
    public String replaceAllProducts(@PathVariable TypeOfProducts type, Model model) {
        model.addAttribute("products", productService.replaceByType(type));
        return "homePage";
    }
    @GetMapping("show/{Id}")
    public String show(Model model, @PathVariable Long Id) throws SearchException {
        model.addAttribute("chosenProduct",productService.searchById(Id));
        return "products/product";
    }


}
