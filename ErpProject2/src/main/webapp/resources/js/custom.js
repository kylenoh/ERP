function findCustomer() {
	var url = "customer.pagingJSON";
	$.getJSON(url, function(data) {
		$(".CustomerList").empty();
		var ar = data.customers;
		$.each(ar, function(i, pack) {
			var cus_no = pack.cus_no;
			var cus_name = pack.cus_name;
			var cus_regno = pack.cus_regno;
			var cus_owner = pack.cus_owner;
			var cus_addr = pack.cus_addr;
			var cus_division = pack.cus_division;
			var cus_note = pack.cus_note;
			var td1 = $("<td></td>").text(cus_no);
			var td2 = $("<td></td>").text(cus_name).attr("class", "cus_name");
			var td3 = $("<td></td>").text(cus_regno);
			var td4 = $("<td></td>").text(cus_owner);
			var td5 = $("<td></td>").text(cus_addr);
			var td6 = $("<td></td>").text(cus_division);
			var td7 = $("<td></td>").text(cus_note);
			var tr1 = $("<tr></tr>").append(td1, td2, td3, td4, td5, td6, td7)
					.attr("class", i).attr("onclick", "goCustomer(" + i + ")");
			$(".CustomerList").append(tr1);
		});// 반복문종료
	});// JSON종료
}

function goCustomer(i) {
	// tbody tr td 인데 .i=0 .c_no = 0
	var name = ($(".CustomerList ." + i + " .cus_name").text());
	$('.customer').val(name);
	$('.SelectCustomer-modal-lg').modal('hide')
}

function getCustomerPaging(c) {
	var url = "customer.pageChangeJSON?c=" + c;
	$.getJSON(url, function(data) {
		$(".CustomerList").empty();
		var ar = data.customers;
		$.each(ar, function(i, pack) {
			var cus_no = pack.cus_no;
			var cus_name = pack.cus_name;
			var cus_regno = pack.cus_regno;
			var cus_owner = pack.cus_owner;
			var cus_addr = pack.cus_addr;
			var cus_division = pack.cus_division;
			var cus_note = pack.cus_note;
			var td1 = $("<td></td>").text(cus_no);
			var td2 = $("<td></td>").text(cus_name).attr("class", "cus_name");
			var td3 = $("<td></td>").text(cus_regno);
			var td4 = $("<td></td>").text(cus_owner);
			var td5 = $("<td></td>").text(cus_addr);
			var td6 = $("<td></td>").text(cus_division);
			var td7 = $("<td></td>").text(cus_note);
			var tr1 = $("<tr></tr>").append(td1, td2, td3, td4, td5, td6, td7)
					.attr("class", i).attr("onclick", "goCustomer(" + i + ")");
			$(".CustomerList").append(tr1);
		});

	});
}

function findContainer() {
	var url = "container.pagingJSON";
	$.getJSON(url, function(data) {
		$(".ContainerList").empty();
		var ar = data.containers;
		$.each(ar, function(i, pack) {
			var con_no = pack.con_no;
			var con_name = pack.con_name;
			var con_note = pack.con_note;
			var td1 = $("<td></td>").text(con_no);
			var td2 = $("<td></td>").text(con_name).attr("class", "con_name");
			var td3 = $("<td></td>").text(con_note);
			var tr1 = $("<tr></tr>").append(td1, td2, td3).attr("class", i)
					.attr("onclick", "goContainer(" + i + ")");
			$(".ContainerList").append(tr1);
		});// 반복문종료
	});// JSON종료
}

function goContainer(i) {
	var name = ($(".ContainerList ." + i + " .con_name").text());
	$('.container').val(name);
	$('.SelectContainer-modal-lg').modal('hide')
}

