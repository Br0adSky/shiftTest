package org.test.shiftTest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.shiftTest.exception.SearchException;
import org.test.shiftTest.models.*;
import org.test.shiftTest.repositorys.ProductRepo;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepo<Products> productRepo;
    private final ProductRepo<Desktop> desktopRepo;
    private final ProductRepo<Notebooks> notebookRepo;
    private final ProductRepo<HardDrive> hardDriveRepo;
    private final ProductRepo<Monitor> monitorRepo;

    @Autowired
    public ProductService(ProductRepo<Products> productRepo, ProductRepo<Desktop> desktopRepo, ProductRepo<Notebooks> notebookRepo,
                          ProductRepo<HardDrive> hardDriveRepo, ProductRepo<Monitor> monitorRepo) {
        this.productRepo = productRepo;
        this.desktopRepo = desktopRepo;
        this.notebookRepo = notebookRepo;
        this.hardDriveRepo = hardDriveRepo;
        this.monitorRepo = monitorRepo;

    }
    public Products createClass(TypeOfProducts typeOfProduct){
        Products product;
        switch (typeOfProduct) {
            case DESKTOP:
                product = new Desktop();
                break;
            case NOTEBOOK:
                product = new Notebooks();
                break;
            case HARD_DRIVE:
                product = new HardDrive();
                break;
            case MONITOR:
                product = new Monitor();
                break;
            default:
                throw new IllegalStateException("Product has no type");
        }
        product.setTypeOfProduct(typeOfProduct);
        return product;
    }

    public void saveProduct(Products product, Long id){
        if (id != 0L && searchById(id) != null) {
            product.setProductId(searchById(id).getProductId());
            System.out.println(product.getProductId());
        }

        if (product instanceof Monitor) {
            monitorRepo.save((Monitor) product);
            return;
        }
        if (product instanceof HardDrive) {
            hardDriveRepo.save((HardDrive) product);
            return;
        }
        if (product instanceof Desktop) {
            desktopRepo.save((Desktop) product);
            return;
        }
        if (product instanceof Notebooks) {
            notebookRepo.save((Notebooks) product);
        }
    }

    public List<Products> replaceProducts() {
        return productRepo.findAll();
    }
    public List<Products> replaceByType(TypeOfProducts type){
        return productRepo.findByTypeOfProduct(type);
    }

    public Products searchById(Long id) throws SearchException {
        return productRepo.findById(id).orElseThrow(()->new SearchException(id));
    }

    public void deleteProduct(Long productId) {
        productRepo.deleteById(productId);
    }
}
