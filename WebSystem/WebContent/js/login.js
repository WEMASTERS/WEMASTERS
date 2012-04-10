function checkLoginForm() {
	return checkUserName()&&checkPassword();
}

function checkUserName() {
	if (document.getElementById("username").value.length > 0) {
		document.getElementById("loginForm_error").innerHTML = "";
		return true;
	} else {
		document.getElementById("loginForm_error").innerHTML = "请输入用户名和密码";
		return false;
	}
}

function checkPassword() {
	if (document.getElementById("password").value.length > 0) {
		document.getElementById("loginForm_error").innerHTML = "";
		return true;
	} else {
		document.getElementById("loginForm_error").innerHTML = "请输入密码";
		return false;
	}
}