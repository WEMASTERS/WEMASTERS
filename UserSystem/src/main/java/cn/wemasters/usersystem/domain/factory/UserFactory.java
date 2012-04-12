package cn.wemasters.usersystem.domain.factory;

import cn.wemasters.usersystem.domain.entity.Account;
import cn.wemasters.usersystem.domain.entity.User;
import cn.wemasters.usersystem.view.SignUpFormByAccount;

public class UserFactory {
	
	public static User purchaseUserBySignUpFormWithAccount(SignUpFormByAccount signUpFormWithAccount) {
		User user = new User();
		user.setName(signUpFormWithAccount.getName());
		user.setGender(signUpFormWithAccount.getGender());
		user.setIsDeleted(false);
		user.setBirthdate(signUpFormWithAccount.getYear() + "-"
				+ signUpFormWithAccount.getMonth() + "-" + signUpFormWithAccount.getDay());
		Account account = new Account();
		account.setEmailAddress(signUpFormWithAccount.getEmailAddress());
		account.setMobilePhoneNumber(signUpFormWithAccount.getMobilePhoneNumber());
		account.setPassword(signUpFormWithAccount.getPassword());
		user.setAccount(account);
		return user;
	}

}
