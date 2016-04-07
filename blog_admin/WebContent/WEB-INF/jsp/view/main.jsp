<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="blog" uri="http://www.wuwenyao.cn/blog/tld"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:url value="/test/error/ajax" var="url_errorAjax"/>
<!DOCTYPE html>
<html>
<head>
<title>主页</title>
<link href="<c:url value='/static/css/blog.css'/>" rel="stylesheet">
<link>
</head>
<body>
<div class="container">

		<div class="blog-header">
			<h1 class="blog-title">欢迎使用博客</h1>
		</div>
		<p class=" lead">
			&nbsp;&nbsp;你好，滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答
			滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答滴答答
		</p>
		

	</div>

<!-- 页面的js，放置在页面底部 -->
<backpagejs>
<script>
	activeNav(1);
	$(function(){
		
	});
</script>
</backpagejs>
</body>