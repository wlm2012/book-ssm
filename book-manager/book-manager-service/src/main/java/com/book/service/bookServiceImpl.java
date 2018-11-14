package com.book.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.book.dao.TBookMapper;
import com.book.inter.bookService;
import com.book.pojo.TBook;
import com.book.pojo.TBookExample;
import com.book.pojo.TBookExample.Criteria;

@Service
public class bookServiceImpl implements bookService {

	@Resource
	TBookMapper bookMapper;

	@Override
	public int getTotal() {
		TBookExample example = new TBookExample();

		return bookMapper.countByExample(example);
	}

	public void addBook(TBook book) {
		bookMapper.insert(book);
	}

	public void updateBook(TBook book) {
		TBookExample example = new TBookExample();
		bookMapper.updateByExample(book, example);
	}

	public void deleteBook(int id) {
		bookMapper.deleteByPrimaryKey(String.valueOf(id));
	}

	public TBook getTBook(int id) {
		return bookMapper.selectByPrimaryKey(String.valueOf(id));
	}

	public List<TBook> list(int start, int count) {
		TBookExample example=new TBookExample();
		Criteria criteria=example.createCriteria();
		criteria.andBidBetween(String.valueOf(start), String.valueOf(count));
		return bookMapper.selectByExample(example);
	}
}
