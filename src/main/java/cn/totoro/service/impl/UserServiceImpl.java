package cn.totoro.service.impl;

import cn.totoro.dao.UserDao;
import cn.totoro.entity.Page;
import cn.totoro.entity.User;
import cn.totoro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User loginByLoginName(String username, String password) {
        return userDao.loginByLoginName(username,password);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public List<Object> getUserByPage(Page page) {
        List<Object> list = new ArrayList<>();
        page.setTotalElementsAndTotalPages(getUserTotal());
        List<User> users = userDao.getUserByPage(page);
        list.add(page);
        list.add(users);
        return list;
    }

    @Override
    public Integer getUserTotal() {
        return userDao.getUserTotal();
    }

    @Override
    public List<Object> getUserByVagueName(Page page,String name) {
        List<Object> list = new ArrayList<>();
        page.setTotalElementsAndTotalPages(getUserTotal());
        List<User> users = userDao.getUserByVagueName(page,name);
        list.add(page);
        list.add(users);
        return list;
    }
}
