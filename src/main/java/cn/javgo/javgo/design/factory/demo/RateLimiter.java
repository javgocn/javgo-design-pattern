package cn.javgo.javgo.design.factory.demo;

/**
 * Desc：
 *
 * @author javgo
 * @date 2024-08-10
 */
public class RateLimiter {

    /**
     * 依赖 RedisCounter
     */
    private RedisCounter redisCounter;

    public RateLimiter(RedisCounter redisCounter) {
        this.redisCounter = redisCounter;
    }

    public void test() {
        System.out.println("Hello World!");
    }

    //...
}
