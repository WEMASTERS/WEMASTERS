<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="js/signUp.js" type="text/javascript"></script>
<title>注册界面</title>
</head>
<body onload="initializeForm()">

	<s:form name="signUpForm" id="signUpForm"
		action="signUpByAccountWithEmailAddress" theme="simple" method="post"
		onsubmit="return checkEmailAllInfo()" >
		<table>
			<tr style="width: 400px;">
				<td><label>电子邮箱：</label></td>
				<td><input type="text" name="signUpFormByAccount.emailAddress"
					id="email" onkeyup="checkMail()" onchange="checkMailIsOccupied()"
					value="<s:property value='signUpFormByAccount.emailAddress'/>"/> <label
					id="mail_error"></label><br/><a href="signUpByAccountWithMobilePhone.jsp">使用手机注册</a></td>
			</tr>
			
			<tr>
				<td><label>密码：</label></td>
				<td><input type="password" name="signUpFormByAccount.password"
					id="password" onkeyup="checkPassword()" onchange="checkPassword()"
					maxlength="20" /> <label id="password_error"></label></td>
			</tr>

			<tr>
				<td><label>密码确认：</label></td>
				<td><input type="password"
					name="signUpFormByAccount.passwordConfirm" id="password2"
					onkeyup="checkPasswordConfirm()" onchange="checkPasswordConfirm()"
					maxlength="20" /> <label id="passwordConfirm_error"></label></td>
			</tr>

			<tr>
				<td><label>姓名：</label></td>
				<td><input type="text" name="signUpFormByAccount.name"
					id="name" maxlength="20" onkeyup="checkName()" onchange="checkName()"  value="<s:property value='signUpFormByAccount.name'/>"
					 /> <label id="name_error"></label></td>
			</tr>

			<tr>
				<td><label for="male">性别：</label></td>
				<td><input type="radio" name="signUpFormByAccount.gender"
					id="male" value="true" onchange="checkGender()"/>男<label for="female" ><input
						type="radio" name="signUpFormByAccount.gender" id="female"
						value="false" onchange="checkGender()"/>女</label><label id="gender_error"></label> <br /></td>
			</tr>

			<tr>
				<td><label>生日:</label></td>
				<td><select id="birth_year" name="signUpFormByAccount.year"
					onchange="setDateRange()">

				</select> 年 <select id="birth_month" name="signUpFormByAccount.month"
					onchange="setDateRange()" >

				</select> 月 <select id="birth_day" name="signUpFormByAccount.day" onchange="checkbirth()">
				</select>日<label id="year_error"></label></td>
			</tr>

			<tr>
				<td><input type="submit" value="提交" /></td>
				<td><input type="button" onclick="mailFormReset()" value="重置" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>