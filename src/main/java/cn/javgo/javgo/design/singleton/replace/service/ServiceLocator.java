package cn.javgo.javgo.design.singleton.replace.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc: 服务定位器
 *
 * @author javgo
 * @create 2024-08-04 15:42
 */
public class ServiceLocator {

    // 服务注册表
    private static final Map<Class<?>, Object> services = new HashMap<>();

    // 注册服务
    public static <T> void registerService(Class<T> serviceClass, T serviceInstance) {
        services.put(serviceClass, serviceInstance);
    }

    // 获取服务
    public static <T> T getService(Class<T> serviceClass) {
        // 将服务转换为指定类型的实例
        return serviceClass.cast(services.get(serviceClass));
    }
}
