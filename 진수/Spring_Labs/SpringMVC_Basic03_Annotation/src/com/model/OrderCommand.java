package com.model;

import java.util.List;

//주문서 클래스
//하나의 주문에 여러개의 상품을 살 수 있다

//OrderCommand > Orderitem, OrderItem , OrderItem 가질수 있다
public class OrderCommand { //하나의 주문서 (는 여러개의 상품을 담을 수 있다)
	private List<OrderItem> orderItem; //orderItem 에는 >> ArrayList, Vector 객체의 주소가 들어와야한다

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) { //주소값 : List<OrderItem>
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
