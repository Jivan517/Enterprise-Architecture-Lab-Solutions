package cs544.exercise8_1.bank.dao;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.exercise8_1.bank.domain.Account;

@Transactional()
public class AccountDAOHibernate implements IAccountDAO{

	private SessionFactory sf ;
	
	public AccountDAOHibernate(SessionFactory sessionFactory){
		this.sf = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public Collection<Account> getAccounts() {
		// To prevent our Lazy Initialization problems
		// we don't have open session in view, so instead we have to eagerly load!
		return sf.getCurrentSession().createQuery("select distinct a from Account a " +
				"join fetch a.customer " +
				"join fetch a.entryList").list();
	}

	public Account loadAccount(long accountnumber) {
		return (Account) sf.getCurrentSession().get(Account.class, accountnumber);
	}

	public void saveAccount(Account account) {
		sf.getCurrentSession().persist(account);
	}

	public void updateAccount(Account account) {
		sf.getCurrentSession().saveOrUpdate(account);
	}

}
