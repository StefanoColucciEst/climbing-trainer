package com.climbingtrainer.assessment;

import java.time.LocalDateTime;
import java.util.List;

public record AssessmentDto(
    Long id,
    Long gripId,
    AssessmentType assessmentType,
    String customName,
    List<EntryDto> entries
) {
    public static AssessmentDto from(Assessment a) {
        return new AssessmentDto(
            a.getId(), a.getGrip().getId(), a.getAssessmentType(), a.getCustomName(),
            a.getEntries().stream().map(EntryDto::from).toList()
        );
    }

    public record EntryDto(
        Long id,
        Double resistanceKg,
        Double bodyWeightPct,
        Double resistanceLeftKg,
        Double resistanceRightKg,
        Double bodyWeightPctLeft,
        Double bodyWeightPctRight,
        Integer numberOfHangs,
        Double timeUnderTensionSeconds,
        Double bodyWeightKg,
        LocalDateTime recordedAt
    ) {
        public static EntryDto from(AssessmentEntry e) {
            return new EntryDto(
                e.getId(), e.getResistanceKg(), e.getBodyWeightPct(),
                e.getResistanceLeftKg(), e.getResistanceRightKg(),
                e.getBodyWeightPctLeft(), e.getBodyWeightPctRight(),
                e.getNumberOfHangs(), e.getTimeUnderTensionSeconds(),
                e.getBodyWeightKg(), e.getRecordedAt()
            );
        }
    }
}
