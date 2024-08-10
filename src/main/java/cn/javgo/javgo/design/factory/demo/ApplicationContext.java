package cn.javgo.javgo.design.factory.demo;

/**
 * Desc：应用上下文接口
 *
 * @author javgo
 * @date 2024-08-10
 */
public interface ApplicationContext {

    /**
     * 获取 bean
     * @param beanId bean name
     * @return bean
     */
    Object getBean(String beanId);
}
