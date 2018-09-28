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
			let p = ui.div({}).addClass("input-group mb-3");
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
		},
		tbl : x=>{
/*			<div class="panel panel-default">
			  <!-- Default panel contents -->
			  <div class="panel-heading">Panel heading</div>
			  <div class="panel-body">
			    <p>...</p>
			  </div>

			  <!-- Table -->
			  <table class="table">
			    ...
			  </table>
			</div>*/
			let type = '<div class="panel panel-default"/>';
			let title = '<div class="panel-heading">JieunZip</div>';
			let body = '<div class="panel-body">'+ x.body + '</div>';
			let t=$('<table/>');
			let thead=$('<thead/>');
			let tr=$('<tr/>');
			tr.appendTo(thead);
			thead.appendTo(t);
			$.each(x.list,(i,j)=>{
	        $('<th/>').html(j).appendTo(tr);});
			$('<tbody/>').appendTo(t);
			
			return t;
		},
		page : x => {
			/*
			 * <nav aria-label="...">
  <ul class="pagination">
    <li class="page-item disabled">
      <span class="page-link">Previous</span>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item active">
      <span class="page-link">
        2
        <span class="sr-only">(current)</span>
      </span>
    </li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#">Next</a>
    </li>
  </ul>
</nav>* */
		let ul = '<ul class="pagination"/>';
		let li1 = '<li class="page-item disabled"/>';
		let pre = li1.append(span).html('Previous');
		
		let li2 = '<li class="page-item"/>';
		let li3 = '<li class="page-item active"/>';
		let span = '<span class="page-link"/>';
		let a = $('<a/>');
		
			 
		ul.li2.append(span).html('1');	 
		ul.li3.append(span).html('2');	 
 
		}
		
}
