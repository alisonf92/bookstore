package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	String driverName = "com.mysql.jdbc.Driver";
	static String conUrl = "jdbc:mysql://localhost/bookstore";
	static String dbUser = "root";
	static String dbPwd = "root";

	private static ConnectionFactory connectionFactory = null;
	static Connection con;

	private ConnectionFactory() {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection()  {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(conUrl, dbUser, dbPwd);

		} catch (Exception e) {
			e.toString();
		}
		return conn;
	}

	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
	
	public static void CloseConnection()
    {
        if(con!=null)
        {
            try
            {
                con.close();
                con = null;
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }            
        }
        
    }
    
    public static ResultSet getResultFromSqlQuery(String SqlQueryString)
    {
        System.out.println("in funcation");
        ResultSet rs=null;
        if(con==null)
        {
            getConnection();
        }
        try
        {
            rs = con.createStatement().executeQuery(SqlQueryString);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }             
        return rs;
    }
}