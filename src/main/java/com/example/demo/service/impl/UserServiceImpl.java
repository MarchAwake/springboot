package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.model.User;
import com.example.demo.pojo.model.UserExample;
import com.example.demo.service.UserService;
import com.example.demo.utils.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> userList() {

        UserExample userExample = new UserExample();
//        增加查询条件
//        UserExample.Criteria criteria = userExample.createCriteria();
//        criteria.andIdEqualTo(1);
//        criteria.andUserAgeEqualTo("100");
        return userMapper.selectByExample(userExample);
    }

    @Override
    public Boolean delete(String userId) {

        int effectRow = userMapper.deleteByPrimaryKey(userId);

        return effectRow == 1;
    }

    @Override
    public User detail(String userId) {

        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED) // 开启事务
    public User save(User user) {

        // 新增操作
        if (StringUtils.isEmpty(user.getId())) {

            // FIXME 这里需要判断用户名是否存在
            user.setId(UuidUtil.getShortUuid());
            userMapper.insert(user);
        } else {

            // 更新操作
            userMapper.updateByPrimaryKeySelective(user);
        }

        return user;
    }
}
