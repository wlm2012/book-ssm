package com.book.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.book.pojo.TAdmin;
import com.book.pojo.TBook;
import com.book.service.AdminService;
import com.book.service.bookService;

@Controller
@RequestMapping("")
public class bookController {
	@Autowired
	private bookService bookService;
	@Autowired
	private AdminService AdminService;

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String loginname = request.getParameter("loginname");
		String loginpassword = request.getParameter("loginpassword");		
		if (null != loginname && null != loginpassword && AdminService.nameAndPassword(loginname, loginpassword)) {
			TAdmin admin = new TAdmin();
			admin.setLoginname(loginname);
			admin.setLoginpass(loginpassword);
			request.getSession().setAttribute("admin", admin);
			mv.setViewName("redirect:listbook");
			return mv;
		}
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}

	@RequestMapping("/addbook1")
	public String addbook1() {
		return "addbook";
	}

	@RequestMapping("/addbook")
	public String addbook(HttpServletRequest request, HttpServletResponse response) {
		TBook book = new TBook();
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String press = request.getParameter("press");
		book.setBid(bid);
		book.setBname(bname);
		book.setAuthor(author);
		book.setPrice(new BigDecimal(price));
		book.setPress(press);
		bookService.addBook(book);
		return "redirect:listbook";
	}

	@RequestMapping("/listbook")
	public String listbook(HttpServletRequest request, HttpServletResponse response) {
		int start = 0;
		int count = 10;
		try {
			start = Integer.parseInt(request.getParameter("page.start"));
			// count = Integer.parseInt(request.getParameter("page.count"));
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
	public String deleteBook(String id) {
		bookService.deleteBook(id);
		return "redirect:listbook";
	}

	@RequestMapping("/editbook")
	public ModelAndView editBook(String id) {
		ModelAndView modelAndView = new ModelAndView();
		TBook book = bookService.getTBook(id);
		modelAndView.addObject("book", book);
		modelAndView.setViewName("editbook");
		return modelAndView;
	}

	@RequestMapping("/updatebook")
	public String updateBook(HttpServletRequest request, HttpServletResponse response) {
		TBook book = new TBook();
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String press = request.getParameter("press");
		String orderby = request.getParameter("orderby");
		book.setBid(bid);
		book.setBname(bname);
		book.setAuthor(author);
		book.setPrice(new BigDecimal(price));
		book.setPress(press);
		book.setOrderby(Integer.valueOf(orderby));
		bookService.updateBook(book);
		return "redirect:listbook";
	}
}