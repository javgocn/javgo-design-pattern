package cn.javgo.javgo.design.bridge;

/**
 * Desc：消息发送顶层接口 - 抽象
 *
 * @author javgo
 * @date 2024-08-10
 */
public interface MsgSender {

    void send(String message);
}
