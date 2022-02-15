package com.ivanshestakov.client.impl;

import com.ivanshestakov.client.WorkClient;
import com.ivanshestakov.entity.BasicAuthCredentials;
import com.ivanshestakov.entity.Work;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class WorkClientImpl extends BaseClient<Work> implements WorkClient {

    @Autowired
    public WorkClientImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    protected String getEndpoint() {
        return "http://localhost:8080/api/works";
    }

    public ResponseEntity<String> get(String employeeId, String projectId) {
        try {
            return restTemplate.exchange(getEndpoint() + "/" + employeeId + "/" + projectId, HttpMethod.GET, null, String.class);
        } catch (HttpStatusCodeException e) {
            return new ResponseEntity<String>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    public ResponseEntity<String> delete(String employeeId, String projectId) {
        try {
            return restTemplate.exchange(getEndpoint() + "/" + employeeId + "/" + projectId, HttpMethod.DELETE, null, String.class);
        } catch (HttpStatusCodeException e) {
            return new ResponseEntity<String>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    public ResponseEntity<String> delete(String employeeId, String projectId, BasicAuthCredentials credentials) {
        final var requestEntity = new HttpEntity<String>(getHeadersForAuth(credentials));
        try {
            return restTemplate.exchange(getEndpoint() + "/" + employeeId + "/" + projectId, HttpMethod.DELETE, null, String.class);
        } catch (HttpStatusCodeException e) {
            return new ResponseEntity<String>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }
}
