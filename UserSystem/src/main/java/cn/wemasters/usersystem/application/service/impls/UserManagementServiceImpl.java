package cn.wemasters.usersystem.application.service.impls;

import cn.wemasters.usersystem.application.service.interfaces.UserManagementService;
import cn.wemasters.usersystem.constant.ReturnCode;
import cn.wemasters.usersystem.domain.entity.User;
import cn.wemasters.usersystem.domain.factory.UserFactory;
import cn.wemasters.usersystem.domain.repository.interfaces.AccountRepository;
import cn.wemasters.usersystem.domain.repository.interfaces.UserRepository;
import cn.wemasters.usersystem.utils.ResultMsgUtils;
import cn.wemasters.usersystem.view.ResultMsg;
import cn.wemasters.usersystem.view.SignUpFormByAccount;

public class UserManagementServiceImpl implements UserManagementService{
	
	private UserRepository userRepository;
	private AccountRepository accountRepository;
	
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Override
	public ResultMsg signUpUserByAccount(
			SignUpFormByAccount signUpFormByAccount) {
		try {
			User user = UserFactory
					.purchaseUserBySignUpFormWithAccount(signUpFormByAccount);
			accountRepository.save(user.getAccount());
			userRepository.save(user);
			return ResultMsgUtils.createSuccess(user.getAccount().getId());
		} catch (Exception e) {
			return ResultMsgUtils
					.createResultMsg(ReturnCode.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public User getUserByAccountId(Long accountId) {
		try {
			return userRepository.getUserByAccountId(accountId);
		} catch (Exception e) {
			return null;
		}
	}

}
