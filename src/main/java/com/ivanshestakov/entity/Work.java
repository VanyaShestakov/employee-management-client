package com.ivanshestakov.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Work {

    private UUID employeeId;

    private UUID projectId;

    private LocalDate positionStartDate;

    private LocalDate positionEndDate;

    private Integer workingHours;

}
