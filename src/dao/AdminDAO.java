package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import model.Book;
import model.Category;
import model.Customer;

public class AdminDAO {
    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;
    
    private Connection getConnection() throws SQLException {
		java.sql.Connection con;
		con = ConnectionFactory.getInstance().getConnection();
		return con;
	}
   
    public AdminDAO() {
        try {
           con = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean addBook(Book book){
        boolean added=false;
        try {
            st=con.prepareStatement("insert into book values(?,?,?,?)");
            st.clearParameters();
            st.setString(2,book.getTitle());
            st.setString(3,book.getAuthor());
            st.setDouble(4,book.getPrice());
            st.setInt(5, book.getCategoryId());
            int count=st.executeUpdate();
            if(count==1){
                added=true;
                System.out.println("+++++++++++++ Record Added+++++++");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return added;
    }
    public void close(){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

   
 
    
    
}