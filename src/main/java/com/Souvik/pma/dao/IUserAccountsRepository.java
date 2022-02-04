package com.Souvik.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Souvik.pma.entities.UserAccount;

@Repository
public interface IUserAccountsRepository extends CrudRepository<UserAccount, Long> {
	
	@Override
	public List<UserAccount> findAll();
}
