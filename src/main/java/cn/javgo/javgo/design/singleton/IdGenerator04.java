package cn.javgo.javgo.design.singleton;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Desc: 静态内部类
 *
 * @author javgo
 * @create 2024-08-04 14:44
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IdGenerator04 {

    private AtomicLong id = new AtomicLong(0);

    private static class SingletonHolder {
        private static final IdGenerator04 instance = new IdGenerator04();
    }

    public static IdGenerator04 getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
