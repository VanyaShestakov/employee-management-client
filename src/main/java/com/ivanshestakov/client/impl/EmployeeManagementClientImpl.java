package com.ivanshestakov.client.impl;

import com.ivanshestakov.client.EmployeeManagementClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeManagementClientImpl implements EmployeeManagementClient {

    private final RestTemplate restTemplate;

    @Autowired
    public EmployeeManagementClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity get() {
        return restTemplate.exchange("http://localhost:8080/api/employees", HttpMethod.GET, null, Object.class);
    }


}
