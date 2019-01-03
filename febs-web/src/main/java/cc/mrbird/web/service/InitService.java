package cc.mrbird.web.service;

import cc.mrbird.common.service.RedisService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Set;

/**
 * @author yiheni
 */
@Service
public class InitService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisService redisService;

    @Value("${spring.session.redis.namespace}")
    private String redisSessionNamespace;

    @PostConstruct
    public void init() {
        Set<String> keys = redisService.getKeys(redisSessionNamespace + "*");
        if (CollectionUtils.isNotEmpty(keys)) {
            keys.forEach(key -> redisService.del(key));
        }
        log.info("clean up spring session in redis");
    }
}
