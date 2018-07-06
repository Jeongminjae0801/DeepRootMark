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
<!-- model.addAttribute("orderCommand",OrderCommand)  -->
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