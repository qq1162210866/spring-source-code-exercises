package com.spring;

/**
 * InitializingBean.java
 * Description:
 *
 * @author Peng Shiquan
 * @date 2022/7/28
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
