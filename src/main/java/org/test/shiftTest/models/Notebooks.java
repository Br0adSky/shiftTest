package org.test.shiftTest.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Notebooks extends Products {
    @NotBlank
    private String dimensions;


    public Notebooks() {
    }

    public Notebooks(@NotBlank String dimensions) {
        this.dimensions = dimensions;

    }
}
