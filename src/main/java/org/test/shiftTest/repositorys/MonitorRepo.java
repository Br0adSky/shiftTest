package org.test.shiftTest.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.shiftTest.models.Monitor;

@Repository
public interface MonitorRepo extends JpaRepository<Monitor, Long> {

}
