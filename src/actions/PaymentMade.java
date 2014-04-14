package actions;

import com.opensymphony.xwork2.ActionSupport;

public class PaymentMade extends ActionSupport {
    private String amount;
    private String cardNo;
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getCardNo() {
        return cardNo;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    @Override
    public String execute() throws Exception {
        System.out.println(amount+"========"+cardNo);
        /*
         * THE Business Logic may be placed here
         */
        return "success";
    }
}