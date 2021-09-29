package org.test.shiftTest.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long productId;

    @NotBlank(message = "Поле пустое или содержит пробелы")
    private String serialNumber;
    @NotBlank(message = "Поле пустое или содержит пробелы")
    private String manufacturer;
    @Positive(message = "Цена не может быть отрицательной или равной нулю")
    private Integer price;
    @PositiveOrZero(message = "Количество товаров не может быть отрицательным")
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
