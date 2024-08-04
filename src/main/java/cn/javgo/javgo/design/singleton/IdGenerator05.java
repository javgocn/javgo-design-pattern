package cn.javgo.javgo.design.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Desc: 枚举
 *
 * @author javgo
 * @create 2024-08-04 14:48
 */
public enum IdGenerator05 {

    INSTANCE;

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
