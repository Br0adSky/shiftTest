package org.test.shiftTest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.test.shiftTest.models.*;
import org.test.shiftTest.repositorys.*;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService {
    private final DesktopRepo desktopRepo;
    private final NotebookRepo notebookRepo;
    private final HardDriveRepo hardDriveRepo;
    private final MonitorRepo monitorRepo;
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo, DesktopRepo desktopRepo, NotebookRepo notebookRepo, HardDriveRepo hardDriveRepo, MonitorRepo monitorRepo) {
        this.desktopRepo = desktopRepo;
        this.notebookRepo = notebookRepo;
        this.hardDriveRepo = hardDriveRepo;
        this.monitorRepo = monitorRepo;
        this.productRepo = productRepo;

    }

    public void saveProducts(Products product) {
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

    public void addNewProduct(Products product, Model model) {
        Products productEF = new Products();
        switch (product.getTypeOfProduct()) {
            case "desktop":
//                productEF = new Desktop(product.getSerialNumber(),product.getManufacturer(),product.getPrice(),product.getUnitsInStock(),
//                product.getTypeOfProduct());
                product = (Desktop) product;
                break;
            case "notebook":
                notebookRepo.save((Notebooks) product);
                break;
            case "hardDrive":
                hardDriveRepo.save((HardDrive) product);
                break;
            case "monitor":
                monitorRepo.save((Monitor) product);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + product.getTypeOfProduct());
        }
        model.addAttribute("productEF", product);
    }


    public void replaceDesktops(Model model) {
        model.addAttribute("products", desktopRepo.findAll());
    }

    public void replaceProducts(Model model) {
        model.addAttribute("products", Stream.of(desktopRepo.findAll(), notebookRepo.findAll(),
                        hardDriveRepo.findAll(), monitorRepo.findAll())
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
    }


//    public void saveEditedProduct(ProductFeatures productFeatures) {
//        productsFeaturesRepo.save(productFeatures);
//    }
}
