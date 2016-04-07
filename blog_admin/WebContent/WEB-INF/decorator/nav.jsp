<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>

<title>
	<sitemesh:write property='title' />
</title>
<sitemesh:write property='head' />
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="javascript:void(0)">博客</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li id="nav_li_1"><a href="<c:url value='/'/>">主页</a></li>
            <li id="nav_li_2"><a href="#about">推荐博客</a></li>
            <li id="nav_li_3"><a href="#contact">联系我们</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
          	<security:authorize access="isAnonymous()">
				<li><a href="<c:url value='/login'></c:url>">登录</a></li>
			</security:authorize>
			<security:authorize access="isAuthenticated()">
				<li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><security:authentication property="principal.username"/> <span class="caret"></span></a>
                	<ul class="dropdown-menu">
                  		<li><a href="#">用户信息</a></li>
                  		<li role="separator" class="divider"></li>
                  		<li class="dropdown-header">博客</li>
                  		<li><a href="#">我的博客</a></li>
                	</ul>
              	</li>
              	<li><a href="<c:url value='/user/blog/list'></c:url>">我的博客</a></li>
				<li><a href="<c:url value='/user/blog/add'></c:url>">撰写博客</a></li>
				<li><a href="<c:url value='/logout'></c:url>">退出登录</a></li>
			</security:authorize> 
          </ul>
        </div>
      </div>
    </nav>
	<sitemesh:write property='body' />
	<sitemesh:write property='frontpagejs' />	
	<script type="text/javascript">
		function activeNav(i){
			$("#nav_li_"+i).addClass("active");
		}
	</script>
	
	<sitemesh:write property='backpagejs' />
	
</body>
</html>
