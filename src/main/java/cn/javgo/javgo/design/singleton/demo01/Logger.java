package cn.javgo.javgo.design.singleton.demo01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Desc: 日志类
 *
 * @author javgo
 * @create 2024-08-04 13:54
 */
public class Logger {

    private FileWriter writer;

    private static final Logger instance = new Logger(); // 单例

    public Logger()  {
        try {
            File file = new File("singleton/log.txt");
            writer = new FileWriter(file, true); // true表示追加写入
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取单例
     */
    public static Logger getInstance() {
        return instance;
    }

    public void log(String message) {
        try {
            // synchronized (this) { // 同步写日志(对象锁)
//            synchronized (Logger.class) { // 同步写日志(类锁)
//                writer.write(message);
//            }
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
