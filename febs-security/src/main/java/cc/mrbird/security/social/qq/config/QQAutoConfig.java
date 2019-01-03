package cc.mrbird.security.social.qq.config;

import cc.mrbird.security.properties.FebsSecurityProperties;
import cc.mrbird.security.properties.QQProperties;
import cc.mrbird.security.social.SocialConnectedView;
import cc.mrbird.security.social.qq.connect.QQConnectionFactory;
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
@ConditionalOnProperty(prefix = "febs.security.social.qq", name = "app-id")
@Order(2)
public class QQAutoConfig extends SocialConfigurerAdapter {

    @Autowired
    private FebsSecurityProperties securityProperties;

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer configurer, Environment environment) {
        configurer.addConnectionFactory(createConnectionFactory());
    }


    public ConnectionFactory<?> createConnectionFactory() {
        QQProperties properties = securityProperties.getSocial().getQQ();
        return new QQConnectionFactory(properties.getProviderId(), properties.getAppId(), properties.getAppSecret());
    }

    @Bean({"connect/qqConnect", "connect/qqConnected"})
    public View qqConnectedView() {
        return new SocialConnectedView();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        return null;
    }
}
