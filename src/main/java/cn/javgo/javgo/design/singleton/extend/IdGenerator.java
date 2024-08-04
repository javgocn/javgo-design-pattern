package cn.javgo.javgo.design.singleton.extend;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Desc: 线程唯一的单例
 *
 * @author javgo
 * @create 2024-08-04 16:01
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);

    // 线程安全的单例
    private static final ConcurrentHashMap<Long, IdGenerator> instances = new ConcurrentHashMap<>();

    public static IdGenerator getInstance() {
        // 不同线程获取到的是同一个单例
        long currentThreadId = Thread.currentThread().getId();
        instances.putIfAbsent(currentThreadId, new IdGenerator());
        return instances.get(currentThreadId);
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
