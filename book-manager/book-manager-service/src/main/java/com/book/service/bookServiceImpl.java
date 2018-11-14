package com.book.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.book.dao.TBookMapper;
import com.book.inter.bookService;

@Service
public class bookServiceImpl implements bookService {

	@Resource
	TBookMapper bookMapper;

	@Override
	public int getTotal() {

		return bookMapper.countByExample(example);
	}

}
