package com.composite.mybatis;

import com.composite.mybatis.bean.User;
import com.composite.mybatis.mapper.UserMapper;
import com.composite.mybatis.session.MySqlSession;

public class TestMybatis {
    public static void main(String[] args) {
        MySqlSession sqlSession=new MySqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class,"UserMapper.xml");
        User user = mapper.getUserById("1");
        System.out.println(user);
    }
}
