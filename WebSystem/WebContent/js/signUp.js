var xmlhttp;
if (window.XMLHttpRequest) {
	xmlhttp = new XMLHttpRequest();
} else {
	xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
}

function checkMail() {
	var pattern = /\w+@\w+\.[a-z]+/;
	if (pattern.test(document.getElementById("email").value) == false) {
		changeMailError(1);
		return false;
	} else {
		changeMailError(0);
		return true;
	}
}

function checkMailIsOccupied() {
	if (checkMail()) {
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var result = eval('(' + xmlhttp.responseText + ')');
				if (result.result == true) {
					changeMailError(2);
				}
			}
		};
		xmlhttp.open("GET",
				"wemasters_websystem_json/checkEmailIsOccupied.action?emailAddress="
						+ document.getElementById("email").value, true);
		xmlhttp.send();
	}
}

function changeMailError(i) {
	if (i == 0) {
		document.getElementById("mail_error").innerHTML = "<font color='#009900'><img src='images/OK.png' style='height:18px; width:18px'>邮箱地址可用</font>";
	} else if (i == 1) {
		document.getElementById("mail_error").innerHTML = "<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>邮箱格式有误</font>";
	} else {
		document.getElementById("mail_error").innerHTML = "<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>账号已存在</font>";
	}
}

function checkMobilePhone() {
	var pattern =  /^1[3,5]\d{9}$/;
	if (pattern.test(document.getElementById("mobilePhone").value) == false) {
		changeMobileError(1);
		return false;
	} else {
		changeMobileError(0);
		return true;
	}
}

function checkMobilePhoneIsOccupied() {
	if (checkMobilePhone()) {
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var result = eval('(' + xmlhttp.responseText + ')');
				if (result.result == true) {
					changeMobileError(2);
				}
			}
		};
		xmlhttp.open("GET",
				"wemasters_websystem_json/checkMobilePhoneIsOccupied.action?mobilePhoneNumber="
						+ document.getElementById("mobilePhone").value, true);
		xmlhttp.send();
	}
}

function changeMobileError(i) {
	if (i == 0) {
		document.getElementById("mobile_error").innerHTML = "<font color='#009900'><img src='images/OK.png' style='height:18px; width:18px'>手机号码可用</font>";
	} else if (i == 1) {
		document.getElementById("mobile_error").innerHTML = "<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>手机号码有误</font>";
	} else {
		document.getElementById("mobile_error").innerHTML = "<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>账号已存在</font>";
	}
}

function checkPassword() {
	if (document.getElementById("password").value.length < 6) {
		changePasswordError(1);
		return false;
	} else if (document.getElementById("password").value.length > 20) {
		changePasswordError(2);
		return false;
	} else {
		changePasswordError(0);
		if (signUpForm.password2.value != "") {
			checkPasswordConfirm();
		}
		return true;
	}
}

function changePasswordError(i) {
	if (i == 0) {
		document.getElementById("password_error").innerHTML = "<font color='#009900'><img src='images/OK.png' style='height:18px; width:18px'>密码可用</font>";
	} else if (i == 1) {
		document.getElementById("password_error").innerHTML = "<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>密码位数过短</font>";
	} else {
		document.getElementById("password_error").innerHTML = "<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>密码位数过长</font>";
	}
}

function checkPasswordConfirm() {
	var password1 = document.getElementById("password").value;
	var password2 = document.getElementById("password2").value;
	if (password1 != password2) {
		changePasswordConfirmError(1);
		return false;
	} else {
		changePasswordConfirmError(0);
		return true;
	}
}

function changePasswordConfirmError(i) {
	if (i == 0) {
		document.getElementById("passwordConfirm_error").innerHTML = "<font color='#009900'><img src='images/OK.png' style='height:18px; width:18px'>密码一致</font>";
	} else {
		document.getElementById("passwordConfirm_error").innerHTML = "<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>密码不一致</font>";
	}
}

function checkName() {
	if (document.getElementById("name").value.length < 2
			|| document.getElementById("name").value.length > 20) {
		changeNameError(1);
		return false;
	} else {
		changeNameError(0);
		return true;
	}
}

function changeNameError(i) {
	if (i == 0) {
		document.getElementById("name_error").innerHTML = "<font color='#009900'><img src='images/OK.png' style='height:18px; width:18px'>名字可用</font>";
	} else {
		document.getElementById("name_error").innerHTML = "<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>名字需由2—20位中文、字母或数字组成！</font>";
	}
}

function checkGender() {
	if (!(document.getElementById("male").checked || document
			.getElementById("female").checked)) {
		changeGenderError(1);
		return false;
	} else {
		changeGenderError(0);
		return true;
	}
}

