package cn.javgo.javgo.design.factory.demo;

import java.io.InputStream;
import java.util.List;

/**
 * Desc：Bean 配置解析
 *
 * @author javgo
 * @date 2024-08-10
 */
public interface BeanConfigParser {

    /**
     * 解析配置文件
     *
     * @param inputStream 配置文件
     * @return 生成的 BeanDefinition 列表
     */
    List<BeanDefinition> parse(InputStream inputStream);

    /**
     * 解析配置文件
     *
     * @param configContent 配置文件
     * @return 生成的 BeanDefinition 列表
     */
    List<BeanDefinition> parse(String configContent);
}
