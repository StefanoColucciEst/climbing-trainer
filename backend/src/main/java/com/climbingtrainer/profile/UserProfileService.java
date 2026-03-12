package com.climbingtrainer.profile;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile getProfile() {
        return userProfileRepository.findAll().stream().findFirst()
            .orElseGet(() -> {
                UserProfile profile = new UserProfile();
                profile.setName("Climber");
                profile.setBodyWeightKg(70.0);
                profile.setStreakDays(0);
                return userProfileRepository.save(profile);
            });
    }

    public UserProfile updateProfile(String name, Double bodyWeightKg) {
        UserProfile profile = getProfile();
        if (name != null) profile.setName(name);
        if (bodyWeightKg != null) profile.setBodyWeightKg(bodyWeightKg);
        return userProfileRepository.save(profile);
    }
}
