package com.example.beauty.dao;

import com.example.beauty.mapper.UserMapper;
import com.example.beauty.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by NiuLilu on 2020-04-13 16:38.
 */
@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public List<User> login(String phoneNumber, String password) {
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("phoneNumber",phoneNumber)
                .andEqualTo("password",password);
        return userMapper.selectByExample(example);
    }

    public List<User> findUserByPhone(String phoneNumber) {
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("phoneNumber",phoneNumber);
        return userMapper.selectByExample(example);
    }

    public Integer addUser(User user) {
        return userMapper.insert(user);
    }

    public Integer deleteUser(Long userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    public Integer updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public User findUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> selectAll() {
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("mark",0);
        return userMapper.selectByExample(example);
    }

    public Integer addUsers(List<User> user) {
        return userMapper.insertList(user);
    }

    public List<User> selectAllAdmin() {
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("mark",1);
        return userMapper.selectByExample(example);
    }
}
