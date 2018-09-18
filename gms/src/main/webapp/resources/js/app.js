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
	/*var setContentView =x=>{
			        $.when(
			            $.getScript($.script+'/router.js'),
			            $.getScript($.script+'/util.js'),
			            $.getScript($.script+'/footer.js'),
			            $.getScript($.script +'/header.js'),
			            $.Deferred(y=>{
			            	console.log('step3 :: ');
			            })
			        ).done(z=>{
			            console.log('step4 :: ');
			        });*/
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
/*		$.getScript(header,()=>{
			w.html(headerUI());
		});*/
		$.when(
	            $.getScript(script+'/content.js'),
	            $.getScript(script+'/nav.js'),
	            $.getScript(script+'/footer.js'),
	            $.getScript(script +'/header.js'),
	            $.Deferred(y=>{
	            	console.log('step3 :: ');
	            	$(y.resolve);
	            })
	        ).done(x=>{
	            console.log('step4 :: ');
	            w.html(headerUI()
	            		+navUI()
	            		+contentUI()
	            		+footerUI());
	            $('#login__btn').click(e=>{	            	
	            	e.preventDefault();
	            	alert('로그인 클릭 !!');
	            	app.permission.login();	            	
	            })
	        }).fail(x=>{console.log('로드실패');	
	});
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
		$('#header').remove();
		$('#content').empty();
		$.getScript($.script()+'/login.js',()=>{
			$('#content').html(loginUI());
		});
		
	};
 
	return{login:login};
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
        }
   };
/*
app = {
		init : x=>{
			console.log('step 1');
			app.router.init(x);
			
		},
		onCreate : ()=>{
			console.log('step 3 ::');
			app.setContentView();
			$('#login__btn').click(()=>{
				location.href = app.x()+'/move/auth/member/login';
			});
			$('#join__btn').click(()=>{
				location.href = app.x()+'/move/auth/member/add';
			});
			$('#login__submit').click(()=>{
				alert('login__submit click!!');
				$('#login__form')
				.attr({
					action : app.x()+'/member/login',
					method : "POST"
				})
				.submit();
			});
			$('#mypage__btn').click(()=>{
				alert('mypage__btn click');
				location.href=app.x()+'/member/retrieve/'+userid;
			});
			$('#logout__btn').click(()=>{
				alert('logout');
				location.href = app.x()+'/member/logout';
			});
					$('#add_submit').click(()=>{
				alert('add_submit click!!');	
				$('#add_form')
				.attr({
					action: app.x()+"/member/add",
					method : "POST"
				})
				.submit();
			
			
				var form = document.getElementById('add_form');
				form.action = app.x()+"/member/add";
				form.method = "POST";
				form.submit();

			});
			
			$('#delete__btn').click(()=>{
				alert('delete__btn click!!');
				location.href = app.x()+'/move/delete/member/remove';
				
			});
			$('#deleteFormBtn').click(()=>{
				alert('deleteFormBtn!!');
				$('#deleteForm')
				.attr({
					action : app.x()+"/member/remove",
					mothod : "POST"
				})
				.submit();
			});
			$('#update__btn').click(()=>{
				alert('modifyBtn click!!');
				location.href = app.x()+'/move/update/member/modify';
			});
			$('#modifyBtn').click(()=>{
				alert('update__btn click!!');
				$('#updateForm')
				.attr({
					action : app.x()+"/member/modify",
					method : "POST"
				})
				.submit();
			});
		},
		setContentView : ()=>{
			console.log('step 4 ::'+app.j());
			
		}
	};


	app.x = ()=>{
		return app.session.path('context');
	};
	app.j = ()=>{
		return app.session.path('js');
	};
	app.c = ()=>{
		return app.session.path('css');
	};
	app.i = ()=>{
		return app.session.path('img');
	};
*/