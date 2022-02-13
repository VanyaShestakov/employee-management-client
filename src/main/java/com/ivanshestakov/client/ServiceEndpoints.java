package com.ivanshestakov.client;

public enum ServiceEndpoints {
    GET_EMPLOYEES("test"),
    GET_DEPARTMENTS("test"),
    GET_PROJECTS("test");

    private final String endpoint;

    ServiceEndpoints(String endpoint) {
        this.endpoint = endpoint;
    }
}
