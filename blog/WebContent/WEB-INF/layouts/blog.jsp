<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<security:csrfMetaTags />
<title><decorator:title/></title>
<decorator:head />
<link
	href="<c:url value='static/metronic/media/css/bootstrap.min.css'/>"
	rel="stylesheet" type="text/css" />

<link
	href="<c:url value='static/metronic/media/css/bootstrap-responsive.min.css'/>"
	rel="stylesheet" type="text/css" />

<link
	href="<c:url value='static/metronic/media/css/font-awesome.min.css'/>"
	rel="stylesheet" type="text/css" />

<link href="<c:url value='static/metronic/media/css/style-metro.css'/>"
	rel="stylesheet" type="text/css" />

<link href="<c:url value='static/metronic/media/css/style.css'/>"
	rel="stylesheet" type="text/css" />

<link
	href="<c:url value='static/metronic/media/css/style-responsive.css'/>"
	rel="stylesheet" type="text/css" />

<link href="<c:url value='static/metronic/media/css/default.css'/>"
	rel="stylesheet" type="text/css" id="style_color" />

<link
	href="<c:url value='static/metronic/media/css/uniform.default.css'/>"
	rel="stylesheet" type="text/css" />

</head>

<body>

	<decorator:body />
	<script src="<c:url value='static/metronic/media/js/jquery-1.10.1.min.js'/>" type="text/javascript"></script>
	<script src="<c:url value='static/metronic/media/js/jquery-migrate-1.2.1.min.js'/>"
		type="text/javascript"></script>
	<script src="<c:url value='static/metronic/media/js/jquery-ui-1.10.1.custom.min.js'/>"
		type="text/javascript"></script>
	<script src="<c:url value='static/metronic/media/js/bootstrap.min.js'/>" type="text/javascript"></script>
	<script src="<c:url value='static/metronic/media/js/jquery.slimscroll.min.js'/>" type="text/javascript"></script>
	<script src="<c:url value='static/metronic/media/js/jquery.blockui.min.js'/>" type="text/javascript"></script>
	<script src="<c:url value='static/metronic/media/js/jquery.cookie.min.js'/>" type="text/javascript"></script>
	<script src="<c:url value='static/metronic/media/js/jquery.uniform.min.js'/>" type="text/javascript"></script>
	<script src="<c:url value='static/metronic/media/js/jquery.validate.min.js'/>" type="text/javascript"></script>
</body>
</html>
