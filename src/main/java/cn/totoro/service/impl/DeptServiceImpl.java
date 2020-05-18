package cn.totoro.service.impl;

import cn.totoro.dao.DeptDao;
import cn.totoro.entity.Dept;
import cn.totoro.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> getAllDept() {
        return deptDao.getAllDept();
    }

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public boolean updateDept(Dept dept) {
        return deptDao.updateDept(dept);
    }

    @Override
    public boolean deleteDeptById(Integer id) {
        return deptDao.deleteDeptById(id);
    }
}
