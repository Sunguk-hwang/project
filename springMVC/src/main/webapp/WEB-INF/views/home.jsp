<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  %{myname}
</h1>
<select>
	<option>월요일</option>
	<option>화요일</option>
	<option>수요일</option>
	<option>목요일</option>
	<option>금요일</option>
	<option>토요일</option>
	<option selected>일요일</option>
</select>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
