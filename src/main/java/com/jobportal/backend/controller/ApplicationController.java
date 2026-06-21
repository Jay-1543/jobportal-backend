package com.jobportal.backend.controller;

import com.jobportal.backend.model.Application;
import com.jobportal.backend.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin("*")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    // Apply for a job
    @PostMapping
    public Application applyJob(@RequestBody Application application) {
        return applicationService.applyJob(application);
    }

    // Get all applied jobs by user
    @GetMapping("/user/{userId}")
    public List<Application> getAppliedJobs(@PathVariable String userId) {
        return applicationService.getAppliedJobs(userId);
    }
}