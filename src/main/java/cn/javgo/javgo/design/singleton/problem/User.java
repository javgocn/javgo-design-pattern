package cn.javgo.javgo.design.singleton.problem;

import cn.javgo.javgo.design.singleton.demo02.IdGenerator;

/**
 * Desc: 用户类
 *
 * @author javgo
 * @create 2024-08-04 15:14
 */
public class User {

    public void create(String param) {
        // ...
        long id = IdGenerator.getInstance().getId();
        // 需要将上面一行代码，替换为下面一行代码
        long id2 = UserIdGenerator.getInstance().getId();
        // ...
    }
}
