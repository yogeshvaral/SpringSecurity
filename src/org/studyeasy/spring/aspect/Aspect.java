package org.studyeasy.spring.aspect;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component("aspect")
@org.aspectj.lang.annotation.Aspect
public class Aspect {
	
	@Pointcut("@target(org.springframework.stereotype.Controller)")
	public void controllerBean() {
		
	}
	@Pointcut("execution(* addUser(..))")
	public void addUser1() {
		
	}
	@Before("controllerBean() && addUser1()")
	public void testAdvice() {
		System.out.println("Test Advice");
	}
}
