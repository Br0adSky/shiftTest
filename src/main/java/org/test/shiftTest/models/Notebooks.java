package org.test.shiftTest.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.Positive;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
public class Notebooks extends Products {

    @Positive(message = "Такого размера не существует")
    private Double dimensions;

    public Notebooks() {
    }

    public Notebooks(Double dimensions) {
        this.dimensions = dimensions;
    }
}
