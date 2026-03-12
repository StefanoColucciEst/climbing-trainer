package com.climbingtrainer.assessment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {

    @Query("SELECT DISTINCT a FROM Assessment a LEFT JOIN FETCH a.entries WHERE a.grip.id = :gripId")
    List<Assessment> findByGripIdWithEntries(Long gripId);
}
