package com.gms.web.mbr;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gms.web.cmm.Util;
import com.google.common.base.Function;
@Controller
@RequestMapping("/member")
//어노테이션을 읽어 오는 것은 mvc "/member" string 값을 저장하는 공간은 spring 
@SessionAttributes("user")
public class MemberCtrl {
	static final Logger logger = LoggerFactory.getLogger(MemberCtrl.class);
	@Autowired Member member;
	@Autowired MemberService memberService;
	@Autowired MemberMapper mbrMapper;
	@RequestMapping(value="/add/{prefix}/{dir}/{page}", method=RequestMethod.POST)
	public String add(@ModelAttribute("member") Member member,
			@PathVariable String prefix,
			@PathVariable String dir,
			@PathVariable String page) {
		logger.info("\n --------- MemberController {} !!--------","add()");
		System.out.println("name is : "+ member.getName());
		memberService.add(member);
		return prefix+":"+dir+"/"+page+".tiles";
		//return 은 MemberController에서 해주던 carrier랑 비슷한 기능을 한다.
	}
	@RequestMapping("/list")
	public void list() {}
	@RequestMapping("/search")
	public void search() {}
	@RequestMapping("/retrieve")
	public void retrieve() {}
	@RequestMapping("/count")
	public void count() {}
	@RequestMapping(value="/modify/{prefix}/{dir}/{page}", method=RequestMethod.POST)
	public String modify(
			@ModelAttribute("user") Member user,
			@PathVariable String prefix,
			@PathVariable String dir,
			@PathVariable String page) {
		logger.info("\n --------- MemberController {} !!--------","modify()");
		memberService.modify(user);	
		return prefix+":"+dir+"/"+page+".tiles";
	}
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@ModelAttribute("user") Member user) {
		logger.info("\n --------- MemberController {} !!--------","remove()");
		memberService.remove(user);
		return "redirect:/";
	}
	@RequestMapping("/login")
	public String login(@ModelAttribute("member") Member param, Model model) {
		logger.info("\n --------- MemberController {} !!--------","login()");
		/*Predicate<String> p = s->s.equals("");*/
		Predicate<String> p = s->s.equals("");
		Predicate<String> notP = p.negate();/*	ngate 는 !s*/
		String view = "login__failed";
		if(notP.test(mbrMapper.exist(member.getUserid()))) {
			Function<Member, String> f = (t)->{
				return mbrMapper.login(t);
			};
			view = f.apply(param).equals("1")?"login__success":"login__failed";			
		}
		//위에서 사용한 함수는 파라미터가 끝나면 바로 없어진다고 생각하면 된다.
		/*Predicate<String> ls = s->s.equals("login__success");*/
		member= ((Predicate.isEqual("login__success").test(view)))?
					mbrMapper.selectOne(param):new Member();
					Util.log.accept(param.toString());
				
		return view;
	}
	@RequestMapping("/logout")
	public String logout() {
		logger.info("\n --------- MemberController {} !!--------","logout()");
		return "redirect:/";
	}
	@RequestMapping("/fileupload")
	public void fileupload() {}
}