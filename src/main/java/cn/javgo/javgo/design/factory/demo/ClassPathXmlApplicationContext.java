package cn.javgo.javgo.design.factory.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Desc：基于 XML 的 ApplicationContext 实现
 *
 * @author javgo
 * @date 2024-08-10
 */
public class ClassPathXmlApplicationContext implements ApplicationContext{

    private BeansFactory beansFactory;

    private BeanConfigParser beanConfigParser;

    public ClassPathXmlApplicationContext(String configLocation) {
        this.beansFactory = new BeansFactory();
        this.beanConfigParser = new XmlBeanConfigParser();
        loadBeanDefinitions(configLocation);
    }

    /**
     * 加载 Bean 配置
     *
     * @param configLocation 配置文件路径
     */
    private void loadBeanDefinitions(String configLocation) {
        try (InputStream in = this.getClass().getResourceAsStream("/" + configLocation)) {
            // 获取配置文件
            if (in == null) {
                throw new RuntimeException("can not find config file: " + configLocation);
            }

            // 解析配置文件
            List<BeanDefinition> beanDefinitions = beanConfigParser.parse(configLocation);
            // 添加到 BeansFactory
            beansFactory.addBeanDefinitions(beanDefinitions);
        } catch (IOException e) {
            // TODO: log error
        }
    }

    @Override
    public Object getBean(String beanId) {
        return beansFactory.getBean(beanId);
    }
}
