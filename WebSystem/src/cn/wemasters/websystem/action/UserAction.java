package cn.wemasters.websystem.action;

import cn.wemasters.usersystem.domain.entity.User;
import cn.wemasters.usersystem.domain.repository.interfaces.UserRepository;

public class UserAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7266866030749030446L;
	
	private UserRepository userRepository;
	
	public String getUserByAccount() {
		Long accountId = (Long) session.get("account");
		User user = userRepository.getUserByAccountId(accountId);
		session.put("user", user);
		return SUCCESS;
	}
	
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
