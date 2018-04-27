package com.model;

import java.util.List;

//주문서 클래스
//하나의 주문에 여러개의 상품을 살 수 있다

//OrderCommand > Orderitem, OrderItem , OrderItem 가질수 있다
public class OrderCommand {
	private List<OrderItem> orderItem;

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	
	/*
	 OrderCommand command = new OrderCommand();
	 //key point
	 List<OrderItem> list = new ArrayList<>();
	 list.add(new OrderItem(1,10,"파손주의")); 
	 list.add(new OrderItem(2,100,"남성"));
	 list.add(new OrderItem(3,111,"사이즈 교환 불가"));
	 command.setOrderItem(list)
	
     Map > HashMap<,>		 
		 
	*/
	
}
