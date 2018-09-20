package com.gms.web.sbj;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gms.web.mbr.Member;
@Repository
public interface SubjectMapper {
	public void post(Subject s) ;
	public List<?> list(Map<?,?>s) ;
	public Member get(Subject s) ;
	public Integer count(Subject s) ;
	public void put(Subject s) ;
	public void delete(Subject s) ;

}
