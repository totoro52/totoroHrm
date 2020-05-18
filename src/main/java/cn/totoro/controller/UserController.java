package cn.totoro.controller;


import cn.totoro.annotation.TokenAccess;
import cn.totoro.entity.Page;
import cn.totoro.entity.User;
import cn.totoro.handler.ApiResult;
import cn.totoro.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RequestMapping("/api/v1/users")
@Controller
@TokenAccess
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ApiResult getAllUser(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        Page pages = new Page(page,pageSize);
        List<Object> allUser = userService.getUserByPage(pages);
        if(allUser!=null){
            return ApiResult.success("获取所有用户成功",allUser);
        }
        return ApiResult.fail("fail","获取用户失败");
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ApiResult addUser(@Valid User user, BindingResult result){
        if(result.getErrorCount()>=1){
            return  ApiResult.fail("fail",result.getAllErrors().get(0).getDefaultMessage());
        }
        boolean isInsert = userService.addUser(user);
        if(isInsert){
            return ApiResult.success(ApiResult.DEFAULT_CODE,"新增用户成功",user);
        }
        return  ApiResult.fail("fail","新增用户失败，请检查数据是否合法");
    }

    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ApiResult updateUser(@PathVariable("id")Integer id, User user){
        user.setId(id);
        boolean isUpdate = userService.updateUser(user);
        if(isUpdate){
            return ApiResult.success(ApiResult.DEFAULT_CODE,"用户信息更新成功",user);
        }
        return  ApiResult.fail("fail","更新失败，ID错误或数据未更新");
    }

    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ApiResult deleteUser(@PathVariable("id") Integer id){
        boolean isDelete = userService.deleteUserById(id);
        if(isDelete){
            return ApiResult.success(ApiResult.DEFAULT_CODE,"用户删除成功");
        }
        return  ApiResult.fail("fail","删除失败，用户或不存在");
    }

    @ResponseBody
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public ApiResult queryUser(@RequestParam(value = "page",defaultValue = "1")Integer page,
                               @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
                               @RequestParam(value = "loginName",required = false)String loginName){
        Page pages = new Page(page,pageSize);
        List<Object> queryUsers = userService.getUserByVagueName(pages,loginName);
        if(queryUsers!=null){
            return ApiResult.success("搜索成功",queryUsers);
        }
        return ApiResult.fail("fail","获取用户失败");
    }





}
