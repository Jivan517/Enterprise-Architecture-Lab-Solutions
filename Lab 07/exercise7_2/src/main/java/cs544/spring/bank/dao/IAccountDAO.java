package cs544.spring.bank.dao;

import java.util.Collection;

import cs544.spring.bank.domain.Account;



public interface IAccountDAO {
	public void saveAccount(Account account);
	public void updateAccount(Account account);
	public Account loadAccount(long accountnumber);
	public Collection<Account> getAccounts();
}
