package cn.javgo.javgo.design.decorator;

/**
 * Desc：数据类型实现
 *
 * @author javgo
 * @date 2024-08-11
 */
public class MyDataInputStream extends MyInputStream {

    /**
     * 使用 volatile 关键字修饰，保证可见性
     */
    protected volatile MyInputStream in;

    protected MyDataInputStream(MyInputStream in) {
        this.in = in;
    }

    // 实现读取基本类型数据的接口
}
