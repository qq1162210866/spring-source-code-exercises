package com.spring;

/**
 * BeanPostProcessor.java
 * Description:
 *
 * @author Peng Shiquan
 * @date 2022/7/28
 */
public interface BeanPostProcessor {

    default Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }

    default Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
