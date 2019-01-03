package cc.mrbird.quartz.dao;

import cc.mrbird.common.config.MyMapper;
import cc.mrbird.quartz.domain.Job;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yiheni
 */
@Component
public interface JobMapper extends MyMapper<Job> {
    /**
     * 查询
     *
     * @return
     */
    List<Job> queryList();
}