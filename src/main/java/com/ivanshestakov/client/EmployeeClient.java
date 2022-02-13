package com.ivanshestakov.client;

import com.ivanshestakov.entity.BasicAuthCredentials;
import com.ivanshestakov.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface EmployeeClient {

    ResponseEntity<String> get();

    ResponseEntity<String> get(String id);

    ResponseEntity<String> put(Employee employee);

    ResponseEntity<String> put(Employee employee, BasicAuthCredentials credentials);

    ResponseEntity<String> delete(String id);

    ResponseEntity<String> delete(String id, BasicAuthCredentials credentials);
}
