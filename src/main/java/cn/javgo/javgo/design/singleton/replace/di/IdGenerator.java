package cn.javgo.javgo.design.singleton.replace.di;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Desc: 依赖注入
 *
 * @author javgo
 * @create 2024-08-04 15:38
 */
@Component
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
