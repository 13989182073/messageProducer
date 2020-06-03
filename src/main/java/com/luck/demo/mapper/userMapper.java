package com.luck.demo.mapper;

import com.luck.demo.entity.user;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface userMapper extends Mapper<user> {
    Integer login(user user);

    String queryPasswordByUsername(String username);

    List<String> selectRoleByUserName(userMapper userMapper);

    Integer userRegister(user user);

    user checkUsername(String username);

    void test(List<Integer> ids);

    void testInsert(List<user> list);

    void testInsert1(user user);

    List<user> queryUser(user user);
}