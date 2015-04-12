<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table">
	<thead>
		<tr>
			<th>Buyer</th>
			<th>Product Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Order Time(GMT+8)</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach begin="1" end="20">
		<tr>
			<td>xxx</td>
			<td>yyyyyyyyyyyyyyyyyyyy</td>
			<td>$12.70</td>
			<td>30</td>
			<td>yyyy-MM-dd HH:mm:ss</td>
		</tr>
		</c:forEach>
	</tbody>
</table>