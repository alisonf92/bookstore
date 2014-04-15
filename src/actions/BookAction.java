package actions;

import model.Book;
import model.Customer;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminDAO;
import dao.ShopCartDAO;
public class BookAction extends ActionSupport {
    private String message;
    private Book book;
    private AdminDAO admin;
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public String add(){
        message="Inside Add method Book Details : [ "+book.getBookId()+" "+
                book.getTitle()+" ].";
        System.out.println(message);
        return "success";
    }
    public String update(){
        message="Inside Update method Book Details : [ "+book.getBookId()+" "+
                book.getTitle()+" ].";
        System.out.println(message);
        return "success";
    }
    public String delete(){
        message="Inside Delete method Book Details : [ "+book.getBookId()+" "+
                book.getTitle()+" ].";
        System.out.println(message);
        return "success";
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String execute() throws Exception {
        admin =new AdminDAO();
        boolean isAdded=admin.addBook(book);
        admin.close();
        if(isAdded){
            return "success";
        }else{
            return "failed";
        }
    }
    
}