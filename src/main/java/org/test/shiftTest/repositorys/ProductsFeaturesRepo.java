package org.test.shiftTest.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.shiftTest.models.ProductFeatures;

import java.util.List;

@Repository
public interface ProductsFeaturesRepo extends JpaRepository<ProductFeatures, Long> {
    List<ProductFeatures> findAllByTypeOfProduct(String typeOfProduct);

}
