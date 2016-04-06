package cs544.spring.bank.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import cs544.spring.bank.logging.ILogger;

@Aspect
public class JMSLogAdvice {

	
	private ILogger logger;
	
	public JMSLogAdvice(ILogger logger){
		this.logger = logger;
	}
	
	@After("execution(public * cs544.spring.bank.jms.JMSSender.sendJMSMessage(..)) && args(text)")
	public void logJMSMessage(JoinPoint joinPoint, String text){
		
		logger.log("JMSSender: sent JMS message =" + text);
	}
}
