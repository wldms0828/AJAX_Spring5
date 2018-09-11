package com.gms.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gms.web.domain.ArticleDTO;
import com.gms.web.mapper.MemberMapper;
import com.gms.web.service.BoardService;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired MemberMapper mapper;
	@Override
	public void add(ArticleDTO p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<?> list(Map<?, ?> p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> search(Map<?, ?> p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleDTO retrieve(Map<?, ?> p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(Map<?, ?> p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modify(ArticleDTO p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(ArticleDTO p) {
		// TODO Auto-generated method stub
		
	}

}
