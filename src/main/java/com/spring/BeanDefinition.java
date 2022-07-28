package com.spring;

/**
 * BeanDefinition.java
 * Description: bean的定义类
 *
 * @author Peng Shiquan
 * @date 2022/7/28
 */
public class BeanDefinition {

    private Class type;
    private String scope;
    private Boolean isLazy;

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Boolean getLazy() {
        return isLazy;
    }

    public void setLazy(Boolean lazy) {
        isLazy = lazy;
    }
}
