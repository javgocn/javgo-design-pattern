package cn.javgo.javgo.design.singleton;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Desc: 懒汉式
 *
 * @author javgo
 * @create 2024-08-04 14:33
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IdGenerator02 {

    private AtomicLong id = new AtomicLong(0);

    // 懒汉式: 延迟加载
    private static IdGenerator02 instance;

    public static synchronized IdGenerator02 getInstance() {
        if (instance == null) {
            instance = new IdGenerator02();
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
