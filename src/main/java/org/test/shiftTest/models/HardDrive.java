package org.test.shiftTest.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.validation.constraints.Min;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class HardDrive extends Products {
    @Min(0)
    private Integer space;


    public HardDrive(Integer space) {
        this.space = space;
    }

    public HardDrive() {

    }
}
