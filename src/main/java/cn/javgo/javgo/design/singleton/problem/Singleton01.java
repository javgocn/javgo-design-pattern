package cn.javgo.javgo.design.singleton.problem;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

/**
 * Desc: 使用 init() 方法初始化
 *
 * @author javgo
 * @create 2024-08-04 15:27
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Singleton01 {

    private static Singleton01 instance = null;

    private final int paramA;
    private final int paramB;

    public static Singleton01 getInstance() {
        // 必须先初始化，否则会抛出异常
        if (instance == null) {
            throw new RuntimeException("Run init() first.");
        }
        return instance;
    }

    // 这里使用 synchronized 关键字保证线程安全，避免竞争初始化
    public synchronized static Singleton01 init(int paramA, int paramB) {
        if (instance != null) {
            throw new RuntimeException("Singleton has been created!");
        }

        instance = new Singleton01(paramA, paramB);
        return instance;
    }
}
