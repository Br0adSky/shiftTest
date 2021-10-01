package org.test.shiftTest.controllers;

import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.test.shiftTest.exception.SearchException;
import org.test.shiftTest.models.Products;
import org.test.shiftTest.models.TypeOfProducts;
import org.test.shiftTest.services.ProductService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/product")
public class RestfulContr {
    private final ProductService productService;

    @Autowired
    public RestfulContr(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("show/{Id}")
    public Products show(@PathVariable Long Id){
        return productService.searchById(Id);
    }

    @DeleteMapping("{Id}")
    public void submitDelete(@PathVariable Long Id){
        productService.deleteProduct(Id);
    }
    @PostMapping("add")
    public void save(@Valid @RequestBody Products product) {
        productService.saveProduct(product, product.getProductId());
    }

    @PutMapping("edit")
    public void edit(@Valid @RequestBody Products product){
        productService.saveProduct(product, product.getProductId());
    }

    @GetMapping("replaceAll/{type}")
    public List<Products> replaceAll(@PathVariable TypeOfProducts type){
        return productService.replaceByType(type);
    }

    //Exception handling
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(SearchException.class)
    public  String handleSearchExceptions(
            SearchException ex) {
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidTypeIdException.class)
    public String handleJsonParseError(InvalidTypeIdException ex){
        return "Wrong field: "+ ex.getMessage();
    }
}
