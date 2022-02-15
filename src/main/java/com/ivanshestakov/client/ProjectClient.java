package com.ivanshestakov.client;

import com.ivanshestakov.entity.BasicAuthCredentials;
import com.ivanshestakov.entity.Department;
import com.ivanshestakov.entity.Project;
import org.springframework.http.ResponseEntity;

public interface ProjectClient {

    ResponseEntity<String> get();

    ResponseEntity<String> get(String id);

    ResponseEntity<String> put(Project entity);

    ResponseEntity<String> put(Project entity, BasicAuthCredentials credentials);

    ResponseEntity<String> post(Project entity);

    ResponseEntity<String> post(Project entity, BasicAuthCredentials credentials);

    ResponseEntity<String> delete(String id);

    ResponseEntity<String> delete(String id, BasicAuthCredentials credentials);
}