function getContainerPaging(c) {
	var url = "container.pageChangeJSON?c=" + c;
	$.getJSON(url, function(data) {
		$(".ContainerList").empty();
		var ar = data.containers;
		$.each(ar, function(i, pack) {
			var con_no = pack.con_no;
			var con_name = pack.con_name;
			var con_note = pack.con_note;
			var td1 = $("<td></td>").text(con_no);
			var td2 = $("<td></td>").text(con_name).attr("class", "con_name");
			var td3 = $("<td></td>").text(con_note);
			var tr1 = $("<tr></tr>").append(td1, td2, td3).attr("class", i)
					.attr("onclick", "goContainer(" + i + ")");
			$(".ContainerList").append(tr1);
		});

	});
}
// 검색
function goProduct(j,i) {
	var no = ($(".ProductList ." + j + " .pro_no").text());
	var name = ($(".ProductList ." + j + " .pro_name").text());
	var unit = ($(".ProductList ." + j + " .pro_unit").text());
	var price = ($(".ProductList ." + j + " .pro_sell").text());
	$('#s_pro_no'+i).val(no);
	$('#s_pro_name'+i).val(name);
	$('#s_pro_unit'+i).val(unit);
	$('#s_pro_price'+i).val(price);
	$('.SelectProduct-modal-lg').modal('hide')
	calculateQty();
}

function goProduct2(j,i) {
	var no = ($(".ProductList ." + j + " .pro_no").text());
	var name = ($(".ProductList ." + j + " .pro_name").text());
	var unit = ($(".ProductList ." + j + " .pro_unit").text());
	var price = ($(".ProductList ." + j + " .pro_sell").text());
	$('#d_pro_no'+i).val(no);
	$('#d_pro_name'+i).val(name);
	$('#d_pro_unit'+i).val(unit);
	$('#d_pro_price'+i).val(price);
	$('.SelectProduct-modal-lg').modal('hide')
	
}

function getContainerDetail(con_no, con_name, con_note) {
	$("#detailModal").modal();
	$("#d_no").val(con_no);
	$("#d_name").val(con_name);
	$("#d_note").val(con_note);
}

function deleteContainer(con_no) {
	var con_no = $("#d_no").val();
	location.href = "delete.container?con_no=" + con_no;
}

function getCurrencyDetail(cur_no, cur_name, cur_money,cur_note) {
	$("#detailModal").modal();
	$("#d_no").val(cur_no);
	$("#d_name").val(cur_name);
	$("#d_money").val(cur_money);
	$("#d_note").val(cur_note);
}

function deleteCurrency(cur_no) {
	var cur_no = $("#d_no").val();
	location.href = "delete.currency?cur_no=" + cur_no;
}

function getDetail(cus_no, cus_name, cus_regno, cus_owner, cus_addr,
		cus_division, cus_note) {
	$("#detailModal").modal();
	$("#d_no").val(cus_no);
	$("#d_name").val(cus_name);
	$("#d_regno").val(cus_regno);
	$("#d_owner").val(cus_owner);
	$("#d_addr").val(cus_addr);
	$("#d_division").val(cus_division);
	$("#d_note").val(cus_note);
}

function deleteCustomer(cus_no) {
	var cus_no = $("#d_no").val();
	location.href = "delete.customer?cus_no=" + cus_no;
}

function getDetailProduct(pro_no, pro_name, pro_unit, pro_weight, pro_buy,
		pro_sell, pro_note) {
	$("#detailModal").modal();
	$("#d_no").val(pro_no);
	$("#d_name").val(pro_name);
	$("#d_unit").val(pro_unit);
	$("#d_weight").val(pro_weight);
	$("#d_buy").val(pro_buy);
	$("#d_sell").val(pro_sell);
	$("#d_note").val(pro_note);
}

function deleteCustomer(cus_no) {
	var cus_no = $("#d_no").val();
	location.href = "delete.customer?cus_no=" + cus_no;
}

