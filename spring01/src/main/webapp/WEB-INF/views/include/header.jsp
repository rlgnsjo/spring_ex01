<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="text-align: center;">
	<a href="${path}/">main</a>
	<a href="${path}/gugu?dan=5">구구단</a> <!-- maincontroller에서 보내준 매개변수 이름이 같아야함(int dan) -->
	<a href="${path}/test">테스트</a>
	<a href="#">회원관리</a>
</div>
<hr>
