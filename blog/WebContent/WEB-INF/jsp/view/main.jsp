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
<title>主页</title>
<link href="<c:url value='static/css/starter-template.css'/>" rel="stylesheet">
</head>
<body>
    <div class="container">

      <div class="starter-template">
        <h1>欢迎使用本博客</h1>
        <p class="lead">欢迎使用本博客</p>
      </div>

    </div>
<!-- 页面的js，放置在页面底部 -->
<backpagejs>
<script>
	activeNav(1);
</script>
</backpagejs>
</body>