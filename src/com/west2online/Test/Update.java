package com.west2online.Test;

import com.west2online.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Update {
    public static void update() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);

            String original_good_no = null,good_no,good_name,order_no,good_id,order_id;
            double good_price;

            Scanner scanner = new Scanner(System.in);
            System.out.printf("请输入要更改的订单的订单编号:");
            order_no = scanner.nextLine();
            String sql = "select `good_no` from `good_order` where `order_no`=?";

            st = conn.prepareStatement(sql);
            st.setString(1,order_no);

            rs = st.executeQuery();

            if (rs.next()) {
                original_good_no = rs.getString("good_no");
            }

            System.out.printf("请输入商品编号:");
            good_no = scanner.nextLine();
            System.out.printf("请输入新的商品名:");
            good_name = scanner.nextLine();
            System.out.printf("请输入新的商品价格:");
            good_price = scanner.nextDouble();


            String sql1 = "update goods set `good_no`=?,`good_name`=?,`good_price`=? where `good_no`=?";

            st = conn.prepareStatement(sql1); //预编译sql,先写sql，然后不执行

            //手动给参数赋值
            st.setString(1,good_no);
            st.setString(2,good_name);
            st.setDouble(3,good_price);
            st.setString(4,original_good_no);

            st.executeUpdate();

            String sql2 = "update good_order set `good_no`=? where `good_no`=?";

            st = conn.prepareStatement(sql2);

            st.setString(1,good_no);
            st.setString(2,original_good_no);

            st.executeUpdate();

            //执行

            conn.commit();

            System.out.println("更新成功");

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
