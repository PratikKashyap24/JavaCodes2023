package com.dxc.java8;

public class Library {
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
public Library(Integer bookNo, String bookName, String author) {
	super();
	this.bookNo = bookNo;
	this.bookName = bookName;
	this.author = author;
}


}
