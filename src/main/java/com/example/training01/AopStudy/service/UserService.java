package com.example.training01.AopStudy.service;

import com.example.training01.AopStudy.domain.t_User;
import com.example.training01.AopStudy.entity.Operation;

import java.sql.SQLException;

public interface UserService {

    void UserUpdate(t_User t_user, Operation operation) throws SQLException;
}
