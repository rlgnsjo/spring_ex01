<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../include/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<h2>doC 페이지</h2>
<h2>
	상품명 : ${map.product.name}<br>
	가격: ${map.product.price}
</h2>
</body>
</html>