package com.climbingtrainer.profile;

import jakarta.persistence.*;

@Entity
@Table(name = "user_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double bodyWeightKg;
    private Integer streakDays;

    public UserProfile() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getBodyWeightKg() { return bodyWeightKg; }
    public void setBodyWeightKg(Double bodyWeightKg) { this.bodyWeightKg = bodyWeightKg; }
    public Integer getStreakDays() { return streakDays; }
    public void setStreakDays(Integer streakDays) { this.streakDays = streakDays; }
}
