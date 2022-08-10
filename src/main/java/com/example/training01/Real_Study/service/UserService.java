package com.example.training01.Real_Study.service;

import com.example.training01.Real_Study.domain.t_User;
import com.example.training01.Real_Study.entity.Operation;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

public interface UserService {

    void UserUpdate(t_User t_user, Operation operation) throws SQLException;
}
