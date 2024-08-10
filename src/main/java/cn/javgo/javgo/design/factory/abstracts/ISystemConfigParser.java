package cn.javgo.javgo.design.factory.abstracts;

import cn.javgo.javgo.design.factory.simple.IRuleConfigParser;

/**
 * Desc：系统配置
 *
 * @author javgo
 * @date 2024-08-10
 */
public interface ISystemConfigParser {

    SystemConfig parse(String configText);
}
