package com.climbingtrainer.conditioning;

public record CreateConditioningEntryRequest(
    Double resistanceKg,
    Double bodyWeightPct,
    Integer maxReps,
    Double bodyWeightKg
) {}
