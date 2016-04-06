package cs544.exercise7_1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class CalcAdvice {

	@Around("execution(public * *.save(..))")
	public Object invoke(ProceedingJoinPoint call) throws Throwable  {
		
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		
		long totalTime = sw.getLastTaskTimeMillis();
		System.out.println("time to execute " + call.getSignature().getName() + " = " + totalTime + " ms");
		return retVal;
		
	}
}
