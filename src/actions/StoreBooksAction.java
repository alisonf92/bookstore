package actions;

import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import model.Book;
import com.opensymphony.xwork2.ActionSupport;
public class StoreBooksAction extends ActionSupport  implements SessionAware{
    private static final long serialVersionUID = 1L;
    private Map<String, Object>session;
    private ArrayList<Book> currSelected;
    private ArrayList<Book>allBooks;
    private String[] selectedBooks;
    public String[] getSelectedBooks() {
        return selectedBooks;
    }
    public void setSelectedBooks(String[] selectedBooks) {
        this.selectedBooks = selectedBooks;
    }
    @Override
    public void setSession(Map<String, Object> session) {
        this.session=session;        
    }
    @Override
    public String execute() throws Exception {
        currSelected=(ArrayList<Book>)session.get("currSelected");
        allBooks=(ArrayList<Book>)session.get("allBooks");
        Double bill=(Double)session.get("bill");
        if(currSelected==null){
            currSelected=new ArrayList<Book>();
        }
        if(bill==null){
            bill=0.0;
        }
        for(String id : selectedBooks){
            for(Book b : allBooks){
                if(b.getBookId()==Integer.parseInt(id)){
                    currSelected.add(b);

                    bill+=b.getPrice();

                    break;
                }
            }
        }
        session.put("currSelected", currSelected);
        session.put("bill",bill);
        for(Book bk : currSelected){

            System.out.println(bk.getTitle());

        }
        System.out.println("BILL :: "+bill);
        return "success";
    }
}
