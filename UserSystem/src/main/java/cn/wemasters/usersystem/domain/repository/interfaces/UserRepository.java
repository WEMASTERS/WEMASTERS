package cn.wemasters.usersystem.domain.repository.interfaces;

import cn.wemasters.usersystem.domain.entity.User;

public interface UserRepository extends BaseRepository<User>{
	
	public User getUserByAccountId(Long accountId);
	
}
