package actions;

import java.util.ArrayList;
import java.util.Map;

import dao.ShopCartDAO;
import model.Category;

import model.Customer;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
public class LoginAction extends ActionSupport {
    private String userName;
    private String password;

    private Customer customer;

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

        customer=new Customer();

        customer.setUserName(getUserName());
        customer.setPassword(getPassword());
        setCustomer(customer);
        if(dao.isValid(customer)){
            setCategoryList(dao.getCategories());
            session.put("user",customer);
            session.put("categoryList", getCategoryList());
            session.put("trackerId", "1111");
            result="success";
        }else{
            addActionError("Invalid Username or Password");
            return ERROR;
        }
        dao.close();

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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