function deleteProduct(pro_no) {
	var pro_no = $("#d_no").val();
	location.href = "delete.product?pro_no=" + pro_no;
}
// 프로덕트 불러오기
function sales() {
	var noCount = $('.ConnectJS');		//배열이 생성[0,1,2,3]	tr에 생김 
		$('.ConnectJS').keyup(
				function(e) {
					var targetConnect = 0;
					for(var i=0; i<noCount.length; i++ ){	//배열의 숫자 세기
						var variable = $(noCount[i]).attr('id');
						
						var this1 = $(this).attr('id');
						if (this1==variable) {	// 서로의 아이디가 일치하고
							targetConnect = i+1;
						}
					}
							if (e.keyCode == 13) {
								var url = "product.pagingJSON";
								$.getJSON(url, function(data) {
									$('.SelectProduct-modal-lg').modal('show');
									$(".ProductList").empty();
									var ar = data.products;
									$.each(ar, function(j, pack) {
										var pro_no = pack.pro_no;
										var pro_name = pack.pro_name;
										var pro_unit = pack.pro_unit;
										var pro_weight = pack.pro_weight;
										var pro_buy = pack.pro_buy;
										var pro_sell = pack.pro_sell;
										var pro_note = pack.pro_note;
										var td1 = $("<td></td>").text(pro_no).attr("class","pro_no");
										var td2 = $("<td></td>").text(pro_name).attr("class", "pro_name");
										var td3 = $("<td></td>").text(pro_unit).attr("class", "pro_unit");
										var td4 = $("<td></td>").text(pro_weight);
										var td5 = $("<td></td>").text(pro_buy);
										var td6 = $("<td></td>").text(pro_sell).attr("class", "pro_sell");
										var td7 = $("<td></td>").text(pro_note);
										tr1 = $("<tr></tr>").append(td1, td2, td3, td4,	td5, td6, td7).attr("class", j).attr("onclick", "goProduct(" + j +","+targetConnect+")");
										$(".ProductList").append(tr1);
									});
								});
							}
				});
	calculateQty();
}

function sales2() {
	var noCount = $('.ConnectJS2');		//배열이 생성[0,1,2,3]	tr에 생김 
		$('.ConnectJS2').keyup(
				function(e) {
					var targetConnect = 0;
					for(var i=0; i<noCount.length; i++ ){	//배열의 숫자 세기
						var variable = $(noCount[i]).attr('id');
						
						var this1 = $(this).attr('id');
						if (this1==variable) {	// 서로의 아이디가 일치하고
							targetConnect = i+1;
						}
					}
							if (e.keyCode == 13) {
								var url = "product.pagingJSON";
								$.getJSON(url, function(data) {
									$('.SelectProduct-modal-lg').modal('show');
									$(".ProductList").empty();
									var ar = data.products;
									$.each(ar, function(j, pack) {
										var pro_no = pack.pro_no;
										var pro_name = pack.pro_name;
										var pro_unit = pack.pro_unit;
										var pro_weight = pack.pro_weight;
										var pro_buy = pack.pro_buy;
										var pro_sell = pack.pro_sell;
										var pro_note = pack.pro_note;
										var td1 = $("<td></td>").text(pro_no).attr("class","pro_no");
										var td2 = $("<td></td>").text(pro_name).attr("class", "pro_name");
										var td3 = $("<td></td>").text(pro_unit).attr("class", "pro_unit");
										var td4 = $("<td></td>").text(pro_weight);
										var td5 = $("<td></td>").text(pro_buy);
										var td6 = $("<td></td>").text(pro_sell).attr("class", "pro_sell");
										var td7 = $("<td></td>").text(pro_note);
										tr1 = $("<tr></tr>").append(td1, td2, td3, td4,	td5, td6, td7).attr("class", j).attr("onclick", "goProduct2(" + j +","+targetConnect+")");
										$(".ProductList").append(tr1);
									});
								});
							}
				});
		calculateQty2();
}

function calculateQty(){
	var qtyCount =$('.QtyJS');
	$('.QtyJS').keyup(function(e) {
			var count = 0;
			for(var i=0; i<qtyCount.length; i++ ){	//배열의 숫자 세기
				var xx = $(qtyCount[i]).attr('id');
				var this2 = $(this).attr('id');
				if (this2==xx) {	// 서로의 아이디가 일치하고
					count = i+1;
				}
			}
			qty = $(this).val();
			price = $('.s_pro_price'+count).val();
			s_price = qty * price;
			$('.s_price'+count).attr('value', s_price);
			$('.s_tax'+count).attr('value', s_price * 0.1);
			$('.s_sum'+count).attr('value', s_price + (s_price * 0.1));
	});
}

