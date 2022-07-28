package com.psq.exercise;

import com.psq.exercise.service.OrderService;
import com.psq.exercise.service.UserService;
import com.psq.exercise.service.UserServiceInterface;
import com.spring.ComponentScan;
import com.spring.PengShiQuanApplicationContext;

@ComponentScan("com.psq.exercise.service")
public class SpringSourceCodeExerciseApplication {

    public static void main(String[] args) {

        PengShiQuanApplicationContext context = new PengShiQuanApplicationContext(SpringSourceCodeExerciseApplication.class);
        UserServiceInterface userService = (UserServiceInterface) context.getBean("userService");

        OrderService orderService = (OrderService) context.getBean("orderService");
        userService.test2();
        orderService.test();
        System.err.println(userService);
        System.err.println(orderService);
    }

}
