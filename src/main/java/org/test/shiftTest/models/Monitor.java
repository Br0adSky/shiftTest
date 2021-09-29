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
public class Monitor extends Products {

    @Positive(message = "Такой диагонали не существует")
    private Integer diagonal;

    public Monitor(Integer diagonal) {
        this.diagonal = diagonal;
    }

    public Monitor() {}
}
