package org.test.shiftTest.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.shiftTest.models.HardDrive;

@Repository
public interface HardDriveRepo extends JpaRepository<HardDrive, Long> {

}
