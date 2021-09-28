package org.test.shiftTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.test.shiftTest.models.*;
import org.test.shiftTest.services.ProductService;

import javax.validation.Valid;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("chooseTypeOfProduct")
    public String chooseTOP(Model model, @RequestParam String typeOfProduct) {
        model.addAttribute("TOP", typeOfProduct);
        Products product;
        switch (typeOfProduct) {
            case "desktop":
                product = new Desktop();
                break;
            case "notebook":
                product = new Notebooks();
                break;
            case "hardDrive":
                product = new HardDrive();
                break;
            case "monitor":
                product = new Monitor();
                break;
            default:
                throw new IllegalStateException("Product has no type");
        }
        product.setTypeOfProduct(typeOfProduct);
        System.out.println(product.getClass());
        model.addAttribute("product", product);
        return "products/addNewProduct";
    }

    @GetMapping(("createNewProduct"))
    public String createNewProduct() {
        return "products/typeOfProduct";
    }

    @PostMapping("addNewProduct/desktop")
    public String saveDesktop(@Valid Desktop product, @RequestParam(required = false) Long Id, BindingResult bindingResult, Model model) {
        checkErrors(product, "product", bindingResult, model, "products/addNewProduct");
        productService.addNewProduct(product, Id);
        return "redirect:/";
    }

    @PostMapping("addNewProduct/notebook")
    public String saveNotebook(@Valid Notebooks product, @RequestParam(required = false) Long Id, BindingResult bindingResult, Model model) {
        checkErrors(product, "product", bindingResult, model, "products/addNewProduct");
        productService.addNewProduct(product, Id);
        return "redirect:/";
    }

    @PostMapping("addNewProduct/hardDrive")
    public String saveHardDrive(@Valid HardDrive product, @RequestParam(required = false) Long Id, BindingResult bindingResult, Model model) {
        checkErrors(product, "product", bindingResult, model, "products/addNewProduct");
        productService.addNewProduct(product, Id);
        return "redirect:/";
    }
    @PostMapping("addNewProduct/monitor")
    public String saveMonitor(@Valid Monitor product, @RequestParam(required = false) Long Id, BindingResult bindingResult, Model model) {
        checkErrors(product, "product", bindingResult, model, "products/addNewProduct");
        productService.addNewProduct(product, Id);
        return "redirect:/";
    }

    private String checkErrors(Products product, String productAttribute, BindingResult bindingResult,
                               Model model, String page) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("TOP", product.getTypeOfProduct());
            model.addAttribute(productAttribute, product);
            return page;
        }
        return null;
    }

    @GetMapping("editProduct/{Id}")
    public String editProduct(@PathVariable Long Id, Model model) {
        Products product = productService.searchById(Id);
        model.addAttribute("TOP", product.getTypeOfProduct());
        model.addAttribute("product", product);
        return "products/addNewProduct";
    }
}
