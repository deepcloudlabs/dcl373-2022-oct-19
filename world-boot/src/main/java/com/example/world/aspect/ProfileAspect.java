package com.example.world.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProfileAspect {

//	@Before
//	@AfterReturning
//	@AfterThrowing
//	@After
	@Around("execution(* com.example.world..*(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		var methodName = pjp.getSignature().getName();
		var start = System.nanoTime();
		var result = pjp.proceed();
		var stop = System.nanoTime();
		var duration = stop - start;
		System.out.println("%s runs %d ns.".formatted(methodName, duration));
		return result;
	}
}
