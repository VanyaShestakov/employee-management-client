package com.ivanshestakov.client;

import com.ivanshestakov.entity.BasicAuthCredentials;
import com.ivanshestakov.entity.Project;
import com.ivanshestakov.entity.Work;
import org.springframework.http.ResponseEntity;

public interface WorkClient {

    ResponseEntity<String> get();

    ResponseEntity<String> get(String employeeId, String projectId);

    ResponseEntity<String> put(Work entity);

    ResponseEntity<String> put(Work entity, BasicAuthCredentials credentials);

    ResponseEntity<String> delete(String employeeId, String projectId);

    ResponseEntity<String> delete(String employeeId, String projectId, BasicAuthCredentials credentials);
}
