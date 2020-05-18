package cn.totoro.dao;

import cn.totoro.entity.Dept;

import java.util.List;

public interface DeptDao {

    /**
     * 获取所有部门
     * @return
     */
    List<Dept> getAllDept();


    /**
     * 根据ID查找员工
     * @param id
     * @return
     */
    Dept getDeptById(Integer id);

    /**
     * 新增职位
     * @param dept
     * @return
     */
    boolean addDept(Dept dept);

    /**
     * 更新部门信息
     * @param dept
     * @return
     */
    boolean updateDept(Dept dept);

    /**
     * 根据ID删除部门
     * @param id
     * @return
     */
    boolean deleteDeptById(Integer id);


}
