package cc.mrbird.security.social.weixin.config;

import cc.mrbird.security.properties.FebsSecurityProperties;
import cc.mrbird.security.properties.WeiXinProperties;
import cc.mrbird.security.social.SocialConnectedView;
import cc.mrbird.security.social.weixin.connect.WeiXinConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.web.servlet.View;

/**
 * @author yiheni
 */
@Configuration
@ConditionalOnProperty(prefix = "febs.security.social.weixin", name = "app-id")
@Order(2)
public class WeixinAutoConfiguration extends SocialConfigurerAdapter {

    @Autowired
    private FebsSecurityProperties securityProperties;

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer configurer, Environment environment) {
        configurer.addConnectionFactory(createConnectionFactory());
    }

    public ConnectionFactory<?> createConnectionFactory() {
        WeiXinProperties weixinConfig = securityProperties.getSocial().getWeixin();
        return new WeiXinConnectionFactory(weixinConfig.getProviderId(), weixinConfig.getAppId(), weixinConfig.getAppSecret());
    }

    @Bean({"connect/weixinConnect", "connect/weixinConnected"})
    public View weixinConnectedView() {
        return new SocialConnectedView();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        return null;
    }
}