function changeGenderError(i) {
	if (i == 0) {
		document.getElementById("gender_error").innerHTML = "<font color='#009900'><img src='images/OK.png' style='height:18px; width:18px'></font>";
	} else {
		document.getElementById("gender_error").innerHTML = "<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>请选择性别</font>";
	}
}

function checkbirth() {
	if (document.getElementById("birth_year").value == ""
			|| document.getElementById("birth_month").value == ""
			|| document.getElementById("birth_day").value == "") {
		changeYearError(1);
		return false;
	} else {
		changeYearError(0);
		return true;
	}
}

function changeYearError(i) {
	if (i == 0) {
		document.getElementById("year_error").innerHTML = "<font color='#009900'><img src='images/OK.png' style='height:18px; width:18px'></font>";
	} else {
		document.getElementById("year_error").innerHTML = "<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>请选择生日</font>";
	}
}

function setDateRange() {
	var birthDayMax = calculateMaxDay();
	var birthDay = document.getElementById("birth_day");
	while (birthDayMax < birthDay.options[1].value) {
		birthDay.options.remove(1);
	}
	while (birthDayMax > birthDay.options[1].value) {
		birthDay.options.add(new Option(
				parseInt(birthDay.options[1].value) + 1,
				parseInt(birthDay.options[1].value) + 1), 1);
	}
	checkbirth();
}

function calculateMaxDay() {
	var birthYear = document.getElementById("birth_year").value;
	var birthMonth = document.getElementById("birth_month").value;
	var birthDayMax;
	if (birthMonth == 4 || birthMonth == 6 || birthMonth == 9
			|| birthMonth == 11) {
		birthDayMax = 30;
	} else if (birthMonth == 2) {
		if (isNaN(birthYear) || birthYear % 4 == 0 && birthYear % 100 != 0
				|| birthYear % 400 == 0) {
			birthDayMax = 29;
		} else {
			birthDayMax = 28;
		}
	} else {
		birthDayMax = 31;
	}
	return birthDayMax;
}

function checkEmailAllInfo() {
	if (checkMail() && checkPassword()
			&& checkPasswordConfirm() && checkName() && checkGender()
			&& checkbirth()) {
		return true;
	}
	return false;
}

function checkMobileAllInfo() {
	if (checkMobilePhone() && checkPassword()
			&& checkPasswordConfirm() && checkName() && checkGender()
			&& checkbirth()) {
		return true;
	}
	return false;
}

function mailFormReset() {
	document.getElementById("signUpForm").reset();
	document.getElementById("mail_error").innerHTML = "";
	document.getElementById("password_error").innerHTML = "";
	document.getElementById("passwordConfirm_error").innerHTML = "";
	document.getElementById("name_error").innerHTML = "";
	document.getElementById("gender_error").innerHTML = "";
	document.getElementById("year_error").innerHTML = "";
}

function mobileFormReset() {
	document.getElementById("signUpForm").reset();
	document.getElementById("mobile_error").innerHTML = "";
	document.getElementById("password_error").innerHTML = "";
	document.getElementById("passwordConfirm_error").innerHTML = "";
	document.getElementById("name_error").innerHTML = "";
	document.getElementById("gender_error").innerHTML = "";
	document.getElementById("year_error").innerHTML = "";
}

function initializeForm() {
	turnOffAutoComplete();
	initializeYearMonthDay();
}

function turnOffAutoComplete() {
	var form = document.getElementById("signUpForm");
	form.setAttribute("autocomplete", "off");
}

function initializeYearMonthDay() {
	initializeYear();
	initializeMonth();
	initializeDay();
}

function initializeYear() {
	var date = new Date();
	var yearNow = date.getFullYear();
	var birthYear = document.getElementById("birth_year");
	birthYear.add(new Option("请选择", ""));
	for ( var year = yearNow; year + 100 >= yearNow; year--) {
		birthYear.add(new Option(year, year));
		if (year % 10 == 0) {
			var y = year % 100;
			if (y > 60) {
				birthYear.add(new Option(y + "后", y + "后"));
			}
		}
	}
}

function initializeMonth() {
	var birthMonth = document.getElementById("birth_month");
	birthMonth.add(new Option("--", ""));
	for ( var i = 12; i > 0; i--) {
		birthMonth.add(new Option(i, i));
	}
}

function initializeDay() {
	var birthDay = document.getElementById("birth_day");
	birthDay.add(new Option("--", ""));
	for ( var i = 31; i > 0; i--) {
		birthDay.add(new Option(i, i));
	}
}