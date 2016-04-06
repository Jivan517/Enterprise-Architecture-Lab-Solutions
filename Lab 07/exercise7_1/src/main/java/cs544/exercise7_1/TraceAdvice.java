package cs544.exercise7_1;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TraceAdvice {

	@After("execution(public void cs544.exercise7_1.EmailSender.sendEmail(..))")
	public void traceAfterMethod(JoinPoint joinPoint){
		
		Object[] args = joinPoint.getArgs();
		
		String address = (String) args[0];
		String message = (String) args[1];
		
		EmailSender es = (EmailSender) joinPoint.getTarget();
		
		System.out.println(new Date() + " method = " + joinPoint.getSignature().getName() + " address=" + address + " message="
				 + message + "\noutgoing mail server = " + es.outgoingMailServer);
	}
	
}
