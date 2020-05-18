package cn.totoro.controller;

import cn.totoro.annotation.TokenAccess;
import cn.totoro.entity.Dept;
import cn.totoro.handler.ApiResult;
import cn.totoro.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/dept")
@Controller
@TokenAccess
public class DeptController {


    @Autowired
    private DeptServiceImpl deptService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ApiResult getAllDept(){
        List<Dept> allDept = deptService.getAllDept();
        if(allDept!=null){
            return ApiResult.success("获取所有部门成功",allDept);
        }
        return ApiResult.fail("fail","获取部门失败");
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ApiResult addDept(@Valid Dept dept, BindingResult result){
        if(result.getErrorCount()>=1){
            return  ApiResult.fail("fail",result.getAllErrors().get(0).getDefaultMessage());
        }
        boolean isInsert = deptService.addDept(dept);
        if(isInsert){
            return ApiResult.success(ApiResult.DEFAULT_CODE,"新增部门成功",dept);
        }
        return  ApiResult.fail("fail","新增部门失败，请检查数据是否合法");
    }


    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ApiResult updateDept(@PathVariable("id")Integer id, Dept dept){
        dept.setId(id);
        boolean isUpdate = deptService.updateDept(dept);
        if(isUpdate){
            return ApiResult.success(ApiResult.DEFAULT_CODE,"部门信息更新成功",dept);
        }
        return  ApiResult.fail("fail","更新失败，ID错误或数据未更新");
    }

    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ApiResult deleteDept(@PathVariable("id") Integer id){
        boolean isDelete = deptService.deleteDeptById(id);
        if(isDelete){
            return ApiResult.success(ApiResult.DEFAULT_CODE,"部门删除成功");
        }
        return  ApiResult.fail("fail","删除失败，用户或不存在");
    }

}
