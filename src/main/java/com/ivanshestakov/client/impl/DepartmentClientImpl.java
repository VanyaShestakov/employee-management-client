package com.ivanshestakov.client.impl;

import com.ivanshestakov.client.DepartmentClient;
import com.ivanshestakov.entity.BaseEntity;
import com.ivanshestakov.entity.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class DepartmentClientImpl extends BaseClient<Department> implements DepartmentClient {

    @Autowired
    public DepartmentClientImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    protected String getEndpoint() {
        return "http://localhost:8080/api/departments";
    }
}
