package model;

public class Book {
    private int bookId;
    private String bookName;
    private int categoryId;
    private double bookPrice;
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public double getBookPrice() {
        return bookPrice;
    }
    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }
    public Book(int bookId, String bookName, int categoryId, double bookPrice) {
        super();
        this.bookId = bookId;
        this.bookName = bookName;
        this.categoryId = categoryId;
        this.bookPrice = bookPrice;
    }
    public Book() {}
}
