package cn.wemasters.websystem.action;

import cn.wemasters.usersystem.application.service.interfaces.AccountManagementService;
import cn.wemasters.usersystem.constant.ReturnCode;
import cn.wemasters.usersystem.view.ChangePwdForm;
import cn.wemasters.usersystem.view.ResultMsg;

public class ChangePwdAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6170912577302066355L;

	private ChangePwdForm changePwdForm;
	private AccountManagementService accountManagementService;

	public String changePwd() {
		ResultMsg resultMsg = accountManagementService.updatePassword(
				(Long) session.get("account"), changePwdForm);
		if (resultMsg.getCode().equals(String.valueOf(ReturnCode.SUCCESS))) {
			return SUCCESS;
		} else {
			addFieldError("orginalPassword", "原密码错误");
			return INPUT;
		}
	}

	public void validateChangePwd() {
		clearFieldErrors();
		checkOriginalPassword();
		checkNewPassword();
		checkNewPasswordConfirm();
	}

	private void checkOriginalPassword() {
		if (changePwdForm.getOriginalPassword() == null
				|| changePwdForm.getOriginalPassword().length() < 6
				|| changePwdForm.getOriginalPassword().length() < 20) {
			addFieldError("orginalPassword", "原密码错误");
		}
	}

	private void checkNewPassword() {
		if (changePwdForm.getNewPassword() == null
				|| changePwdForm.getNewPassword().length() < 6) {
			addFieldError("newPassword", "新密码位数过短");
		} else if (changePwdForm.getNewPassword() == null
				|| changePwdForm.getNewPassword().length() < 20) {
			addFieldError("newPassword", "新密码位数过长");
		}
	}

	private void checkNewPasswordConfirm() {
		if (changePwdForm.getNewPasswordConfirm() == null
				|| !changePwdForm.getNewPasswordConfirm().equals(changePwdForm.getNewPassword())) {
			addFieldError("newPasswordConfirm", "密码不一致");
		}
	}

	public void setChangePwdForm(ChangePwdForm changePwdForm) {
		this.changePwdForm = changePwdForm;
	}

	public void setAccountManagementService(
			AccountManagementService accountManagementService) {
		this.accountManagementService = accountManagementService;
	}

}
