package cn.javgo.javgo.design.singleton;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Desc: 饿汉式
 *
 * @author javgo
 * @create 2024-08-04 14:27
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IdGenerator01 {

  private AtomicLong id = new AtomicLong(0);

  // 饿汉式：类加载时就初始化实例
  private static final IdGenerator01 instance = new IdGenerator01();

  public static IdGenerator01 getInstance() {
      return instance;
  }

  public long getId() {
      return id.incrementAndGet();
  }
}
