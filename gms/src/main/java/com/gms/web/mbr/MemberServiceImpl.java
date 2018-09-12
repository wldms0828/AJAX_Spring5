package com.gms.web.mbr;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MemberServiceImpl implements MemberService{
	@Autowired MemberMapper mapper;
	@Override
	public void add(Member p) {
		SimpleDateFormat date = new SimpleDateFormat("yyyy");
		String year= date.format(new Date());
		int age = Integer.parseInt(year) - (Integer.parseInt(p.getSsn().substring(0, 2))+1899);
		p.setAge(String.valueOf(age));
		char gd = p.getSsn().charAt(7);
		String gender = "";
		if(gd=='1'||gd=='3'){
			gender = "남";
			}else if(gd=='2'||gd=='4'){
			gender = "여";
			}else if(gd=='5'||gd=='6'){
			gender = "외국인";
			}else{
			gender = "다시 입력하세요";
			}
			p.setGender(gender);
		System.out.println("age : " + age);
		System.out.println("성별을 정하는 숫자 : " + gd);
		System.out.println("성별 : " + gender);
		mapper.insert(p);
	}

	@Override
	public List<?> list(Map<?, ?> p) {
		return mapper.selectList(p);}

	@Override
	public List<?> search(Map<?, ?> p) {
		return mapper.selectSome(p);}

	@Override
	public Member retrieve(Member p) {
		return p;
	}

	@Override
	public int count(Map<?, ?> p) {
		return mapper.count(p);}

	@Override
	public void modify(Member p) {
		mapper.update(p);		
	}

	@Override
	public void remove(Member p) {
		mapper.delete(p);
			}

	@Override
	public String login(Member p) {
		return mapper.login(p);
	}

}