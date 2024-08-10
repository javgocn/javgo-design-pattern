package cn.javgo.javgo.design.factory.simple;

import cn.javgo.javgo.design.factory.simple.factory.RuleConfigParserFactory;
import cn.javgo.javgo.design.factory.simple.impl.JsonRuleConfigParser;
import cn.javgo.javgo.design.factory.simple.impl.PropertiesRuleConfigParser;
import cn.javgo.javgo.design.factory.simple.impl.XmlRuleConfigParser;
import cn.javgo.javgo.design.factory.simple.impl.YamlRuleConfigParser;

/**
 * Desc：简单工厂 - 解析器工厂
 *
 * @author javgo
 * @date 2024-08-10
 */
public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) {
        // 获取文件扩展名
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);

        // 初始化解析器
        IRuleConfigParser parser = RuleConfigParserFactory.createParser(ruleConfigFileExtension);
        if (parser == null) {
            throw new RuntimeException("Rule config file format is not supported: " + ruleConfigFilePath);
        }

//        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
//            parser = new JsonRuleConfigParser();
//        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
//            parser = new XmlRuleConfigParser();
//        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
//            parser = new YamlRuleConfigParser();
//        } else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)) {
//            parser = new PropertiesRuleConfigParser();
//        } else {
//            throw new RuntimeException("Rule config file format is not supported: " + ruleConfigFilePath);
//        }

        // 从 ruleConfigFilePath 文件中读取配置文本到 configText 中
        String configText = "";
        return parser.parse(configText);
    }

    private String getFileExtension(String filePath) {
        // 解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
