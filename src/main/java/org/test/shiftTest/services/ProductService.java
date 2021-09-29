package org.test.shiftTest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.test.shiftTest.models.*;
import org.test.shiftTest.repositorys.ProductRepo;

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

    public void saveProduct(Products product, Long id) {
        if (id != null && searchById(id) != null) {
            product.setProductId(searchById(id).getProductId());
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

    public void replaceDesktops(Model model) {
        model.addAttribute("products", desktopRepo.findByTypeOfProduct("desktop"));
    }

    public void replaceNotebooks(Model model) {
        model.addAttribute("products", notebookRepo.findByTypeOfProduct("notebook"));
    }

    public void replaceHardDrives(Model model) {
        model.addAttribute("products", hardDriveRepo.findByTypeOfProduct("hardDrive"));
    }

    public void replaceMonitors(Model model) {
        model.addAttribute("products", monitorRepo.findByTypeOfProduct("monitor"));
    }

    public void replaceProducts(Model model) {
        model.addAttribute("products", productRepo.findAll());
    }

    public Products searchById(Long id) {
        return productRepo.findById(id).get();
    }

    public void deleteProduct(Long productId) {
        productRepo.deleteById(productId);
    }
}
