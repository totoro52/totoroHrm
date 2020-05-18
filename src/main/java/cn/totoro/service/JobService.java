package cn.totoro.service;

import cn.totoro.entity.Job;

import java.util.List;

public interface JobService {

    List<Job> getAllJob();
    boolean addJob(Job job);
    boolean updateJob(Job job);
    boolean deleteJobById(Integer id);
}
