<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.MyBean"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shop</title>
</head>

<jsp:useBean id="cart" scope="session" class="model.MyBean" />
<jsp:setProperty name="cart" property="*" />
<%
     cart.processRequest();
%>

<br> You have the following items in your cart:
<ol>
	<%
	String[] items = cart.getItems();
	for (int i = 0; i < items.length; i++) {
	%>
	<li>
		<%
		      out.print(items[i]);
		%> <%
 }
 %>
	
</ol>

</html>

