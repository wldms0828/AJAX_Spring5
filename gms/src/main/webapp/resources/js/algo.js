"use strict";
var algo = algo || {};

algo={
	init : x=> {
			alert('step1'+x);
			algo.onCreate(x);
			algo.setContentView();
			},
	onCreate : (x) => {
			algo.router.onCreate(x);
	},
	setContentView : ()=>{
		$('#wrapper').empty();
	}
};
algo.main = {
		onCreate:()=>{
			alert('step4 ::'+$.ctx());
			algo.main.setContentView();
		},
		setContentView : ()=>{
			alert('step5 ::'+$.ctx());
			$('#wrapper').html('<h1>Hello Algorithm</h1><h3>수열</h3><div id="ctn">'
			+'<table id="tbl" style="width:800px;height:300px;'
			+'border-collapse:collapse;border:1px solid black; margin:0 auto">'
			+'<tr style="border:1 px solid black;">'
			+'<td id="t__l" style="width:50%;border:1px solid black;"></td>'
			+'<td id="t__r" style="width:50%;border:1px solid black;"></td>'
			+'</tr>'
			+'</table>'											
			+'</div>');
			$('#t__l').html('<h3><a id="arith">등차수열</a></h3>');
			$('#arith').click(e=>{alert('등차수열선택');});
			$('#t__l').append('<h3><a id="fibonacci">피보나치수열</a></h3>');
			$('#fibonacci').click(e=>{alert('피보나치수열선택');});
			$('#t__l').append('<h3><a id="swit">스위치수열</a></h3>');
			$('#swit').click(e=>{alert('스위치수열선택');});
			$('#t__l').append('<h3><a id="factorial">팩토리얼수열</a></h3>');
			$('#factorial').click(e=>{alert('팩토리얼수열선택');});
		}
};
algo.series={
		arith : x=>{},
		fibonacci : x=>{},
		swit : x=>{},
		factorial : x=>{},
};
algo.array={
	bubble : x=>{},
	insert : x=>{},
	select : x=>{},
	ranking : x=>{},
};
algo.matrix={ObyO : x=> {},	
		sandGlass : x=> {},	
		snail : x=> {},	
		diamond : x=> {},	
		zigzag : x=> {}	
		};
algo.math={
		
		
};
algo.appl={};

algo.router = {
	onCreate:x=>{
		alert('step2'+x);
		$.getScript(x+'/resources/js/router.js',
				()=>{
					alert('step3 :: '+x);
					$.extend(new Session(x));
					algo.main.onCreate();
				}		
		);
	}
};
		