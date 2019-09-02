<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath }"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>부서 상세보기</h1>
<form action="deptdetail" method="post">
부서 번호 : <input type="number" name="department_id" value="${dept.department_id }"><br>
부서 이름 : <input type="text" name="department_name" value="${dept.department_name }"><br>
<%-- <img alt="이미지" src="${path}/resources/photo17.jpg"><br> --%>
<img alt="이미지" src="${path}/resources/${dept.fileName }" width="400" height="300"><br>
<a href="deptdownload?folder=resources&file=${dept.fileName }">이미지 다운로드</a><br>
<input type="submit" value="수정하기">

</form>
</body>
</html>