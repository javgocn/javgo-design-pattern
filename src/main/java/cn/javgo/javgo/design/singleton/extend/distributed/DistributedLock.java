package cn.javgo.javgo.design.singleton.extend.distributed;

/**
 * Desc: 分布式锁接口
 *
 * @author javgo
 * @create 2024-08-04 16:21
 */
public interface DistributedLock {

    /**
     * 获取锁
     */
    void lock();

    /**
     * 释放锁
     */
    void unlock();
}
