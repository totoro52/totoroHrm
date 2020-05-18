package cn.totoro.controller;

import cn.totoro.annotation.TokenAccess;
import cn.totoro.entity.Menu;
import cn.totoro.handler.ApiResult;
import cn.totoro.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/api/v1/menus")
@Controller
@TokenAccess
public class MenuController {


    @Autowired
    private MenuServiceImpl menuService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ApiResult getAllMenus(){
        return ApiResult.success("获取菜单成功",menuService.getAllMenus());
    }
}
