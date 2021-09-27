package org.test.shiftTest.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.shiftTest.models.HardDrive;
import org.test.shiftTest.models.Monitor;
import org.test.shiftTest.models.ProductFeatures;

@Repository
public interface MonitorRepo extends JpaRepository<Monitor, Long> {
    Monitor findMonitorByProductFeatures(ProductFeatures productFeatures);
}
