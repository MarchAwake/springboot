package com.example.demo.service;

import com.example.demo.pojo.model.User;

import java.util.List;

/**
 * 用户接口定义
 */
public interface UserService {

    /**
     * <h2>用户列表</h2>
     * @return {@link  List}
     */
    List<User> userList();

    /**
     * <h2>删除用户</h2>
     * @param userId 用户ID
     * @return {@link Boolean}
     */
    Boolean delete(String userId);


    /**
     * <h2>用户详情</h2>
     * @param userId 用户ID
     * @return {@link User}
     */
    User detail(String userId);


    /**
     * <h2>用户保存或修改</h2>
     * @param user 用户信息
     * @return {@link User}
     */
    User save(User user);
}
