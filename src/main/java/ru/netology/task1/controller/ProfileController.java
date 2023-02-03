package ru.netology.task1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.task1.service.SystemProfile;

@RestController
@RequestMapping("/")
public class ProfileController {
    private final SystemProfile profile;

    public ProfileController(SystemProfile profile) {
        this.profile = profile;
    }

    @GetMapping("profile")
    public String getProfile() {
        return profile.getProfile();
    }

    @GetMapping("read")
    public String readInfo() {
        return "See read info";
    }

    @GetMapping("write")
    public String writeInfo() {
        return "Write info";
    }
}
