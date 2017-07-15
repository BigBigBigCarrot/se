package com.david.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *	例子：获取过程的结果集
 */
public class CursorAndResultSet {

	public static void main(String[] args) throws SQLException {
		Connection connection=JDBCUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql="call p_resultset_test(); ";
		
		/*
		//获取单个结果集
		preparedStatement=connection.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();//执行语句，得到结果集
	
		while (resultSet.next()) {  
            String column1 = resultSet.getString(1);  
            String column2 = resultSet.getString(2);  
            String column3 = resultSet.getString(3);  
            String column4 = resultSet.getString(4); 
            String column5 = resultSet.getString(5);
            System.out.println(column1 + "\t" + column2 + "\t" + column3 + "\t" + column4 + "\t" +column5);  
        }//显示数据 
		*/
		
		//获取多个结果集 
		//sql="{call p_resultset_test()} ";
		sql="{call p_temp_table_test()} ";
		CallableStatement cs=connection.prepareCall(sql);
		boolean hadResults = cs.execute();  
		resultSet = cs.getResultSet();
		if(hadResults&&cs.getResultSet()!=null){
			while (resultSet.next()) {  
	            String column1 = resultSet.getString(1);  
	            String column2 = resultSet.getString(2);  
	            String column3 = resultSet.getString(3);  
	            String column4 = resultSet.getString(4); 
	            String column5 = resultSet.getString(5);
	            System.out.println(column1 + "\t" + column2 + "\t" + column3 + "\t" + column4 + "\t" +column5);  
	        }//显示数据 
		}
		
		
		hadResults = cs.getMoreResults(); //检查是否存在下一个结果集 
		if(hadResults&&cs.getResultSet()!=null){
			System.out.println("-------------------第二组结果集--------------------");  
			resultSet = cs.getResultSet();
			while (resultSet.next()) {  
	            String column1 = resultSet.getString(1);
	            String column2 = resultSet.getString(2);  
	            String column3 = resultSet.getString(3);  
	            String column4 = resultSet.getString(4); 
	            String column5 = resultSet.getString(5);
	            System.out.println(column1 + "\t" + column2 + "\t" + column3 + "\t" + column4 + "\t" +column5);  
	        }//显示数据 
		}
	      
		resultSet.close();
		connection.close();

	}

}
