package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.OrderCommand;
import com.model.OrderItem;

import jdk.internal.org.objectweb.asm.commons.Method;


//주문화면(UI), 주문처리 하나(처리)
//Forward 방식: 같은 URL (method={GET, POST})

//1.주소요청: 	/order/order.do(화면)
//			/order/orderok.do(처리)

//2.같은주소 요청:/order/order.do: 화면 & 처리

@Controller
@RequestMapping("/order/order.do")
public class OrderController {
	
	@RequestMapping(method= RequestMethod.GET)	//화면
	public String form() {
		return "order/OrderForm";
	}
	
	@RequestMapping(method= RequestMethod.POST)	//처리 결과
	public String submit(OrderCommand orderCommand) {
		System.out.println("OrderCommand 주소: " + orderCommand);
		System.out.println("OrderCommand 크기: " + orderCommand.getOrderItem().size());
		
		//검증코드
		List<OrderItem> items = orderCommand.getOrderItem(); //상품 목록 List 주소값 리턴
		for(OrderItem item : items) {
			System.out.println(item.toString());
		}
		
		return "order/OrderCommited";
	}
	
}
