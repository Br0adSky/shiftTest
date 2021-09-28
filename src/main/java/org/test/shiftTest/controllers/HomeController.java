package org.test.shiftTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        productService.replaceProducts(model);
        return "homePage";
    }

    @PostMapping(("replaceAllDesktops"))
    public String replaceAllDesktops(Model model) {
        productService.replaceDesktops(model);
        return "homePage";
    }
    @PostMapping(("replaceAllNotebooks"))
    public String replaceAllNotebooks(Model model) {
        productService.replaceNotebooks(model);
        return "homePage";
    }
    @PostMapping(("replaceAllMonitors"))
    public String replaceAllMonitors(Model model) {
        productService.replaceMonitors(model);
        return "homePage";
    }
    @PostMapping(("replaceAllHardDrives"))
    public String replaceAllHardDrives(Model model) {
        productService.replaceHardDrives(model);
        return "homePage";
    }


}
