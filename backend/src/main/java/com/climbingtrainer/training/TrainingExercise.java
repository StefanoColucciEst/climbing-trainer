package com.climbingtrainer.training;

import jakarta.persistence.*;

@Entity
@Table(name = "training_exercises")
public class TrainingExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false)
    private TrainingSession session;

    private String name;
    private Integer sets;
    private Integer reps;
    private Double weightKg;
    private Integer durationSeconds;

    public TrainingExercise() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public TrainingSession getSession() { return session; }
    public void setSession(TrainingSession session) { this.session = session; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getSets() { return sets; }
    public void setSets(Integer sets) { this.sets = sets; }
    public Integer getReps() { return reps; }
    public void setReps(Integer reps) { this.reps = reps; }
    public Double getWeightKg() { return weightKg; }
    public void setWeightKg(Double weightKg) { this.weightKg = weightKg; }
    public Integer getDurationSeconds() { return durationSeconds; }
    public void setDurationSeconds(Integer durationSeconds) { this.durationSeconds = durationSeconds; }
}