function calculateQty2(){
	var qtyCount =$('.QtyJS2');
	$('.QtyJS2').keyup(function(e) {	// 수량에 엔터누르면	
			var count = 0;					//카운터 에서
			for(var i=0; i<qtyCount.length; i++ ){	//배열의 숫자 세기
				var xx = $(qtyCount[i]).attr('id');	//아이디받고
				var this2 = $(this).attr('id');		//엔터누른곳 아이디받고
				if (this2==xx) {	// 서로의 아이디가 일치하고
					count = i+1;
				}
			}
			qty = $(this).val();
			price = $('#d_pro_price'+count).val();
			d_price = qty * price;
			$('#d_price'+count).val(d_price);
			$('#d_tax'+count).val(d_price * 0.1);
			$('#d_sum'+count).val(d_price+(d_price * 0.1));
	});
}

function getSalesDetail(s_no,s_date, s_cus, s_m_id, s_con, s_cur, s_type,s_note) {
	$("#detailModal").modal();
	$("#d_no").val(s_no);
	$("#d_date").val(s_date);
	$("#d_cus").val(s_cus);
	$("#d_m_id").val(s_m_id);
	$("#d_con").val(s_con);
	$("#d_cur").val(s_cur);
	$("#d_type").val(s_type);
	$("#d_note").val(s_note);
	getSubSales(s_no);
}

function getSubSales(s_no){
	var detailNo = $('.DetailNo');
	var url = "sales.detailJSON?sb_s_no="+s_no;
	$.getJSON(url, function(data) {
		var ar = data.subsaleses;
		for(var i=0; i < detailNo.length; i++ ){	//값나옴 4
			cost = $(detailNo[i]).val();		// 1,2,3,4
			$('#d_sb_no'+cost).val(ar[i].sb_no);
			$('#d_pro_no'+cost).val(ar[i].sb_pro_no);
			$('#d_pro_name'+cost).val(ar[i].pro_name);
			$('#d_pro_unit'+cost).val(ar[i].pro_unit);
			$('#d_qty'+cost).val(ar[i].sb_qty);
			$('#d_pro_price'+cost).val(ar[i].sb_pro_price);
			$('#d_price'+cost).val(ar[i].sb_price);
			$('#d_tax'+cost).val(ar[i].sb_tax);
			$('#d_sum'+cost).val(ar[i].sb_sum);
			
		}
	});
}

function deleteSales() {
	var d_no = $("#d_no").val();
	location.href = "delete.sales?s_no=" + d_no;
}

function deleteMember(){
	if (confirm("정말 탈퇴하시겠습니까?")) {
		location.href = "member.bye";
	}
}

function autoClosingAlert(selector,delay){
	var alert = $(selector).alert();
	alert.show();
	window.setTimeout(function(){
		alert.hide();
		},delay);
}

function submitFunction(){
	var fromID = document.chatForm.userID;
	var toID = document.chatForm.toID;
	var chatContent = document.chatForm.chatContent;
	$.ajax({
		type:"POST",
		url:"reg.chat",
		data:{
			fromID:encodeURIComponent(fromID),
			toID:encodeURIComponent(toID),
			chatContent:encodeURIComponent(chatContent)
		},
		success:function(result){
			if(result==1){
				autoClosingAlert("#successMessage",2000);
			}else if (result ==0) {
				autoClosingAlert("#dangerMessage",2000);
			}else{
				autoClosingAlert("#warningMessage",2000);
			}
		}
	});
	$('#chatContent').val('');
}

function bbsReplDelete(br_no) {
	if (confirm("삭제하시겠습니까?")) {
		location.href = "bbs.reply.delete?br_no=" + br_no;
	}
}

function bbsDelete(b_no) {
	if (confirm("삭제하시겠습니까?")) {
		location.href = "bbs.delete?b_no=" + b_no;
	}
}

