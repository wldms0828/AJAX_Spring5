package com.gms.web.page;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.gms.web.brd.BoardMapper;

import lombok.Data;
@Data @Component @Lazy
public class Pagination implements Proxy{
	int pageNum,count,pageSize,blockSize,beginPage,endPage,beginRow,endRow,prevBlock,nextBlock;
	boolean existPrev,existNext; 
	@Autowired BoardMapper brdMapper;
	@Override
	public void carryOut(Map<?,?> p) {
		pageNum =  (int) p.get("pageNo"); 
		pageSize = 5; 
		blockSize = 5;
		count = (int) p.get("count");
		beginPage = Math.floorDiv(pageNum-1, pageSize)*pageSize+1;
		endPage = (count>(beginPage+(blockSize-1))*pageSize)?
				beginPage+(blockSize-1):(int)(Math.ceil(count/(double)pageSize));
		beginRow = (pageNum-1)*pageSize+1;
		endRow = 5/*(count>pageNum*pageSize)?pageNum*pageSize:count*/;
		prevBlock = beginPage -1;
		nextBlock = endPage +1;
		existPrev = (beginPage>1);
		existNext = (count>endPage*5);
		
	}
}