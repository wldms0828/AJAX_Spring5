package com.gms.web.mbr;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gms.web.cmm.Util;

@Controller
@RequestMapping("/member")
//어노테이션을 읽어 오는 것은 mvc "/member" string 값을 저장하는 공간은 spring 
@RestController
public class MemberCtrl {
	static final Logger logger = LoggerFactory.getLogger(MemberCtrl.class);
	@Autowired Member member;
	@Autowired MemberMapper mbrMapper;
	@PostMapping("/add")
	public @ResponseBody Map<String,Object> 
			add(@RequestBody Map<String,Object> map) {
		logger.info("\n --------- MemberController {} !!--------","add()");
		Map<String,Object>amap = new HashMap<>();
		Util.log.accept("회원가입Mctrl ::");
		amap.put("addtest", "회원가입성공~!");
		System.out.println("name is : "+ member.getName());

		return amap;
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

		return prefix+":"+dir+"/"+page+".tiles";
	}
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@ModelAttribute("user") Member user) {
		logger.info("\n --------- MemberController {} !!--------","remove()");

		return "redirect:/";
	}
	@PostMapping("/login")
	public @ResponseBody Map<String,Object>
		login(@RequestBody Member param) {
		logger.info("\n --------- MemberController {} !!--------","login()");
		/*Predicate<String> p = s->s.equals("");
		Predicate<String> p = s->s.equals("");
		Predicate<String> notP = p.negate();	ngate 는 !s*/
		Map<String,Object> rmap = new HashMap<>();
		Util.log.accept("넘어온 로그인 정보  id :: "+param.getUserid());
		Util.log.accept("넘어온 로그인 정보 pw :: "+param.getPassword());
		String pwValid = "WRONG";
		String idValid="WRONG";
		if(mbrMapper.count(param)!=0) {
			idValid="CORRECT";
			Function <Member, Member> f = (t)->{return mbrMapper.get(t);
			};
			member = f.apply(param);
			pwValid = (member!=null)?"CORRECT":"WRONG";
			System.out.println("====password 유효성 ====="+pwValid);
			member = (member!=null)?member:new Member();
		}
		
/*		if(Util.notNull.test(mbrMapper.exist(param.getUserid()) )) {
			Function<Member, String> f = (t)->{
				return mbrMapper.login(t);
			};
			pwValid = f.apply(param).equals("1")?"CORRECT":"WRONG";			
		}else {
			idValid="NOT EXIST";
		}*/
		//위에서 사용한 함수는 파라미터가 끝나면 바로 없어진다고 생각하면 된다.
		/*Predicate<String> ls = s->s.equals("login__success");
		member= ((Predicate.isEqual("login__success").test(pwValid)))?
				mbrMapper.get(param):new Member();
					Util.log.accept(param.toString());*/
		System.out.println("MEMBER ::" + member);
		rmap.put("ID", idValid);
		rmap.put("PW", pwValid);
		rmap.put("MBR", member);
		
		return rmap;
	}
	@RequestMapping("/logout")
	public String logout() {
		logger.info("\n --------- MemberController {} !!--------","logout()");
		return "redirect:/";
	}
	@RequestMapping("/fileupload")
	public void fileupload() {}
}