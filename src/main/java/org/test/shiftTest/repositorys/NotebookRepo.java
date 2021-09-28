package org.test.shiftTest.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.shiftTest.models.Notebooks;

@Repository
public interface NotebookRepo extends JpaRepository<Notebooks, Long>{
}
