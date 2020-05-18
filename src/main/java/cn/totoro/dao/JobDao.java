package cn.totoro.dao;

import cn.totoro.entity.Job;

import java.util.List;

public interface JobDao {

    /**
     * 获取所有岗位
     * @return
     */
    List<Job> getAllJob();


    /**
     * 根据ID查找职位
     * @param id
     * @return
     */
    Job getJobById(Integer id);

    /**
     * 新增职位
     * @param job
     * @return
     */
    boolean addJob(Job job);

    /**
     * 更新职位信息
     * @param job
     * @return
     */
    boolean updateJob(Job job);

    /**
     * 根据ID删除职位
     * @param id
     * @return
     */
    boolean deleteJobById(Integer id);
}
