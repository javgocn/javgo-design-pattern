package cn.javgo.javgo.design.singleton.problem;

import cn.javgo.javgo.design.singleton.demo02.IdGenerator;

/**
 * Desc: 订单类
 *
 * @author javgo
 * @create 2024-08-04 15:12
 */
public class Order {

    public void create(String param) {
        // ...
        long id = IdGenerator.getInstance().getId();
        // 需要将上面一行代码，替换为下面一行代码
        long id2 = OrderIdGenerator.getInstance().getId();
        // ...
    }
}
