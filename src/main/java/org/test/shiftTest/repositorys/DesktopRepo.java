package org.test.shiftTest.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.shiftTest.models.Desktop;

@Repository
public interface DesktopRepo extends JpaRepository<Desktop, Long> {

}
