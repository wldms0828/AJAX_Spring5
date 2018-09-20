"use strict";
var app = app || {};
var user = user || {};

user.session= x => {
		$.each(x, function(k,v){
			alert('key:'+k+',value:'+v);
			sessionStorage.setItem(k, v);
		});
		alert(sessionStorage.getItem('userid'));
};
app =(()=>{
	var init =x=>{
		app.router.init(x);
			console.log('step 1');
		};

	return {init : init};
})();

app.main=(()=>{
	var header,footer,content,ctx,script,style,nav,w,img;
	var init=()=>{
		ctx = $.ctx();
		img = $.img();
		script = $.script();
		style = $.style();
		w=$('#wrapper');

/*		header= script+'/header.js';
		footer=script+'/footer.js';
		content=script+'/content.js';
		nav=script+'/nav.js';*/
		onCreate();
		
	};
	var onCreate =()=>{
		setContentView();
	};
	var setContentView=()=>{
		app.router.home();
		
	};
	return{init:init};
})();
app.board=(()=>{
	var header,footer,content,ctx,script,style,nav,w,img;
	var list =()=>{
		alert('게시판!!!');
		$('#header').remove();
		$('#content').empty();
	};
})();
app.permission=(()=>{
	var login=()=>{
		alert('로그인~~');
			$.getScript($.script()+'/compo.js',()=>{
				$.getScript($.script()+'/login.js',()=>{
					$('#content').html(loginUI());
					ui.anchor({id:'#login__submit',txt:'로그인'})
					.css({'backgrond-color' : 'orange'})
					.addClass('login__btn')
					.appendTo('#contentBox')
					/*$('#login__submit')*/.click(()=>{
						$.ajax({
							url:$.ctx()+'/member/login',
							method:'post',
							contentType:'application/json',
							data:JSON.stringify({userid : $('#userid').val(),
								  password : $('#password').val()}),
							success:d=>{
								alert('ID판단 : '+d.ID);
								alert('PW판단 : '+d.PW);
								alert('MBR판단 : '+d.MBR.userid);
								if(d.ID === "WRONG"){
									
								}else if(d.PW  === "WRONG"){
									
								}else{
									
									$('#ch_login').empty().html('로그아웃 <span class="caret"></span>');
									$('#login__btn').empty().html("로그아웃");
									$('#join__btn').empty().html("마이페이지");
									$('#content').html(contentUI());
									
								}
								
							},
							error:(m1,m2,m3)=>{
								
							}
					})				
					});
				});
			});

	
	};
	var add=()=>{
		alert('회원가입!');
		$.getScript($.script()+'/compo.js',()=>{
			$.getScript($.script()+'/add.js',()=>{			
				$('#content').html(addUI());
				ui.anchor({id:'#add_submit',txt:'회원가입'})
				.addClass('add_submit')
				.appendTo('#contentBox')
				/*$('#add_submit')*/
				.click(e=>{
					e.preventDefault();
					alert('---click---');
					var arr = [];
					var sub = $("[name='roll']");
					let i;
					for(i of sub){
						if(i.checked){
							alert('선택된 역할 :: '+i.value);
							arr.push(i.value);
						}
					}
					$.ajax({
						url:$.ctx()+'/member/add',
						method:'post',
						contentType:'application/json',
						data:JSON.stringify({
							userid:$('#userid').val(),
							password : $('#password').val(),
							name : $('#name').val(),
							ssn : $('#ssn').val(),
							teamid : $('input[name=teamid]:checked').val(),
							/*roll : $('#roll').val(),*/
							roll : JSON.stringify(arr)
							
							}),
						success:d=>{
							alert('회원가입  test'+d.addtest);
						},
						error:(m1,m2,m3)=>{
							
						}
					});
				})
			});
		});

		
	};
 
	return{login:login,
			add:add	};
})();

app.router={
        init: x=>{
            alert("2번");
           $.getScript(x+'/resources/js/router.js',
                   ()=>{
                       $.extend(new Session(x));
                       $.getScript(x+'/resources/js/util.js')
                       .done(x=>{console.log('실행');})
                       .fail(x=>{console.log('실패');});
                       app.main.init();
               });
        },
        home : ()=>{
    		$.when(
    	            $.getScript($.script()+'/content.js'),
    	            $.getScript($.script()+'/nav.js'),
    	            $.getScript($.script()+'/footer.js'),
    	            $.getScript($.script() +'/header.js'),
    	            $.Deferred(y=>{
    	            	console.log('step3 :: ');
    	            	$(y.resolve);
    	            })
    	        ).done(x=>{
    	            console.log('step4 :: ');
    	            $('#wrapper').html(headerUI()
    	            		+navUI()
    	            		+contentUI()
    	            		+footerUI());
    	            $('#home_btn').click(e=>{
    	            	e.preventDefault();
    	            	app.router.home();
    	            });
    	            $('#login__btn').click(e=>{	            	
    	            	e.preventDefault();
    	            	alert('로그인 클릭 !!');
    	            	app.permission.login();	            	
    	            });
    	            $('#join__btn').click(e=>{
    		    		e.preventDefault();
    		    		alert('회원가입 클릭!!');
    		    		app.permission.add();
        	});
    	        }).fail(x=>{console.log('로드실패');		        	
    	});
        }
   };
