// 잘못되면 true, 정상이면 false

// <input>을 넣어주면 거기에 글자가 없는지 체크해줄 함수
// 없으면 true, 있으면 false리턴
function isEmpty(field) {
	return (!field.value);
}

// <input>, 최소 글자수를 넣어주면 체크해줄 함수
// 최소글자수보다 짧으면 true, 길면 false리턴
function lessThan(field, min) {
	return (field.value.length < min);
}

// <input>넣어주면 거기에 한글/특수문자 있는지 체크해줄 함수
// 한글/특수문자가 들어있으면 true, 없으면 false리턴
function containsHS(field) {
	var str = "@_.123456890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
	for (var i = 0; i < field.value.length; i++) {
		if (str.indexOf(field.value[i]) == -1) {
			return true;
		}
	}
	return false;
}

// <input>2개 넣어서, 그 2개 값 다른지 체크할 함수
// 다르면 true, 같으면 false
function notEquals(field1, field2){
	return (field1.value != field2.value);
}

// <input>, 허용할 문자열세트를 넣었을때
// 그게 들어있지 않으면 true, 들어있으면 false
function notContains(field, set){
	for (var i = 0; i < set.length; i++) {
		if (field.value.indexOf(set[i]) != -1){
			return false;
		}
	}
	return true;
}

// <input>을 넣어주면 숫자만 있는지
// 불순물이 있으면 true, 아니면 false
function isNotNumber(field){
	return isNaN(field.value);
}

// <input>, 파일확장자(png)를 넣어주면
// value가 확장자로 안끝나면 true, 끝나면 false
function isNotType(field, type){
	return (field.value.toLowerCase().indexOf("." + type) == -1);
	//return (!field.value.toLowerCase().endsWith("." + type));
}










