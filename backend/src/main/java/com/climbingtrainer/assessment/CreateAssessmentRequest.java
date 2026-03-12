package com.climbingtrainer.assessment;

import jakarta.validation.constraints.NotNull;

public record CreateAssessmentRequest(
    @NotNull AssessmentType assessmentType,
    String customName
) {}
