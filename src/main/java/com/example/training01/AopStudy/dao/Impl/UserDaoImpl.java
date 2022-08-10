package com.example.training01.AopStudy.dao.Impl;

import com.example.training01.AopStudy.dao.UserDao;
import com.example.training01.AopStudy.domain.t_User;
import com.example.training01.AopStudy.entity.Operation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate template;

//    @Resource(name = "myTransManager")
//    private MyTransManager myTransManager;

//    @Resource
//    public void setTemplate(JdbcTemplate template) {
//        this.template=template;
//    }

    @Override
    public void Update(t_User t_user) {
//        Connection connection=myTransManager.getConn();
        String sql1 = "insert into t_user values (? , ?)";
        template.update(sql1, t_user.getU_id(), t_user.getU_name());
    }
    @Override
    public void Uplog(t_User t_user, Operation operation) {
//        Connection connection=myTransManager.getConn();
        String sql2 = "insert into operation values (? , '添加用户信息' , ?)";
//        int a=5/0;
        template.update(sql2, operation.getId(), t_user.getU_id());
    }


}
