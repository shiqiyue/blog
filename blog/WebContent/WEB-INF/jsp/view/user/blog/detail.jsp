<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="blog" uri="http://www.wuwenyao.cn/blog/tld"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<c:url value="/test/error/ajax" var="url_errorAjax" />
<!DOCTYPE html>
<html>
<head>
<title>${blog.title }</title>
<link href="<c:url value='/static/css/blog.css'/>" rel="stylesheet">
<link>
</head>
<body>
	<div class="container">
		<div class="blog-header">
			<h1 class="blog-title">${blog.title }</h1>
		</div>
		<div class="row">
			<div class="blog-post">
				<h2 class=" lead">${blog.briefIntro }</h2>
				<p class="blog-post-meta">关键字：${blog:listCombine(blog.keywords,' ') }</p>
				${blog.context }
			</div>
		</div>
		
	</div>
	<!-- 页面的js，放置在页面底部 -->
	<backpagejs> <script>
		$(function() {

		});
	</script> </backpagejs>
</body>