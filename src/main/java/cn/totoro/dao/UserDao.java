package cn.totoro.dao;

import cn.totoro.entity.Page;
import cn.totoro.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface UserDao {

    /**
     * 根据用户名登录，返回登录用户实体类
     * @param username
     * @param password
     * @return
     */
    User loginByLoginName(@Param("username") String username, @Param("password") String password);

    /**
     * 获取所有用户
     * @return
     */
    List<User> getAllUser();

    /**
     * 按照分页获取用户
     * @return
     */
    List<User> getUserByPage(Page page);


    /**
     * 根据LoginName模拟搜索
     * @param name
     * @return
     */
    List<User> getUserByVagueName(@Param("page") Page page,@Param("name") String name);

    /**
     * 获取数量
     * @return
     */
    Integer getUserTotal();


    /**
     * 增加用户
     * @param user
     * @return
     */
    boolean addUser(User user);


    /**
     * 更新用户信息
     * @param user
     * @return
     */
    boolean updateUser(User user);


    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
    boolean deleteUserById(Integer id);


}
