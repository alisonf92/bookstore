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
    
    
    public AdminDAO() {
       
        	con = ConnectionFactory.getInstance().getConnection();
        
    }
    public boolean addBook(Book book){
    	
        boolean added=false;
        try {
        	
            st=con.prepareStatement("insert into book(title, author, price,categoryid) values(?,?,?,?)");
           
            st.clearParameters();
            
            st.setString(1,book.getTitle());
            st.setString(2,book.getAuthor());
            st.setInt(4, book.getCategoryid());
            st.setDouble(3,book.getPrice());
          
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