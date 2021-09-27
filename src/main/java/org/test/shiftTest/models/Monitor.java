package org.test.shiftTest.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Monitor extends Products {
    @Id
    private Long id;
    @Min(1)
    private Integer diagonal;
    @OneToOne
    private ProductFeatures productFeatures;

    public Monitor(Integer diagonal, ProductFeatures productFeatures) {
        this.diagonal = diagonal;
        this.productFeatures = productFeatures;
    }

    public Monitor() {

    }
}
