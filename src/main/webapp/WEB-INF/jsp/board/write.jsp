<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/board/write" method="post">
<p><input type="text" name="title" placeholder="제목"></p>
<p><textarea rows="15" cols="23" name="content" placeholder="내용"></textarea></p>
<input type="submit" value="글쓰기">
</form>
</body>
</html>