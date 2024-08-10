package cn.javgo.javgo.design.factory.abstracts;

import cn.javgo.javgo.design.factory.abstracts.impl.JsonConfigParserFactory;
import cn.javgo.javgo.design.factory.abstracts.impl.PropertiesConfigParserFactory;
import cn.javgo.javgo.design.factory.abstracts.impl.XmlConfigParserFactory;
import cn.javgo.javgo.design.factory.abstracts.impl.YamlConfigParserFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc：工厂的工厂，用于管理具体工厂类的映射
 *
 * @author javgo
 * @date 2024-08-10
 */
public class ConfigParserFactoryMap {

    private static final Map<String, IConfigParserFactory> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", new JsonConfigParserFactory());
        cachedFactories.put("xml", new XmlConfigParserFactory());
        cachedFactories.put("yaml", new YamlConfigParserFactory());
        cachedFactories.put("properties", new PropertiesConfigParserFactory());
    }

    public static IConfigParserFactory getFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        return cachedFactories.get(type.toLowerCase());
    }
}
