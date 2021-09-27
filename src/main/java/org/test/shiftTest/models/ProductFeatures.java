package org.test.shiftTest.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class ProductFeatures {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String serialNumber;
    @NotBlank
    private String manufacturer;
    @Min(0)
    private Integer price;
    @Min(0)
    private Integer unitsInStock;
    private String typeOfProduct;


    public ProductFeatures(@NotBlank String serialNumber, @NotBlank String manufacturer, @Min(0) Integer price, @Min(0) Integer unitsInStock, String typeOfProduct) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.unitsInStock = unitsInStock;
        this.typeOfProduct = typeOfProduct;
    }

    public ProductFeatures() {

    }
}
