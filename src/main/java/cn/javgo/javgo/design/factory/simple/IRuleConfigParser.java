package cn.javgo.javgo.design.factory.simple;

/**
 * Desc：规则解析策略
 *
 * @author javgo
 * @date 2024-08-10
 */
public interface IRuleConfigParser {

    /**
     * 解析规则
     *
     * @param configText 规则文本
     * @return 规则
     */
    RuleConfig parse(String configText);
}
