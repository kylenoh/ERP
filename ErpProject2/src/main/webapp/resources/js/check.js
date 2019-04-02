//회원가입
function registerCheck(){
		var userID = $('#m_id').val();
		$.ajax({
			type:'POST',
			url:"member.id.check",
			data:{m_id:userID},
			success:function(data){
				if (data.member[0] == null) {
					$('#checkTitle').html('성공 메시지');
					$('#checkMessage').html('사용 가능한  아이디입니다.');
					$('#checkType').css('background-color','#dff0d8');
				}else if (data.member[0].m_id == userID) {
					$('#checkTitle').html('실패 메시지');
					$('#checkMessage').html('사용할 수 없는 아이디입니다.');
					$('#checkType').css('background-color','#faebcc');
				}
				$('#checkModal').modal("show");
			}
		});
}

function passwordCheck(){
		var userPassword1 = $('#userPassword1').val();
		var userPassword2 = $('#userPassword2').val();
		if (userPassword1 != userPassword2) {
			$('#passwordCheckMessage').html('비밀번호가 서로 일치하지 않습니다.');
		}else{
			$('#passwordCheckMessage').html('');
		}
}

function registerAddress(){
		new daum.Postcode({
	        oncomplete: function(data) {
	        	$(".m_addr3").val(data.zonecode);
	        	$(".m_addr1").val(data.address);
	        }	
	    }).open();
}

function joinCheck() {
	var m_id = document.joinForm.m_id;
	var m_pw = document.joinForm.m_pw;
	var m_pwChk = document.joinForm.m_pwChk;
	var m_name = document.joinForm.m_name;
	var m_addr1 = document.joinForm.m_addr1;
	var m_addr2 = document.joinForm.m_addr2;
	var m_addr3 = document.joinForm.m_addr3;

	if (isEmpty(m_id) || containsHS(m_id)) {
		m_id.value = "";
		m_id.focus();
		return false;
	} else if (isEmpty(m_pw) || notEquals(m_pw, m_pwChk)
			|| notContains(m_pw, "1234567890")
			|| notContains(m_pw, "qwertyuiopasdfghjklzxcvbnm")) {
		m_pw.value = "";
		m_pwChk.value = "";
		m_pw.focus();
		$('#checkTitle').html('실패 메시지');
		$('#checkMessage').html('비밀번호는 영문과 숫자를 포함해야합니다. ');
		$('#checkType').css('background-color','#faebcc');
		$('#checkModal').modal("show");
		return false;
	} else if (isEmpty(m_name)) {
		m_name.value = "";
		m_name.focus();
		return false;
	} else if (isEmpty(m_addr1) || isEmpty(m_addr2) || isEmpty(m_addr3)) {
		m_addr1.value = "";
		m_addr2.value = "";
		m_addr3.value = "";
		m_addr1.focus();
		$('#checkTitle').html('실패 메시지');
		$('#checkMessage').html('주소를 입력해주세요');
		$('#checkType').css('background-color','#faebcc');
		$('#checkModal').modal("show");
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
		m_id.value = "";
		m_id.focus();
		return false;
	} else if (isEmpty(m_pw) || notEquals(m_pw, m_pwChk)
			|| notContains(m_pw, "1234567890")
			|| notContains(m_pw, "qwertyuiopasdfghjklzxcvbnm")) {
		m_pw.value = "";
		m_pwChk.value = "";
		m_pw.focus();
		$('#checkTitle').html('실패 메시지');
		$('#checkMessage').html('비밀번호는 영문과 숫자를 포함해야합니다. ');
		$('#checkType').css('background-color','#faebcc');
		$('#checkModal').modal("show");
		return false;
	} else if (isEmpty(m_name)) {
		m_name.value = "";
		m_name.focus();
		return false;
	} else if (isEmpty(m_addr1) || isEmpty(m_addr2) || isEmpty(m_addr3)) {
		m_addr1.value = "";
		m_addr2.value = "";
		m_addr3.value = "";
		m_addr1.focus();
		$('#checkTitle').html('실패 메시지');
		$('#checkMessage').html('주소를 입력해주세요');
		$('#checkType').css('background-color','#faebcc');
		$('#checkModal').modal("show");
		return false;
	}
	return true;
}




