package cn.javgo.javgo.design.singleton.extend.distributed;

import java.io.*;

/**
 * Desc: 共享对象实现类
 *
 * @author javgo
 * @create 2024-08-04 16:16
 */
public class FileSharedObjectStorage implements SharedObjectStorage{

    // 存储路径
    private String storagePath;

    public FileSharedObjectStorage(String storagePath) {
        this.storagePath = storagePath;
    }

    /**
     * 从存储中加载序列化对象
     *
     * @param clazz 要加载的类的类型
     * @return 序列化对象
     * @throws RuntimeException 如果无法从存储中加载对象
     */
    @Override
    public <T> T load(Class<T> clazz) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(storagePath + "/" + clazz.getSimpleName() + ".ser"))) {
            // 将对象反序列化为指定类型的对象
            return clazz.cast(ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to load object from storage", e);
        }
    }

    /**
     * 保存对象到存储区
     *
     * @param instance 要保存的对象实例
     * @param clazz 对象实例的类
     * @param <T> 泛型参数，表示对象的类型
     *
     * 该方法通过序列化机制将对象保存到文件中每个类的对象保存在独立的文件中，文件名基于类的简单名称
     * 如果存储过程中发生IO异常，将抛出运行时异常
     */
    @Override
    public <T> void save(T instance, Class<T> clazz) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(storagePath + "/" + clazz.getSimpleName() + ".ser"))) {
            // 将对象序列化为字节流
            oos.writeObject(instance);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save object to storage", e);
        }
    }
}
