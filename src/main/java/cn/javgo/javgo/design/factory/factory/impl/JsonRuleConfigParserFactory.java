package cn.javgo.javgo.design.factory.factory.impl;

import cn.javgo.javgo.design.factory.factory.IRuleConfigParserFactory;
import cn.javgo.javgo.design.factory.simple.IRuleConfigParser;
import cn.javgo.javgo.design.factory.simple.impl.JsonRuleConfigParser;

/**
 * Desc：JSON 解析工厂
 * 
 * @author javgo
 * @date 2024-08-10
 */
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
