package com.ivanshestakov.client;

import com.ivanshestakov.entity.BasicAuthCredentials;
import com.ivanshestakov.entity.Department;
import com.ivanshestakov.entity.Employee;
import org.springframework.http.ResponseEntity;

public interface DepartmentClient {

    ResponseEntity<String> get();

    ResponseEntity<String> get(String id);

    ResponseEntity<String> put(Department entity);

    ResponseEntity<String> put(Department entity, BasicAuthCredentials credentials);

    ResponseEntity<String> post(Department entity);

    ResponseEntity<String> post(Department entity, BasicAuthCredentials credentials);

    ResponseEntity<String> delete(String id);

    ResponseEntity<String> delete(String id, BasicAuthCredentials credentials);
}
