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
	$('#customer').attr('value', name);
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
	$('#container').attr('value', name);
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
	$('#s_pro_no'+i).attr('value', no);
	$('#s_pro_name'+i).attr('value', name);
	$('#s_pro_unit'+i).attr('value', unit);
	$('#s_pro_price'+i).attr('value', price);
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
	var qtyCount =$('.QtyJS');
	
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
		
	$('.QtyJS').keyup(function(e) {
		if (e.keyCode == 13) {
			var count = 0;
			for(var i=0; i<qtyCount.length; i++ ){	//배열의 숫자 세기
				var xx = $(qtyCount[i]).attr('id');
				var this2 = $(this).attr('id');
				if (this2==xx) {	// 서로의 아이디가 일치하고
					count = i+1;
				}
			}
			qty = $(this).val();
			price = $('#s_pro_price'+count).val();
			s_price = qty * price;
			$('#s_price'+count).attr('value', s_price);
			$('#s_tax'+count).attr('value', s_price * 0.1);
			$('#s_sum'+count).attr('value', s_price + (s_price * 0.1));
		}
	});
	
}

function getSalesDetail(s_date, s_cus, s_m_id, s_con, s_cur, s_type, s_pro_no,
		s_qty, s_pro_price, s_price, s_tax, s_sum) {
	$("#detailModal").modal();
	$("#d_date").val(s_date);
	$("#d_cus").val(s_cus);
	$("#d_m_id").val(s_m_id);
	$("#d_con").val(s_con);
	$("#d_cur").val(s_cur);
	$("#d_type").val(s_type);
	$("#d_pro_no").val(s_pro_no);
	$("#d_pro_price").val(s_pro_price);
	$("#d_price").val(s_price);
	$("#d_sum").val(s_sum);
}

function deleteSales(s_no) {
	var s_no = $("#d_no").val();
	location.href = "delete.container?s_no=" + s_no;
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

