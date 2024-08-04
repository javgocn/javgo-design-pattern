package cn.javgo.javgo.design.singleton.extend.mulsingleton;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Desc: 日志类
 *
 * @author javgo
 * @create 2024-08-04 16:42
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Logger {

    // 存储不同类型的日志类的实例
    private static final ConcurrentHashMap<String, Logger> instance = new ConcurrentHashMap<>();

    public static Logger getInstance(String loggerName) {
        instance.putIfAbsent(loggerName, new Logger());
        return instance.get(loggerName);
    }

    public void log() {
        //...
    }
}
