package trng.reflection;

public class Book {
	Integer bookNo;
	String bookName;
	String author;
	public Integer getBookNo() {
		return bookNo;
	}
	public void setBookNo(Integer bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [bookNo=" + bookNo + ", bookName=" + bookName
				+ ", author=" + author + "]";
	}
	
	
}
