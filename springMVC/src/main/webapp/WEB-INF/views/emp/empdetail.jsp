<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>직원 상세보기</h1>
<form action="empdetail" method="post">
직원 번호 : <input type="number" disabled="disabled" name="employee_id" value="${emp.employee_id }"><br>
<input type="hidden" name="employee_id" value="${emp.employee_id }">
직원 이름 : <input type="text" name="first_name" value="${emp.first_name }"><br>
직원 성 : <input type="text" name="last_name" value="${emp.last_name }"><br>
직원 이메일 : <input type="text" name="email" value="${emp.email }"><br>
직원 전화번호 : <input type="tel" name="phone_number" value="${emp.phone_number }" pattern="\d{3}.\d{3}.\d{4}"><br>
직원 입사일 : <input type="date" name="hire_date" value="${emp.hire_date }"><br>
직원 직무 : 
<select name="job_id">
	<c:forEach var="job" items="${joblist}">
		<c:if test="${emp.job_id == job}">
			<option selected>${job}</option>
		</c:if>
		<c:if test="${emp.job_id != job}">
			<option>${job}</option>
		</c:if>
	</c:forEach>
</select><br>
직원 급여 : <input type="number" name="salary" value="${emp.salary }"><br>
직원 커미션 : <input type="text" name="commission_pct" value="${emp.commission_pct }"><br>
직원 매니저 : 
<select name="manager_id">
	<c:forEach var="manager" items="${managerlist}">
		<option ${emp.manager_id == manager ? "selected" : ""}>${manager}</option>
	</c:forEach>
</select><br>
직원 부서 : 
<select name="department_id">
	<c:forEach var="dept" items="${deptlist}">
		<c:if test="${emp.department_id == dept.department_id}">
			<option selected value="${dept.department_id}">${dept.department_id}: ${dept.department_name }</option>
		</c:if>
		<c:if test="${emp.department_id != dept.department_id }">
			<option value="${dept.department_id}">${dept.department_id}: ${dept.department_name }</option>
		</c:if>
	</c:forEach>
</select><br>
<input type="submit" value="수정하기">
</form>
</body>
</html>