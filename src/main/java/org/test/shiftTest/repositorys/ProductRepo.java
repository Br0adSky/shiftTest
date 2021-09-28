package org.test.shiftTest.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.shiftTest.models.Products;

import java.util.List;

@Repository
public interface ProductRepo<T extends Products> extends JpaRepository<T, Long> {
    List<T> findByTypeOfProduct(String typeOfProduct);
}
