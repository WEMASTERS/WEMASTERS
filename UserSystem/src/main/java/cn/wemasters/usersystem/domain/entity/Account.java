package cn.wemasters.usersystem.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.wemasters.usersystem.utils.EncryptionUtils;

@Entity
@Table(name = "WM_US_ACCOUNT")
public class Account {

	private Long id;
	private String emailAddress;
	private String mobilePhoneNumber;
	private String encryptedPassword;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public void setPassword(String password) {
		this.encryptedPassword = EncryptionUtils.SHA256(password);
	}

	public boolean checkPasswordIsEqual(String password) {
		if(encryptedPassword.equals(EncryptionUtils.SHA256(password))) {
			return true;
		} else {
			return false;
		}
	}
}
