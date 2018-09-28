package com.gms.web.brd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gms.web.cmm.Util;
import com.gms.web.mbr.Member;
import com.gms.web.mbr.MemberMapper;
import com.gms.web.page.Pagination;

@RestController

public class BoardCtrl {
	static final Logger logger = LoggerFactory.getLogger(BoardCtrl.class);
	@Autowired Member member;
	@Autowired MemberMapper mbrMapper;
	@Autowired BoardMapper brdMapper;
	@Autowired Pagination page;
	@Autowired Map<String,Object> map;
	@RequestMapping("/boards/{pageNo}")
	public @ResponseBody Map<String,Object> list(@PathVariable String pageNo){
		logger.info("\n --------- BoardCtrl {} !!--------","list()");		
		map.clear();
		map.put("pageNo", Integer.parseInt(pageNo));
		map.put("count", brdMapper.countAll());
		page.carryOut(map);
		List<Board> list = brdMapper.listAll(page);
		Util.log.accept("게시글 리스트 :: "+list);
		Util.log.accept("count  :: "+page.getCount());
		Util.log.accept("existPrev :: "+page.isExistPrev());
		Util.log.accept("prevBlock :: "+page.getPrevBlock());
		Util.log.accept("beginPage :: "+page.getBeginPage());
		Util.log.accept("existNext :: "+page.isExistNext());
		Util.log.accept("nextBlock :: "+page.getNextBlock());
		map.clear();
		map.put("list",list);
		return map;
	}
}
