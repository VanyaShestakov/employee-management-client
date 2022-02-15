package com.ivanshestakov.client.impl;

import com.ivanshestakov.client.ProjectClient;
import com.ivanshestakov.entity.Project;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ProjectClientImpl extends BaseClient<Project> implements ProjectClient {

    @Autowired
    public ProjectClientImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    protected String getEndpoint() {
        return "http://localhost:8080/api/projects";
    }

}
