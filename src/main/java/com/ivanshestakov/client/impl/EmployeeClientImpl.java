package com.ivanshestakov.client.impl;

import com.ivanshestakov.client.EmployeeClient;
import com.ivanshestakov.entity.BasicAuthCredentials;
import com.ivanshestakov.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

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
    public ResponseEntity<String> put(Employee employee, BasicAuthCredentials credentials) {
        final var requestEntity = new HttpEntity<Employee>(employee, getHeadersForAuth(credentials));
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

    @Override
    public ResponseEntity<String> delete(String id, BasicAuthCredentials credentials) {
        final var requestEntity = new HttpEntity<String>(getHeadersForAuth(credentials));
        try {
            return restTemplate.exchange(EMPLOYEE_ENDPOINT + "/" + id, HttpMethod.DELETE, requestEntity, String.class);
        } catch (HttpStatusCodeException e) {
            return new ResponseEntity<String>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    private HttpHeaders getHeadersForAuth(BasicAuthCredentials credentials) {
        final var headers = new HttpHeaders();
        final var token = Base64Utils
                        .encodeToString((credentials.getUsername() + ":" + credentials.getPassword())
                        .getBytes(StandardCharsets.UTF_8));
        headers.add("Authorization", "Basic " + token);
        return headers;
    }


}
