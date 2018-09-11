package com.gms.web.controller;

import java.util.HashMap;
import java.util.Map;

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

import com.gms.web.domain.MemberDTO;
import com.gms.web.service.MemberService;
@Controller
@RequestMapping("/member")
//어노테이션을 읽어 오는 것은 mvc "/member" string 값을 저장하는 공간은 spring 
@SessionAttributes("user")
public class MemberController {
	static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberDTO member;
	@Autowired MemberService memberService;
	@RequestMapping(value="/add/{prefix}/{dir}/{page}", method=RequestMethod.POST)
	public String add(@ModelAttribute("member") MemberDTO member,
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
			@ModelAttribute("user") MemberDTO user,
			@PathVariable String prefix,
			@PathVariable String dir,
			@PathVariable String page) {
		logger.info("\n --------- MemberController {} !!--------","modify()");
		memberService.modify(user);	
		return prefix+":"+dir+"/"+page+".tiles";
	}
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@ModelAttribute("user") MemberDTO user) {
		logger.info("\n --------- MemberController {} !!--------","remove()");
		memberService.remove(user);
		return "redirect:/";
	}
	@RequestMapping("/login")
	public String login(@ModelAttribute("member") MemberDTO member, Model model) {
		logger.info("\n --------- MemberController {} !!--------","login()");
		Map<String, String> map = new HashMap<>();
		if(memberService.login(member).equals("1")) {
			System.out.println("로그인성공");
			map.put("userid", member.getUserid());
			model.addAttribute("user",memberService.retrieve(map));
		}else {
			System.out.println("로그인실패");
		}
		return "login__success";
	}
	@RequestMapping("/logout")
	public String logout() {
		logger.info("\n --------- MemberController {} !!--------","logout()");
		return "redirect:/";
	}
	@RequestMapping("/fileupload")
	public void fileupload() {}
}