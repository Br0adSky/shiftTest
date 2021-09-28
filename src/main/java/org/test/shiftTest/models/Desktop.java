package org.test.shiftTest.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Desktop extends Products{

    private String formFactor;


    public Desktop(String serialNumber, String manufacturer, Integer price, Integer unitsInStock, String typeOfProduct) {
        super(serialNumber, manufacturer, price, unitsInStock, typeOfProduct);

    }

    public Desktop() {
    }

}
