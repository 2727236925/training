package com.example.training01.Real_Study.service.Impl;

import com.example.training01.Real_Study.dao.UserDao;
import com.example.training01.Real_Study.domain.t_User;
import com.example.training01.Real_Study.entity.Operation;
import com.example.training01.Real_Study.service.UserService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao userDao;

//    @Resource
//    public void setUserDao(UserDaoImpl userDao) {
//        this.userDao = userDao;
//    }


    /**
     * 业务方法中侵入了事务管理代码
     */
//    @Resource(name = "myTransManager")
//    private MyTransManager myTransManager;

    @Override
    public void UserUpdate(t_User t_user, Operation operation) throws SQLException {
        userDao.Update(t_user);
        userDao.Uplog(t_user,operation);
    }

}
