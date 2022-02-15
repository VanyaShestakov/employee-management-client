package com.ivanshestakov.client;

import com.ivanshestakov.entity.BaseEntity;
import com.ivanshestakov.entity.BasicAuthCredentials;
import com.ivanshestakov.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface EmployeeClient {

    ResponseEntity<String> get();

    ResponseEntity<String> get(String id);

    ResponseEntity<String> put(Employee entity);

    ResponseEntity<String> put(Employee entity, BasicAuthCredentials credentials);

    ResponseEntity<String> delete(String id);

    ResponseEntity<String> delete(String id, BasicAuthCredentials credentials);
}
