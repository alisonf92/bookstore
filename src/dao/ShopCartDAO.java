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

public class ShopCartDAO {
    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;

    
    private Connection getConnection() throws SQLException {
		java.sql.Connection con;
		con = ConnectionFactory.getInstance().getConnection();
		return con;
	}
   
    public ShopCartDAO() {
        try {
           con = getConnection();
//            Class.forName("com.mysql.jdbc.Driver");
//            con=DriverManager.getConnection("jdbc:mysql://localhost/bookstore2", "root", "root");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addUser(Customer customer){
        boolean added=false;
        try {
            st=con.prepareStatement("insert into customer(name, address,interests,email, cardnumber, username,password) values(?,?,?,?,?,?,?)");
            st.clearParameters();
            st.setString(1,customer.getName());
            st.setString(2,customer.getAddress());
            st.setString(3,Arrays.toString(customer.getInterests()));
            st.setString(4,customer.getEmail());
            st.setInt(5, customer.getCardnumber());
            st.setString(6,customer.getUserName());
            st.setString(7,customer.getPassword());
            
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


    public boolean isValid(Customer user){
        boolean valid=false;
        try {
            st=con.prepareStatement("select * from customer where username " +

                    "like ? and password like ?");
            st.clearParameters();
            st.setString(1,user.getUserName());
            st.setString(2,user.getPassword());
            rs=st.executeQuery();
            if(rs.next()){
                valid=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valid;
    }
    public ArrayList<Category>getCategories(){
        ArrayList<Category>categoryList=new ArrayList<Category>();
        try {
            st=con.prepareStatement("select * from category");
            rs=st.executeQuery();
            while(rs.next()){
                categoryList.add(new Category(rs.getInt(1),rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(Category c : categoryList){
            System.out.println(c.getCategoryName());
        }
        return categoryList;
    }
    public ArrayList<Book>getBooks(int categoryId){
        ArrayList<Book>bookList=new ArrayList<Book>();
        try {
            st=con.prepareStatement("select  * from book where categoryId=?");
            st.clearParameters();
            st.setInt(1,categoryId);
            rs=st.executeQuery();
            while(rs.next()){

                bookList.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4), rs.getDouble(5)));
            }
            for(Book b : bookList){
                System.out.println(b.getTitle());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

}