package org.test.shiftTest.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.shiftTest.models.Desktop;
import org.test.shiftTest.models.ProductFeatures;

import java.util.List;

@Repository
public interface DesktopRepo extends JpaRepository<Desktop, Long> {
    Desktop findDesktopsByProductFeatures(ProductFeatures productFeatures);
}
