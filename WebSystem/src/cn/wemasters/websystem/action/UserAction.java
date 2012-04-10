package cn.wemasters.websystem.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import cn.wemasters.usersystem.domain.entity.User;
import cn.wemasters.usersystem.domain.repository.interfaces.UserRepository;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7266866030749030446L;
	
	private UserRepository userRepository;
	private Map<String, Object> session;
	
	public String getUserByAccount() {
		Long accountId = (Long) session.get("account");
		User user = userRepository.getUserByAccountId(accountId);
		session.put("user", user);
		return SUCCESS;
	}
	
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}
