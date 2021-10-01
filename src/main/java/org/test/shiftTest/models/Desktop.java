package org.test.shiftTest.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@JsonTypeName("desktop")
public class Desktop extends Products {

    @Enumerated(EnumType.STRING)
    private FormFactor formFactor;

    public Desktop(String serialNumber, String manufacturer, Integer price, Integer unitsInStock, TypeOfProducts typeOfProduct, FormFactor formFactor) {
        super(serialNumber, manufacturer, price, unitsInStock, typeOfProduct);
        this.formFactor = formFactor;

    }
    public Desktop() {}

}
