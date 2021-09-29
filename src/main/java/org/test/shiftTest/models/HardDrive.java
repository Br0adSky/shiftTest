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
public class HardDrive extends Products {

    @Positive(message = "Такого объема не существует")
    private Integer space;

    public HardDrive(Integer space) {
        this.space = space;
    }

    public HardDrive() {}
}
