package cn.javgo.javgo.design.singleton.extend.distributed;

/**
 * Desc: 存储共享对象
 *
 * @author javgo
 * @create 2024-08-04 16:15
 */
public interface SharedObjectStorage {

    /**
     * 加载共享对象
     * @param clazz 共享对象类型
     * @param <T> 共享对象类型
     * @return 共享对象
     */
    <T> T load(Class<T> clazz);

    /**
     * 保存共享对象
     *
     * @param instance 单例
     * @param clazz 共享对象类型
     * @param <T> 共享对象类型
     */
    <T> void save(T instance, Class<T> clazz);
}
