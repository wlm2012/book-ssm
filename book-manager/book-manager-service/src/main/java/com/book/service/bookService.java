package com.book.service;

import java.util.List;

import com.book.pojo.TBook;

public interface bookService {
	int getTotal();

	void addBook(TBook book);

	void updateBook(TBook book);

	void deleteBook(int id);

	TBook getTBook(int id);

	List<TBook> list(int start, int count);
}
