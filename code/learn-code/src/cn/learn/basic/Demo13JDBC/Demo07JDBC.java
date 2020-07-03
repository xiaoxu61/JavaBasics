package cn.learn.basic.Demo13JDBC;
/*
    JDBC��ȡ���ݱ�sort��ÿ�����ݷ�װ��Sort��Ķ�����
    �ܶ��Sort����󣬴洢��List������
*/

import cn.learn.basic.Demo13JDBC.jdbcutil.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Demo07JDBC {
    public static void main(String[] args) throws Exception{
        //ʹ��JDBC�����ֱ࣬�ӻ�ȡ���ݿ����Ӷ���
        Connection con = JDBCUtils.getConnection();
        //���ӻ�ȡ���ݿ�SQL���ִ���߶���
        PreparedStatement pst = con.prepareStatement("SELECT * FROM sort");
        //���÷�����ȡ�����
        ResultSet rs = pst.executeQuery();
        //�������϶���
        List<Sort> list = new ArrayList<Sort>();
        while (rs.next()) {
            //��ȡ��ÿ�������ݣ���װ��Sort������
            Sort s = new Sort(rs.getInt("sid"), rs.getString("sname"),
                    rs.getDouble("sprice"), rs.getString("sdesc"));
            //��װ��Sort���󣬴洢��������
            list.add(s);
        }
        JDBCUtils.close(con, pst, rs);
        //��������
        for (Sort sort : list) {
            System.out.println(sort);
        }
    }
}
