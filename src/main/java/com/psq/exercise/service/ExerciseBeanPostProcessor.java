package com.psq.exercise.service;

import com.spring.BeanPostProcessor;
import com.spring.Component;

/**
 * ExerciseBeanPostProcessor.java
 * Description:
 *
 * @author Peng Shiquan
 * @date 2022/7/28
 */
@Component
public class ExerciseBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println(" this is ExerciseBeanPostProcessor bean is" + bean + " beanName is " + beanName);
        return bean;
    }
}
