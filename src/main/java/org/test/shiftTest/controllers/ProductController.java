package org.test.shiftTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        model.addAttribute("product", new Products());
        return "products/addNewProduct";
    }

    @PostMapping("addNewProduct")
    public String addNewProduct(@Valid Products product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            return "products/addNewProduct";
        }
        productService.addNewProduct(product, model);
        model.addAttribute("product", product);
        return "products/extraFeaturesPage";
    }

    @PostMapping("extraFeatures")
    public String extraFeatures(@Valid Products productEF, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("product", productEF);
            return "products/extraFeaturesPage";
        }
        productService.saveProducts(productEF);
        return "redirect:/";
    }
    @GetMapping("editProduct/{productID}")
    public String editProduct(@PathVariable Products productID, Model model) {
        model.addAttribute("productInEdit", productID);
        return "products/editProductPage";
    }

    @PostMapping("editProduct/saveEdited")
    public String editExtraFeature(@Valid Products product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productFeatures", product);
            return "products/editProductPage";
        }
        productService.saveProducts(product);
        return "products/editExtraFeaturePage";
    }
    @PostMapping("editProduct/saveEditedExtraFeature")
    public String saveEdited(@Valid Products product, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("extraFeatureInEdit", product);
            return "products/editExtraFeaturePage";
        }
        productService.saveProducts(product);
        return "redirect:/";
    }
}
