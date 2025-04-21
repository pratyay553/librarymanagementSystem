package com.utility;

import com.entities.Book;

public class Resize 
{
	public static Book[] increaseArray(Book[] book)
	{
		Book[] b1 = new Book[book.length + 1];
		for(int i = 0; i < book.length; i++)
		{
			b1[i] = book[i];
		}
		 book = new Book[b1.length];
		 for(int i = 0; i < book.length; i++)
		 {
			 if(b1[i] != null)
			 book[i] = b1[i];
			 else
				 break;
		 }
		 
		 return book;
	}
	public static Book[] decreaseArray(Book[] book)
	{
		Book[] b1 = new Book[book.length - 1];
		for(int i = 0; i < b1.length; i++)
		{
			b1[i] = book[i];
		}
		book = new Book[b1.length];
		for(int i = 0; i < book.length; i++)
		 {
			 book[i] = b1[i];
		 }
		
		return book;
	}
	public static Book[] removeSwap(Book[] book, int index)
	{
		for(int i = index; i < book.length - 1; i++)
		{
			book[i] = book[i+1];
		}
		book = decreaseArray(book);
		return book;
	}
}
