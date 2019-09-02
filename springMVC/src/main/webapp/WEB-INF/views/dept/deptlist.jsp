<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- namespace -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function call(){
		location.href = "deptinsert";
	}
</script>
</head>
<body>
<h1>부서 목록</h1>
<button onclick="call()">
	부서 추가
</button>
<%-- <h2>자료 건수 : ${deptcount }</h2>
<h2>EL 연습 : ${10+20 } ${10>20 }</h2> --%>
<hr>
<table border="1">
	<tr>
		<td>부서 번호</td><td>부서 이름</td><td>부서 삭제</td>
	</tr>
	<c:forEach var="dept" items="${deptlist }"> <!-- 향상된 for문 느낌 -->
		<tr>
			<td><a href="deptdetail?deptid=${dept.department_id }">${dept.department_id }</a></td>
			<td>${dept.department_name }</td>
			<td><a href="deptdelete?deptid=${dept.department_id }">삭제</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>