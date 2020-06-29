<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Blog Home - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/blog-home.css" rel="stylesheet">
  
  <script
  src="https://code.jquery.com/jquery-3.5.1.min.js"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous"></script>
  <script>
  $(document).ready(function(){
	  $("#searchBtn").on("click", function() {
		 var keyword = $("input[name='keyword']").val();
	  	 location.href="/board?reqPage=1&keyword="+keyword;
	  });
  });
  </script>
</head>

<body>

  <!-- Navigation -->
  <jsp:include page="/WEB-INF/jsp/commons/nav.jsp"/>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <!-- Blog Entries Column -->
      <div class="col-md-8">

		<div class="my-4">
        	<h1>게시판<a href="/board/write"><button style="float: right">글쓰기</button></a></h1>
		</div>
		
        <!-- Blog Post -->
        <c:forEach items="${boards}" var="b">
		<div class="card mb-4">
          <!-- <img class="card-img-top" src="http://placehold.it/750x300" alt="Card image cap"> -->
          
          <div class="card-body">
            <h2 class="card-title"><c:out value="${b.title}"/></h2>
            <p class="card-text"><c:out value="${b.content}"/></p>
            <a href="/board/${b.no}" class="btn btn-primary">Read More &rarr;</a>
          </div>
          <div class="card-footer text-muted">
            <c:out value="${b.regDate}"/>  by
            <a href="#">${b.nickname}</a>
          </div>
        </div>        
        </c:forEach>

        <!-- Pagination -->
        <ul class="pagination justify-content-center mb-4">
          <li class="page-item <c:if test='${paging.prev == false}'><c:out value='disabled'/></c:if>">
            <a class="page-link" href="/?reqPage=${paging.reqPage-1}&keyword=${paging.keyword}" >&larr; Prev</a>
          </li>
          <li class="page-item  <c:if test='${paging.next == false}'><c:out value='disabled'/></c:if>">
            <a class="page-link" href="/?reqPage=${paging.reqPage+1}&keyword=${paging.keyword}">Next &rarr;</a>
          </li>
          <li class="page-item">${paging.reqPage} / ${paging.totalPage}</li>
        </ul>
		
      </div>

      <!-- Sidebar Widgets Column -->
 	  <div class="col-md-4">

        <!-- Search Widget -->
        <div class="card my-4">
          <h5 class="card-header">Search</h5>
          <div class="card-body">
            <div class="input-group">
              <input type="text" class="form-control" name="keyword" placeholder="Search for...">
              <span class="input-group-append">
                <button id="searchBtn" class="btn btn-secondary" type="button">Go!</button>
              </span>
            </div>
          </div>
        </div>

        <!-- Categories Widget -->
        <div class="card my-4">
          <h5 class="card-header">Categories</h5>
          <div class="card-body">
            <div class="row">
              <div class="col-lg-6">
                <ul class="list-unstyled mb-0">
                  <li>
                    <a href="#">Web Design</a>
                  </li>
                  <li>
                    <a href="#">HTML</a>
                  </li>
                  <li>
                    <a href="#">Freebies</a>
                  </li>
                </ul>
              </div>
              <div class="col-lg-6">
                <ul class="list-unstyled mb-0">
                  <li>
                    <a href="#">JavaScript</a>
                  </li>
                  <li>
                    <a href="#">CSS</a>
                  </li>
                  <li>
                    <a href="#">Tutorials</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>

        <!-- Side Widget -->
        <div class="card my-4">
          <h5 class="card-header">Side Widget</h5>
          <div class="card-body">
            You can put anything you want inside of these side widgets. They are easy to use, and feature the new Bootstrap 4 card containers!
          </div>
        </div>

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <jsp:include page="/WEB-INF/jsp/commons/footer.jsp"/>
  
  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
