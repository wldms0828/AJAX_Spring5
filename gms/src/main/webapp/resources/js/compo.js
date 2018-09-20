"use strict";
var ui ={
		div : x=>{return $('<div/>').attr(x);},
		anchor : x=>{
			//ui.anchor({id:'',txt:'TEST'});
			return $('<a/>').attr({href:'#',
						id:x.id }).html(x.txt)},
		ul : x=>{
			//ui.ul({id:'',len:''});
			let ul = $('<ul/>');
			for(var i=0;i<x.len;i++){
				$('<li/>').attr({
					id : x.id+'-'+i	}).appendTo(ul);
			}
			return ul;
		},
		input : x =>{
			let res=ui.div({}).addClass('input-group mb-3');
			res.append(ui.div({}).addClass('input-group-prepend'));
			return $('<input/>')
					.attr(x).addClass('form-control');
			/*<div class="input-group">
		      <span class="input-group-addon" id="basic-addon1">@</span>
		      <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
		    </div>*/
		},
		label : x=> {return $('<label/>').attr('for',x.id).text(x.txt)},
		input2 : x=>{ // id,val
			let ul = ui.div({}).addClass("input-group mb-3");
			(ui.div({id:'input-group-prepend'})
					.addClass("input-group-prepend"))
					.html('<span class="input-group-text" id="basic-addon1">'
							+ x.txt
							+'</span>').appendTo(p);
			/*ui.span({
				id: "basic-addon1",
				value: x.div__val
			}).appendTo($('#input-group-prepend'));*/
			$("<input/>").attr({
				id : x.id,
				type: 'text',
				placeholder:"입금액" ,
				"aria-label":"Username", 
				"aria-describedby":"basic-addon1"
			}).addClass("form-control").appendTo(p);
			return p;
		},
		inputGroupPrepend : x =>{
			return '<div class="input-group">'
			+'<span class="input-group-addon" id="basic-addon1">@</span>'
		    +'<input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">'
		    +'</div>'
		},
		btn:x=>{
			//let y =$('<button/>');
			//<button type = "button" class = "btn btn-primary" >Primary</button>
			
			return $('<button/>').attr('type','button').addClass('btn btn-'+ x.clazz).html(x.txt);
		}
		
}
