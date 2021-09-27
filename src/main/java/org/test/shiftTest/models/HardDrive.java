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
public class HardDrive extends Products {
    @Id
    private Long id;
    @Min(0)
    private Integer space;
    @OneToOne
    private ProductFeatures productFeatures;

    public HardDrive(Integer space, ProductFeatures productFeatures) {
        this.space = space;
        this.productFeatures = productFeatures;
    }

    public HardDrive() {

    }
}
