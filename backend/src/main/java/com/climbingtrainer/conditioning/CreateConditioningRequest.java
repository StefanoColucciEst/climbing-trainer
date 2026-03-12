package com.climbingtrainer.conditioning;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateConditioningRequest(
    @NotBlank String name,
    @NotNull ConditioningType conditioningType
) {}
