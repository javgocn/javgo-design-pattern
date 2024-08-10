package cn.javgo.javgo.design.factory.abstracts;

/**
 * Desc：抽象工厂接口，定义了创建不同类型解析器的方法
 *
 * @author javgo
 * @date 2024-08-10
 */
public interface IConfigParserFactory {

    IRuleConfigParser createRuleParser();
    ISystemConfigParser createSystemParser();
    // 可以扩展新的解析器类型，比如IBizConfigParser
}
