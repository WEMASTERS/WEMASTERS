package cn.wemasters.usersystem.application.service.interfaces;

import cn.wemasters.usersystem.view.ChangePwdForm;
import cn.wemasters.usersystem.view.LoginForm;
import cn.wemasters.usersystem.view.ResultMsg;

public interface AccountManagementService {
	
	public boolean verifyEmailAddressIsOccupied(String emailAddress);
	
	public boolean verifyMobilePhoneNumberIsOccupied(String mobilePhoneNumber);
	
	public ResultMsg loginByAccount(LoginForm loginForm);

	public ResultMsg updatePassword(Long accountId, ChangePwdForm changePwdForm);

}
