package cn.javgo.javgo.design.factory.abstracts;

/**
 * Desc：规则配置
 *
 * @author javgo
 * @date 2024-08-10
 */
public interface IRuleConfigParser {

    RuleConfig parse(String configText);
}
