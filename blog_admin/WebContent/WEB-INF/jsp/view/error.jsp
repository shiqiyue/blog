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
<title>系统错误</title>
<link href="<c:url value='static/css/main.css'/>" rel="stylesheet">
<link>
</head>
<body>
    <div class="container">

      <div class="starter-template">
        <h1>抱歉，系统出现错误</h1>
        <p class="lead">${error }</p>
      </div>

    </div>
<!-- 页面的js，放置在页面底部 -->
<backpagejs>

</backpagejs>
</body>