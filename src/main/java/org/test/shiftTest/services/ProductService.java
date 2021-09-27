package org.test.shiftTest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.test.shiftTest.models.*;
import org.test.shiftTest.repositorys.*;

@Service
public class ProductService {
    private final ProductsFeaturesRepo productsFeaturesRepo;
    private final DesktopRepo desktopRepo;
    private final NotebookRepo notebookRepo;
    private final HardDriveRepo hardDriveRepo;
    private final MonitorRepo monitorRepo;

    @Autowired
    public ProductService(ProductsFeaturesRepo productsFeaturesRepo, DesktopRepo desktopRepo, NotebookRepo notebookRepo, HardDriveRepo hardDriveRepo, MonitorRepo monitorRepo) {
        this.productsFeaturesRepo = productsFeaturesRepo;
        this.desktopRepo = desktopRepo;
        this.notebookRepo = notebookRepo;
        this.hardDriveRepo = hardDriveRepo;
        this.monitorRepo = monitorRepo;
    }

    public void createNewProduct(Model model) {
        ProductFeatures productFeatures = new ProductFeatures();
        model.addAttribute("productFeatures", productFeatures);
    }

    public void addNewProduct(ProductFeatures productFeatures, Model model) {
        productsFeaturesRepo.save(productFeatures);
        Products products;
        switch (productFeatures.getTypeOfProduct()) {
            case "desktop":
                products = new Desktop();
                break;
            case "notebook":
                products = new Notebooks();
                break;
            case "hardDrive":
                products = new HardDrive();
                break;
            case "monitor":
                products = new Monitor();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + productFeatures.getTypeOfProduct());

        }
        products.setProductFeatures(productFeatures);
        model.addAttribute("product", products);
    }

    public void saveExtraFeatures(Products product) {
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
        model.addAttribute("products", productsFeaturesRepo.findAllByTypeOfProduct("desktop"));
    }

    public void replaceProducts(Model model) {
        model.addAttribute("products", productsFeaturesRepo.findAll());
    }

    public void editProduct(ProductFeatures productFeatures, Model model) {
        System.out.println(desktopRepo.findDesktopsByProductFeatures(productFeatures));
        model.addAttribute("productInEdit", productFeatures);
        Products product;
        if (monitorRepo.findMonitorByProductFeatures(productFeatures) != null) {
            product = monitorRepo.findMonitorByProductFeatures(productFeatures);
        } else if (notebookRepo.findNotebooksByProductFeatures(productFeatures) != null) {
            product = notebookRepo.findNotebooksByProductFeatures(productFeatures);
        } else if (desktopRepo.findDesktopsByProductFeatures(productFeatures) != null) {
            product = desktopRepo.findDesktopsByProductFeatures(productFeatures);
        } else {
            product = hardDriveRepo.findHardDriveByProductFeatures(productFeatures);
        }
        model.addAttribute("extraFeatureInEdit", product);

    }

    public void saveEditedProduct(ProductFeatures productFeatures) {
        productsFeaturesRepo.save(productFeatures);
    }
}
