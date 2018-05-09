$(function(){
	var images = ["img/jinwonfront.png","img/jinwonback.png","img/jinwon1.jpg","img/jinwon2.jpg"]
	
	var i = 0
	setInterval(function() {
		if(i++ >= (images.length-1)){
			i = 0;
		}
		$('#img').attr("src", images[i]);
	}, 1000)

	allsearch()
	
	$('#allshow').click(function() {
		allsearch()
	})
	
	$('#empshow').click(function() {
		empallsearch()
	})
	
	$('#deptshow').click(function() {
		deptallsearch()
	})
	
	//ALL 관련
	$(document).on('click','#allsearch',function(){
		allsearch() 
	})

	$(document).on('click','#allfindempno',function(){
		allfindempno() 
	})
	
	$(document).on('click','#allinsert',function(){
		var table = "<tr>"
		 	table +="<td><input type='text' id='insertempno' placeholder='사번'></td>"
			table +="<td><input type='text' id='insertename' placeholder='이름'></td>"
			table +="<td><input type='text' id='insertjob' placeholder='직업'></td>"
			table +="<td><input type='text' id='insertmgr' placeholder='사수번호'></td>"
			table +="<td><input type='text' id='inserthiredate' placeholder='입사일'></td>"
			table +="<td><input type='text' id='insertsal' placeholder='급여'></td>"
			table +="<td><input type='text' id='insertcomm' placeholder='수당'></td>"
			table +="<td><input type='text' id='insertdeptno' placeholder='부서번호'></td>"
			table +="<td><input type='text' placeholder='부서이름' readonly></td>"
			table +="<td><input type='text' placeholder='부서지역' readonly></td>"
			table +="<td><a id='allinsertconfirm'>확인</a>"
			table +="<td><a id='allinsertcancle'>취소</a>"
			table +="</tr>" 
		$('.all').append(table)
		$('#insertempno').focus()
		
		$("#inserthiredate").datepicker({
			changeMonth: true,
			changeYear: true,
			minDate: new Date(1980, 1 - 1, 1)
		})
		
		$("#inserthiredate").datepicker( "option", "showAnim", "blind" )
		$("#inserthiredate").datepicker( "option", "dateFormat", "yy-mm-dd")
		
		$('#allinsert').hide()
	})
	
	$(document).on('click','#alldelete',function(){
		empdelete($(this).closest('tr')[0].firstChild.textContent)
		allsearch()
	})

	$(document).on('click','#allinsertconfirm',function(){
		empinsert() 
		allsearch()
		$('#allinsert').show()
	})
	
	$(document).on('click','#allinsertcancle',function(){
		$(this).closest('tr').remove()
		$('#allinsert').show()
	})
	
	$(document).on('click','#alldeptnosearch',function(){
		alldeptnosearch()
	})
	//ALL 관련
	
	//EMP 관련
	$(document).on('click','#empallsearch',function(){
		empallsearch()
	})
	
	$(document).on('click','#empnosearch',function(){
		findempno()
	})
	
	$(document).on('click','#empinsert',function(){
	
		var table = "<tr>"
		 	table +="<td><input type='text' id='insertempno' placeholder='사번'></td>"
			table +="<td><input type='text' id='insertename' placeholder='이름'></td>"
			table +="<td><input type='text' id='insertjob' placeholder='직업'></td>"
			table +="<td><input type='text' id='insertmgr' placeholder='사수번호'></td>"
			table +="<td><input type='text' id='inserthiredate' placeholder='입사일'></td>"
			table +="<td><input type='text' id='insertsal' placeholder='급여'></td>"
			table +="<td><input type='text' id='insertcomm' placeholder='수당'></td>"
			table +="<td><input type='text' id='insertdeptno' placeholder='부서번호'></td>"
			table +="<td><a id='insertconfirm'>확인</a>"
			table +="<td><a id='insertcancle'>취소</a>"
			table +="</tr>" 
		$('.emp').append(table)
		$('#insertempno').focus()
		
		$("#inserthiredate").datepicker({
			changeMonth: true,
			changeYear: true,
			minDate: new Date(1980, 1 - 1, 1)
		})
		
		$("#inserthiredate").datepicker( "option", "showAnim", "blind" )
		$("#inserthiredate").datepicker( "option", "dateFormat", "yy-mm-dd")
		
		$('#empinsert').hide()
	})
	
	$(document).on('click','#empdelete',function(){
		empdelete($(this).closest('tr')[0].firstChild.textContent)
		empallsearch()
		$('#empinsert').show()
	})

	$(document).on('click','#insertconfirm',function(){
		empinsert() 
		empallsearch()
		$('#empinsert').show()
	})
	$(document).on('click','#insertcancle',function(){
		$(this).closest('tr').remove()
		$('#empinsert').show()
	})
	//EMP 관련
	
	//DEPT 관련
	$(document).on('click','#deptinsert',function(){
		var table = "<tr>"
		 	table +="<td><input type='text' id='insertdeptno' placeholder='부서번호'></td>"
			table +="<td><input type='text' id='insertdname' placeholder='부서이름'></td>"
			table +="<td><input type='text' id='insertloc' placeholder='부서위치'></td>"
			table +="<td><a id='deptinsertconfirm'>확인</a>"
			table +="<td><a id='deptinsertcancle'>취소</a>"
			table +="</tr>" 
		$('.dept').append(table)
		$('#insertdeptno').focus()
		
		$('#deptinsert').hide()
	})
	
	$(document).on('click','#deptdelete',function(){
		deptdelete($(this).closest('tr')[0].firstChild.textContent)
	})

	$(document).on('click','#deptinsertconfirm',function(){
		deptinsert() 
	})
	
	$(document).on('click','#deptinsertcancle',function(){
		$(this).closest('tr').remove()
		$('#deptinsert').show()
	})
	//DEPT 관련	
})

