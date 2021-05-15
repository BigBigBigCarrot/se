/**
 * 
 */
package pers.david.se.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author david
 *
 */
public class JDBCUtils {

	public static final String url="jdbc:mysql://localhost/caiming";
	public static final String driver = "org.mariadb.jdbc.Driver";  
	public static final String user = "root";  
    public static final String password = "123";
    
    private static Connection connection = null;  
    
    public static Connection getConnection(){
    	if(connection!=null){
    		return connection;
    	}
    	try{
    		Class.forName(driver);
    		connection = DriverManager.getConnection(url, user, password);//��ȡ���� 
		}catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
    	return connection;
    } 

}
