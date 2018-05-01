package com.mkyong.customer.bo;

import java.util.List;

public interface CustomerBo {

	void addCustomer();
	
	String addCustomerReturnValue();
	
	void addCustomerThrowException() throws Exception;
	
	void addCustomerAround(String name);
	
	void getitmes(List<String> items);
}