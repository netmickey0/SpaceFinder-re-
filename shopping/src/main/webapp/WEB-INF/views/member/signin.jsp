<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SpaceFinder</title>

  <!-- Bootstrap core CSS -->
  <link href="/resources/clean-blog/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="/resources/clean-blog/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="/resources/clean-blog/css/clean-blog.min.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <%@ include file="../include/nav.jsp" %>
  </nav>

  <!-- Page Header -->
  <header class="masthead" style="background-image: url('/resources/img/home-bg.jpg')">
    <%@ include file="../include/header.jsp" %>
  </header>

  <!-- Main Content -->
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-md-10 mx-auto">
        <p>로그인</p>
        <!-- Contact Form - Enter your email address on line 19 of the mail/contact_me.php file to make this form work. -->
        <!-- WARNING: Some web hosts do not allow emails to be sent through forms to common mail hosts like Gmail or Yahoo. It's recommended that you use a private domain email address! -->
        <!-- To use the contact form, your site must be on a live web host with PHP! The form will not work locally! -->
        <form role="form" method="post" autocomplete="off" name="sentMessage" id="contactForm" novalidate>
          <div class="control-group">
            <div class="form-group floating-label-form-group controls">
              <label>아이디</label>
              <input type="email" class="form-control" placeholder="아이디(E-mail)" id="userId" name="userId" required="required" data-validation-required-message="Please enter your E-mail">
              <p class="help-block text-danger"></p>
            </div>
          </div>
          <div class="control-group">
            <div class="form-group floating-label-form-group controls">
              <label>패스워드</label>
              <input type="password" class="form-control" placeholder="패스워드" id="userPass" name="userPass" required="required" data-validation-required-message="Please enter your Password">
              <p class="help-block text-danger"></p>
            </div>
          </div>
          <button type="submit" class="btn btn-primary" id="signin_btn" name="signin_btn">로그인</button>
          <c:if test="${msg == false}">
			  <script>alert("로그인 실패")</script>
		  </c:if>
        </form>
      </div>
    </div>
  </div>

  <hr>

  <!-- Footer -->
  <footer>
     <%@ include file="../include/footer.jsp" %>
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="/resources/clean-blog/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/clean-blog/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="/resources/clean-blog/js/clean-blog.min.js"></script>

</body>

</html>


<%-- 


<html>
<head>
<title>Shopping</title>
</head>
<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="../include/header.jsp"%>
			</div>
		</header>

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="../include/nav.jsp"%>
			</div>
		</nav>

		<section id="container">
			<div id="container_box">
				<section id="content">
					<form role="form" method="post" autocomplete="off">
						<div class="input_area">
							<label for="userId">아이디</label> <input type="email" id="userId"
								name="userId" required="required" />
						</div>

						<div class="input_area">
							<label for="userPass">패스워드</label> <input type="password"
								id="userPass" name="userPass" required="required" />
						</div>

						<button type="submit" id="signin_btn" name="signin_btn">로그인</button>

						<c:if test="${msg == false}">
							<p style="color: #f00;">로그인에 실패했습니다.</p>
						</c:if>

					</form>
				</section>
			</div>
		</section>

		<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp"%>
			</div>
		</footer>

	</div>

	<P>  The time on the server is ${serverTime}. </P>
</body>
</html> --%>