package com.Souvik.pma.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.Souvik.pma.entities.UserAccount;

@Repository
public interface IUserAccountsRepository extends PagingAndSortingRepository<UserAccount, Long> {
	
	@Override
	public List<UserAccount> findAll();

	public UserAccount getUserByEmail(String email);

	public UserAccount getUserByuserName(String userName);
}
