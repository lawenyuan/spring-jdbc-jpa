package com.myproject.service;

import com.myproject.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class StudentService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Student findByUid(int uid){
        String sql = "select uid, uname, sex from student where uid="+uid;
       return jdbcTemplate.query(sql, new ResultSetExtractor<Student>() {
            @Override
            public Student extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()){
                    Student temp = new Student();
                    temp.setUid(resultSet.getInt("uid"));
                    temp.setUname(resultSet.getString("uname"));
                    temp.setSex(resultSet.getInt("sex"));
                    return temp;
                }
                return null;
            }
        });
    }
}
