<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="blog" uri="http://www.wuwenyao.cn/blog/tld"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<security:csrfMetaTags/>
<title>main</title>
</head>
<body>
hello world!!!
<a href="<c:url value='/'></c:url>">主页</a>
<security:authorize access="isAnonymous()">
	<a href="<c:url value='/login'></c:url>">登录</a>
</security:authorize>
<security:authorize access="isAuthenticated()">
	欢迎:<security:authentication property="principal.username"/>,
	<a href="<c:url value='/logout'></c:url>">退出登录</a>
</security:authorize>

</body>