function subSalesSubmit(){
	var subNo = $('.ConnectNo');
	var cost = 0;
	var sq_pro_no = null;
	var sq_qty = 0;
	var sq_pro_price = 0;
	var sq_price = 0;
	var sq_tax = 0;
	var sq_sum = 0;
			for(var i=0; i < subNo.length; i++ ){	//값나옴 4
				cost = $(subNo[i]).val();
				sq_pro_no =$('#s_pro_no'+cost).val();
				sq_qty =$('#s_qty'+cost).val();
				sq_pro_price =$('#s_pro_price'+cost).val();
				sq_price =$('#s_price'+cost).val();
				sq_tax =$('#s_tax'+cost).val();
				sq_sum =$('#s_sum'+cost).val();
				var data = {
						sb_pro_no: sq_pro_no,
						sb_qty: sq_qty,
						sb_pro_price:sq_pro_price,
						sb_price:sq_price,
						sb_tax:sq_tax,
						sb_sum:sq_sum,
				     };
				   $.ajax({
					    url : "sales.regSubJSON",
					    type : "GET",
					    data : data,
					    async:false,
					    success : function(data){
					    },
					    error : function(){
					    }
					});
			}
}

function salesSubmit(){
	var sq_d_no = $('#s_d_no').val();
	var sq_date = $('#salesDate').val();
	var sq_cus = $('#customer').val();
	var sq_m_id = $('#member').val();
	var sq_con = $('#container').val();
	var sq_cur = $('#currency').val();
	var sq_type = $('#division').val();
	var sq_note = $('#note').val();
		   var data = {
				s_d_no: sq_d_no,
				s_date: sq_date,
				s_cus: sq_cus,
				s_m_id:sq_m_id,
				s_con:sq_con,
				s_cur:sq_cur,
				s_type:sq_type,
				s_note:sq_note
		     };
		   $.ajax({
			    url : "sales.regJSON",
			    type : "GET",
			    data : data,
			    success : function(){
			    	subSalesSubmit();
			    	location.href="go.sales";		
			    },
			    error : function(){
			     
			    }
			});
   
		   
}

function subSalesUpdate(sq_no){
	var detailNo = $('.DetailNo');
			for(var i=0; i < detailNo.length; i++ ){	//값나옴 4
				var cost = $(detailNo[i]).val();
				var sq_no =$('#d_sb_no'+cost).val();
				var sq_pro_no =$('#d_pro_no'+cost).val();
				var sq_pro_name =$('#d_pro_name'+cost).val();
				var sq_pro_unit =$('#d_pro_unit'+cost).val();
				var sq_qty =$('#d_qty'+cost).val();
				var sq_pro_price =$('#d_pro_price'+cost).val();
				var sq_price =$('#d_price'+cost).val();
				var sq_tax =$('#d_tax'+cost).val();
				var sq_sum =$('#d_sum'+cost).val();
				var data = {
						sb_pro_no: sq_pro_no,
						pro_name: sq_pro_name,
						pro_unit: sq_pro_unit,
						sb_qty: sq_qty,
						sb_pro_price:sq_pro_price,
						sb_price:sq_price,
						sb_tax:sq_tax,
						sb_sum:sq_sum,
				     };
				   $.ajax({
					    url : "sales.updateSubJSON?sb_no="+sq_no,
					    type : "GET",
					    data : data,
					    async:false,
					    success : function(data){
					    	
					    },
					    error : function(){
					    	
					    }
					});
			}
}

function salesUpdate(){
	var sq_no = $('#d_no').val();
	var sq_date = $('#d_date').val();
	var sq_cus = $('#d_cus').val();
	var sq_m_id = $('#d_m_id').val();
	var sq_con = $('#d_con').val();
	var sq_cur = $('#d_cur').val();
	var sq_type = $('#d_type').val();
	var sq_note = $('#d_note').val();
		   var data = {
				s_date: sq_date,
				s_cus: sq_cus,
				s_m_id:sq_m_id,
				s_con:sq_con,
				s_cur:sq_cur,
				s_type:sq_type,
				s_note:sq_note
		     };
		   $.ajax({
			    url : "sales.updateJSON?s_no="+sq_no,
			    type : "GET",
			    data : data,
			    success : function(){
			    	subSalesUpdate(sq_no);
			    	location.href="update.sales";		
			    },
			    error : function(){
			     
			    }
			});
}
function goInvoice(){
	location.href="go.invoice";
}
function printInvoice(){
	Popup($('.invoice')[0].outerHTML);
	function Popup(data){
	  window.print();
	  return true;
	}
}


