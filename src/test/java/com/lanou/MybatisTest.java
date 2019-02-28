package com.lanou;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.dao.StudentDao;
import com.lanou.dao.UserDao;
import com.lanou.pojo.Student;
import com.lanou.pojo.User;
import com.lanou.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring-config.xml")
 class MybatisTest {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private StudentDao studentDao;

    @Test
    void test() {
        List<User> userList = userDao.selectAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    void test2() {
        List<User> users = userService.findUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void test3() {
        //#{}和${}都可以注入值;当#{}注入时,会加"",${}则不会
        //注:能用#{},就尽量要使用#{};
        List<User> userList = userDao.selectBylimit(2, 3);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    void test4() {
        PageHelper.startPage(1,2);
        List<User> userList = userDao.selectAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    void test5() {
        PageInfo<User> pageInfo = userService.findUsers(1, 2);
        System.out.println(pageInfo);
    }

    @Test
    void test6() {
        List<Student> studentList = studentDao.selectAll();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
