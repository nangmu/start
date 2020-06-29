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
<form action="/board/update" method="post">
<p>글번호:${board.no}&nbsp;작성자:${board.nickname}</p>
<input type="hidden" name="no" value="${board.no}">
<p><input type="text" name="title" placeholder="제목" value="<c:out value='${board.title}'/>"></p>
<p><textarea rows="15" cols="23" name="content" placeholder="내용"><c:out value="${board.content}"/></textarea></p>
<input type="submit" value="글수정">
</form>
</body>
</html>