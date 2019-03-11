
function connectIdCheckEvent() {
	$("#m_id").keyup(function() {
		var id = $(this).val();

		$.ajax({
			url : "member.id.check",
			data : {
				m_id : id
			}, 
			success : function(data) {
				if (id.length == 0) {
					$("#joinIdOk").text("ID입력");
					
				} else if ($(data).find("member").length == 1) {
					$("#joinIdOk").text("ID중복");
					
				} else {
					$("#joinIdOk").text("OK");
					
				}
			}
		});

	});
}

function joinCheck() {
	var m_id = document.joinForm.m_id;
	var m_pw = document.joinForm.m_pw;
	var m_pwChk = document.joinForm.m_pwChk;
	var m_name = document.joinForm.m_name;
	var m_addr1 = document.joinForm.m_addr1;
	var m_addr2 = document.joinForm.m_addr2;
	var m_addr3 = document.joinForm.m_addr3;
	var m_photo = document.joinForm.m_photo;

	if (isEmpty(m_id) || containsHS(m_id) || $("#joinIdOk").text() == "ID중복") {
		alert("!");
		m_id.value = "";
		m_id.focus();
		return false;
	} else if (isEmpty(m_pw) || notEquals(m_pw, m_pwChk)
			|| notContains(m_pw, "1234567890")
			|| notContains(m_pw, "qwertyuiopasdfghjklzxcvbnm")) {
		alert("!");
		m_pw.value = "";
		m_pwChk.value = "";
		m_pw.focus();
		return false;
	} else if (isEmpty(m_name)) {
		alert("!");
		m_name.value = "";
		m_name.focus();
		return false;
	} else if (isEmpty(m_addr1) || isEmpty(m_addr2) || isEmpty(m_addr3)) {
		alert("!");
		m_addr1.value = "";
		m_addr2.value = "";
		m_addr3.value = "";
		m_addr1.focus();
		return false;
	} else if (isEmpty(m_photo)
			|| (isNotType(m_photo, "png") && isNotType(m_photo, "jpg")
					&& isNotType(m_photo, "gif") && isNotType(m_photo, "bmp") && isNotType(
					m_photo, "jpeg"))) {
		alert("!");
		m_photo.value = "";
		return false;
	}

	return true;
}

function updateMemberCheck() {
	var m_id = document.updateForm.m_id;
	var m_pw = document.updateForm.m_pw;
	var m_pwChk = document.updateForm.m_pwChk;
	var m_name = document.updateForm.m_name;
	var m_addr1 = document.updateForm.m_addr1;
	var m_addr2 = document.updateForm.m_addr2;
	var m_addr3 = document.updateForm.m_addr3;
	var m_photo = document.updateForm.m_photo;
	if (isEmpty(m_id) || containsHS(m_id)) {
		alert("!");
		m_id.value = "";
		m_id.focus();
		return false;
	} else if (isEmpty(m_pw) || notEquals(m_pw, m_pwChk)
			|| notContains(m_pw, "1234567890")
			|| notContains(m_pw, "qwertyuiopasdfghjklzxcvbnm")) {
		alert("!");
		m_pw.value = "";
		m_pwChk.value = "";
		m_pw.focus();
		return false;
	} else if (isEmpty(m_name)) {
		alert("!");
		m_name.value = "";
		m_name.focus();
		return false;
	} else if (isEmpty(m_addr1) || isEmpty(m_addr2) || isEmpty(m_addr3)) {
		alert("!");
		m_addr1.value = "";
		m_addr2.value = "";
		m_addr3.value = "";
		m_addr1.focus();
		return false;
	} else if (isEmpty(m_photo)) {
		return true;
	} else if (isNotType(m_photo, "png") && isNotType(m_photo, "jpg")
			&& isNotType(m_photo, "gif") && isNotType(m_photo, "bmp")
			&& isNotType(m_photo, "jpeg")) {
		alert("!");
		m_photo.value = "";
		return false;
	}

	return true;
}

function loginCheck() {
	var m_id = document.loginForm.m_id;
	var m_pw = document.loginForm.m_pw;

	if (isEmpty(m_id) || isEmpty(m_pw)) {
		alert("!");
		m_id.value = "";
		m_pw.value = "";
		m_id.focus();
		return false;
	}
	return true;
}

function connectSummonAddrInputEvent(){
	$("#joinAddrSearchBtn").click(function(){
		new daum.Postcode({
	        oncomplete: function(data) {
	        	$("#m_addr3").val(data.zonecode);
	        	$("#m_addr1").val(data.address);
	        }
	    }).open();
	});
}




