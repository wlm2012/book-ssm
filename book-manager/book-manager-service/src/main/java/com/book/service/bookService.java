package com.book.service;

import java.util.List;

import com.book.pojo.TBook;

public interface bookService {
	int getTotal();

	void addBook(TBook book);

	void updateBook(TBook book);

	void deleteBook(String id);

	TBook getTBook(String id);

	List<TBook> list(int start, int count);
}
