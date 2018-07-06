package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.OrderCommand;
import com.model.OrderItem;

// 주문화면(UI) , 주문처리(처리)
// Forward 방식 : 같은 URL (method=GET, POST)

// 1. 요청 주소 달리하기 : /order/order.do (화면 단 줘)
//  				/order/orderok.do (처리 해)
// 2. 같은 요청 주소 : /order/order.do : 화면 , 처리 모두

@Controller
@RequestMapping("/order/order.do")
public class OrderController {

	@RequestMapping(method=RequestMethod.GET) // 화면을 클라이언트에게
	public String form() {
		
		return "order/OrderForm";
	}
	
	@RequestMapping(method=RequestMethod.POST) // 처리 결과를 클라이언트에게
	public String submit(OrderCommand orderCommand) {
		System.out.println("orderCommand 주소 : " + orderCommand);
		System.out.println("orderCommand 크기 : " + orderCommand.getOrderItem().size());
		
		// 검증 코드
		List<OrderItem> items = orderCommand.getOrderItem();
		for(OrderItem item : items) {
			System.out.println(item.toString());
		}
		return "order/OrderCommited";
	}
}
