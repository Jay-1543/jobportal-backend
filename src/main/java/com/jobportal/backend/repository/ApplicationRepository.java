package com.jobportal.backend.repository;

import com.jobportal.backend.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ApplicationRepository extends MongoRepository<Application, String> {

    List<Application> findByUserId(String userId);

    boolean existsByUserIdAndJobId(
        String userId,
        String jobId
);
}