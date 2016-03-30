<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="博客">
<meta name="author" content="吴文尧">
<security:csrfMetaTags />
<title><sitemesh:write property='title' /></title>
<sitemesh:write property='head' />
<!-- Bootstrap core CSS -->
<link href="<c:url value='static/css/bootstrap.min.css'/>" rel="stylesheet">
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="<c:url value='static/css/ie10-viewport-bug-workaround.css'/>" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>

	<sitemesh:write property='body' />

	<sitemesh:write property='pagejs' />
	 <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="<c:url value='static/js/ie10-viewport-bug-workaround.js'/>"></script>
	<script src="<c:url value='static/js/jquery-2.2.2.min.js'/>"></script>
	<script src="<c:url value='static/js/bootstrap.min.js'/>"></script>
</body>
</html>
