package com.luck.demo.service.impl;

import com.luck.demo.entity.user;
import com.luck.demo.mapper.userMapper;
import com.luck.demo.service.UserServices;
import com.luck.demo.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private userMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public int login(user user) {


        if (userMapper.login(user) != null) {
            return userMapper.login(user);
        } else {
            return 0;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public String queryPasswordByUsername(String username) {

        return userMapper.queryPasswordByUsername(username);
    }

    @Override
    public List<String> selectRoleByUserName(String username) {
        return userMapper.selectRoleByUserName(userMapper);
    }

    @Transactional
    @Override
    public Integer userRegister(user user) {

        //密码加密
        String password = user.getPassword();
        String encodePassword = bCryptPasswordEncoder.encode(password);
        user.setPassword(encodePassword);
        return userMapper.userRegister(user);

    }

    @Override
    @Transactional(readOnly = true)
    public user checkUsername(String username) {
        return userMapper.checkUsername(username);

    }

    @Override
    public void test(List<Integer> ids) {
        userMapper.test(ids);
        System.out.println("第" + ids + "次调用");
    }

    @Override
    public void testInsert1(user user) {
        userMapper.testInsert1(user);
    }

    @Override
    public List<user> queryUser(user user) {
        //先从redis中判断是否有数据
//        String allUser = redisUtil.get("allUser");
        List<Object> allUser = redisUtil.lGet("allUser", 0, -1);
        if (allUser.size() != 0) {
            List<user> o = (List<com.luck.demo.entity.user>) allUser.get(0);
            redisUtil.expire("allUser", 1);
            return o;
        } else {
            //去数据库中查询
            List<com.luck.demo.entity.user> userList = userMapper.queryUser(user);
            if (userList.isEmpty()) {
                redisUtil.lSet("", "");
            } else {
                boolean b = redisUtil.lSet("allUser", userList);
                redisUtil.expire("allUser", 1000);
            }

            return userList;
        }
    }

    @Override
    public void testInsert(ArrayList<user> list) {
        userMapper.testInsert(list);
//        redisUtil.append("123", "321");

    }
}
