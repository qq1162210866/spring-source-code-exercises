package com.psq.exercise.service;

import com.spring.Autowired;
import com.spring.BeanNameAware;
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
public class UserService implements UserServiceInterface, BeanNameAware {

    @Autowired
    private OrderService orderService;

    @ExerciseValue("Shiquan Peng")
    private String userName;

    private String beanName;

    @Override
    public void test() {
        System.out.println("this is UserService test method");
        System.out.println("userName is " + userName);
        System.out.println("beanName is " + beanName);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
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
