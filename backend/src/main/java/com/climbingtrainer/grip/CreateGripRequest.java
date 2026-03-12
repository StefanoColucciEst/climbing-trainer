package com.climbingtrainer.grip;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.Set;

public record CreateGripRequest(
    @NotBlank String name,
    @NotNull GripCategory category,
    @NotNull HandMode handMode,
    @NotNull Set<Finger> fingers,
    @NotNull GripType gripType,
    @NotNull @Positive Integer edgeDepthMm,
    @NotNull EdgeType edgeType
) {}
