package org.test.shiftTest.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = org.test.shiftTest.models.Desktop.class, name = "desktop"),
        @JsonSubTypes.Type(value = Monitor.class, name = "monitor"),
        @JsonSubTypes.Type(value = HardDrive.class, name = "hardDrive"),
        @JsonSubTypes.Type(value = Notebooks.class, name = "notebook")
})
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

    private TypeOfProducts typeOfProduct;

    public Products() {
    }

    public Products(String serialNumber, String manufacturer, Integer price, Integer unitsInStock, TypeOfProducts typeOfProduct) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.unitsInStock = unitsInStock;
        this.typeOfProduct = typeOfProduct;
    }

}