//FUNCTION
//ALL
	function allsearch(){
		$('#tablespace').empty()
		$('#allinsert').show()
		$.ajax({
			url : "allListServlet",
			success : function(data) {
				$('#menu').empty()
				var menu = '<select id="deptno"></select><button id="alldeptnosearch">부서검색</button><input type="text" id="search"><button id="allfindempno">검색</button><button id="allsearch">전체보기</button><button id="allinsert">사원추가</button>'
				$('#menu').append(menu)
				
				$('#allinsert').show()
				var datas = JSON.parse(data)
				var table = '<table id="alltable"><thead><tr><th width="5%">사번</th><th width="10%">이름</th><th width="13%">직업</th><th width="11%">사수번호</th><th width="11%">입사일</th><th width="5%">급여</th><th width="5%">수당</th><th width="10%">부서번호</th><th width="11%">부서이름</th><th width="10%">부서위치</th><th width="8%" colspan="2">작업공간</th></tr></thead><tbody class="all mybox">'
				$.each(datas, function(i, elt) {
					table += "<tr>"
					table += "<td>" +elt[0].empno +"</td>"
					table += "<td>" +elt[0].ename +"</td>"
					table += "<td>" +elt[0].job +"</td>"
					table += "<td>" +elt[0].mgr +"</td>"
					table += "<td>" +elt[0].hiredate +"</td>"
					table += "<td>" +elt[0].sal +"</td>"
					table += "<td>" +elt[0].comm +"</td>"
					table += "<td>" +elt[0].deptno +"</td>"
					if(elt[1] != null){
						table += "<td>" +elt[1].dname +"</td>"
						table += "<td>" +elt[1].loc +"</td>"
					}else{
						table += "<td> X </td>"
						table += "<td> X </td>"
					}
					table += "<td><a onclick='allupdate(this)'>수정</a></td>"	
					table += "<td><a id='alldelete'>삭제</a></td>"
					table += "</tr>"
				})
				table += "</tbody></table>"
				$('#tablespace').append(table)
				$("#alltable").tablesorter();
				selectboxdeptno()
			}
		}) 
	}
	
	function allfindempno(){
		$('.all').empty()
		$('#allinsert').hide()
		var search = $('#search').val()
		if(search == ""	){
			search = 0
		}
		$.ajax({
			url : "allFindByDeptnoServlet",
			data : {empno : search},
			success : function(data) {
				$('#search').val("")
				var datas = JSON.parse(data)
				if(datas == "" || datas == null){
					var table = "<tr><td colspan='12'> 검색된 사원이 없습니다 </td></tr>"
					$('#alltable').append(table)				
				}else{
					var table = "<tr>"
						table += "<td>" +datas[1][0].empno +"</td>"
						table += "<td>" +datas[1][0].ename +"</td>"
						table += "<td>" +datas[1][0].job +"</td>"
						table += "<td>" +datas[1][0].mgr +"</td>"
						table += "<td>" +datas[1][0].hiredate +"</td>"
						table += "<td>" +datas[1][0].sal +"</td>"
						table += "<td>" +datas[1][0].comm +"</td>"
						table += "<td>" +datas[1][0].deptno +"</td>"
					if(datas[1][1] != null){	
						table += "<td>" +datas[1][1].dname +"</td>"
						table += "<td>" +datas[1][1].loc +"</td>"
					}else{
						table += "<td> X </td>"
						table += "<td> X </td>"
					}
						table += "<td><a onclick='allupdate(this)'>수정</a></td>"	
						table += "<td><a id='alldelete'>삭제</a></td>"
						table += "</tr>"
					$('#alltable').append(table)
				}
			}
		})
	}
	
	function selectboxdeptno(){
			$('#deptno').empty()
			$.ajax({
				type : "POST",
				url : "deptListServlet",
				success : function(data) {
					var datas = JSON.parse(data)
					var selectbox =""
					for(var i = 0; i<datas.length; i++){
						selectbox += "<option>" + datas[i].deptno + "</option>"
					}
					$('#deptno').append(selectbox)
			}
		}) 
	}
	
	function alldeptnosearch(){
		$('.all').empty()
		$('#allinsert').hide()
		$.ajax({
			url : "allListFindByDeptnoServlet",
			data : {deptno : $('#deptno > option:selected').val()},
			success : function(data) {
				var datas = JSON.parse(data)
				
				if(datas == "" || datas == null){
					var table = "<tr><td colspan='12'> 검색된 사원이 없습니다 </td></tr>"
					$('#alltable').append(table)				
				}else{
					var table = "";
						$.each(datas, function(i, elt) {
							table += "<tr>"
							table += "<td>" + elt[0].empno +"</td>"
							table += "<td>" + elt[0].ename +"</td>"
							table += "<td>" + elt[0].job +"</td>"
							table += "<td>" + elt[0].mgr +"</td>"
							table += "<td>" + elt[0].hiredate +"</td>"
							table += "<td>" + elt[0].sal +"</td>"
							table += "<td>" + elt[0].comm +"</td>"
							table += "<td>" + elt[0].deptno +"</td>"
							table += "<td>" + elt[1].dname +"</td>"
							table += "<td>" + elt[1].loc +"</td>"
							table += "<td><a onclick='allupdate(this)'>수정</a></td>"	
							table += "<td><a id='alldelete'>삭제</a></td>"
							table += "</tr>"
						})
					$('#alltable').append(table)
				}
			}
		}) 
	}
	
	function allupdate(me){
		
		var tr = $(me).closest('tr')
		var datas = {empno:$(me).closest('tr').children().html()};
		$(me).closest('tr').empty();
		$('#empinsert').hide()
		
		$.ajax({
			url:"allFindByDeptnoServlet",
			data:datas,
			success : function(data) {
				var emp = JSON.parse(data)
				var td = "<td><input type='text' value='"+emp[1][0].empno +"' readonly></td>";
					td +="<td><input type='text' value='"+emp[1][0].ename +"'></td>";
					td +="<td><input type='text' value='"+emp[1][0].job +"'></td>";
					td +="<td><input type='text' value='"+emp[1][0].mgr +"'></td>";
					td +="<td><input type='text' value='"+emp[1][0].hiredate +"' readonly></td>";
					td +="<td><input type='text' value='"+emp[1][0].sal +"'></td>";
					td +="<td><input type='text' value='"+emp[1][0].comm +"'></td>";
					td +="<td><input type='text' value='"+emp[1][0].deptno +"'></td>";
					if(emp[1][1] != null){
						td +="<td><input type='text' value='"+emp[1][1].dname +"' readonly></td>";
						td +="<td><input type='text' value='"+emp[1][1].loc +"' readonly></td>";
					}else{
						td +="<td><input type='text' value='X' readonly></td>";
						td +="<td><input type='text' value='X' readonly></td>";
					}
					td +="<td colspan='2'><a onclick='allupdateconfirm(this)'>완료</a></td>";
					
					$(tr).append(td);
			}
		})
	}
	
	function allupdateconfirm(me){
		empupdateok(me)
		allsearch()
	}
	//ALL
	
	//EMP
	function empallsearch(){
		$('#tablespace').empty()
		$.ajax({
			type : "POST",
			url : "empListServlet",
			success : function(data) {
				$('#menu').empty()
				var div = '<input type="text" id="search"><button id="empnosearch">사원번호검색</button><button id="empallsearch">전체보기</button><button id="empinsert">사원추가</button>'
				$('#menu').append(div)
				
				$('#empinsert').show()
				var datas = JSON.parse(data)
				
				var table = '<table id="emptable"><thead><tr><th width="7%">사번</th><th width="15%">이름</th><th width="15%">직업</th><th width="7%">사수번호</th><th width="15%">입사일</th><th width="10%">급여</th><th width="10%">수당</th><th width="10%">부서번호</th><th width="11%" colspan="2">작업공간</th></tr></thead><tbody class="mybox emp">'
				$.each(datas, function(i, elt) {
					table += "<tr>"
					table += "<td>" +elt.empno +"</td>"
					table += "<td>" +elt.ename +"</td>"
					table += "<td>" +elt.job +"</td>"
					table += "<td>" +elt.mgr +"</td>"
					table += "<td>" +elt.hiredate +"</td>"
					table += "<td>" +elt.sal +"</td>"
					table += "<td>" +elt.comm +"</td>"
					table += "<td>" +elt.deptno +"</td>"
					table += "<td><a onclick='empupdate(this)'>수정</a></td>"	
					table += "<td><a id='empdelete'>삭제</a></td>"
					table += "</tr>"
				})
				table += "</tbody></table>"
				$('#tablespace').append(table)
				$("#emptable").tablesorter(); 
			}
		}) 
	}
	 
	function findempno(){
		$('.emp').empty()
		var search = $('#search').val()
		if(search == ""	){
			search = 0
		}
		$.ajax({
			type : "POST",
			url : "empFindByEmpnoServlet",
			data : {empno : search},
			success : function(data) {
				$('#search').val("")
				$('#empinsert').hide()
				var emp = JSON.parse(data)
				
				if(emp == "" || emp == null){
					var table = "<tr><td colspan='10'> 검색된 사원이 없습니다 </td></tr>"
					$('#emptable').append(table)				
				}else{
					var table = "<tr>"
						table += "<td>" +emp.empno +"</td>"
						table += "<td>" +emp.ename +"</td>"
						table += "<td>" +emp.job +"</td>"
						table += "<td>" +emp.mgr +"</td>"
						table += "<td>" +emp.hiredate +"</td>"
						table += "<td>" +emp.sal +"</td>"
						table += "<td>" +emp.comm +"</td>"
						table += "<td>" +emp.deptno +"</td>"
						table += "<td><a onclick='empupdate(this)'>수정</a></td>"	
						table += "<td><a id='empdelete'>삭제</a></td>"
						table += "</tr>"
					$('#emptable').append(table)
				}
			}
		})
	}
	
	function empinsert(){
		$.ajax({
			type : "POST",
			url : "empInsertServlet",
			data : {
						empno : $('#insertempno').val(),
						ename : $('#insertename').val(),
						job : $('#insertjob').val(),
						mgr : $('#insertmgr').val(),
						hiredate : $('#inserthiredate').val(),
						sal : $('#insertsal').val(),
						comm : $('#insertcomm').val(),
						deptno : $('#insertdeptno').val()
					}
		})
	}
	
	function empupdate(me){
		
		var tr = $(me).closest('tr')
		var datas = {empno:$(me).closest('tr').children().html()};
		$(me).closest('tr').empty();
		$('#empinsert').hide()
		
		$.ajax({
			url:"empFindByEmpnoServlet",
			data:datas,
			success : function(data) {
				var emp = JSON.parse(data)
				
				var td = "<td><input type='text' value='"+emp.empno +"' readonly></td>";
					td +="<td><input type='text' value='"+emp.ename +"'></td>";
					td +="<td><input type='text' value='"+emp.job +"'></td>";
					td +="<td><input type='text' value='"+emp.mgr +"'></td>";
					td +="<td><input type='text' value='"+emp.hiredate +"' readonly></td>";
					td +="<td><input type='text' value='"+emp.sal +"'></td>";
					td +="<td><input type='text' value='"+emp.comm +"'></td>";
					td +="<td><input type='text' value='"+emp.deptno +"'></td>";
					td +="<td colspan='2'><a onclick='empupdateconfirm(this)'>완료</a></td>";
					
					$(tr).append(td);
			}
		})
	}
	
	function empupdateconfirm(me){
		empupdateok(me)
		empallsearch()
		$('#empinsert').show()
	}
	
	function empupdateok(me){
		var tr = $(me).closest('tr');
		var data = {empno:tr.find("td:eq(0)").children().val(),
					ename:tr.find("td:eq(1)").children().val(),
					job:tr.find("td:eq(2)").children().val(),
					mgr:tr.find("td:eq(3)").children().val(),
					hiredate:tr.find("td:eq(4)").children().val(),
					sal:tr.find("td:eq(5)").children().val(),
					comm:tr.find("td:eq(6)").children().val(),
					deptno:tr.find("td:eq(7)").children().val(),
				   };
		$.ajax({
			url:"empUpdateServlet",
			data:data
		})
	}
	
	function empdelete(delempno){
		$.ajax({
			type : "get",
			url : "empDeleteServlet",
			data : {empno : delempno}
		})
	}
	//EMP
	
	//DEPT
	function deptallsearch(){
		$('#tablespace').empty()
		$.ajax({
			type : "POST",
			url : "deptListServlet",
			success : function(data) {
				$('#menu').empty()
				var menu = '<button id="deptinsert">부서추가</button>'
				$('#menu').append(menu)
				
				$('#deptinsert').show()
				var datas = JSON.parse(data)
	
				var table = '<table id="depttable"><thead><tr><th width="20%">부서번호</th><th width="35%">부서이름</th><th width="25%">부서위치</th><th width="20%" colspan="2">작업공간</th></tr></thead><tbody class="dept mybox">'
				$.each(datas, function(i, elt) {
					table += "<tr>"
					table += "<td>" +elt.deptno +"</td>"
					table += "<td>" +elt.dname +"</td>"
					table += "<td>" +elt.loc +"</td>"
					table += "<td><a onclick='deptupdate(this)'>수정</a>"	
					table += "<td><a id='deptdelete'>삭제</a></td>"
					table += "</tr>"
				})
				table +="</tbody></table>"
				$('#tablespace').append(table)
				$("#depttable").tablesorter(); 
			}
		}) 
	}
	
	function deptinsert(){
		$.ajax({
			type : "POST",
			url : "deptInsertServlet",
			data : {
						deptno : $('#insertdeptno').val(),
						dname : $('#insertdname').val(),
						loc : $('#insertloc').val(),
					},
			success : function() {
				deptallsearch()
				$('#deptinsert').show()
			}
		})
	}
	
	function deptupdate(me){
		
		var tr = $(me).closest('tr')
		var datas = {deptno:$(me).closest('tr').children().html()};
		$(me).closest('tr').empty();
		$('#deptinsert').hide()
		
		$.ajax({
			url:"deptFindByDeptnoServlet",
			data:datas,
			success : function(data) {
				var dept = JSON.parse(data)
				
				var td = "<td><input type='text' value='"+dept.deptno +"' readonly></td>";
					td +="<td><input type='text' value='"+dept.dname +"'></td>";
					td +="<td><input type='text' value='"+dept.loc +"'></td>";
					td +="<td colspan='2'><a onclick='deptupdateok(this)'>완료</a></td>";
					
					$(tr).append(td);
			}
		})
	}
	
	function deptupdateok(me){
		var tr = $(me).closest('tr');
		var data = {deptno:tr.find("td:eq(0)").children().val(),
					dname:tr.find("td:eq(1)").children().val(),
					loc:tr.find("td:eq(2)").children().val(),
				   };
		$.ajax({
			url:"deptUpdateServlet",
			data:data,
			success : function() {
				$('#deptinsert').show()
				deptallsearch()
			}
		})
	}
	
	function deptdelete(deldeptno){
		$.ajax({
			type : "get",
			url : "deptDeleteServlet",
			data : {deptno : deldeptno},
			success : function() {
				deptallsearch()
				$('#deptinsert').show()
			}
		})
	}
	
	