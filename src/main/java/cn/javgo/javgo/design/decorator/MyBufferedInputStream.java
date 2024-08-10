package cn.javgo.javgo.design.decorator;

/**
 * Desc：缓存实现
 *
 * @author javgo
 * @date 2024-08-11
 */
public class MyBufferedInputStream extends MyInputStream {

    /**
     * 缓存输入流（使用 volatile 关键字修饰，保证可见性）
     */
    protected volatile MyInputStream in;

    protected MyBufferedInputStream(MyInputStream in) {
        this.in = in;
    }

    // 实现基于缓存的读数据接口
}
