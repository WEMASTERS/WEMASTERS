package cn.wemasters.websystem.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import cn.wemasters.usersystem.application.service.interfaces.AccountManagementService;
import cn.wemasters.usersystem.constant.ReturnCode;
import cn.wemasters.usersystem.utils.StringUtils;
import cn.wemasters.usersystem.view.LoginForm;
import cn.wemasters.usersystem.view.ResultMsg;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5438634539801724610L;

	private LoginForm loginForm;
	private Map<String, Object> session;
	private AccountManagementService accountManagementService;

	public String loginByAccount() {
		ResultMsg result = accountManagementService.loginByAccount(loginForm);
		if (result.getCode().equals(String.valueOf(ReturnCode.SUCCESS))) {
			session.put("account", result.getObject());
			return SUCCESS;
		} else if (result.getCode().equals(String.valueOf(ReturnCode.FORBIDDEN))) {
			addFieldError("loginForm", "您的用户名和密码不匹配");
		} else {
			addFieldError("loginForm", "出错了");
		}
		return INPUT;
	}
	
	public String logOut() {
		session.clear();
		return SUCCESS;
	}

	public void validateLoginByAccount() {
		clearFieldErrors();
		if (StringUtils.isEmpty(loginForm.getUsername())
				|| StringUtils.isEmpty(loginForm.getPassword())) {
			addFieldError("loginForm", "请输入用户名和密码");
		}
	}

	public LoginForm getLoginForm() {
		return loginForm;
	}

	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}

	public void setAccountManagementService(
			AccountManagementService accountManagementService) {
		this.accountManagementService = accountManagementService;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
