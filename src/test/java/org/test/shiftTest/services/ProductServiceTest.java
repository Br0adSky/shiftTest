package org.test.shiftTest.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.test.shiftTest.models.Products;
import org.test.shiftTest.repositorys.DesktopRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService productService;
    @MockBean
    private DesktopRepo desktopRepo;
    @Test
    void addNewProduct(Model model) {
        Products product = new Products("1234","Huawei",500,4,"desktop");
        productService.addNewProduct(product,model);
        Assertions.assertTrue(desktopRepo.existsById(product.getProductId()));
    }
}