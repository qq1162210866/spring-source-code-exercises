package com.psq.exercise.service;

import com.spring.BeanPostProcessor;
import com.spring.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

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
        if ("userService".equals(beanName)) {
            System.out.println("开始生成userService代理类");
            return Proxy.newProxyInstance(ExerciseBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), (proxy, method, args) -> {
                System.out.println("开始执行切面逻辑");
                return method.invoke(bean, args);
            });
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(ExerciseValue.class)) {
                ExerciseValue annotation = field.getAnnotation(ExerciseValue.class);
                field.setAccessible(true);
                try {
                    field.set(bean, annotation.value());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return bean;
    }
}
