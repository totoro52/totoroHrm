package cn.totoro.service;

import cn.totoro.entity.Menu;

import java.util.List;

public interface MenuService {
    /**
     * 获取所有菜单
     * @return
     */
    List<Menu> getAllMenus();
}
