package cn.wemasters.websystem.action;

import cn.wemasters.usersystem.application.service.interfaces.AccountManagementService;
import cn.wemasters.usersystem.application.service.interfaces.UserManagementService;
import cn.wemasters.usersystem.constant.ReturnCode;
import cn.wemasters.usersystem.utils.StringUtils;
import cn.wemasters.usersystem.view.ResultMsg;
import cn.wemasters.usersystem.view.SignUpFormByAccount;

public class SignUpAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2096320720296318968L;

	private SignUpFormByAccount signUpFormByAccount;
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
			addFieldError(
					"email",
					"<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>邮箱格式有误</font>");
		} else if (!StringUtils.isEmailAddress(signUpFormByAccount
				.getEmailAddress())) {
			addFieldError(
					"email",
					"<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>邮箱格式有误</font>");
		} else if (accountManagementService
				.verifyEmailAddressIsOccupied(signUpFormByAccount
						.getEmailAddress())) {
			addFieldError(
					"email",
					"<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>账号已存在</font>");
		}
	}

	private void verifyMobilePhoneNumber() {
		if (signUpFormByAccount.getMobilePhoneNumber() == null) {
			addFieldError(
					"mobile",
					"<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>手机号码有误</font>");
		} else if (!StringUtils.isMobilePhoneNumber(signUpFormByAccount
				.getMobilePhoneNumber())) {
			addFieldError(
					"mobile",
					"<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>手机号码有误</font>");
		} else if (accountManagementService
				.verifyMobilePhoneNumberIsOccupied(signUpFormByAccount
						.getMobilePhoneNumber())) {
			addFieldError(
					"mobile",
					"<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>账号已存在</font>");
		}
	}

	private void verifyPassword() {
		if (signUpFormByAccount.getPassword() == null
				|| signUpFormByAccount.getPassword().length() < 6) {
			addFieldError(
					"password",
					"<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>密码位数过短</font>");
		} else if (signUpFormByAccount.getPassword().length() > 20) {
			addFieldError(
					"password",
					"<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>密码位数过长</font>");
		}
	}

	private void verifyPasswordConfirm() {
		if (signUpFormByAccount.getPasswordConfirm() == null
				|| !signUpFormByAccount.getPasswordConfirm().equals(
						signUpFormByAccount.getPassword())) {
			addFieldError(
					"passwordConfirm",
					"<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>密码不一致</font>");
		}
	}

	private void verifyName() {
		if (signUpFormByAccount.getName() == null
				|| signUpFormByAccount.getPassword().length() < 2
				|| signUpFormByAccount.getPassword().length() > 20) {
			addFieldError(
					"name",
					"<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>名字需由2—20位中文、字母或数字组成！</font>");
		}
	}

	private void verifyGender() {
		if (signUpFormByAccount.getGender() == null) {
			addFieldError(
					"gender",
					"<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>请选择性别</font>");
		}
	}

	private void verifyYearMonthDay() {
		if (signUpFormByAccount.getYear() == null
				|| signUpFormByAccount.getMonth() == null
				|| signUpFormByAccount.getDay() == null) {
			addFieldError(
					"signUpFormByAccount.year",
					"<font color='#FF0000'><img src='images/NO.png' style='height:18px; width:18px'>请选择生日</font>");
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

	public void setUserManagementService(
			UserManagementService userManagementService) {
		this.userManagementService = userManagementService;
	}

}
