package com.example.training01.Real_Study.dao;

import com.example.training01.Real_Study.domain.t_User;
import com.example.training01.Real_Study.entity.Operation;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;


public interface UserDao{

    void Update(t_User t_user) throws SQLException;

    void Uplog(t_User t_user,Operation operation) throws SQLException;

}
