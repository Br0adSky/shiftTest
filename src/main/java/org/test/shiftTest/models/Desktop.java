package org.test.shiftTest.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Desktop extends Products{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String formFactor;
    @OneToOne
    private ProductFeatures productFeatures;

    public Desktop() {
    }

    public Desktop(@NotBlank String formFactor, @NotNull ProductFeatures productFeatures) {
        this.formFactor = formFactor;
        this.productFeatures = productFeatures;
    }
}
