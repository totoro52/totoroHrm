package cn.totoro.service.impl;

import cn.totoro.dao.MenuDao;
import cn.totoro.entity.Menu;
import cn.totoro.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    /**
     * 获取全部总父级菜单
     * @return
     */
    @Override
    public List<Menu> getAllMenus() {
        return menuDao.getAllParentMenus();
    }
}
