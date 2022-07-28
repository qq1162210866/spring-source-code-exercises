package com.psq.exercise;

import com.psq.exercise.service.UserService;
import com.spring.ComponentScan;
import com.spring.PengShiQuanApplicationContext;

@ComponentScan("com.psq.exercise.service")
public class SpringSourceCodeExerciseApplication {

    public static void main(String[] args) {

        PengShiQuanApplicationContext context = new PengShiQuanApplicationContext(SpringSourceCodeExerciseApplication.class);
        UserService userService = (UserService) context.getBean("userService");

        UserService userService1 = (UserService) context.getBean("userService");

        UserService userService2 = (UserService) context.getBean("userService");
        userService.test();
        System.err.println(userService);
        System.err.println(userService1);
        System.err.println(userService2);
    }

}
