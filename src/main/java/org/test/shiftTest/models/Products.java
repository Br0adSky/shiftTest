package org.test.shiftTest.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@MappedSuperclass
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long productId;

    @NotBlank
    private String serialNumber;
    @NotBlank
    private String manufacturer;
    @Min(0)
    private Integer price;
    @Min(0)
    private Integer unitsInStock;

    private String typeOfProduct;

    public Products() {
    }

    public Products(String serialNumber, String manufacturer, Integer price, Integer unitsInStock, String typeOfProduct) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.unitsInStock = unitsInStock;
        this.typeOfProduct = typeOfProduct;
    }

}
