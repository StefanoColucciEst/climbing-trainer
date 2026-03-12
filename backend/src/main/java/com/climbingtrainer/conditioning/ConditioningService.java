package com.climbingtrainer.conditioning;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ConditioningService {

    private final ConditioningRepository conditioningRepository;

    public ConditioningService(ConditioningRepository conditioningRepository) {
        this.conditioningRepository = conditioningRepository;
    }

    public List<ConditioningExercise> findAll() {
        return conditioningRepository.findAllWithEntries();
    }

    public ConditioningExercise create(String name, ConditioningType type) {
        return conditioningRepository.save(new ConditioningExercise(name, type));
    }

    public ConditioningEntry addEntry(Long exerciseId, Double resistanceKg, Double bodyWeightPct,
                                       Integer maxReps, Double bodyWeightKg) {
        ConditioningExercise exercise = conditioningRepository.findById(exerciseId)
            .orElseThrow(() -> new RuntimeException("Exercise not found: " + exerciseId));

        ConditioningEntry entry = new ConditioningEntry();
        entry.setExercise(exercise);
        entry.setResistanceKg(resistanceKg);
        entry.setBodyWeightPct(bodyWeightPct);
        entry.setMaxReps(maxReps);
        entry.setBodyWeightKg(bodyWeightKg);
        entry.setRecordedAt(LocalDateTime.now());

        exercise.getEntries().add(entry);
        conditioningRepository.save(exercise);
        return entry;
    }
}
