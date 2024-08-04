package cn.javgo.javgo.design.singleton.extend.distributed;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

/**
 * Desc: 分布式锁实现
 *
 * @author javgo
 * @create 2024-08-04 16:22
 */
public class RedisDistributedLock implements DistributedLock{

    // 分布式锁的键
    private static final String LOCK_KEY = "DistributedLock";

    // 分布式锁的值
    private static final String LOCK_VALUE = "LOCKED";

    // 分布式锁的过期时间(秒)
    private static final int EXPIRE_TIME = 60;

    // Redis 客户端
    private Jedis jedis;

    public RedisDistributedLock(Jedis jedis) {
        this.jedis = jedis;
    }

    @Override
    public void lock() {
        // 自旋获取锁
        while (true) {
            // 获取锁，这里使用 SETNX 命令，如果键不存在则设置键值对，如果键已存在则返回失败
            String result = jedis.set(LOCK_KEY, LOCK_VALUE, SetParams.setParams().nx().ex(EXPIRE_TIME));
            if ("OK".equals(result)) {
                break;
            }

            try {
                // 休眠 100ms 再尝试获取锁
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // 恢复中断: 如果当前线程在等待过程中被中断，则抛出 InterruptedException 异常
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void unlock() {
        // 删除锁
        jedis.del(LOCK_KEY);
    }
}
