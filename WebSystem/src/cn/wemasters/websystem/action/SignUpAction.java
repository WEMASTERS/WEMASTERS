package cn.wemasters.websystem.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import cn.wemasters.usersystem.application.service.interfaces.AccountManagementService;
import cn.wemasters.usersystem.application.service.interfaces.UserManagementService;
import cn.wemasters.usersystem.constant.ReturnCode;
import cn.wemasters.usersystem.utils.StringUtils;
import cn.wemasters.usersystem.view.ResultMsg;
import cn.wemasters.usersystem.view.SignUpFormByAccount;

import com.opensymphony.xwork2.ActionSupport;

public class SignUpAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2096320720296318968L;

	private SignUpFormByAccount signUpFormByAccount;
	private Map<String, Object> session;
	private AccountManagementService accountManagementService;
	private UserManagementService userManagementService;

	public String signUpByAccountWithEmailAddress() {
		signUpFormByAccount.setMobilePhoneNumber(null);
		return signUpByAccount();
	}

	public String signUpByAccountWithMobilePhoneNumber() {
		signUpFormByAccount.setEmailAddress(null);
		return signUpByAccount();
	}

	private String signUpByAccount() {
		ResultMsg result = userManagementService
				.signUpUserByAccount(signUpFormByAccount);
		if (result.getCode().equals(String.valueOf(ReturnCode.SUCCESS))) {
			session.put("account", result.getObject());
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	public void validateSignUpByAccountWithEmailAddress() {
		verfiyEmailAddress();
		verifyPassword();
		verifyPasswordConfirm();
		verifyName();
		verifyGender();
		verifyYearMonthDay();
	}

	public void validateSignUpByAccountWithMobilePhoneNumber() {
		verifyMobilePhoneNumber();
		verifyPassword();
		verifyPasswordConfirm();
		verifyName();
		verifyGender();
		verifyYearMonthDay();
	}

	private void verfiyEmailAddress() {
		if (signUpFormByAccount.getEmailAddress() == null) {
			addFieldError("signUpFormByAccount.emailAddress", "1");
		} else if (!StringUtils.isEmailAddress(signUpFormByAccount
				.getEmailAddress())) {
			addFieldError("signUpFormByAccount.emailAddress", "1");
		} else if (accountManagementService
				.verifyEmailAddressIsOccupied(signUpFormByAccount
						.getEmailAddress())) {
			addFieldError("signUpFormByAccount.emailAddress", "2");
		}
	}

	private void verifyMobilePhoneNumber() {
		if (signUpFormByAccount.getMobilePhoneNumber() == null) {
			addFieldError("signUpFormByAccount.mobilePhoneNumber", "1");
		} else if (!StringUtils.isMobilePhoneNumber(signUpFormByAccount
				.getMobilePhoneNumber())) {
			addFieldError("signUpFormByAccount.mobilePhoneNumber", "1");
		} else if (accountManagementService
				.verifyMobilePhoneNumberIsOccupied(signUpFormByAccount
						.getMobilePhoneNumber())) {
			addFieldError("signUpFormByAccount.mobilePhoneNumber", "2");
		}
	}

	private void verifyPassword() {
		if (signUpFormByAccount.getPassword() == null) {
			addFieldError("signUpFormByAccount.password", "1");
		} else if (signUpFormByAccount.getPassword().length() < 6
				|| signUpFormByAccount.getPassword().length() > 20) {
			addFieldError("signUpFormByAccount.password", "1");
		}
	}

	private void verifyPasswordConfirm() {
		if (signUpFormByAccount.getPasswordConfirm() == null) {
			addFieldError("signUpFormByAccount.passwordConfirm", "1");
		} else if (!signUpFormByAccount.getPasswordConfirm().equals(
				signUpFormByAccount.getPassword())) {
			addFieldError("signUpFormByAccount.passwordConfirm", "1");
		}
	}

	private void verifyName() {
		if (signUpFormByAccount.getName() == null) {
			addFieldError("signUpFormByAccount.name", "1");
		} else if (signUpFormByAccount.getPassword().length() < 2
				|| signUpFormByAccount.getPassword().length() > 20) {
			addFieldError("signUpFormByAccount.name", "1");
		}
	}

	private void verifyGender() {
		if (signUpFormByAccount.getGender() == null) {
			addFieldError("signUpFormByAccount.gender", "1");
		}
	}

	private void verifyYearMonthDay() {
		if (signUpFormByAccount.getYear() == null
				|| signUpFormByAccount.getMonth() == null
				|| signUpFormByAccount.getDay() == null) {
			addFieldError("signUpFormByAccount.year", "1");
		}
	}

	public SignUpFormByAccount getSignUpFormByAccount() {
		return signUpFormByAccount;
	}

	public void setSignUpFormByAccount(SignUpFormByAccount signUpFormByAccount) {
		this.signUpFormByAccount = signUpFormByAccount;
	}

	public void setAccountManagementService(
			AccountManagementService accountManagementService) {
		this.accountManagementService = accountManagementService;
	}

	public void setUserManagementService(UserManagementService userManagementService) {
		this.userManagementService = userManagementService;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
