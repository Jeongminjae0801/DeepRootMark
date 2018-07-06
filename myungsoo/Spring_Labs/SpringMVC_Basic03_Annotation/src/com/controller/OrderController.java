package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.OrderCommand;
import com.model.OrderItem;

//주문화면(UI) , 주문처리(처리)
//Forward 방식 : 같은 URL (method = GET, POST)

//1. 요청 주소달리하기 : /order/order.do(화면)
//				  /order/orderok.do (처리)

//2. 같은 요청 주소 : /order/order.do : 화면 , 처리 모두

@Controller
@RequestMapping("/order/order.do")
public class OrderController {
	
	@RequestMapping(method= RequestMethod.GET)
	public String from() {
		return "order/OrderForm";
	}

	@RequestMapping(method= RequestMethod.POST)
	public String submit(OrderCommand orderCommand) {
		System.out.println("ordercommand 주소 : " + orderCommand);
		System.out.println("ordercommand 크리 : " + orderCommand.getOrderItem().size());
		
		//검증코드
		List<OrderItem> items = orderCommand.getOrderItem(); //상품 목록 list 주소값 리턴
		for(OrderItem item : items) {
			System.out.println(item.toString());
			
		}
		//검증코드
		return "order/OrderCommited";
	}
}
