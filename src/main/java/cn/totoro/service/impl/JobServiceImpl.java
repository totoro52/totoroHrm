package cn.totoro.service.impl;

import cn.totoro.dao.JobDao;
import cn.totoro.entity.Job;
import cn.totoro.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDao jobDao;

    @Override
    public List<Job> getAllJob() {
        return jobDao.getAllJob();
    }

    @Override
    public boolean addJob(Job job) {
        return jobDao.addJob(job);
    }

    @Override
    public boolean updateJob(Job job) {
        return jobDao.updateJob(job);
    }

    @Override
    public boolean deleteJobById(Integer id) {
        return jobDao.deleteJobById(id);
    }

}
