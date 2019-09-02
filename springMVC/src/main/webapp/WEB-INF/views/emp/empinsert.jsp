<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	label{
		width: 150px;
		background-color: yellow;
		display: inline-block;
	}
</style>
</head>
<body>
<h1>
직원 추가하기
</h1>
<form action="empinsert" method="post">
<label>직원 번호 : </label><input type="number" name="employee_id"><br>
<label>직원 이름 : </label><input type="text" name="first_name"><br>
<label>직원 성 : </label><input type="text" name="last_name"><br>
<label>직원 이메일 : </label><input type="text" name="email" placeholder="xxx@yyy.zzz"><br>
<label>직원 전화번호 : </label><input type="tel" name="phone_number" placeholder="xxx.xxx.xxxx" pattern="\d{3}.\d{3}.\d{4}"><br> <!-- pattern="\d{3}-\d{4}-\d{4}" 형식 외에 입력이 들어오면 안 넘어간다.-->
<label>직원 입사일 : </label><input type="date" name="hire_date"><br>
<label>직원 직무 : </label>
<select name="job_id">
	<c:forEach var="job" items="${joblist }">
		<option>${job }</option>
	</c:forEach>
</select><br>
<label>직원 급여 : </label><input type="number" name="salary"><br>
<label>직원 커미션 : </label><input type="text" name="commission_pct"><br>
<label>직원 매니저 : </label>
<select name="manager_id">
	<c:forEach var="manager" items="${managerlist }">
		<option>${manager }</option>
	</c:forEach>
</select><br>
<label>직원 부서 : </label>
<select name="department_id">
	<c:forEach var="dept" items="${deptlist }">
		<option value="${dept.department_id }">${dept.department_name }</option>
	</c:forEach>
</select><br>
<input type="submit" value="추가하기">
</form>
</body>
</html>