package com.example.world.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProfileAspect {

//	@Before
//	@AfterReturning
//	@AfterThrowing
//	@After
	@Around("""
			worldPackage() && 
			( methodIsProfilerAnnotated() || classIsProfilerAnnotated())
			""")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		var methodName = pjp.getSignature().getName();
		var start = System.nanoTime();
		var result = pjp.proceed();
		var stop = System.nanoTime();
		var duration = stop - start;
		System.out.println("%s runs %d ns.".formatted(methodName, duration));
		return result;
	}
	
	@Pointcut("execution(* com.example.world..*(..))")
	public void worldPackage() {}
	
	@Pointcut("@annotation(com.example.world.aspect.Profiler)")
	public void methodIsProfilerAnnotated() {}
	
	@Pointcut("within(@com.example.world.aspect.Profiler *)")
	public void classIsProfilerAnnotated() {}
	
}
