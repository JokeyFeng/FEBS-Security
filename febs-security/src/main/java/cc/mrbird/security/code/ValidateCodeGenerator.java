package cc.mrbird.security.code;

/**
 * @author yiheni
 */
public interface ValidateCodeGenerator {

    /**
     * 创建验证码
     *
     * @return
     */
    ValidateCode createCode();
}
