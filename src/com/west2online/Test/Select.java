package com.west2online.Test;

import com.west2online.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Select {
    public static void select() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();

            Scanner scanner = new Scanner(System.in);
            String order_no;

            System.out.printf("请输入要查询的订单编号:");
            order_no = scanner.nextLine();

            String sql = "SELECT o.`order_no`,o.`good_no`,g.`good_name`,g.`good_price`,o.`order_time` FROM good_order o INNER JOIN goods g ON o.`good_no`=g.`good_no` WHERE o.`order_no`=?";

            st = conn.prepareStatement(sql); //预编译sql,先写sql，然后不执行

            //手动给参数赋值
            st.setString(1,order_no);

            //执行
            rs = st.executeQuery();
            while (rs.next()) {
                System.out.println("=====================================");
                System.out.println("订单编号:"+rs.getString("order_no"));
                System.out.println("商品编号:"+rs.getString("good_no"));
                System.out.println("商品名称:"+rs.getString("good_name"));
                System.out.println("商品价格:"+rs.getDouble("good_price"));
                System.out.println("订单日期:"+rs.getTime("order_time"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st,rs);
        }
    }

}
