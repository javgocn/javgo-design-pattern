package cn.javgo.javgo.design.factory.demo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc：XML 文件解析实现
 *
 * @author javgo
 * @date 2024-08-10
 */
public class XmlBeanConfigParser implements BeanConfigParser {

    @Override
    public List<BeanDefinition> parse(InputStream inputStream) {
        // 模拟从输入流读取配置文件内容
        String content = "Some XML Content";  // TODO: 实现从 inputStream 读取内容
        return parse(content);
    }

    @Override
    public List<BeanDefinition> parse(String configContent) {
        // 模拟XML解析过程，这里仅为示例
        List<BeanDefinition> beanDefinitions = new ArrayList<>();
        // TODO: 解析 configContent，并生成 BeanDefinition 列表
        return beanDefinitions;
    }
}
