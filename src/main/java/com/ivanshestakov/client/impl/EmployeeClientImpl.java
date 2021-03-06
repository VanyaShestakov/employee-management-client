package com.ivanshestakov.client.impl;

import com.ivanshestakov.client.EmployeeClient;
import com.ivanshestakov.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class EmployeeClientImpl extends BaseClient<Employee> implements EmployeeClient {

    @Autowired
    public EmployeeClientImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    protected String getEndpoint() {
        return "http://localhost:8080/api/employees";
    }



}
