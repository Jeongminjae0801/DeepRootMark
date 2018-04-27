package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.OrderCommand;
import com.model.OrderItem;

//[주문화면], [주문처리 화면]
//Forward 방식 : 같은 URL을 갖고 있다 (method=GET, POST 두 방식을 나눠받아 해결)


//1. 요청 주소달리하기 : /order/order.do(화면)
//				 /order/orderok.do(처리)
// 위 방법으로 하는건 구식, 지금하려는건 아래

//2. 같은 요청 주소 : /order/order.do : 화면, 처리 모두

@Controller
@RequestMapping("/order/order.do")
public class OrderController {
	
		@RequestMapping(method=RequestMethod.GET)
		public String form() {
			return "order/OrderForm";
		}
		
		@RequestMapping(method=RequestMethod.POST)
		public String submit(OrderCommand orderCommand) {
			
			System.out.println("orderCommand 주소 : " + orderCommand);
			System.out.println("orderCommand 크기 : " + orderCommand.getOrderItem().size());
			
			//검증코드
			List<OrderItem> items= orderCommand.getOrderItem(); //상품 목록 List 주소값 리턴
			for(OrderItem item : items) {
				System.out.println(item.toString());
			}
			//검증코드 ...
			
			//model.addAttribute("orderCommand",OrderCommand) 가 보이지않게 자동 생성된걸 뷰단에 이용하도록 한다
			return "order/OrderCommited";
		}
}
