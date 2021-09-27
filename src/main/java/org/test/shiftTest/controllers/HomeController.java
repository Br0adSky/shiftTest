package org.test.shiftTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.test.shiftTest.models.ProductFeatures;
import org.test.shiftTest.models.Products;
import org.test.shiftTest.services.ProductService;

import javax.validation.Valid;

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

    @GetMapping("editProduct/{productID}")
    public String editProduct(@PathVariable ProductFeatures productID, Model model) {
        productService.editProduct(productID, model);
        return "products/editProductPage";
    }

    @PostMapping("editProduct/saveEdited")
    public String editExtraFeature(@Valid ProductFeatures productFeatures, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productFeatures", productFeatures);
            return "products/editProductPage";
        }
        productService.saveEditedProduct(productFeatures);
        return "products/editExtraFeaturePage";
    }
    @PostMapping("editProduct/saveEditedExtraFeature")
    public String saveEdited(@Valid Products product, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("extraFeatureInEdit", product);
            return "products/editExtraFeaturePage";
        }
        productService.saveExtraFeatures(product);
        return "redirect:/";
    }
}
