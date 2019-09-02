<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>부서 추가하기</h1>
<form action="deptinsert" method="post" enctype="multipart/form-data"> <!-- enctype 기본값 enctype="application/x-www-form-urlencoded" : 문자로 보낸다 -->
부서 번호 : <input type="number" name="department_id"><br>
부서 이름 : <input type="text" name="department_name"><br>
<input type="file" name="uploadfile" required="required"><br>
<input type="submit" value="추가하기">
</form>
</body>
</html>