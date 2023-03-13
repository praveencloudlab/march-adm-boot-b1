package com.cts.ecart.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	
	/*
	
	@Before("execution(void com.cts.ecart.service.ProductServiceImpl.product*())")
	public void f1(JoinPoint jp) {
		System.out.println("DML operation about to start on :: "+jp.getSignature());
	}
	
	@After("execution(void com.cts.ecart.service.ProductServiceImpl.product*())")
	public void f2() {
		System.out.println("DML operation is completed :: ");
	}
	
	@AfterReturning("execution(Object com.cts.ecart.service.ProductServiceImpl.product*())")
	public void f3() {
		System.out.println("method is returning a value :: ");
	}
	
	@AfterThrowing("execution(* com.cts.ecart.service.ProductServiceImpl.product*())")
	public void f4() {
		System.out.println("Excdeption is thrown .. falling back to rollback :: ");
	}
	 */

	@Around("execution(* com.cts.ecart.service.ProductServiceImpl.product*())")
	public void f5(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("Transaction is initiated.....");

		Boolean status =(Boolean) jp.proceed();
		System.out.println(status);
		if (status)
			System.out.println("Transaction is completed...");
		else
			System.out.println("Transaction not completed.. rolling back");

	}

}
