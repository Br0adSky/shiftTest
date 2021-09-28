package org.test.shiftTest.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.validation.constraints.Min;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Monitor extends Products {

    @Min(1)
    private Integer diagonal;


    public Monitor(Integer diagonal) {
        this.diagonal = diagonal;
    }

    public Monitor() {

    }
}
