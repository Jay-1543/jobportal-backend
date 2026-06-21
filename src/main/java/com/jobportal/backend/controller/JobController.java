package com.jobportal.backend.controller;

import com.jobportal.backend.model.Job;
import com.jobportal.backend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin("*")
public class JobController {

    @Autowired
    private JobService jobService;

    // Get all jobs
    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    // Add new job
    @PostMapping
    public Job addJob(@RequestBody Job job) {
        return jobService.addJob(job);
    }

    // Get job by id
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable String id) {
        return jobService.getJobById(id);
    }

    // Update job
    @PutMapping("/{id}")
    public Job updateJob(
            @PathVariable String id,
            @RequestBody Job job) {

        job.setId(id);

        return jobService.addJob(job);
    }

    // Delete job
    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable String id) {

        jobService.deleteJob(id);

        return "Job Deleted Successfully";
    }
}