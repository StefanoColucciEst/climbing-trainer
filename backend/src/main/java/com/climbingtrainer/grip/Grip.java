package com.climbingtrainer.grip;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "grips")
public class Grip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GripCategory category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HandMode handMode;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "grip_fingers", joinColumns = @JoinColumn(name = "grip_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "finger")
    private Set<Finger> fingers = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GripType gripType;

    @Column(nullable = false)
    private Integer edgeDepthMm;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EdgeType edgeType;

    public Grip() {}

    public Grip(String name, GripCategory category, HandMode handMode, Set<Finger> fingers,
                GripType gripType, Integer edgeDepthMm, EdgeType edgeType) {
        this.name = name;
        this.category = category;
        this.handMode = handMode;
        this.fingers = fingers;
        this.gripType = gripType;
        this.edgeDepthMm = edgeDepthMm;
        this.edgeType = edgeType;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public GripCategory getCategory() { return category; }
    public void setCategory(GripCategory category) { this.category = category; }

    public HandMode getHandMode() { return handMode; }
    public void setHandMode(HandMode handMode) { this.handMode = handMode; }

    public Set<Finger> getFingers() { return fingers; }
    public void setFingers(Set<Finger> fingers) { this.fingers = fingers; }

    public GripType getGripType() { return gripType; }
    public void setGripType(GripType gripType) { this.gripType = gripType; }

    public Integer getEdgeDepthMm() { return edgeDepthMm; }
    public void setEdgeDepthMm(Integer edgeDepthMm) { this.edgeDepthMm = edgeDepthMm; }

    public EdgeType getEdgeType() { return edgeType; }
    public void setEdgeType(EdgeType edgeType) { this.edgeType = edgeType; }
}
