package cn.javgo.javgo.design.singleton.extend.mulsingleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Desc: 多例模式
 *
 * @author javgo
 * @create 2024-08-04 16:38
 */
public class BackendServer {

    // 实例编号
    private long serverNo;

    // 实例地址
    private String serverAddress;

    // 实例数量
    private static final int SERVER_COUNT = 3;

    // 实例集
    private static final Map<Long, BackendServer> serverInstances = new HashMap<>();

    // 类加载时初始化实例集
    static {
        serverInstances.put(1L, new BackendServer(1L, "192.134.22.138:8080"));
        serverInstances.put(2L, new BackendServer(2L, "192.134.22.139:8080"));
        serverInstances.put(3L, new BackendServer(3L, "192.134.22.140:8080"));
    }

    private BackendServer(long serverNo, String serverAddress) {
        this.serverNo = serverNo;
        this.serverAddress = serverAddress;
    }

    // 获取指定实例
    public BackendServer getInstance(long serverNo) {
        return serverInstances.get(serverNo);
    }

    // 获取随机实例
    public BackendServer getRandomInstance() {
        Random r = new Random();
        int no = r.nextInt(SERVER_COUNT + 1);
        return serverInstances.get((long) no);
    }
}
