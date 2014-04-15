package actions;

import dao.ShopCartDAO;
import model.Customer;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;


public class RegisterAction extends ActionSupport implements ModelDriven<Customer>,
        Preparable {
    private Customer user;

    private ShopCartDAO dao;
  
    @Override
    public void prepare() throws Exception {

        user=new Customer();
    }
    @Override
    public Customer getModel() {

        return user;
    }
@Override
public String execute() throws Exception {
    dao=new ShopCartDAO();
    boolean isAdded=dao.addUser(user);
    dao.close();
    if(isAdded){
        return "success";
    }else{
        return "failed";
    }
}
}

