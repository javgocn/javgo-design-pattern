package cn.javgo.javgo.design.bridge;

import java.util.List;

/**
 * Desc：电话告警
 *
 * @author javgo
 * @date 2024-08-10
 */
public class TelephoneMsgSender implements MsgSender {

    private List<String> telephones;

    public TelephoneMsgSender(List<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public void send(String message) {
        // 实现自动语音电话发送逻辑
    }
}
