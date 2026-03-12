package com.climbingtrainer.assessment;

import com.climbingtrainer.grip.Grip;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "assessments")
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grip_id", nullable = false)
    private Grip grip;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AssessmentType assessmentType;

    private String customName;

    @OneToMany(mappedBy = "assessment", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("recordedAt DESC")
    private List<AssessmentEntry> entries = new ArrayList<>();

    public Assessment() {}

    public Assessment(Grip grip, AssessmentType assessmentType, String customName) {
        this.grip = grip;
        this.assessmentType = assessmentType;
        this.customName = customName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Grip getGrip() { return grip; }
    public void setGrip(Grip grip) { this.grip = grip; }

    public AssessmentType getAssessmentType() { return assessmentType; }
    public void setAssessmentType(AssessmentType assessmentType) { this.assessmentType = assessmentType; }

    public String getCustomName() { return customName; }
    public void setCustomName(String customName) { this.customName = customName; }

    public List<AssessmentEntry> getEntries() { return entries; }
    public void setEntries(List<AssessmentEntry> entries) { this.entries = entries; }
}
