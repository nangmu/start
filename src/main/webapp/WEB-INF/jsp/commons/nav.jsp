<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">Start Bootstrap</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          
          <c:choose>
          	<c:when test="${user.no eq null }">
          	<li class="nav-item">
            	<a class="nav-link" href="/user/login">로그인</a>
            </li>
            <li class="nav-item">
            	<a class="nav-link" href="/user/regist">가입</a>
        	</li>
          	</c:when>
          	
          	<c:otherwise>
          	<li class="nav-item">
            	<a class="nav-link" href="#">${user.nickname}</a>
            </li>
            <li class="nav-item">
            	<a class="nav-link" href="/user/logout">로그아웃</a>
        	</li>
          	</c:otherwise>
          </c:choose>
          	
          	<li class="nav-item">
            	<a class="nav-link" href="/board">게시판</a>
        	</li>
        	
          <c:if test="${user.role eq 'ADMIN'}">
          	<li class="nav-item">
            	<a class="nav-link" href="/admin">관리자페이지</a>
          	</li>
          </c:if>
        
        </ul>
      </div>
    </div>
  </nav>