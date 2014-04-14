package actions;

import java.util.ArrayList;
import java.util.Map;

import dao.ShopCartDAO;
import model.Category;
import model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
public class LoginAction extends ActionSupport {
    private String userName;
    private String password;
    private User user;
    private ArrayList<Category>categoryList;
    private ShopCartDAO dao;
    private Map<String, Object>session;
        public ArrayList<Category> getCategoryList() {
        return categoryList;
    }
    public void setCategoryList(ArrayList<Category> categoryList) {
        this.categoryList = categoryList;
    }
    public ShopCartDAO getDao() {
        return dao;
    }
    public void setDao(ShopCartDAO dao) {
        this.dao = dao;
    }
        public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String execute() throws Exception {
        String result="failed";
        session=ActionContext.getContext().getSession();
        System.out.println(userName+" : "+password);
        dao=new ShopCartDAO();
        user=new User();
        user.setUserName(getUserName());
        user.setPassword(getPassword());
        setUser(user);
        if(dao.isValid(user)){
            setCategoryList(dao.getCategories());
            session.put("user",user);
            session.put("categoryList", getCategoryList());
            session.put("trackerId", "1111");
            result="success";
        }else{
            addActionError("Invalid Username or Password");
            return ERROR;
        }
        dao.close();
        /*
        ValueStack stack=ActionContext.getContext().getValueStack();
        System.out.println(stack);
        System.out.println(stack.size());
        */
        return result;
    }
    @Override
    public void validate() {
        if(getUserName().length()==0){
            addFieldError("userName","USERNAME is Required");
        }
        if(getPassword().length()==0){
            addFieldError("password", "PASSWORD is Required");
        }else if(getPassword().length()<5){
            addFieldError("password","PASSWORD must be MINIMUM 5 characters");
        }
    }
}
