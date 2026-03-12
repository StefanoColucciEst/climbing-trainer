package com.climbingtrainer.grip;

import java.util.Set;

public record GripDto(
    Long id,
    String name,
    GripCategory category,
    HandMode handMode,
    Set<Finger> fingers,
    GripType gripType,
    Integer edgeDepthMm,
    EdgeType edgeType
) {
    public static GripDto from(Grip grip) {
        return new GripDto(
            grip.getId(), grip.getName(), grip.getCategory(),
            grip.getHandMode(), grip.getFingers(), grip.getGripType(),
            grip.getEdgeDepthMm(), grip.getEdgeType()
        );
    }
}
