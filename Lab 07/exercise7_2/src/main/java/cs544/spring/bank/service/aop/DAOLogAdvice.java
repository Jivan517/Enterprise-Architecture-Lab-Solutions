package cs544.spring.bank.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import cs544.spring.bank.domain.Account;
import cs544.spring.bank.logging.ILogger;

@Aspect
public class DAOLogAdvice {
	
	private ILogger logger;
	
	
	public DAOLogAdvice(ILogger logger){
		this.logger = logger;
	}
	
	@After("execution(public * cs544.spring.bank.dao.*.*(..)) && args(account)")
	public void logDAOCall(JoinPoint joinPoint, Account account){
		logger.log("Executing " + joinPoint.getSignature() + " with accountNumber: " + account.getAccountnumber());
	}
	
	@Before("execution(public * cs544.spring.bank.dao.*.*(..)) && args(accountNumber)")
	public void logDAOCall(JoinPoint joinPoint, long accountNumber){
		logger.log("Executing " + joinPoint.getSignature() + " with parameter accountNumber: " + accountNumber);
	}

}
