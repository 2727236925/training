package com.example.training01.AopStudy.dao;

import com.example.training01.AopStudy.domain.t_User;
import com.example.training01.AopStudy.entity.Operation;

import java.sql.SQLException;


public interface UserDao{

    void Update(t_User t_user) throws SQLException;

    void Uplog(t_User t_user, Operation operation) throws SQLException;

}
