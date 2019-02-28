package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.dao.UserDao;
import com.lanou.pojo.User;
import com.lanou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//异常时回滚
@Transactional(rollbackFor = Exception.class)
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public List<User> findUsers() {
        return userDao.selectAll();


    }

    public PageInfo<User> findUsers(int page, int count) {
        PageHelper.startPage(page,count);
        List<User> userList = userDao.selectAll();
        PageInfo<User> userPageInfo = new PageInfo<User>(userList);
        return userPageInfo;
    }
}
