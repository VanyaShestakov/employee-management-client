package com.ivanshestakov.client.impl;

import com.ivanshestakov.client.EmployeeClient;
import com.ivanshestakov.entity.Employee;
import com.ivanshestakov.entity.ExceptionInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class EmployeeClientImpl implements EmployeeClient {

    private static final String EMPLOYEE_ENDPOINT = "http://localhost:8080/api/employees";

    private final RestTemplate restTemplate;

    @Autowired
    public EmployeeClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<String> get() {
        try {
            return restTemplate.exchange(EMPLOYEE_ENDPOINT, HttpMethod.GET, null, String.class);
        } catch (HttpStatusCodeException e) {
            return new ResponseEntity<>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public ResponseEntity<String> get(String id) {
        try {
            return restTemplate.exchange(EMPLOYEE_ENDPOINT + "/" + id, HttpMethod.GET, null, String.class);
        } catch (HttpStatusCodeException e) {
            return new ResponseEntity<String>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public ResponseEntity<String> put(Employee employee) {
        final var requestEntity = new HttpEntity<Employee>(employee);
        try {
            return restTemplate.exchange(EMPLOYEE_ENDPOINT, HttpMethod.PUT, requestEntity , String.class);
        } catch (HttpStatusCodeException e) {
            return new ResponseEntity<String>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    @Override
    public ResponseEntity<String> delete(String id) {
        try {
            return restTemplate.exchange(EMPLOYEE_ENDPOINT + "/" + id, HttpMethod.DELETE, null, String.class);
        } catch (HttpStatusCodeException e) {
            return new ResponseEntity<String>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }


}
