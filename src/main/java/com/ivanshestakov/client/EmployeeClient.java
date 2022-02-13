package com.ivanshestakov.client;

import com.ivanshestakov.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface EmployeeClient {

    ResponseEntity<String> get();

    ResponseEntity<String> get(String id);

    ResponseEntity<String> put(Employee employee);

    ResponseEntity<String> delete(String id);
}
