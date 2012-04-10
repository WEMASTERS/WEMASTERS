package cn.wemasters.usersystem.domain.repository.interfaces;

import cn.wemasters.usersystem.domain.entity.Account;

public interface AccountRepository extends BaseRepository<Account>{
	
	public Account getAccountIdPasswordByEmailAddress(String emailAddress);
	
	public Account getAccountIdPasswordByMobilePhoneNumber(String mobilePhoneNumber);
	
	public int countAccountByEmailAddress(String emailAddress);
	
	public int countAccountByMobilePhoneNumber(String mobilePhoneNumber);

}
