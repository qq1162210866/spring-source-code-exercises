package com.psq.exercise.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ExerciseValue.java
 * Description: 自定义value注解
 *
 * @author Peng Shiquan
 * @date 2022/7/29
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface ExerciseValue {

    String value() default "";
}
