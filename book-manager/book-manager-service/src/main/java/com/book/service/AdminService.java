package com.book.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.book.dao.TAdminMapper;
import com.book.pojo.TAdmin;
import com.book.pojo.TAdminExample;
import com.book.pojo.TAdminExample.Criteria;

@Service
public class AdminService {
	@Resource
	TAdminMapper adminMapper;

	public boolean nameAndPassword(String name, String password) {

		List<TAdmin> admins = new ArrayList<TAdmin>();
		TAdminExample example = new TAdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andLoginnameEqualTo(name);
		criteria.andLoginpassEqualTo(password);
		admins = adminMapper.selectByExample(example);	
				if (admins.isEmpty()) {
			return false;
		}
		return true;
	}
}
