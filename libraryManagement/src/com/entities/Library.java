package com.entities;



import java.lang.classfile.CodeBuilder.CatchBuilder;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.exception.BookNotFoundException;
import com.exception.WrongChoiceException;
import com.utility.Resize;
import com.utility.SortBasedOnAuthorName;
import com.utility.SortBasedOnBookName;
import com.utility.SortBasedOnBookPrice;

public class Library 
{
	private Book[] book = new Book[0];

	public Book[] getBook() {
		return book;
	}
	
	public boolean addBook(Book b)
	{
		boolean flag = false;
		book = Resize.increaseArray(book);
		
		for(int i = 0; i < book.length; i++)
		{
			if(book[i] == null)
			{
				book[i] = b;
				flag = true;
				break;
			}
		}
		
		return flag;
	}
	public void removeBook(Book b)
	{
		boolean flag = false;
		
		if(book.length == 0)
			System.out.println("Library is empty");
		
		for(int i = 0; i < book.length; i++)
		{
			if(book[i].equals(b))
			{
				book = Resize.removeSwap(book, i);
				flag = true;
			}
				
		}
		
		if(flag)
			System.out.println("Book Removed Successfully");
		else
		{
			try 
			{
				throw new BookNotFoundException("Book not found in the library");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
			
	}
	
	public void removeBook(int bookId)
	{
		
		boolean flag = false;
		
		if(book.length == 0)
			System.out.println("Library is empty");
		for(int i = 0; i < book.length; i++)
		{
			if(book[i].getBookId() == bookId)
			{
				book = Resize.removeSwap(book, i);
				flag = true;
			}
				
		}
		
		if(flag)
			System.out.println("Book Removed Successfully");
		else
		{
			try 
			{
				throw new BookNotFoundException("Book not found in the library");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}
	
	public void searchBook(int bookId)
	{
		boolean flag = false;
		int index = -1;
		if(book.length == 0)
			System.out.println("Library is empty");
		
		for(int i = 0; i < book.length; i++)
		{
			if(book[i].getBookId() == bookId)
			{
				index = i;
				flag = true;
				break;
			}
		}
		
		if(flag)
			System.out.println(book[index]);
		else 
		{
			try 
			{
				throw new BookNotFoundException("Book not found in the library");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void sortBook()
	{
		try {
				if(book.length < 1)
					throw new BookNotFoundException("No Book available to sort");
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter 1 to sort based on BookName\n"
						  		  +"Enter 2 to sort based on AuthorName\n"
				                  +"Enter 3 to sort based on BookId\n"
				                  +"Enter 4 to sort based on Price");
				System.out.println("----------------------------------------");
				System.out.println("Enter your Choice");
				switch (sc.nextInt())
				{
				case 1 -> { 
						Arrays.sort(book, new SortBasedOnBookName());
						for(int i = 0; i < book.length; i++)
							System.out.println(book[i]);
				}
				case 2 -> { 
						Arrays.sort(book, new SortBasedOnAuthorName());
						for(int i = 0; i < book.length; i++)
							System.out.println(book[i]);
				}
				case 3 -> { 
						Arrays.sort(book);
						for(int i = 0; i < book.length; i++)
							System.out.println(book[i]);
				}
				case 4 -> { 
						Arrays.sort(book, new SortBasedOnBookPrice());
						for(int i = 0; i < book.length; i++)
							System.out.println(book[i]);
				}
				default ->{
						try {
							throw new WrongChoiceException("Wrong Choice !!");
						}
						catch (Exception e) {
							System.out.println(e.getMessage());
						}
				}
				}
			}
			catch (BookNotFoundException e) 
			{
				System.out.println(e.getMessage());
			}
			catch (InputMismatchException e) 
			{
				System.out.println("Invalid Input");
			}
			finally 
			{
				System.out.println("Enter Valid Input");
			}
	}
}
