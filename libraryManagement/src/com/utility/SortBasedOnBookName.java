package com.utility;

import java.util.Comparator;

import com.entities.Book;

public class SortBasedOnBookName implements Comparator
{

	@Override
	public int compare(Object o1, Object o2) {
		Book b1 = (Book)o1;
		Book b2 = (Book)o2;
		
		return b1.getBookName().compareTo(b2.getBookName());
	}
	
}
