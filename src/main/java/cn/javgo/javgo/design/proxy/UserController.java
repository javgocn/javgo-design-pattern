package cn.javgo.javgo.design.proxy;

/**
 * Desc：收集接口请求数据
 *
 * @author javgo
 * @date 2024-08-10
 */
public class UserController implements IUserController {

    private MetricsCollector metricsCollector;

    @Override
    public UserVo login(String telephone, String password) {
        // ... 省略login逻辑...
        return new UserVo();
    }

    @Override
    public UserVo register(String telephone, String password) {
        // ... 省略register逻辑...
        return new UserVo();
    }
}
