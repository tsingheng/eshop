<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul class="navigation">
	<li>
		<a href="">最新折扣</a>
	</li>
	<c:forEach items="${topCategoryList}" var="topCategory">
	<li class="${topCategory.id eq currentTopCategory.id ? 'cur' : ''}">
		<a href="${ctx}/${topCategory.code}/list.htm">${topCategory.name}</a>
	</li>
	</c:forEach>
</ul>