package com.driver;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.entities.Book;
import com.entities.Library;
import com.exception.BookNotFoundException;

public class LibraryManagement 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Library l = new Library();
		System.out.println("---------------------------------------");
		System.out.println("Welcome to Library Management System");
		System.out.println("---------------------------------------");
		boolean flag = true;
		
		do 
		{
			System.out.println("Enter 1 to Add Book");
			System.out.println("Enter 2 to Remove Book using Object");
			System.out.println("Enter 3 to Remove Book using Book ID");
			System.out.println("Enter 4 to Search Book using Book ID");
			System.out.println("Enter 5 to Sort Book");
			System.out.println("Enter 6 to Display all Books");
			System.out.println("Enter 7 to Exit Management System");
			System.out.println("--------------------------------------");
			System.out.println("Enter Your Choice");
			System.out.println("--------------------------------------");
			int n;
			try {
				n = sc.nextInt();
				switch (n) 
				{
					case 1 ->{
						System.out.println("Enter Book Name");
						try {
						String bookName = sc.nextLine()+sc.nextLine();
						System.out.println("Enter Author Name");
						String authorName = sc.nextLine();
						System.out.println("Enter Book Id");
						int bookId = sc.nextInt();
						System.out.println("Enter Price of the Book");
						double bookprice = sc.nextDouble();
						if(l.addBook(new Book(bookName, authorName, bookId, bookprice)))
							System.out.println("Book Added Successfully");
						else
							System.out.println("Book Not Added");
						}
						catch (InputMismatchException e) {

							System.out.println("Invalid Input");
						}
					}
					case 2 ->{
						try {
						System.out.println("Enter Book Name");
						String bookName = sc.nextLine()+sc.nextLine();
						System.out.println("Enter Author Name");
						String authorName = sc.nextLine();
						System.out.println("Enter Book Id");
						int bookId = sc.nextInt();
						System.out.println("Enter Price of the Book");
						double bookprice = sc.nextDouble();
						l.removeBook(new Book(bookName, authorName, bookId, bookprice));
						}
						catch (InputMismatchException e) {
							System.out.println("Invalid Input");
						}
					}
					case 3 ->{
						try {
						System.out.println("Enter Book ID");
						int bookId = sc.nextInt();
						l.removeBook(bookId);
						}
						catch (InputMismatchException e) {
							System.out.println("Invalid Input");
						}
					}
					case 4 ->{
						try {
						System.out.println("Enter Book ID");
						int bookId = sc.nextInt();
						l.searchBook(bookId);
						}
						catch (InputMismatchException e) {
							System.out.println("Invalid Input");
						}
					}
					case 5 ->{
						l.sortBook();
					}
					case 6 ->{
							try {
									if(l.getBook().length == 0)
									{
										throw new BookNotFoundException("No Books Found");
									}
									for(int i = 0; i < l.getBook().length; i++)
										System.out.println(l.getBook()[i]);
								}
							catch (BookNotFoundException e) {
									System.out.println(e.getMessage());
								}
					}
					case 7 ->{
						flag = false;
					}
					default ->{
						System.out.println("Wrong Choice !!");
					}
					
				}
				
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid Input");
				sc.nextLine();
				System.out.println("Enter Numeric value");
			}
			
		} while (flag);
		sc.close();
	}
}
