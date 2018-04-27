<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- model.addAttribute("orderCommand",OrderCommand)  
	
	${orderCommand.orderItem} >> 클래스의 get함수 호출
	
	public List<OrderItem> getOrderItem(){
		return orderItem;
	}
	
	for : List<OrderItem>
	First for 		ArrayList<OrderItem> list = new ArrayList<>();
			  		Orderitem item = list.get(i);
			  		..item.id
			  		..item.number
	아래 과정을 이해할 수 있도록 풀어 써놓은것 
-->
	<h3>EL & JSTL 사용 출력</h3>
	<ul>
		<c:forEach items="${orderCommand.orderItem}" var="orderitem">
			<li>	
				${orderitem.itemid} / ${orderitem.number} / ${orderitem.remark}
			</li> 
		</c:forEach>	
	</ul>
	
</body>
</html>