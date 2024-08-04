package cn.javgo.javgo.design.singleton.extend.distributed;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Desc: 集群环境下的单例
 *
 * @author javgo
 * @create 2024-08-04 16:08
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DistributedIdGenerator implements Serializable {

    private static final long serialVersionUID = 1L;

    private AtomicLong id = new AtomicLong(0);

    private static DistributedIdGenerator instance;

    // 存储共享对象
    private static SharedObjectStorage storage = new FileSharedObjectStorage("/path/to/storage");

    // 分布式锁
    private static DistributedLock lock = new RedisDistributedLock(new Jedis("localhost"));

    // 获取单例，加分布式锁
    public synchronized static DistributedIdGenerator getInstance() {
        if (instance == null) {
            // 加锁，避免多个线程同时创建
            lock.lock();
            try {
                // 读取共享对象
                instance = storage.load(DistributedIdGenerator.class);
                // 如果不存在，则创建（这里再检测一次，因为可能在获取锁的过程中，其他线程创建了实例）
                if (instance == null) {
                    instance = new DistributedIdGenerator();
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    // 释放共享对象
    public synchronized void freeInstance() {
        // 加锁，避免多个线程同时释放
        lock.lock();
        try {
            // 回存共享对象
            storage.save(this, DistributedIdGenerator.class);
            //释放对象
            instance = null;
        } finally {
            // 释放分布式锁
            lock.unlock();
        }
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
