package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Initializing Spring Application Context Container...");

        // Load the applicationContext.xml file from the classpath resources folder
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the configured BookService bean instance
        BookService service = context.getBean("bookService", BookService.class);

        // Run methods to verify everything is wired together cleanly
        service.processBookLoan();
    }
}