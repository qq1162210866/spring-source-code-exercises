package com.psq.exercise.service;

import com.spring.Autowired;
import com.spring.Component;
import com.spring.Scope;

/**
 * UserService.java
 * Description:
 *
 * @author Peng Shiquan
 * @date 2022/7/28
 */
@Component("userService")
@Scope()
public class UserService implements UserServiceInterface {

    @Autowired
    private OrderService orderService;

    @Override
    public void test() {
        System.out.println("this is UserService test method");
    }

    @Override
    public void test2() {
        System.out.print("this is UserService test method");
        System.out.println(" next is orderService" + orderService);
        orderService.test();
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化");
    }
}
