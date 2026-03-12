package com.climbingtrainer.conditioning;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "conditioning_entries")
public class ConditioningEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private ConditioningExercise exercise;

    private Double resistanceKg;
    private Double bodyWeightPct;
    private Integer maxReps;
    private Double bodyWeightKg;

    @Column(nullable = false)
    private LocalDateTime recordedAt;

    public ConditioningEntry() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ConditioningExercise getExercise() { return exercise; }
    public void setExercise(ConditioningExercise exercise) { this.exercise = exercise; }

    public Double getResistanceKg() { return resistanceKg; }
    public void setResistanceKg(Double resistanceKg) { this.resistanceKg = resistanceKg; }

    public Double getBodyWeightPct() { return bodyWeightPct; }
    public void setBodyWeightPct(Double bodyWeightPct) { this.bodyWeightPct = bodyWeightPct; }

    public Integer getMaxReps() { return maxReps; }
    public void setMaxReps(Integer maxReps) { this.maxReps = maxReps; }

    public Double getBodyWeightKg() { return bodyWeightKg; }
    public void setBodyWeightKg(Double bodyWeightKg) { this.bodyWeightKg = bodyWeightKg; }

    public LocalDateTime getRecordedAt() { return recordedAt; }
    public void setRecordedAt(LocalDateTime recordedAt) { this.recordedAt = recordedAt; }
}
