package cs544.spring.bank.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

//import cs544.spring.bank.logging.ILogger;

@Aspect
public class StopWatchAdvice {
	
//	private ILogger logger;
//	
//	public StopWatchAdvice(ILogger logger){
//		this.logger = logger;
//	}

	@Around("execution(public * cs544.spring.bank.service.*.*(..))")
	public Object invoke(ProceedingJoinPoint call) throws Throwable{
		
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		
		sw.stop();
		
		System.out.println("time to execute " + call.getSignature().getName() + " = " + sw.getLastTaskTimeMillis() + " ms");
		
		return retVal;
		
	}
}
