package com.mkyong.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.mkyong.customer.bo.CustomerBo;
import com.sun.java_cup.internal.runtime.Scanner;

public class App {
	public static void main(String[] args) throws Exception {

		GenericXmlApplicationContext appContext = new GenericXmlApplicationContext("classpath:Spring-servlet.xml");
				/*ClassPathXmlApplicationContext("Spring-Customer.xml");*/
		/*classpath:AOP_Basic_Spring_06*/
		CustomerBo customer = (CustomerBo) appContext.getBean("customerBo");
		//customer.addCustomer();
		
		//customer.addCustomerReturnValue();
		
		//customer.addCustomerThrowException();
		
		//customer.addCustomerAround("mkyong");
		
		
		
		List<String> items = new ArrayList<>();
		items.add("2qjs");
		items.add("3qjs");
		customer.getitmes(items);
	}
}