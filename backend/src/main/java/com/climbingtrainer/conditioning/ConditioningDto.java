package com.climbingtrainer.conditioning;

import java.time.LocalDateTime;
import java.util.List;

public record ConditioningDto(
    Long id,
    String name,
    ConditioningType conditioningType,
    List<EntryDto> entries
) {
    public static ConditioningDto from(ConditioningExercise e) {
        return new ConditioningDto(e.getId(), e.getName(), e.getConditioningType(),
            e.getEntries().stream().map(EntryDto::from).toList());
    }

    public record EntryDto(
        Long id,
        Double resistanceKg,
        Double bodyWeightPct,
        Integer maxReps,
        Double bodyWeightKg,
        LocalDateTime recordedAt
    ) {
        public static EntryDto from(ConditioningEntry e) {
            return new EntryDto(e.getId(), e.getResistanceKg(), e.getBodyWeightPct(),
                e.getMaxReps(), e.getBodyWeightKg(), e.getRecordedAt());
        }
    }
}
