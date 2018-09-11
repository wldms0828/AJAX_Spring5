package com.gms.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@Lazy
//Lazy 로직은 필요한 도메인 값을 부를때 바로바로 만들어 준다.
//초기 로딩 속도가 엄청 빨라진다.
public class ArticleDTO {
	private String bno, title,content,writer,regdate,viewcnt;
}
