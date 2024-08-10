package cn.javgo.javgo.design.factory.abstracts;

/**
 * Desc：
 *
 * @author javgo
 * @date 2024-08-10
 */
public class ConfigSource {

    public RuleConfig loadRuleConfig(String configFilePath) {
        String fileExtension = getFileExtension(configFilePath);
        IConfigParserFactory parserFactory = ConfigParserFactoryMap.getFactory(fileExtension);
        if (parserFactory == null) {
            throw new RuntimeException("Unsupported config file format: " + configFilePath);
        }

        IRuleConfigParser parser = parserFactory.createRuleParser();
        String configText = ""; // 从文件中读取配置文本
        return parser.parse(configText);
    }

    public SystemConfig loadSystemConfig(String configFilePath) {
        String fileExtension = getFileExtension(configFilePath);
        IConfigParserFactory parserFactory = ConfigParserFactoryMap.getFactory(fileExtension);
        if (parserFactory == null) {
            throw new RuntimeException("Unsupported config file format: " + configFilePath);
        }
        ISystemConfigParser parser = parserFactory.createSystemParser();
        String configText = ""; // 从文件中读取配置文本
        return parser.parse(configText);
    }

    private String getFileExtension(String filePath) {
        // 获取文件扩展名，例如 rule.json 返回 json
        return "json";
    }
}
