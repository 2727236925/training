package com.example.training01.MybatisStudy.dao;

import com.example.training01.MybatisStudy.entity.t_User;
import com.example.training01.MybatisStudy.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("UserDao")
public class UserDaoImpl implements UserDao{

    @Override
    public void Insert(t_User t_user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession() ;
        int insert=sqlSession.insert( "com.example.training01.MybatisStudy.dao.UserDao.Insert",t_user);
        System.out.println(insert);
        sqlSession.commit();
    }

    @Override
    public void Delete(Integer u_id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession() ;
        int delete=sqlSession.delete( "com.example.training01.MybatisStudy.dao.UserDao.Delete",u_id);
        System.out.println(delete);
        sqlSession.commit();
    }

    @Override
    public t_User SelectSingle(Integer u_id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        return sqlSession.selectOne("com.example.training01.MybatisStudy.dao.UserDao.SelectSingle",u_id);
    }

    @Override
    public List<t_User> SelectMap(Map<String,Object> paramMap) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession() ;
        List<t_User> selectMap=sqlSession.selectList( "com.example.training01.MybatisStudy.dao.UserDao.SelectMap",paramMap);
        sqlSession.commit();
        return selectMap;
    }

    @Override
    public void Update(t_User t_user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession() ;
        int update=sqlSession.update( "com.example.training01.MybatisStudy.dao.UserDao.Update",t_user);
        System.out.println(update);
        sqlSession.commit();
    }
}
