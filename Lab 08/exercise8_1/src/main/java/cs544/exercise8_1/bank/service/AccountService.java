package cs544.exercise8_1.bank.service;

import java.util.Collection;

//import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.exercise8_1.bank.dao.IAccountDAO;
import cs544.exercise8_1.bank.domain.Account;
import cs544.exercise8_1.bank.domain.Customer;
import cs544.exercise8_1.bank.jms.IJMSSender;
import cs544.exercise8_1.bank.logging.ILogger;


@Transactional
public class AccountService implements IAccountService {

    private IAccountDAO accountDAO;
    private ICurrencyConverter currencyConverter;
    private IJMSSender jmsSender;
    private ILogger logger;
    private SessionFactory sessionFactory;


    public AccountService(IAccountDAO accountDAO, ICurrencyConverter currencyConverter, IJMSSender jmsSender,
			ILogger logger, SessionFactory sessionFactory) {
		super();
		this.accountDAO = accountDAO;
		this.currencyConverter = currencyConverter;
		this.jmsSender = jmsSender;
		this.logger = logger;
		this.sessionFactory = sessionFactory;
	}

    
    //@Transactional(propagation = Propagation.REQUIRED)
	public Account createAccount(long accountNumber, String customerName) {
    	System.out.println(sessionFactory);
        //Transaction tx = sessionFactory.getCurrentSession().beginTransaction();

        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);
        accountDAO.saveAccount(account);
        logger.log("createAccount with parameters accountNumber= "
                + accountNumber + " , customerName= " + customerName);

        //tx.commit();
        return account;
    }

    public void deposit(long accountNumber, double amount) {
        //Transaction tx = sessionFactory.getCurrentSession().beginTransaction();

        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        accountDAO.updateAccount(account);
        logger.log("deposit with parameters accountNumber= " + accountNumber
                + " , amount= " + amount);
        if (amount > 10000) {
            jmsSender.sendJMSMessage("Deposit of $ " + amount
                    + " to account with accountNumber= " + accountNumber);
        }

       // tx.commit();
    }

    public Account getAccount(long accountNumber) {
       // Transaction tx = sessionFactory.getCurrentSession().beginTransaction();

        Account account = accountDAO.loadAccount(accountNumber);

        //tx.commit();
        return account;
    }

    public Collection<Account> getAllAccounts() {
       // Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
        Collection<Account> accounts = accountDAO.getAccounts();
       // tx.commit();

        return accounts;
    }

    public void withdraw(long accountNumber, double amount) {
       // Transaction tx = sessionFactory.getCurrentSession().beginTransaction();

        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
        logger.log("withdraw with parameters accountNumber= " + accountNumber
                + " , amount= " + amount);
       // tx.commit();
    }

    public void depositEuros(long accountNumber, double amount) {
       // Transaction tx = sessionFactory.getCurrentSession().beginTransaction();

        Account account = accountDAO.loadAccount(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.deposit(amountDollars);
        accountDAO.updateAccount(account);
        logger.log("depositEuros with parameters accountNumber= "
                + accountNumber + " , amount= " + amount);
        if (amountDollars > 10000) {
            jmsSender.sendJMSMessage("Deposit of $ " + amount
                    + " to account with accountNumber= " + accountNumber);
        }
       // tx.commit();
    }

    public void withdrawEuros(long accountNumber, double amount) {
       // Transaction tx = sessionFactory.getCurrentSession().beginTransaction();

        Account account = accountDAO.loadAccount(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.withdraw(amountDollars);
        accountDAO.updateAccount(account);
        logger.log("withdrawEuros with parameters accountNumber= "
                + accountNumber + " , amount= " + amount);

       // tx.commit();
    }

    public void transferFunds(long fromAccountNumber, long toAccountNumber,
            double amount, String description) {
        //Transaction tx = sessionFactory.getCurrentSession().beginTransaction();

        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);
        logger.log("transferFunds with parameters fromAccountNumber= "
                + fromAccountNumber + " , toAccountNumber= " + toAccountNumber
                + " , amount= " + amount + " , description= " + description);
        if (amount > 10000) {
            jmsSender.sendJMSMessage("TransferFunds of $ " + amount
                    + " from account with accountNumber= " + fromAccount
                    + " to account with accountNumber= " + toAccount);
        }
       // tx.commit();
    }
}
