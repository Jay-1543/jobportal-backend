package com.jobportal.backend.service;

import com.jobportal.backend.model.Application;
import com.jobportal.backend.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(
            ApplicationRepository applicationRepository
    ) {
        this.applicationRepository = applicationRepository;
    }

    // Apply for a job
    public Application applyJob(
            Application application
    ) {

        boolean alreadyApplied =
                applicationRepository
                .existsByUserIdAndJobId(
                        application.getUserId(),
                        application.getJobId()
                );

        if (alreadyApplied) {
            throw new RuntimeException(
                    "Already Applied"
            );
        }

        return applicationRepository.save(
                application
        );
    }

    // Get all applications by user
    public List<Application> getAppliedJobs(
            String userId
    ) {
        return applicationRepository.findByUserId(
                userId
        );
    }
}