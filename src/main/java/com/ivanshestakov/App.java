package com.ivanshestakov;

import com.ivanshestakov.client.EmployeeClient;
import com.ivanshestakov.configuration.Config;
import com.ivanshestakov.entity.BasicAuthCredentials;
import com.ivanshestakov.entity.ExceptionInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;
import java.util.UUID;

import static com.ivanshestakov.util.JsonUtils.toObject;

@Slf4j
public class App {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final var context = new AnnotationConfigApplicationContext(Config.class);
        final var client = context.getBean(EmployeeClient.class);
        final var response =
                client.delete("83490f09-a187-4f44-9df2-e1887000fb5d",
                        BasicAuthCredentials.builder()
                                .password("1234")
                                .username("vanechka")
                                .build());

        if (response.getStatusCode().value() != 204) {
            final var exceptionInfo = toObject(response.getBody(), ExceptionInfo.class);
            System.out.println(exceptionInfo);
        }

        log.info(response.getStatusCode().toString());
    }

    private static void displayMenu() {
        while (true) {
            System.out.println
                    ("Department CRUD operations\n" +
                    "1 : [GET]    /api/departments - Get list of all departments\n" +
                    "2 : [GET]    /api/departments{id} - Get department by id\n" +
                    "3 : [POST]   /api/departments - Create department\n" +
                    "4 : [PUT]    /api/departments - Update department\n" +
                    "5 : [DELETE] /api/departments - Delete department\n" +
                    "\n" +
                    "Employee CRUD operations\n" +
                    "6 : [GET]    /api/employees - Get list of all employees\n" +
                    "7 : [GET]    /api/employees{id} - Get employee by id\n" +
                    "8 : [PUT]    /api/employees - Update employee\n" +
                    "9 : [DELETE] /api/employees - Delete employee\n" +
                    "\n" +
                    "Project CRUD operations\n" +
                    "10: [GET]    /api/projects - Get list of all projects\n" +
                    "11: [GET]    /api/projects{id} - Get project by id\n" +
                    "12: [POST]   /api/projects - Create project\n" +
                    "13: [PUT]    /api/projects - Update project\n" +
                    "14: [DELETE] /api/projects - Delete project\n" +
                    "\n" +
                    "Work CRUD operations\n" +
                    "15: [GET]    /api/works - Get list of all works\n" +
                    "16: [GET]    /api/works/empId={empId}/projId={projId} - Get work by employee id and project id\n" +
                    "17: [PUT]    /api/works - Update work\n" +
                    "18: [DELETE] /api/works/empId={empId}/projId={projId} - Delete work\n" +
                    "\n" +
                    "Authorization\n" +
                    "[POST] /api/register - Register employee\n" +
                    "[POST] /api/reset-password - Reset password of employee");
            break;
        }
    }
}
