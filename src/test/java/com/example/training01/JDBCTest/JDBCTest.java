package JDBCTest;

import com.example.training01.JDBC.JDBCUtils;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class JDBCTest {

    /**
     * 传统JDBC操作数据库
     */
    @Test
    public void test1() throws ClassNotFoundException, SQLException {
            Connection conn = JDBCUtils.getConnection();

            try{
                PreparedStatement pst=conn.prepareStatement("select * from t_user where u_id = ? and u_name = ?");
                pst.setInt(1,1);
                pst.setString(2,"龙吟");
                ResultSet resultSet = pst.executeQuery();
                while(resultSet.next()){
                    System.out.println(resultSet.getString("u_id")+"----"+resultSet.getString("u_name"));
                }
                resultSet.close();
                pst.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    @Test
    public void test2() throws SQLException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        DriverManager driverManager = ac.getBean("driverManager",DriverManager.class);
        Connection conn=driverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Zcl27272369250?");
        System.out.println(conn);
    }

    @Test
    public void test3() throws SQLException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        DriverManagerDataSource dataSource = ac.getBean("dataSource", DriverManagerDataSource.class);
        Connection conn=dataSource.getConnection();
        System.out.println(conn);
    }

    @Test
    public void test4(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        Map<String,Object> stringObjectMap= jdbcTemplate.queryForMap("select * from t_user");
        System.out.println(stringObjectMap);
    }

    @Test
    public void test5(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        String sql="select * from t_user";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String,Object> map:list) {
            System.out.println(map);
        }
    }

    @Test
    public void test6(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        String sql1="insert into t_user values (2,'周峰')";
        jdbcTemplate.update(sql1);
        String sql2="insert into t_user values ( ? , ? )";
        jdbcTemplate.update(sql2,3,"李树");
        String sql3="insert into t_user values ( ? , ? )";
        jdbcTemplate.update(sql3,4,"柳格");
        String sql4="delete from t_user where u_id = ?";
        jdbcTemplate.update(sql4,3);
        String sql5="update t_user set u_id = ? , u_name = ? where u_id = ?";
        jdbcTemplate.update(sql5,6,"王泽额",2);
        String sql6="select * from t_user";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql6);
        for (Map<String,Object> map:list) {
            System.out.println(map);
        }
    }
}