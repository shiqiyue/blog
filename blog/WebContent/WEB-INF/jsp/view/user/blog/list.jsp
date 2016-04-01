<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="blog" uri="http://www.wuwenyao.cn/blog/tld"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>我的博客</title>
<link href="<c:url value='/static/css/blog.css'/>" rel="stylesheet">

</head>
<body>

	<div class="container">

		<div class="blog-header">
			<h1 class="blog-title">我的博客</h1>
		</div>

		<div class="row">

			<div class="col-sm-8 blog-main">
				<c:forEach items="${blogs.getContent() }" var="blog">
					<div class="blog-post">
						<div class="row">
							<div class="col-sm-8">
								<h2 class="blog-post-title">${blog.title}</h2>
							</div>
							<div class="col-sm-4">
								<div class="btn-group" role="group">
									<a href="<c:url value='/user/blog/detail/${blog.id} '/>"
										role="button" class="btn btn-default left">浏览</a> <a
										href="<c:url value='/user/blog/edit/${blog.id }'/>"
										role="button" class="btn btn-default left">修改</a>
								</div>
							</div>
						</div>

						<p class="blog-post-meta">${blog.addDate }</p>
						<div class="blog-post-briefIntro">${blog.briefIntro }</div>

					</div>
					<!-- /.blog-post -->
				</c:forEach>
				<nav>
					<ul class="pager">
						<li><a href="#">Previous</a></li>
						<li><a href="#">Next</a></li>
					</ul>
				</nav>

			</div>
			<!-- /.blog-main -->

			<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
				<div class="sidebar-module sidebar-module-inset">
					<h4>About</h4>
					<p>
						Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras
						mattis consectetur purus sit amet fermentum. Aenean lacinia
						bibendum nulla sed consectetur.
					</p>
				</div>
				<div class="sidebar-module">
					<h4>Archives</h4>
					<ol class="list-unstyled">
						<li><a href="#">March 2014</a></li>
						<li><a href="#">February 2014</a></li>
						<li><a href="#">January 2014</a></li>
						<li><a href="#">December 2013</a></li>
						<li><a href="#">November 2013</a></li>
						<li><a href="#">October 2013</a></li>
						<li><a href="#">September 2013</a></li>
						<li><a href="#">August 2013</a></li>
						<li><a href="#">July 2013</a></li>
						<li><a href="#">June 2013</a></li>
						<li><a href="#">May 2013</a></li>
						<li><a href="#">April 2013</a></li>
					</ol>
				</div>
				<div class="sidebar-module">
					<h4>Elsewhere</h4>
					<ol class="list-unstyled">
						<li><a href="#">GitHub</a></li>
						<li><a href="#">Twitter</a></li>
						<li><a href="#">Facebook</a></li>
					</ol>
				</div>
			</div>
			<!-- /.blog-sidebar -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- 页面的js，放置在页面底部 -->
	<backpagejs> <script>
</script> </backpagejs>
</body>