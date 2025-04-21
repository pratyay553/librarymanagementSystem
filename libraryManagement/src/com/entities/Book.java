package com.entities;

import java.util.Objects;

public class Book implements Comparable
{
	private String bookName, authorName;
	private int bookId;
	private double bookprice;
	
	
	public Book(String bookName, String authorName, int bookId, double bookprice) 
	{
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookId = bookId;
		this.bookprice = bookprice;
	}


	public Book() { }


	public String getBookName() {
		return bookName;
	}


	public String getAuthorName() {
		return authorName;
	}


	public int getBookId() {
		return bookId;
	}


	public double getBookprice() {
		return bookprice;
	}


	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", authorName=" + authorName + ", bookId=" + bookId
				+ ", bookprice=" + bookprice + "]";
	}


	@Override
	public int hashCode() {
		return (int)(authorName.hashCode() + bookId + bookName.hashCode() + bookprice);
	}


	@Override
	public boolean equals(Object obj) {
		Book other = (Book) obj;
		return Objects.equals(authorName, other.authorName) && bookId == other.bookId
				&& Objects.equals(bookName, other.bookName)
				&& Double.doubleToLongBits(bookprice) == Double.doubleToLongBits(other.bookprice);
	}


	@Override
	public int compareTo(Object o) 
	{
		Book b = (Book)o;
		return this.bookId - b.bookId;
	}
		
}
