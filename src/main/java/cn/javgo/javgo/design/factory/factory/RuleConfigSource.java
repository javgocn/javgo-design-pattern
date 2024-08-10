package cn.javgo.javgo.design.factory.factory;

import cn.javgo.javgo.design.factory.factory.impl.JsonRuleConfigParserFactory;
import cn.javgo.javgo.design.factory.factory.impl.PropertiesRuleConfigParserFactory;
import cn.javgo.javgo.design.factory.factory.impl.XmlRuleConfigParserFactory;
import cn.javgo.javgo.design.factory.factory.impl.YamlRuleConfigParserFactory;
import cn.javgo.javgo.design.factory.simple.IRuleConfigParser;
import cn.javgo.javgo.design.factory.simple.RuleConfig;
import cn.javgo.javgo.design.factory.simple.factory.RuleConfigParserFactory;

/**
 * Desc：工厂方法 - 解析器工厂
 *
 * @author javgo
 * @date 2024-08-10
 */
public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);

        // if-else 重现江湖
//        IRuleConfigParserFactory parserFactory = null;
//        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
//            parserFactory = new JsonRuleConfigParserFactory();
//        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
//            parserFactory = new XmlRuleConfigParserFactory();
//        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
//            parserFactory = new YamlRuleConfigParserFactory();
//        } else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)) {
//            parserFactory = new PropertiesRuleConfigParserFactory();
//        } else {
//            throw new RuntimeException("Rule config file format is not supported: " + ruleConfigFilePath);
//        }

        // 工厂的工厂，消除 load 的 if-else
        IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);
        IRuleConfigParser parser = parserFactory.createParser();

        // 从 ruleConfigFilePath 文件中读取配置文本到 configText 中
        String configText = "";
        return parser.parse(configText);
    }

    private String getFileExtension(String filePath) {
        // 解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
