package org.assignment_3_2_producer.repository;

import org.assignment_3_2_common_classes.entity.DVD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DVDRepository extends JpaRepository<DVD, Integer> {
}
