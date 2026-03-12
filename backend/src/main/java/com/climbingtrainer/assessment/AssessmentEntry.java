package com.climbingtrainer.assessment;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "assessment_entries")
public class AssessmentEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assessment_id", nullable = false)
    private Assessment assessment;

    private Double resistanceKg;
    private Double bodyWeightPct;
    private Double resistanceLeftKg;
    private Double resistanceRightKg;
    private Double bodyWeightPctLeft;
    private Double bodyWeightPctRight;
    private Integer numberOfHangs;
    private Double timeUnderTensionSeconds;
    private Double bodyWeightKg;

    @Column(nullable = false)
    private LocalDateTime recordedAt;

    public AssessmentEntry() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Assessment getAssessment() { return assessment; }
    public void setAssessment(Assessment assessment) { this.assessment = assessment; }

    public Double getResistanceKg() { return resistanceKg; }
    public void setResistanceKg(Double resistanceKg) { this.resistanceKg = resistanceKg; }

    public Double getBodyWeightPct() { return bodyWeightPct; }
    public void setBodyWeightPct(Double bodyWeightPct) { this.bodyWeightPct = bodyWeightPct; }

    public Double getResistanceLeftKg() { return resistanceLeftKg; }
    public void setResistanceLeftKg(Double resistanceLeftKg) { this.resistanceLeftKg = resistanceLeftKg; }

    public Double getResistanceRightKg() { return resistanceRightKg; }
    public void setResistanceRightKg(Double resistanceRightKg) { this.resistanceRightKg = resistanceRightKg; }

    public Double getBodyWeightPctLeft() { return bodyWeightPctLeft; }
    public void setBodyWeightPctLeft(Double bodyWeightPctLeft) { this.bodyWeightPctLeft = bodyWeightPctLeft; }

    public Double getBodyWeightPctRight() { return bodyWeightPctRight; }
    public void setBodyWeightPctRight(Double bodyWeightPctRight) { this.bodyWeightPctRight = bodyWeightPctRight; }

    public Integer getNumberOfHangs() { return numberOfHangs; }
    public void setNumberOfHangs(Integer numberOfHangs) { this.numberOfHangs = numberOfHangs; }

    public Double getTimeUnderTensionSeconds() { return timeUnderTensionSeconds; }
    public void setTimeUnderTensionSeconds(Double timeUnderTensionSeconds) { this.timeUnderTensionSeconds = timeUnderTensionSeconds; }

    public Double getBodyWeightKg() { return bodyWeightKg; }
    public void setBodyWeightKg(Double bodyWeightKg) { this.bodyWeightKg = bodyWeightKg; }

    public LocalDateTime getRecordedAt() { return recordedAt; }
    public void setRecordedAt(LocalDateTime recordedAt) { this.recordedAt = recordedAt; }
}
