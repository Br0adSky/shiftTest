package org.test.shiftTest.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.test.shiftTest.models.Desktop;
import org.test.shiftTest.models.Products;
import org.test.shiftTest.repositorys.ProductRepo;

@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService productService;
    @MockBean
    private ProductRepo<Desktop> desktopRepo;
    @Test
    void addNewProduct() {
        Products product = new Desktop("1234","Huawei",500,4,"desktop","desk");
        productService.addNewProduct(product, null);
    }
}