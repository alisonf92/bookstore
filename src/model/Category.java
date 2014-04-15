package model;

public class Category {
    private int categoryid;
    private String categoryName;
    public Category() {}
    public Category(int categoryId,String categoryName){
        this.categoryid=categoryId;
        this.categoryName=categoryName;
    }
    public int getCategoryid() {
        return categoryid;
    }
    public void setCategoryid(int categoryId) {
        this.categoryid = categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}