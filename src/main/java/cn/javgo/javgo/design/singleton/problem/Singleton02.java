package cn.javgo.javgo.design.singleton.problem;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

/**
 * Desc: 在 getInstance() 方法中传递参数
 *
 * @author javgo
 * @create 2024-08-04 15:27
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Singleton02 {

    private static Singleton02 instance = null;

    private final int paramA;
    private final int paramB;

    public static Singleton02 getInstance(int paramA, int paramB) {
        if (instance == null) {
            instance = new Singleton02(paramA, paramB);
        }
        return instance;
    }
}
