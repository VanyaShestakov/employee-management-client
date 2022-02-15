package com.ivanshestakov.client.impl;

import com.ivanshestakov.client.DepartmentClient;
import com.ivanshestakov.client.EmployeeClient;
import com.ivanshestakov.entity.BaseEntity;
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
public abstract class BaseClient<T> {

    protected final RestTemplate restTemplate;

    @Autowired
    public BaseClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    protected abstract String getEndpoint();

    public ResponseEntity<String> get() {
        try {
            return restTemplate.exchange(getEndpoint(), HttpMethod.GET, null, String.class);
        } catch (HttpStatusCodeException e) {
            return new ResponseEntity<>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    public ResponseEntity<String> get(String id) {
        try {
            return restTemplate.exchange(getEndpoint() + "/" + id, HttpMethod.GET, null, String.class);
        } catch (HttpStatusCodeException e) {
            return new ResponseEntity<String>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    public ResponseEntity<String> put(T entity) {
        final var requestEntity = new HttpEntity<T>(entity);
        try {
            return restTemplate.exchange(getEndpoint(), HttpMethod.PUT, requestEntity , String.class);
        } catch (HttpStatusCodeException e) {
            return new ResponseEntity<String>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    public ResponseEntity<String> put(T entity, BasicAuthCredentials credentials) {
        final var requestEntity = new HttpEntity<T>(entity, getHeadersForAuth(credentials));
        try {
            return restTemplate.exchange(getEndpoint(), HttpMethod.PUT, requestEntity , String.class);
        } catch (HttpStatusCodeException e) {
            return new ResponseEntity<String>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    public ResponseEntity<String> post(T entity) {
        final var requestEntity = new HttpEntity<T>(entity);
        try {
            return restTemplate.exchange(getEndpoint(), HttpMethod.POST, requestEntity , String.class);
        } catch (HttpStatusCodeException e) {
            return new ResponseEntity<String>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    public ResponseEntity<String> post(T entity, BasicAuthCredentials credentials) {
        final var requestEntity = new HttpEntity<T>(entity, getHeadersForAuth(credentials));
        try {
            return restTemplate.exchange(getEndpoint(), HttpMethod.POST, requestEntity , String.class);
        } catch (HttpStatusCodeException e) {
            return new ResponseEntity<String>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    public ResponseEntity<String> delete(String id) {
        try {
            return restTemplate.exchange(getEndpoint() + "/" + id, HttpMethod.DELETE, null, String.class);
        } catch (HttpStatusCodeException e) {
            return new ResponseEntity<String>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    public ResponseEntity<String> delete(String id, BasicAuthCredentials credentials) {
        final var requestEntity = new HttpEntity<String>(getHeadersForAuth(credentials));
        try {
            return restTemplate.exchange(getEndpoint() + "/" + id, HttpMethod.DELETE, requestEntity, String.class);
        } catch (HttpStatusCodeException e) {
            return new ResponseEntity<String>(e.getResponseBodyAsString(), e.getStatusCode());
        }
    }

    protected HttpHeaders getHeadersForAuth(BasicAuthCredentials credentials) {
        final var headers = new HttpHeaders();
        final var token = Base64Utils
                        .encodeToString((credentials.getUsername() + ":" + credentials.getPassword())
                        .getBytes(StandardCharsets.UTF_8));
        headers.add("Authorization", "Basic " + token);
        return headers;
    }


}
