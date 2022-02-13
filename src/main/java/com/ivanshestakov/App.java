package com.ivanshestakov;

import com.ivanshestakov.client.EmployeeManagementClient;
import com.ivanshestakov.configuration.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        final var context = new AnnotationConfigApplicationContext(Config.class);
        final var client = context.getBean(EmployeeManagementClient.class);

        System.out.println(client.get());

    }
}
