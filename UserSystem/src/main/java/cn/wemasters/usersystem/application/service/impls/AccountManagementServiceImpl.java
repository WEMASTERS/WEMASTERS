package cn.wemasters.usersystem.application.service.impls;

import cn.wemasters.usersystem.application.service.interfaces.AccountManagementService;
import cn.wemasters.usersystem.constant.ReturnCode;
import cn.wemasters.usersystem.domain.entity.Account;
import cn.wemasters.usersystem.domain.repository.interfaces.AccountRepository;
import cn.wemasters.usersystem.utils.ResultMsgUtils;
import cn.wemasters.usersystem.utils.StringUtils;
import cn.wemasters.usersystem.view.LoginForm;
import cn.wemasters.usersystem.view.ResultMsg;

public class AccountManagementServiceImpl implements AccountManagementService {

	private AccountRepository accountRepository;

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public boolean verifyEmailAddressIsOccupied(String emailAddress) {
		try {
			if (accountRepository.countAccountByEmailAddress(emailAddress) > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean verifyMobilePhoneNumberIsOccupied(String mobilePhoneNumber) {
		try {
			if (accountRepository
					.countAccountByMobilePhoneNumber(mobilePhoneNumber) > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public ResultMsg loginByAccount(LoginForm loginForm) {
		try {
			Account account = null;
			if (StringUtils.isEmailAddress(loginForm.getUsername())) {
				account = accountRepository
						.getAccountIdEncryptedPasswordByEmailAddress(loginForm
								.getUsername());
			} else if (StringUtils.isMobilePhoneNumber(loginForm.getUsername())) {
				account = accountRepository
						.getAccountIdEncryptedPasswordByMobilePhoneNumber(loginForm
								.getUsername());
			}
			if (account != null) {
				if (account.checkPasswordIsEqual(loginForm.getPassword())) {
					return ResultMsgUtils.createSuccess(account.getId());
				}
			}
			return ResultMsgUtils
					.createResultMsg(ReturnCode.FORBIDDEN);
		} catch (Exception e) {
			return ResultMsgUtils.createResultMsg(ReturnCode.INTERNAL_SERVER_ERROR);
		}
	}

}
