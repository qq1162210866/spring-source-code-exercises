package com.psq.exercise.service;

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
public class UserService {

    public void test() {
        System.out.println("this is UserService test method");
    }
}
