package cn.javgo.javgo.design.factory.simple.factory;

import cn.javgo.javgo.design.factory.simple.IRuleConfigParser;
import cn.javgo.javgo.design.factory.simple.impl.JsonRuleConfigParser;
import cn.javgo.javgo.design.factory.simple.impl.PropertiesRuleConfigParser;
import cn.javgo.javgo.design.factory.simple.impl.XmlRuleConfigParser;
import cn.javgo.javgo.design.factory.simple.impl.YamlRuleConfigParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc：简单工厂
 *
 * @author javgo
 * @date 2024-08-10
 */
public class RuleConfigParserFactory {

    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    // 类加载时就初始化好，便于复用
    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
//        IRuleConfigParser parser = null;
//        if ("json".equalsIgnoreCase(configFormat)) {
//            parser = new JsonRuleConfigParser();
//        } else if ("xml".equalsIgnoreCase(configFormat)) {
//            parser = new XmlRuleConfigParser();
//        } else if ("yaml".equalsIgnoreCase(configFormat)) {
//            parser = new YamlRuleConfigParser();
//        } else if ("properties".equalsIgnoreCase(configFormat)) {
//            parser = new PropertiesRuleConfigParser();
//        }
//        return parser;

        if (configFormat == null || configFormat.isEmpty()) {
            return null; // 返回null或抛出异常均可，根据具体需求决定
        }
        return cachedParsers.get(configFormat.toLowerCase());
    }
}
