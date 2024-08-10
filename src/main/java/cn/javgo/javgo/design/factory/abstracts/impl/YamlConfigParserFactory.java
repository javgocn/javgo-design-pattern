package cn.javgo.javgo.design.factory.abstracts.impl;

import cn.javgo.javgo.design.factory.abstracts.IConfigParserFactory;
import cn.javgo.javgo.design.factory.abstracts.ISystemConfigParser;

/**
 * Desc：Yaml 解析工厂
 * 
 * @author javgo
 * @date 2024-08-10
 */
public class YamlConfigParserFactory implements IConfigParserFactory {

    @Override
    public cn.javgo.javgo.design.factory.abstracts.IRuleConfigParser createRuleParser() {
        return null;
    }

    @Override
    public ISystemConfigParser createSystemParser() {
        return null;
    }
}
