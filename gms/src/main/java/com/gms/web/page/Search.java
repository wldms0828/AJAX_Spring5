package com.gms.web.page;

public class Search {
	public void test() {

	/*		
			if(request.getSession().getAttribute("option") == null) {
				request.getSession().setAttribute("option", "none");
			}
			
			if(request.getParameter("option") != null) {
				request.getSession().setAttribute("option", request.getParameter("option"));
				request.getSession().setAttribute("word", request.getParameter("word"));
			}	
			
			PageProxy pxy = new PageProxy();
			String pageNum = request.getParameter("pageNum");  //초기값으로 페이지가 1이면 코드가 더 줄어들것 같다.
			pxy.carryOut(
					((pageNum==null)?
							"1/"
							:pageNum+"/")
					+((request.getSession().getAttribute("option").equals("none"))?
							MemberServiceImpl.getInstance().count()
							:MemberServiceImpl.getInstance().count(
										request.getSession().getAttribute("option")+"/"
										+request.getSession().getAttribute("word"))
					 )
			);
			Pagination page = pxy.getPagination();
			boolean flag = !(((String)request.getSession().getAttribute("option")).equals("none"));
			String[] arr1 = ("domain/beginRow/endRow"
							+((flag)?
							  "/column/value"
							  :"")
							)
					.split("/"), 
					 arr2 = (Domain.MEMBER.toString()+"/"
								+String.valueOf(page.getBeginRow())+"/"
								+String.valueOf(page.getEndRow())
								+((flag)?
								"/"+((String) request.getSession().getAttribute("option"))
								+"/"+((String) request.getSession().getAttribute("word"))
								:"")
							)
					 .split("/");
			Map<String,Object>paramMap = new HashMap<>();
			for(int i=0;i<arr1.length;i++) {
				paramMap.put(arr1[i], arr2[i]);
			}
			
			request.setAttribute("page", page);
			request.setAttribute("list", MemberServiceImpl.getInstance().search(paramMap));
		*/
	}
}
