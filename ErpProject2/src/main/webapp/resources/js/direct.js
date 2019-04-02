function deleteContainer(con_no) {
	var con_no = $("#d_no").val();
	location.href = "delete.container?con_no=" + con_no;
}

function deleteCurrency(cur_no) {
	var cur_no = $("#d_no").val();
	location.href = "delete.currency?cur_no=" + cur_no;
}

function deleteCustomer(cus_no) {
	var cus_no = $("#d_no").val();
	location.href = "delete.customer?cus_no=" + cus_no;
}

function deleteCustomer(cus_no) {
	var cus_no = $("#d_no").val();
	location.href = "delete.customer?cus_no=" + cus_no;
}

function deleteProduct(pro_no) {
	var pro_no = $("#d_no").val();
	location.href = "delete.product?pro_no=" + pro_no;
}

function deleteSales() {
	var d_no = $("#d_no").val();
	location.href = "delete.sales?s_no=" + d_no;
}

function deletePurchase() {
	var d_no = $("#d_no").val();
	location.href = "delete.purchase?ps_no=" + d_no;
}

function deleteMember(){
	if (confirm("정말 탈퇴하시겠습니까?")) {
		location.href = "member.bye";
	}
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

function goInvoice(){
	var d_no = $('#d_no').val();
	location.href="go.invoice?d_no="+d_no;
}