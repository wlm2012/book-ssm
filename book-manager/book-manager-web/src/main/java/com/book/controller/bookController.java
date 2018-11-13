package com.book.controller;

import java.awt.print.Book;
import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.book.pojo.TBook;

@Controller
public class bookController {
	@Resource
	private bookService bookService;

	@RequestMapping("/addbook")
	public String addbook(HttpServletRequest request, HttpServletResponse response) {
		TBook book=new TBook();
		String bname = request.getParameter(bname);
		String author = request.getParameter(author);
		String price = request.getParameter(price);
		String press = request.getParameter(press);
		book.setBname(bname);
		book.setAuthor(author);
		book.setPrice(new BigDecimal(price));
		book.setPress(press);
		bookService.addBook(book);
		return "listbook";
	}

	@RequestMapping("listbook")
	public String listbook
}
