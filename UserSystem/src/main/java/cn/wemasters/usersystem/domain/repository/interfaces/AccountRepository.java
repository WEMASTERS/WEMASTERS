package cn.wemasters.usersystem.domain.repository.interfaces;

import cn.wemasters.usersystem.domain.entity.Account;

public interface AccountRepository extends BaseRepository<Account>{
	
	public Account getAccountIdEncryptedPasswordByEmailAddress(String emailAddress);
	
	public Account getAccountIdEncryptedPasswordByMobilePhoneNumber(String mobilePhoneNumber);
	
	public int countAccountByEmailAddress(String emailAddress);
	
	public int countAccountByMobilePhoneNumber(String mobilePhoneNumber);
	
	public void updateEncryptedPassword(Long id, String encryptedPassword);

}
