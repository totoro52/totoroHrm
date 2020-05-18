package cn.totoro.service;

import cn.totoro.entity.Employee;
import cn.totoro.entity.Page;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();
    boolean addEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployeeById(Integer id);
    List<Object> getEmployeeByPage(Page page);
    Integer getEmployeeTotal();
}
