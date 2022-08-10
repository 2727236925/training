package JDBCTest;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest2 {

    @Test
    public void test1() throws SQLException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        BasicDataSource basicDataSource=ac.getBean("basicDataSource", BasicDataSource.class);
        Connection conn=basicDataSource.getConnection();
//        PreparedStatement pst=conn.prepareStatement("select * from t_user where u_id = ? and u_name = ?");

    }
    @Test
    public void test2() throws SQLException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        DruidDataSource druidDataSource=ac.getBean("druidDataSource", DruidDataSource.class);
        Connection conn=druidDataSource.getConnection();
        System.out.println(conn);
    }
}
