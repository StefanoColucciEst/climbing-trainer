package com.climbingtrainer.assessment;

public record CreateEntryRequest(
    Double resistanceKg,
    Double bodyWeightPct,
    Double resistanceLeftKg,
    Double resistanceRightKg,
    Double bodyWeightPctLeft,
    Double bodyWeightPctRight,
    Integer numberOfHangs,
    Double timeUnderTensionSeconds,
    Double bodyWeightKg
) {}
