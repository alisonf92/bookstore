package actions;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import dao.ShopCartDAO;

import model.Customer;

import model.Book;
import com.opensymphony.xwork2.ActionSupport;
public class ShowBooksAction extends ActionSupport  implements SessionAware{
    private static final long serialVersionUID = 1L;
    private Map<String, Object>session;
    private int category;
    private ShopCartDAO dao;
    private ArrayList<Book>bookList;
    @Override
    public void setSession(Map<String, Object> session) {
        this.session=session;        
    }
    public int getCategory() {
        return category;
    }
    public void setCategory(int category) {
        this.category = category;
    }
    public ArrayList<Book> getBookList() {
        return bookList;
    }
    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }
    @Override
    public String execute() throws Exception {
        dao=new ShopCartDAO();
        Customer customer=(Customer)session.get("user");
        System.out.println("---------"+customer.getUserName());
        session.put("Current Credit", new Double(12.50));
        setBookList(dao.getBooks(category));        
        dao.close();
        return "success";
    }
}