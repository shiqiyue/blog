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
<title>主页</title>
<link>
</head>
<body>
	<div class="page-header">
		<h1>
			欢迎使用博客后台管理系统
		</h1>
	</div>
	<!-- /.page-header -->

	<div class="row">
		
	</div>
	<!-- /.row -->
	<!-- 页面的js，放置在页面底部 -->
	<backpagejs> <script>
	$(function(){
		activeSideBar("li_fileupload");
	});
</script> </backpagejs>
</body>