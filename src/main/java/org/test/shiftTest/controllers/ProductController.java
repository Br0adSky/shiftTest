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

    @GetMapping("editProduct/{Id}")
    public String editProduct(@PathVariable Long Id, Model model) {
        Products product = productService.searchById(Id);
        model.addAttribute("TOP", product.getTypeOfProduct());
        model.addAttribute("product", product);
        return "products/addNewProduct";
    }

    @GetMapping("deleteProduct/{Id}")
    public String deleteProduct(@PathVariable Long Id, Model model) {
        Products product = productService.searchById(Id);
        model.addAttribute("product", product);
        return "products/deleteProduct";
    }
    @PostMapping("submitDelete")
    public String submitDelete(@RequestParam Long productId){
        productService.deleteProduct(productId);
        return "redirect:/";
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
        model.addAttribute("product", product);
        return "products/addNewProduct";
    }

    @GetMapping(("createNewProduct"))
    public String createNewProduct() {
        return "products/typeOfProduct";
    }

    @PostMapping("addNewProduct/desktop")
    public String saveDesktop(@RequestParam(required = false) Long Id,
                              @Valid Desktop product,BindingResult bindingResult, Model model) {
        return checkErrors(product, bindingResult, model, "product",
                "products/addNewProduct", "redirect:/", Id);
    }

    @PostMapping("addNewProduct/notebook")
    public String saveNotebook(@Valid Notebooks product, BindingResult bindingResult,
                               Model model, @RequestParam(required = false) Long Id) {
        return checkErrors(product, bindingResult, model, "product",
                "products/addNewProduct", "redirect:/", Id);
    }

    @PostMapping("addNewProduct/hardDrive")
    public String saveHardDrive(@Valid HardDrive product, BindingResult bindingResult, Model model, @RequestParam(required = false) Long Id) {
        return checkErrors(product, bindingResult, model, "product",
                "products/addNewProduct", "redirect:/", Id);
    }

    @PostMapping("addNewProduct/monitor")
    public String saveMonitor(@Valid Monitor product, BindingResult bindingResult, Model model, @RequestParam(required = false) Long Id) {
        return checkErrors(product, bindingResult, model, "product",
                "products/addNewProduct", "redirect:/", Id);
    }

    public String checkErrors(@Valid Products product, BindingResult bindingResult, Model model,
                              String productAttribute, String errorPage, String mainPage, Long id) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("TOP", product.getTypeOfProduct());
            model.addAttribute(productAttribute, product);
            return errorPage;
        }
        productService.saveProduct(product, id);
        return mainPage;
    }
}
