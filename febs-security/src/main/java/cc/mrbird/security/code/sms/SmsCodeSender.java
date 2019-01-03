package cc.mrbird.security.code.sms;

/**
 * @author yiheni
 */
public interface SmsCodeSender {
    /**
     * 发送短信认证码
     *
     * @param mobile
     * @param code
     */
    void send(String mobile, String code);
}
