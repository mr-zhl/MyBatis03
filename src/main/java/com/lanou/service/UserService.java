package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findUsers();
    PageInfo<User> findUsers(int page, int count);


}
