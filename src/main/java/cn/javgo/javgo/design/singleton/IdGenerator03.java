package cn.javgo.javgo.design.singleton;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Desc: 双重检测
 *
 * @author javgo
 * @create 2024-08-04 14:39
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IdGenerator03 {

    private AtomicLong id = new AtomicLong(0);

    // 双重检测: volatile 确保单例对象的可见性
    private static volatile IdGenerator03 instance;

    public static IdGenerator03 getInstance() {
        if (instance == null) {
            synchronized (IdGenerator03.class) { // 类级别的锁
                if (instance == null) {
                    instance = new IdGenerator03();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
