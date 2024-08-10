package cn.javgo.javgo.design.factory.factory;

import cn.javgo.javgo.design.factory.factory.impl.JsonRuleConfigParserFactory;
import cn.javgo.javgo.design.factory.factory.impl.PropertiesRuleConfigParserFactory;
import cn.javgo.javgo.design.factory.factory.impl.XmlRuleConfigParserFactory;
import cn.javgo.javgo.design.factory.factory.impl.YamlRuleConfigParserFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc：工厂的工厂，用于生成解析器工厂对象
 *
 * @author javgo
 * @date 2024-08-10
 */
public class RuleConfigParserFactoryMap {

    private static final Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
        cachedFactories.put("properties", new PropertiesRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getParserFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        return cachedFactories.get(type.toLowerCase());
    }
}
