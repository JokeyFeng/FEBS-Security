package cc.mrbird.quartz.service;

import cc.mrbird.common.service.IService;
import cc.mrbird.quartz.domain.Job;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author yiheni
 */
@CacheConfig(cacheNames = "JobService")
public interface JobService extends IService<Job> {
    /**
     * 查找定时任务
     *
     * @param jobId
     * @return
     */
    Job findJob(Long jobId);

    /**
     * 查找所有的定时任务
     *
     * @return
     */
    List<Job> findAllJobs();

    /**
     * 查找指定的任务的所有任务
     *
     * @param job
     * @return
     */
    List<Job> findAllJobs(Job job);

    /**
     * 新增一个定时任务
     *
     * @param job
     */
    void addJob(Job job);

    /**
     * 修改定时任务
     *
     * @param job
     */
    void updateJob(Job job);

    /**
     * 删除定时任务
     *
     * @param jobIds
     */
    void deleteBatch(String jobIds);

    /**
     * 批量修改定时任务
     *
     * @param jobIds
     * @param status
     * @return
     */
    int updateBatch(String jobIds, String status);

    /**
     * 启动定时任务
     *
     * @param jobIds
     */
    void run(String jobIds);

    /**
     * 暂停定时任务
     *
     * @param jobIds
     */
    void pause(String jobIds);

    /**
     * 恢复定时任务
     *
     * @param jobIds
     */
    void resume(String jobIds);

    /**
     * 获取系统所有定时任务
     *
     * @param job
     * @return
     */
    @Cacheable(key = "#p0")
    List<Job> getSysCronClazz(Job job);
}
