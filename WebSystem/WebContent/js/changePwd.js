function checkChangePwdForm() {
	return checkOriginalPassword() && checkNewPassword()
			&& checkNewPasswordConfirm();
}

function checkOriginalPassword() {
	if (document.getElementById("originalPassword").value.length < 6
			|| document.getElementById("originalPassword").value.length > 20) {
		document.getElementById("originalPassword_error").innerHTML = "原密码错误";
		return false;
	} else {
		document.getElementById("originalPassword_error").innerHTML = "";
		return true;
	}
}

function checkNewPassword() {
	if (document.getElementById("newPassword").value.length < 6) {
		document.getElementById("newPassword_error").innerHTML = "新密码过短";
		return false;
	} else if (document.getElementById("newPassword").value.length > 20) {
		document.getElementById("newPassword_error").innerHTML = "新密码过长";
		return false;
	} else {
		document.getElementById("newPassword_error").innerHTML = "";
		return true;
	}
}

function checkNewPasswordConfirm() {
	if (document.getElementById("newPasswordConfirm").value != document
			.getElementById("newPassword").value) {
		document.getElementById("newPasswordConfirm_error").innerHTML = "新密码不一致";
		return false;
	} else {
		document.getElementById("newPasswordConfirm_error").innerHTML = "";
		return true;
	}
}