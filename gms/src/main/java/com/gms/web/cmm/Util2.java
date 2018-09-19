package com.gms.web.cmm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.gms.web.mbr.Member;
@Component
public class Util2 {
	public Function<Member,Member> ageAndGender = (Member mbr) -> {
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy");
		String year= date.format(new Date());
		int age = Integer.parseInt(year) - (Integer.parseInt(mbr.getSsn().substring(0, 2))+1899);
		mbr.setAge(String.valueOf(age));
		char gd = mbr.getSsn().charAt(7);
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
		mbr.setGender(gender);
		System.out.println("age : " + age);
		System.out.println("성별을 정하는 숫자 : " + gd);
		System.out.println("성별 : " + gender);
		return mbr;
	};
}
