package org.test.shiftTest.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.shiftTest.models.Desktop;
import org.test.shiftTest.models.HardDrive;
import org.test.shiftTest.models.ProductFeatures;

@Repository
public interface HardDriveRepo extends JpaRepository<HardDrive, Long> {
    HardDrive findHardDriveByProductFeatures(ProductFeatures productFeatures);
}
