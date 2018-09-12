package com.gms.web.brd;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gms.web.brd.Article;
@Repository
public interface BoardMapper {
	public void insert(Article p) ;
	public List<?> selectList(Map<?,?>p) ;
	public List<?> selectSome(Map<?,?>p) ;
	public Article selectOne(Map<?,?>p) ;
	public int count(Map<?,?>p) ;
	public void update(Article p) ;
	public void delete(Article p) ;
	public boolean login(Article p) ;
	
	
	public int countPaging();
	public int listSearchCount();
	public Article listCriteria();
	public Article listSearch();
	public Article listPage();
}
