package cn.totoro.service.impl;

import cn.totoro.dao.EmployeeDao;
import cn.totoro.entity.Employee;
import cn.totoro.entity.Page;
import cn.totoro.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    @Override
    public boolean deleteEmployeeById(Integer id) {
        return employeeDao.deleteEmployeeById(id);
    }

    @Override
    public List<Object> getEmployeeByPage(Page page) {
        List<Object> list = new ArrayList<>();
        page.setTotalElementsAndTotalPages(getEmployeeTotal());
        List<Employee> employees = employeeDao.getEmployeeByPage(page);
        list.add(page);
        list.add(employees);
        return list;
    }

    @Override
    public Integer getEmployeeTotal() {
        return employeeDao.getEmployeeTotal();
    }
}
