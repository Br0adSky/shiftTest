package org.test.shiftTest.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Notebooks extends Products{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String dimensions;
    @OneToOne
    private ProductFeatures productFeatures;

    public Notebooks() {
    }

    public Notebooks(@NotBlank String dimensions, @NotNull ProductFeatures productFeatures) {
        this.dimensions = dimensions;
        this.productFeatures = productFeatures;
    }
}
