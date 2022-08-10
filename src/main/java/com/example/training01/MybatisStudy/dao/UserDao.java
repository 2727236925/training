package com.example.training01.MybatisStudy.dao;

import com.example.training01.MybatisStudy.entity.t_User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    /**
     * 查找用户操作
     */
    void Insert(t_User t_user);

    /**
     * 删除用户操作
     */
    void Delete(Integer u_id);

    /**
     * 单个插入用户操作
     */
    t_User SelectSingle(Integer u_id);

    /**
     * 多个插入用户操作
     *
     * @return
     */
    List<t_User> SelectMap(Map<String,Object> paramMap);

    /**
     * 修改用户操作
     */
    void Update(t_User t_user);


}
