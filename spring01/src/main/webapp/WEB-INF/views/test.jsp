<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="include/common.jsp" %>	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file ="include/header.jsp" %>
<h2>링크 테스트</h2>
<a href="${path}/test/doA">doA</a>
<a href="${path}/test/doB">doB</a>
<a href="${path}/test/doC">doC</a>
<a href="${path}/test/doD">doD</a>
<a href="#" onclick="doF()">doF</a><br>
<div id="result"></div>

<script type="text/javascript">
	function doF(){
		$.ajax({
			type: "post",
			url: "${path}/test/doF",  //${path} =spring01
			success: function(result) {
				console.log(result);
				$("#result").html("상품명:" + result.name+",가격:"+result.price);
			}			
		});
	}	
</script>

</body>
</html>