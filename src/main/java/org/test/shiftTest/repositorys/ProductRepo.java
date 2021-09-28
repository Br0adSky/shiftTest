package org.test.shiftTest.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.shiftTest.models.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products, Long> {
}
