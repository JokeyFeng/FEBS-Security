package cc.mrbird.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author yiheni
 */
@Configuration
@ConfigurationProperties(prefix = "febs")
public class FebsProperies {

    private boolean openAopLog = true;

    public boolean isOpenAopLog() {
        return openAopLog;
    }

    public void setOpenAopLog(boolean openAopLog) {
        this.openAopLog = openAopLog;
    }
}
