package com.example.training01.AopStudy.service.Impl;

import com.example.training01.AopStudy.dao.UserDao;
import com.example.training01.AopStudy.domain.t_User;
import com.example.training01.AopStudy.entity.Operation;
import com.example.training01.AopStudy.service.UserService;
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
