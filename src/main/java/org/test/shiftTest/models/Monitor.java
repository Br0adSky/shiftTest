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
@JsonTypeName("monitor")
public class Monitor extends Products {

    @Positive(message = "Такой диагонали не существует")
    private Integer diagonal;

    public Monitor(String serialNumber, String manufacturer, Integer price, Integer unitsInStock, TypeOfProducts typeOfProduct, Integer diagonal) {
        super(serialNumber, manufacturer, price, unitsInStock, typeOfProduct);
        this.diagonal = diagonal;
    }

    public Monitor() {
    }
}
