package cn.javgo.javgo.design.bridge;

/**
 * Desc：通知
 *
 * @author javgo
 * @date 2024-08-10
 */
public abstract class NotificationNew {

    /**
     * 消息发送（有不同的实现）
     */
    protected MsgSender msgSender;

    public NotificationNew(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    /**
     * 发送消息（抽象）
     * @param message 消息
     */
    public abstract void notify(String message);
}
