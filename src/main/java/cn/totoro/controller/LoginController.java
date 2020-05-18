package cn.totoro.controller;


import cn.totoro.entity.User;
import cn.totoro.handler.ApiResult;
import cn.totoro.service.impl.UserServiceImpl;
import cn.totoro.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@RequestMapping("/api/v1/")
@Controller
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ApiResult loginByLoginName(@RequestParam(value = "loginName")String loginname, @RequestParam(value = "password")String password){
        User user = userService.loginByLoginName(loginname, password);
        if(user!=null){
            String token = JwtUtil.sign(user);
            HashMap<String,Object> data = new HashMap<>();
            data.put("user",user);
            data.put("token",token);
            return ApiResult.success("登录成功",data);
        }
        return  ApiResult.fail("fail","登录失败，账号或密码错误");
    }

}
