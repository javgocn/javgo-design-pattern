package cn.javgo.javgo.design.singleton.replace.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Desc: 订单类
 *
 * @author javgo
 * @create 2024-08-04 15:39
 */
@Component
public class Order {

    private final IdGenerator idGenerator;

    @Autowired
    public Order(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public void create(String param) {
        long id = idGenerator.getId();
        // ...
    }
}
