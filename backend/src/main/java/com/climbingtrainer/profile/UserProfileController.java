package com.climbingtrainer.profile;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profile")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping
    public UserProfile getProfile() {
        return userProfileService.getProfile();
    }

    @PutMapping
    public UserProfile updateProfile(@RequestBody UpdateProfileRequest request) {
        return userProfileService.updateProfile(request.name(), request.bodyWeightKg());
    }

    public record UpdateProfileRequest(String name, Double bodyWeightKg) {}
}
