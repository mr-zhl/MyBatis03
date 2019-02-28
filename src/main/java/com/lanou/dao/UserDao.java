package com.lanou.dao;

import com.lanou.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
    List<User> selectAll();

    List<User> selectBylimit(@Param("m") int m, @Param("n") int n);
}
