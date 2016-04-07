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
<title>用户登录</title>
<link href="<c:url value='/static/css/blog.css'/>" rel="stylesheet">
<link href="<c:url value='/static/css/signin.css'/>" rel="stylesheet">
</head>
<body>
	
	<div class="container">
		
      <form class="form-signin" method="post">
      	
        <h2 class="form-signin-heading">请登录</h2>
        <c:if test="${info != null }">
        	<div role="alert" class="alert alert-danger">
					${info }
			</div>
        </c:if>
        <label for="inputEmail" class="sr-only">用户名</label>
        <input type="text" id="inputEmail" name="username" class="form-control" placeholder="用户名" required autofocus>
        <label for="inputPassword"  class="sr-only">密码</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="密码" required>
        <security:csrfInput/>
        <div class="checkbox">
          <label>
            <input type="checkbox" name="rememberme" value="true"> 记住我
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>

    </div> 

</body>


