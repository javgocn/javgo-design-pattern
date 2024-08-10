package cn.javgo.javgo.design.factory.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Desc：
 *
 * @author javgo
 * @date 2024-08-10
 */
public class Demo {

    public static void main(String[] args) {
        // 获取 Spring 上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("factory/beans.xml");
        // 获取 RateLimiter 对象
        RateLimiter rateLimiter = (RateLimiter) applicationContext.getBean("rateLimiter");
        rateLimiter.test();
    }
}
