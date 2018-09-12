package com.gms.web.brd;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gms.web.mbr.Member;
import com.gms.web.mbr.MemberService;


@Controller
@RequestMapping("/board")
public class BoardCtrl {

static final Logger logger = LoggerFactory.getLogger(BoardCtrl.class);
	@Autowired Article article;
	@Autowired BoardService boardService;
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public void add(@ModelAttribute("member") Article article) {
		logger.info("\n --------- BoardController {} !!--------","add()");
//		System.out.println("name is : "+ article.getName());
		boardService.add(article);
	}
	@RequestMapping("/list")
	public void list() {}
	@RequestMapping("/search")
	public void search() {}
	@RequestMapping("/retrieve")
	public void retrieve() {}
	@RequestMapping("/count")
	public void count() {}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public void modify(@ModelAttribute("member") Article member) {
		logger.info("\n --------- BoardController {} !!--------","modify()");
		boardService.modify(member);	
	}
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public void remove(@ModelAttribute("member") Article member) {
		logger.info("\n --------- BoardController {} !!--------","remove()");
		boardService.remove(member);
	}
	@RequestMapping("/login")
	public String login(@ModelAttribute("member") Article member, Model model) {
		logger.info("\n --------- BoardController {} !!--------","login()");
		Map<String, String> map = new HashMap<>();
//		if(boardService.login(member).equals("1")) {
//			System.out.println("로그인성공");
//			map.put("userid", member.getUserid());
//			model.addAttribute("user",boardService.retrieve(map));
//		}else {
//			System.out.println("로그인실패");
//		}
		return "login__success";
	}
	@RequestMapping("/logout")
	public String logout() {
		logger.info("\n --------- BoardController {} !!--------","logout()");
		return "redirect:/";
	}
	@RequestMapping("/fileupload")
	public void fileupload() {}
}
