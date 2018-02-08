package com.cjzf.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.cjzf.dao.UserMapper;
import com.cjzf.entity.User;
import com.cjzf.entity.UserCriteria;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserService
 * @Description
 * @author nicholas
 * @Date 2018年1月12日 上午10:20:18
 * @version 1.0.1
 */
@Service
@Slf4j
public class UserService {
    @Resource
    private UserMapper userMapper;

    public User findUserInfoByName(String userName) {
        UserCriteria userCriteria = new UserCriteria();
        UserCriteria.Criteria criteria = userCriteria.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<User> users = userMapper.selectByExample(userCriteria);

        return (users != null) ? !users.isEmpty() ? users.get(0) : null : null;
    }
}