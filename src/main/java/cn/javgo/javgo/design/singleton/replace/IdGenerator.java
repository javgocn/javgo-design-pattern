package cn.javgo.javgo.design.singleton.replace;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Desc: 静态方法
 *
 * @author javgo
 * @create 2024-08-04 15:35
 */
public class IdGenerator {

    private static AtomicLong id = new AtomicLong(0);

    public static long getId() {
        return id.incrementAndGet();
    }
}
