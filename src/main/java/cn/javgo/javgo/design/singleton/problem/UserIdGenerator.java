package cn.javgo.javgo.design.singleton.problem;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Desc: 用户ID生成器
 *
 * @author javgo
 * @create 2024-08-04 15:17
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserIdGenerator {

    private AtomicLong id = new AtomicLong(0);

    private static final UserIdGenerator instance = new UserIdGenerator();

    public static UserIdGenerator getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
