package cn.totoro.dao;


import cn.totoro.entity.Employee;
import cn.totoro.entity.Page;

import java.util.List;

public interface EmployeeDao {

    /**
     * 获取全部员工
     * @return
     */
    List<Employee> getAllEmployee();

    /**
     * 新增一个员工
     * @param employee
     * @return
     */
    boolean addEmployee(Employee employee);

    /**
     * 更新员工信息
     * @param employee
     * @return
     */
    boolean updateEmployee(Employee employee);

    /**
     * 删除员工信息
     * @param id
     * @return
     */
    boolean deleteEmployeeById(Integer id);


    /**
     * 按照分页获取员工
     * @return
     */
    List<Employee> getEmployeeByPage(Page page);

    /**
     * 获取数量
     * @return
     */
    Integer getEmployeeTotal();

}
