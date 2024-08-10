package cn.javgo.javgo.design.bridge;

/**
 * Desc：服务器告警
 *
 * @author javgo
 * @date 2024-08-10
 */
public class SevereNotification extends NotificationNew {

    public SevereNotification(MsgSender msgSender) {
        super(msgSender);
    }

    /**
     * 重写notify方法，用于发送消息
     *
     * @param message 要发送的消息内容
     */
    @Override
    public void notify(String message) {
        msgSender.send(message);
    }
}
