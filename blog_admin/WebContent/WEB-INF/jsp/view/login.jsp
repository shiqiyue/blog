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
<title>用户登录</title>

</head>
<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="icon-leaf green"></i> <span class="red">Ace</span> <span
									class="white">Application</span>
							</h1>
							<h4 class="blue">&copy; Company Name</h4>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="icon-coffee green"></i> 请输入登录信息
										</h4>

										<div class="space-6"></div>

										<form method="post">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" class="form-control" name="username" placeholder=用户名 /> <i
														class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" class="form-control" name="password" placeholder="密码" />
														<i class="icon-lock"></i>
												</span>
												</label>

												<div class="space"></div>

												<div class="clearfix">
													<label class="inline"> <input type="checkbox" name="rememberme"
														class="ace" /> <span class="lbl"> 记住我</span>
													</label>

													<button type="submit"
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="icon-key"></i>登录
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>


									</div>


								</div>
							</div>
							<!-- /login-box -->


						</div>
						<!-- /position-relative -->
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
	</div>
	<!-- /.main-container -->
	<backpagejs> <script>
		$(function(){
			addBodyClass("login-layout");
		})
	</script> <script type="text/javascript">
		function show_box(id) {
			jQuery('.widget-box.visible').removeClass('visible');
			jQuery('#' + id).addClass('visible');
		}
		
	</script> </backpagejs>

</body>