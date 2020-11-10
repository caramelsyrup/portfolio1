<%@ include file="includes/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 누구나 접근, 로그인 페이지 -->
<title>home</title>
<meta name="theme-color" content="#563d7c">
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
</head>
<body class="text-center">
    <form class="form-signin" action="/">
  <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
  <label for="inputEmail" class="sr-only">Account</label>
  <input type="email" id="inputEmail" class="form-control" placeholder="Account" required autofocus>
  <label for="inputPassword" class="sr-only">Password</label>
  <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"> Remember me
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-info" type="submit">Sign in</button>
  <button class="btn btn-lg btn-primary btn-secondary" type="reset">Reset</button>
  <button class="btn btn-lg btn-primary btn-dark" type="button" id="btnSignUp">Sign up</button>
  <p class="mt-5 mb-3 text-muted">&copy; 2020</p>
</form>

<%@ include file="includes/footer.jsp"%>