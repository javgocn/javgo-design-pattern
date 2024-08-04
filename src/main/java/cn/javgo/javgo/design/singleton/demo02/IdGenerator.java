package cn.javgo.javgo.design.singleton.demo02;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Desc: 唯一递增ID生成器
 *
 * @author javgo
 * @create 2024-08-04 14:20
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE) // 禁止外部实例化
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);

    private static final IdGenerator instance = new IdGenerator();

    public static IdGenerator getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
