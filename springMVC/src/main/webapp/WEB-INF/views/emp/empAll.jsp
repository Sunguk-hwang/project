<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function call(){
		location.href = "empinsert";
	}
</script>
<body>
<h1>직원 목록</h1>
<hr>
<button onclick="call()"> <!-- <button onclick="location.href=empinsert"> -->
	직원 신규 입력
</button>
<hr>
<table border = "1">
	<tr>
		<td>직원 번호</td>
		<td>직원 이름</td>
		<td>직원 성</td>
		<td>직원 이메일</td>
		<td>직원 전화번호</td>
		<td>직원 급여</td>
		<td>직원 입사일</td>
		<td>직원 매니저</td>
		<td>직원 부서</td>
		<td>직원 커미션</td>
		<td>직원 직무</td>
		<td>데이터 삭제</td>
	</tr>
	<c:forEach var="emp" items="${emplist }">
	<tr>
		<td> <a href="empdetail?empid=${emp.employee_id }">${emp.employee_id }</a></td>
		<td>${emp.first_name }</td>
		<td>${emp.last_name }</td>
		<td>${emp.email }</td>
		<td>${emp.phone_number }</td>
		<td>${emp.salary }</td>
		<td>${emp.hire_date }</td>
		<td>${emp.manager_id }</td>
		<td>${emp.department_id }</td>
		<td>${emp.commission_pct }</td>
		<td>${emp.job_id }</td>
		<td> <a href="empdelete?empid=${emp.employee_id }">삭제</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>