package cn.javgo.javgo.design.singleton.problem;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Desc: 订单ID生成器
 *
 * @author javgo
 * @create 2024-08-04 15:17
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderIdGenerator {

    private AtomicLong id = new AtomicLong(0);

    private static final OrderIdGenerator instance = new OrderIdGenerator();

    public static OrderIdGenerator getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
