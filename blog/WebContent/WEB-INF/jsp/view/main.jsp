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
<link href="<c:url value='/static/css/main.css'/>" rel="stylesheet">
<link>
</head>
<body>
    <div class="container">

      <div class="starter-template">
        <h1>欢迎使用本博客</h1>
        <p class="lead">欢迎使用本博客</p>
      </div>
	  <button id="btn_ajax">ajax error</button>
	  <div id="div_error">
	  </div>
    </div>
<!-- 页面的js，放置在页面底部 -->
<backpagejs>
<script>
	activeNav(1);
	$(function(){
		$("#btn_ajax").click(function(){
			$.post("${url_errorAjax}",{},function(data){
				console.warn(data);
				$("#div_error").html(data);
			})
		});
	});
</script>
</backpagejs>
</body>