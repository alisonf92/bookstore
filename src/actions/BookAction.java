package actions;

import model.Book;

import model.Customer;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import dao.AdminDAO;
import dao.ShopCartDAO;

import com.opensymphony.xwork2.ActionSupport;
public class BookAction extends ActionSupport implements ModelDriven<Book> ,Preparable {
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
    

   
	@Override
	public Book getModel() {
		
		return book;
	}
    
	  public void prepare() throws Exception {

	        book=new Book();
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