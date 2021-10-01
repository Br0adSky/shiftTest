package org.test.shiftTest.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.Positive;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
@JsonTypeName("hardDrive")
public class HardDrive extends Products {

    @Positive(message = "Такого объема не существует")
    private Integer space;

    public HardDrive(String serialNumber, String manufacturer, Integer price, Integer unitsInStock, TypeOfProducts typeOfProduct, Integer space) {
        super(serialNumber, manufacturer, price, unitsInStock, typeOfProduct);
        this.space = space;
    }

    public HardDrive() {
    }
}
