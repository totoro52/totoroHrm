package cn.totoro.service;

import cn.totoro.entity.Page;
import cn.totoro.entity.User;

import java.util.List;

public interface UserService {

    User loginByLoginName(String username, String password);
    List<User> getAllUser();
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUserById(Integer id);
    List<Object> getUserByPage(Page page);
    Integer getUserTotal();
    List<Object> getUserByVagueName(Page page,String name);
}
