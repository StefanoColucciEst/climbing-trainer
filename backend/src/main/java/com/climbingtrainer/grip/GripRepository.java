package com.climbingtrainer.grip;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GripRepository extends JpaRepository<Grip, Long> {
    List<Grip> findByCategory(GripCategory category);
}
