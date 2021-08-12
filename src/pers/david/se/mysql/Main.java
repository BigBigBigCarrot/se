package pers.david.se.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from customers ";

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();//执行语句，得到结果集

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String dob = resultSet.getString(4);
                String phone = resultSet.getString(5);
                System.out.println(id + "\t" + firstName + "\t" + lastName + "\t" + dob);
            }//显示数据 

        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            resultSet.close();
            connection.close();
        }
    }
}
