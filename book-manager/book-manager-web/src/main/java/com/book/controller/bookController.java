package com.book.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.book.inter.bookService;
import com.book.pojo.TBook;

@Controller
 @RequestMapping("")
public class bookController {
	@Resource
	private bookService bookService;

	@RequestMapping("/addbook")
	public String addbook(HttpServletRequest request, HttpServletResponse response) {
		TBook book = new TBook();
		String bname = request.getParameter("bname");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String press = request.getParameter("press");
		book.setBname(bname);
		book.setAuthor(author);
		book.setPrice(new BigDecimal(price));
		book.setPress(press);
		bookService.addBook(book);
		return "listbook";
	}

	@RequestMapping("/listbook")
	public String lsitbook(HttpServletRequest request, HttpServletResponse response) {
		int start = 0;
		int count = 10;
		try {
			start = Integer.parseInt(request.getParameter("page.start"));
			count = Integer.parseInt(request.getParameter("page.count"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		page page = new page(start, count);
		List<TBook> books = bookService.list(page.getStart(), page.getCount());
		int total = bookService.getTotal();
		page.setTotal(total);
		request.setAttribute("books", books);
		request.setAttribute("page", page);
		return "listbook";
	}

	@RequestMapping("/deletebook")
	public String deleteBook(int id) {
		bookService.deleteBook(id);
		return "listbook";
	}

	@RequestMapping("/editbook")
	public ModelAndView editBook(int id) {
		ModelAndView modelAndView = new ModelAndView();
		TBook book = bookService.getTBook(id);
		modelAndView.addObject("book", book);
		modelAndView.setViewName("editbook");
		return modelAndView;
	}

	@RequestMapping("/updatebook")
	public String updateBook(HttpServletRequest request, HttpServletResponse response) {
		TBook book = new TBook();
		String bname = request.getParameter("bname");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String press = request.getParameter("press");
		book.setBname(bname);
		book.setAuthor(author);
		book.setPrice(new BigDecimal(price));
		book.setPress(press);
		bookService.updateBook(book);
		return "listbook";
	}
}