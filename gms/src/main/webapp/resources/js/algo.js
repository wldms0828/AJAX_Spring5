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
		
			let $t__l = $('#t__l');
			let $t__r = $('#t__r');
	
			//t__l원판이 객체가 된다.
			$("<ul />")
	        .attr({id : 'side__menu'})
	        .addClass('list-group').appendTo($t__l);
		
	       $('<li/>')
	       .attr({id : 'arith'})
	       .addClass('list-group-item')
	       .appendTo($('#side__menu'));
			$("<a/>")
			.attr({href :'#'})
			.html('등차수열의 합').appendTo($('#arith'))
			.click(e=>{
				alert('step: 8');
				$t__r.empty();
			
			let arr = [{id:'sta',label:'시작 값'},
					   {id:'end',label:'마지막 값'},
					   {id:'d',label:'공차'}];
			$('<div/>').attr({id:'ques'}).appendTo($t__r);
			$('<h4/>').html('시작 값 x,마지막 값 y,공차가 d 인 등차수열의 합을 구하시오.' ).appendTo($('#ques'));
			$('<div/>').attr({id:'ques'}).addClass('text-center').appendTo($t__r);
		  /*for(let i in arr){
				$('<label/>').html(arr[i].label).appendTo($('#ques'));
				$('<input/>').attr({id:arr[i].id,type:'text'}).appendTo($('#ques'));
				$('<br/>').appendTo($('#ques'));
			}
			$(arr).each(function(i){
				$('<label/>').html(this.label).appendTo($('#ques'));
				$('<input/>').attr({id:this.id,type:'text'}).appendTo($('#ques'));
				$('<br/>').appendTo($('#ques'));
			});
			$.each(arr,function(){
				$('<label/>').html(this.label).appendTo($('#ques'));
				$('<input/>').attr({id:this.id,type:'text'}).appendTo($('#ques'));
				$('<br/>').appendTo($('#ques'));
			});*/
			$.each(arr,(i,j)=>{
				
				$('<label/>').html(j.label).appendTo($('#ques'));
				$('<input/>').attr({id:j.id,type:'text'}).appendTo($('#ques'));
				$('<br/>').appendTo($('#ques'));
			});
			
			$('<button/>').addClass('btn btn-primary').attr({type : 'button'}).html('결과보기').appendTo('#ques')
			.click(()=>{
             let res = '숫자입력';
             	let a = $.fn.zeroChecker([
                        $('#sta').val()*1,
                        $('#end').val()*1,
                        $('#d').val()*1                          
                        ]);
               if(!a){
                   let sta = $('#sta').val()*1;
                   let end = $('#end').val()*1;
                   let d = $('#d').val()*1;
                   let sum=0;
                   let i=sta;
                   while(i<=end){
                         sum = i+sum;
                         i=d+i;                         
                         }    
                   	res=sum;
               }
          $('<h6/>').attr({id:"h6"}).appendTo('#ques').text('정답 : ' + res);
			})
			});
			
			
			$('#fibonacci').click(e=>{
				let ques = 
				'	<h3>다음 피보나치수열에 대하여 10번째 항 까지의 합을 구하는 알고리즘을 제시하라.</h3></br>'
				+'	<label for="시작값">시작값</label><input id="sta" type="text"></br>'
				+'	<button id="bt">결과보기</button>';	 
				$('#t__r').html(ques);
				$('#bt').click(()=>{
						let sta = $('#sta').val()*1;
						let sta2 = 1;
						let sum = sta+sta2;
						let n =2;
						let total =0;
						while(true){
							total = sta+sta2;
							sum+=total;
							sta=sta2;
							sta2=total;
						console.log(sta+','+sta2+','+sum);
							n++;
							if(n==10) 
								break;
									}
						let ans = "정답 : "
					$('#t__r').append(ans+sum);
				});
			});
			$('#swit').click(e=>{
				let ques = 
					'	<h3>다음 SWITCH수열에 대하여1번째부터 10번째 항 까지의 합을 구하는 알고리즘을 제시하라.</h3></br>'
				+'	<label for="시작값">시작값</label><input id="sta" type="text"></br>'
				+'	<button id="bt">결과보기</button>';
			$('#t__r').html(ques);
			$('#bt').click(()=>{
				let sta = 0;
				let sum = 0;
				console.log(sta+','+sum);
				while(true){
					sta++;
					sum+=sta;
					sta++;
					sum-=sta;
					if(sta==10){
						break;
					}
				let ans = "정답 : "
				}
				$('#t__r').append('정답 : ' + sum);
			});

					
			});
			$('#factorial').click(e=>{
				let ques = 
					'	<h3>다음 factorial수열에 대하여 1번째부터 5번째 항 까지의 합을 구하는 알고리즘을 제시하라.</h3></br>'
				+'	<label for="시작값">시작값</label><input id="sta" type="text"></br>'
				+'	<button id="bt">결과보기</button>';
				$('#t__r').html(ques);
				$('#bt').click(()=>{
					let n = 1;
					let f = 1;
					let s = 1;
					console.log(n+','+s);
					while(true){
						n++;
						f*=n;
						s+=f;
						
						if(n==5){
							break;
						}
					let ans = "정답 : "
					}
					$('#t__r').append('정답 : ' + s);
				});
			});
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
					$.getScript(x+'/resources/js/util.js')
					.done(x=>{console.log('실행');})
					.fail(x=>{console.log('실패');})
					algo.main.onCreate();
					}		
		);
	}
};
/*algo.util = {
		onCreate:x=>{			
			$.getScript(x+'/resources/js/util.js',
					()=>{
						$.extend(new NullChecker(x));
						algo.main.onCreate();
						}		
			);
		}
	};
		*/