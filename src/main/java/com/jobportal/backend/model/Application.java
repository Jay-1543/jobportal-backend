package com.jobportal.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "applications")
@Data
public class Application {

    @Id
    private String id;

    private String userId;
    private String jobId;
}