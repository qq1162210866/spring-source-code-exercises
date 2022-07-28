package com.spring;

import com.sun.xml.internal.ws.util.StringUtils;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * PengShiQuanApplicationContext.java
 * Description: 上下文环境类
 *
 * @author Peng Shiquan
 * @date 2022/7/28
 */
public class PengShiQuanApplicationContext {
    private final Class<?> baseClazz;
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();

    private Map<String, Object> singletonObjects = new HashMap<String, Object>();

    public PengShiQuanApplicationContext(Class baseClazz) {
        this.baseClazz = baseClazz;
        //扫描类注解上的路径
        scan(baseClazz);
        //创建单例bean
        creatSingletonBean();

    }

    private void scan(Class baseClazz) {
        if (baseClazz.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScan = (ComponentScan) baseClazz.getAnnotation(ComponentScan.class);
            String path = componentScan.value();
            //资源的名称是标识资源的' / '分隔的路径名 和系统没有关系
            path = path.replace(".", "/");
            //System.err.println(path);
            ClassLoader loader = PengShiQuanApplicationContext.class.getClassLoader();
            URL resource = loader.getResource(path);
            File file = new File(resource.getFile());
            if (file.isDirectory()) {
                for (File listFile : file.listFiles()) {
                   // System.err.println(listFile.getAbsolutePath());
                    String filePath = listFile.getAbsolutePath();
                    try {
                        Class<?> aClass = loader.loadClass(filePath.substring(filePath.indexOf("com"), filePath.indexOf(".class"))
                                .replace(String.valueOf(File.separatorChar), "."));
                        if (aClass.isAnnotationPresent(Component.class)) {
                           // System.err.println("找到一个注解" + aClass);
                            Component component = aClass.getAnnotation(Component.class);
                            BeanDefinition definition = new BeanDefinition();
                            definition.setType(aClass);

                            if (aClass.isAnnotationPresent(Scope.class)) {
                                Scope scope = aClass.getAnnotation(Scope.class);
                                definition.setScope(scope.value());
                            } else {
                                //单例
                                definition.setScope("singleton");
                            }
                            // 获取bean名称
                            String beanName = component.value();
                            if ("".equals(beanName)) {

                            }
                            beanDefinitionMap.put(beanName, definition);
                        }
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private void creatSingletonBean() {
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition definition = entry.getValue();
            if ("singleton".equals(definition.getScope())) {
                Object bean = creatBean(beanName, definition);
                singletonObjects.put(beanName, bean);
            }
        }
    }

    private Object creatBean(String beanName, BeanDefinition definition) {
        Class type = definition.getType();
        Object bean = null;
        try {
            bean = type.getConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return bean;
    }

    public Object getBean(String beanName) {
        if (!beanDefinitionMap.containsKey(beanName)) {
            throw new NullPointerException("找不到该bean对象");
        }
        BeanDefinition definition = beanDefinitionMap.get(beanName);
        if ("singleton".equals(definition.getScope())) {
            return singletonObjects.get(beanName);
        } else {
            return creatBean(beanName, definition);
        }
    }
}
