package cn.javgo.javgo.design.factory.factory;

import cn.javgo.javgo.design.factory.simple.IRuleConfigParser;

/**
 * Desc：工厂方法
 *
 * @author javgo
 * @date 2024-08-10
 */
public interface IRuleConfigParserFactory {

    IRuleConfigParser createParser();
}
