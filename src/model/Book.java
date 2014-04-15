package model;

public class Book {
    private int bookId;

    private String title;
    private String author;
    private int categoryid;
    private double price;
    

    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCategoryid() {
        return categoryid;
    }
    public void setCategoryid(int categoryId) {
        this.categoryid = categoryId;
    }

    
    public Book(int bookId, String title, String author, int categoryid, double price) {
        super();
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.categoryid = categoryid;
        this.price = price;
        
    }
    public Book() {}
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
