package com.book.controller;

import java.awt.print.Book;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class bookController {
	@Resource
	private bookService bookService;

	@RequestMapping("/addbook")
	public String addbook(HttpServletRequest request, HttpServletResponse response) {
		Book book = new Book();
		String bname = request.getParameter(bname);
		String author = request.getParameter(author);
		double price = request.getParameter(price);
		String press = request.getParameter(press);
		book.setName(bname);
		book.setAuthor(author);
		book.setPrice(price);
		book.setPress(press);
		bookService.addBook(book);
		return "listbook";
	}

	@RequestMapping("listbook")
	public String listbook
}
