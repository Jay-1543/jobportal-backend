package com.jobportal.backend.service;

import com.jobportal.backend.model.Job;
import com.jobportal.backend.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    // Get all jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Add new job
    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    // Get job by id
    public Job getJobById(String id) {
        return jobRepository.findById(id).orElse(null);
    }

    // Delete job
    public void deleteJob(String id) {
        jobRepository.deleteById(id);
    }
}