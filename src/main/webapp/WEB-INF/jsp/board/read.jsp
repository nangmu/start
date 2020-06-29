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
<form action="/board/write" method="post">
<p>글번호:${board.no}&nbsp;작성자:${board.nickname }</p>
<p><input type="text" name="title" placeholder="제목" value='<c:out value="${board.title}"/>' readonly></p>
<p><textarea rows="15" cols="23" name="content" placeholder="내용" readonly><c:out value="${board.content}"/></textarea></p>
</form>
<a href="/board/update?no=${board.no}"><button>수정</button></a>
&nbsp;
<a href="/board/delete?no=${board.no}"><button>삭제</button></a>
</body>
</html>