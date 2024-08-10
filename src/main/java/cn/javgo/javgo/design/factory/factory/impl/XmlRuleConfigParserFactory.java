package cn.javgo.javgo.design.factory.factory.impl;

import cn.javgo.javgo.design.factory.factory.IRuleConfigParserFactory;
import cn.javgo.javgo.design.factory.simple.IRuleConfigParser;
import cn.javgo.javgo.design.factory.simple.impl.JsonRuleConfigParser;

/**
 * Desc：XML 解析工厂
 * 
 * @author javgo
 * @date 2024-08-10
 */
public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
