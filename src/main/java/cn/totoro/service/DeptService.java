package cn.totoro.service;


import cn.totoro.entity.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> getAllDept();
    boolean addDept(Dept dept);
    boolean updateDept(Dept dept);
    boolean deleteDeptById(Integer id);
}
