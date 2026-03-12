package com.climbingtrainer.conditioning;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "conditioning_exercises")
public class ConditioningExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConditioningType conditioningType;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("recordedAt DESC")
    private List<ConditioningEntry> entries = new ArrayList<>();

    public ConditioningExercise() {}

    public ConditioningExercise(String name, ConditioningType conditioningType) {
        this.name = name;
        this.conditioningType = conditioningType;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ConditioningType getConditioningType() { return conditioningType; }
    public void setConditioningType(ConditioningType conditioningType) { this.conditioningType = conditioningType; }

    public List<ConditioningEntry> getEntries() { return entries; }
    public void setEntries(List<ConditioningEntry> entries) { this.entries = entries; }
}
