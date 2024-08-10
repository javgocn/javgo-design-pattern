package cn.javgo.javgo.design.factory.abstracts;

import lombok.Data;

/**
 * Desc：规则配置
 *
 * @author javgo
 * @date 2024-08-10
 */
@Data
public class RuleConfig implements IRuleConfigParser {

    /**
     * 规则配置文件路径
     */
    private String ruleConfigFilePath;

    @Override
    public RuleConfig parse(String configText) {
        return null;
    }
}
