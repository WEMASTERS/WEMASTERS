package cn.wemasters.websystem.ajax.action;

import cn.wemasters.usersystem.application.service.interfaces.AccountManagementService;

import com.opensymphony.xwork2.ActionSupport;

public class CheckAccountIsOccupiedAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 179531657104196415L;
	private String emailAddress;
	private String mobilePhoneNumber;
	private Boolean result;
	private AccountManagementService accountManagementService;
	
	public String checkEmailIsOccupied() {
		result = accountManagementService
				.verifyEmailAddressIsOccupied(emailAddress);
		return SUCCESS;
	}
	
	public String checkMobilePhoneIsOccupied() {
		result = accountManagementService
				.verifyMobilePhoneNumberIsOccupied(mobilePhoneNumber);
		return SUCCESS;
	}

	public void setAccountManagementService(
			AccountManagementService accountManagementService) {
		this.accountManagementService = accountManagementService;
	}

	public Boolean getResult() {
		return result;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
	
}
