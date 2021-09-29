package org.test.shiftTest.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class Desktop extends Products {

    @NotBlank(message = "Форм-фактор пустой или с пробелами")
    private String formFactor;

    public Desktop(String serialNumber, String manufacturer, Integer price, Integer unitsInStock, String typeOfProduct, String formFactor) {
        super(serialNumber, manufacturer, price, unitsInStock, typeOfProduct);
        this.formFactor = formFactor;

    }
    public Desktop() {}

    @AssertTrue(message = "Уберите символы или цифры из поля форм-фактора")
    public boolean isSymOrDig(){
        return formFactor.matches("[\\p{L}| ]+");
    }
}
