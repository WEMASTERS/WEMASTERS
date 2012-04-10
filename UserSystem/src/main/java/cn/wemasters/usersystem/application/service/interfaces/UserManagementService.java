package cn.wemasters.usersystem.application.service.interfaces;

import cn.wemasters.usersystem.domain.entity.User;
import cn.wemasters.usersystem.view.ResultMsg;
import cn.wemasters.usersystem.view.SignUpFormByAccount;

public interface UserManagementService {
	
	public ResultMsg signUpUserByAccount(SignUpFormByAccount signUpFormByAccount);

	public User getUserByAccountId(Long accountId);

}
