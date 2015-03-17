<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="nav">
	<jsp:include page="/WEB-INF/page/nav/main-nav.jsp"/>
	<div class="category-nav">
		<ul>
		<c:forEach items="categories" item="category">
			<li class="category-icon">
				<c:if test="${not empty category.children}">
					<ul>
					<c:forEach items="${category.children}" var="child">
						<li><a href="${ctx}/${currentTopCategory.code}/${category.code}/${child.code}/list.htm">${child.name}</a></li>
					</c:forEach>
					</ul>
				</c:if>
				<a href="${ctx}/${currentTopCategory.code}/${category.code}/list.htm"><span></span><div class="category-name">${category.name}</div></a>
			</li>
		</c:forEach>
		</ul>
	</div>
</div>