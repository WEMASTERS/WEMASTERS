<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/error.css" />
<script src="js/login.js" type="text/javascript"></script>
<title>主界面</title>
</head>
<body>

	<s:form name="loginForm" id="loginForm" action="loginByAccount"
		method="post" theme="simple" onsubmit="return checkLoginForm()">
		<table>
			<tr>
				<td>账号</td>
				<td><input type="text" name="loginForm.username" id="username" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="loginForm.password"
					id="password" /></td>
			</tr>
		</table>
		<s:fielderror name="loginForm" />
        <input type="submit" value="提交" />
		<input type="button" onclick="window.location.href='signUpByAccountWithEmail.jsp'" value="注册" />
	</s:form>

</body>
</html>