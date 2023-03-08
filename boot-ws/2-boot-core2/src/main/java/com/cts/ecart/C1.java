package com.cts.ecart;

import org.springframework.stereotype.Component;
@Component("c1Bean")
public class C1 {
	
	public C1() {
		System.out.println(">>> C1 class object created...");
	}
	
	public void f1() {
		System.out.println(">>> C1 class f1 method");
	}

}
