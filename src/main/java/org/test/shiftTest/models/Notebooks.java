package org.test.shiftTest.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.test.shiftTest.services.DimensionsConverter;

import javax.persistence.Convert;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
@JsonTypeName("notebook")
public class Notebooks extends Products {

    @Convert(converter = DimensionsConverter.class)
    private Dimensions dimensions;

    public Notebooks() {
    }

    public Notebooks(String serialNumber, String manufacturer, Integer price, Integer unitsInStock, TypeOfProducts typeOfProduct, Dimensions dimensions) {
        super(serialNumber, manufacturer, price, unitsInStock, typeOfProduct);
        this.dimensions = dimensions;
    }

}
