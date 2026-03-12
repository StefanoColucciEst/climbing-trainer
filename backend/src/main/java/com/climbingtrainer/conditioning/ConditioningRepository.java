package com.climbingtrainer.conditioning;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ConditioningRepository extends JpaRepository<ConditioningExercise, Long> {

    @Query("SELECT DISTINCT e FROM ConditioningExercise e LEFT JOIN FETCH e.entries")
    List<ConditioningExercise> findAllWithEntries();
}
