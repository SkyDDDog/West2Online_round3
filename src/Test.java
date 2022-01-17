import javax.xml.transform.Result;
import java.sql.*;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        System.out.println("Hello");
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");     //固定写法,加载驱动

        //2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username = "root";
        String password = "9738faq";

        //3.连接成功，数据库对象
        Connection connection = DriverManager.getConnection(url,username,password);

        //4.执行sql的对象
        Statement statement = connection.createStatement();

        //5.执行sql的对象 去 执行sql 可能存在结果，查看返回结果
        String sql = "SELECT * FROM users";//编写sql
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name="+resultSet.getObject("NAME"));
            System.out.println("pwd="+resultSet.getObject("PASSWORD"));
            System.out.println("email="+resultSet.getObject("email"));
            System.out.println("birth="+resultSet.getObject("birthday"));
            System.out.println("=============================");
        }

        //6.释放链接
        resultSet.close();
        statement.close();
        connection.close();

        


    }
}
