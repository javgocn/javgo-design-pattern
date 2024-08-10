package cn.javgo.javgo.design.factory.demo;

/**
 * Desc：
 *
 * @author javgo
 * @date 2024-08-10
 */
public class RedisCounter {

    private String ipAddress;

    private int port;

    public RedisCounter(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    //...
}
