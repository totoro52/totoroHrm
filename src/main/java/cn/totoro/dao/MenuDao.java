package cn.totoro.dao;

import cn.totoro.entity.Menu;

import java.util.List;

public interface MenuDao {

    /**
     * 获取所有父级菜单
     * @return
     */
    List<Menu> getAllParentMenus();

    /**
     * 获取所有子级菜单
     * @return
     */
    List<Menu> getAllChildMenus(Integer id);
}
