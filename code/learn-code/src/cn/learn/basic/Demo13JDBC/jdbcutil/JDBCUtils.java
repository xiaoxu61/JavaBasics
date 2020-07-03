package cn.learn.basic.Demo13JDBC.jdbcutil;
/*
ʵ��JDBC�Ĺ�����
���巽����ֱ�ӷ������ݿ�����Ӷ���


*/

import java.sql.*;

public class JDBCUtils {
    private JDBCUtils() {}
    private static Connection con;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mybase";
            String username = "root";
            String password = "123";
            con = DriverManager.getConnection(url, username, password);
        }catch (Exception ex) {
            throw new RuntimeException(ex + "���ݿ�����ʧ��");
        }

    }

    //���徲̬�������������ݿ�����Ӷ���
    public static Connection getConnection() {
        return con;
    }

    public  static void close(Connection con, Statement stat) {
        if (stat != null) {
            try {
                stat.close();
            }catch (SQLException ex) {}
        }

        if (con != null) {
            try {
                con.close();
            }catch (SQLException ex) {}
        }
    }

    public  static void close(Connection con, Statement stat, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            }catch (SQLException ex) {}
        }

        if (stat != null) {
            try {
                stat.close();
            }catch (SQLException ex) {}
        }

        if (con != null) {
            try {
                con.close();
            }catch (SQLException ex) {}
        }
    }
}
