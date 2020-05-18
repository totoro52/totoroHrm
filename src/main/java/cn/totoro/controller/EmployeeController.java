package cn.totoro.controller;


import cn.totoro.annotation.TokenAccess;
import cn.totoro.entity.Employee;
import cn.totoro.entity.Page;
import cn.totoro.handler.ApiResult;
import cn.totoro.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/employees")
@Controller
@TokenAccess
public class EmployeeController{

    @Autowired
    private EmployeeServiceImpl employeeService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ApiResult getAllEmployee(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                    @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){

        Page pages = new Page(page,pageSize);
        List<Object> allEmployee = employeeService.getEmployeeByPage(pages);
        if(allEmployee!=null){
            return ApiResult.success("获取所有用户成功",allEmployee);
        }
        return ApiResult.fail("fail","获取用户失败");
    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ApiResult addEmployee(@Valid Employee employee, BindingResult result){
        if(result.getErrorCount()>=1){
            return  ApiResult.fail("fail",result.getAllErrors().get(0).getDefaultMessage());
        }
        boolean isInsert = employeeService.addEmployee(employee);
        if(isInsert){
            return ApiResult.success(ApiResult.DEFAULT_CODE,"新增员工成功",employee);
        }
        return  ApiResult.fail("fail","新增员工失败，请检查数据是否合法");
    }

    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ApiResult updateEmployee(@PathVariable("id")Integer id, Employee employee){
        employee.setId(id);
        boolean isUpdate = employeeService.updateEmployee(employee);
        if(isUpdate){
            return ApiResult.success(ApiResult.DEFAULT_CODE,"员工信息更新成功",employee);
        }
        return  ApiResult.fail("fail","更新失败，ID错误或数据未更新");
    }

    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ApiResult deleteEmployee(@PathVariable("id") Integer id){
        boolean isDelete = employeeService.deleteEmployeeById(id);
        if(isDelete){
            return ApiResult.success(ApiResult.DEFAULT_CODE,"员工删除成功");
        }
        return  ApiResult.fail("fail","删除失败，员工或不存在");
    }

}
