package com.lanou.dao;

import com.lanou.pojo.Student;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;



@Repository
public interface StudentDao extends Mapper<Student> {

}
