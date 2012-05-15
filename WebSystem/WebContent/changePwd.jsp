<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/error.css" />
<script src="js/changePwd.js" type="text/javascript"></script>
<title>修改密码</title>
</head>
<body>

	<s:form name="changePwdForm" id="changePwdForm" action="changePwd"
		method="post" theme="simple" onsubmit="return checkChangePwdForm()">
		<table>
			<tr>
				<td>原密码</td>
				<td><input type="password" name="changePwdForm.originalPassword" id="originalPassword" /></td>
				<td><s:fielderror name="originalPassword" /></td>
			</tr>
			<tr>
				<td>新密码</td>
				<td><input type="password" name="changePwdForm.newPassword"
					id="newPassword" /></td>
				<td><s:fielderror name="newPassword" /></td>
			</tr>
			<tr>
				<td>新密码确认</td>
				<td><input type="password" name="changePwdForm.newPasswordConfirm"
					id="newPasswordConfirm" /></td>
				<td><s:fielderror name="newPasswordConfirm" /></td>
			</tr>
		</table>
		
        <input type="submit" value="提交" />
		<input type="button" onclick="window.location.href='main.jsp'" value="返回" />
	</s:form>

</body>
</html>