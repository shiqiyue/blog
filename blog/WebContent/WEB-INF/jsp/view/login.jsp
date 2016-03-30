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
<title>main</title>
</head>
<body>
<form  method="post">
	<label for="username">用户名:</label>
	<input name="username"/>
	<label for="password">密码:</label>
	<input type="password" name="password"/>
	<input type="submit" value="提交"/>
	<security:csrfInput/>
</form>
 <c:if test="${param.containsKey('error')}">
        <b class="errors">${SPRING_SECURITY_LAST_EXCEPTION.message}</b><br />
  </c:if>
</body>
