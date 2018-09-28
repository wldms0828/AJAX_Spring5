package com.gms.web.page;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import lombok.Data;

@Data
public class Pageproxy implements Proxy {


		private Pagination pagination;
		private HttpServletRequest request;
		
		@Override
		public void carryOut(Map<?,?> p) {
			this.pagination = new Pagination();
			pagination.carryOut(p);}
		
	
}
