package cn.javgo.javgo.design.singleton.problem;

/**
 * Desc: 使用全局变量存储参数
 *
 * @author javgo
 * @create 2024-08-04 15:27
 */
public class Singleton03 {

    private static Singleton03 instance = null;

    private final int paramA;
    private final int paramB;

    private Singleton03() {
        this.paramA = Config.PARAM_A;
        this.paramB = Config.PARAM_B;
    }

    public static Singleton03 getInstance(int paramA, int paramB) {
        if (instance == null) {
            instance = new Singleton03();
        }
        return instance;
    }
}
