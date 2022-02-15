package com.ivanshestakov.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee extends BaseEntity {

    private UUID id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String position;

    private String role;

    private UUID departmentId;

    private List<UUID> projectIds;

    public void addProjectId(UUID id) {
        if (projectIds == null) {
            projectIds = new ArrayList<>();
        }
        projectIds.add(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", position='" + position + '\'' +
                ", role='" + role + '\'' +
                ", departmentId=" + departmentId +
                ", projectsIds=" + projectIds +
                '}';
    }

}
