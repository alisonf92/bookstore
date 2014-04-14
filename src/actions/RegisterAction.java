package actions;

import dao.ShopCartDAO;
import model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class RegisterAction extends ActionSupport implements ModelDriven<User>,
        Preparable {
    private User user;
    private ShopCartDAO dao;
  
    @Override
    public void prepare() throws Exception {
        user=new User();
    }
    @Override
    public User getModel() {
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

