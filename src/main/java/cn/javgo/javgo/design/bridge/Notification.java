package cn.javgo.javgo.design.bridge;

import java.util.List;

/**
 * Desc：告警通知
 *
 * @author javgo
 * @date 2024-08-10
 */
public class Notification {

    /**
     * 告警通知方式 - 邮件
     */
    private List<String> emailAddresses;

    /**
     * 告警通知方式 - 电话
     */
    private List<String> telephones;

    /**
     * 告警通知方式 - 微信
     */
    private List<String> wechatIds;

    public Notification() {}

    public void setEmailAddress(List<String> emailAddress) {
        this.emailAddresses = emailAddress;
    }

    public void setTelephones(List<String> telephones) {
        this.telephones = telephones;
    }

    public void setWechatIds(List<String> wechatIds) {
        this.wechatIds = wechatIds;
    }

    /**
     * 发送告警
     *
     * @param level 告警等级
     * @param message 告警信息
     */
    public void notify(NotificationEmergencyLevel level, String message) {
        if (level.equals(NotificationEmergencyLevel.SEVERE)) {
            // 自动语音电话
        } else if (level.equals(NotificationEmergencyLevel.URGENCY)) {
            // 发微信
        } else if (level.equals(NotificationEmergencyLevel.NORMAL)) {
            // 发邮件
        } else if (level.equals(NotificationEmergencyLevel.TRIVIAL)) {
            // 发邮件
        }
    }
}
