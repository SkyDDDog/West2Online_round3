package com.west2online.Test;
import com.west2online.utils.JdbcUtils;
import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class Insert {
    public static void insert() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            //关闭自动提交 开启事务
            conn.setAutoCommit(false);
            //区别
            //使用?占位符代替参数
            //设置需要传入的参数
            String good_no,good_name,order_no;
            double good_price;
            //手动给参数赋值
            Scanner scanner = new Scanner(System.in);
            System.out.printf("请输入订单编号:");
            order_no = scanner.nextLine();
            System.out.printf("请输入商品编号:");
            good_no = scanner.nextLine();
            System.out.printf("请输入商品名:");
            good_name = scanner.nextLine();
            System.out.printf("请输入商品价格:");
            good_price = scanner.nextDouble();

            String sql1 = "insert into goods(`good_no`,`good_name`,`good_price`) VALUES(?,?,?)";

            st = conn.prepareStatement(sql1);

            st.setString(1,good_no);
            st.setString(2,good_name);
            st.setDouble(3,good_price);

            st.executeUpdate();

            String sql2 = "INSERT INTO good_order(`order_no`,`good_no`,`order_time`) VALUES(?,?,?)";

            st = conn.prepareStatement(sql2);

            st.setString(1,order_no);
            st.setString(2,good_no);
            st.setDate(3,new java.sql.Date(new Date().getTime()));

            st.executeUpdate();

            //执行

            conn.commit();

            System.out.println("插入成功");


        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
