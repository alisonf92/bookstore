package actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class PaymentAction extends ActionSupport {
    private String mode;
    private Map<String, Object>session;

    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
    @Override
    public String execute() throws Exception {
        System.out.println(mode);
        session=ActionContext.getContext().getSession();
        session.put("mode",mode);
        return mode;
    }
}