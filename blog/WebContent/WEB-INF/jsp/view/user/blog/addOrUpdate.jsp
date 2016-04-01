<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="blog" uri="http://www.wuwenyao.cn/blog/tld"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<c:url value="/user/blog/list" var="url_myBlog"/>
<!DOCTYPE html>
<html>
<head>
<title>我的博客</title>
<link href="<c:url value='/static/css/blog.css'/>" rel="stylesheet">
<link href="<c:url value='/static/css/wysiwyg.css'/>" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="blog-header">
			<h1 class="blog-title">撰写博客</h1>
		</div>
		<form id="form" role="form" data-toggle="validator" >
			<input type="hidden" name="id" value="${blog.id }">
			<div class="form-group">
				<label for="title">标题</label>
				<input id="ipt_title" type="text" class="form-control" value="${blog.title }"
					name="title" maxlength="20" required="required"/>
				<div class="help-block with-errors"></div>	
			</div>
			<div class="form-group">
				<label for="title">简介</label> 
				<textarea id="ipt_brief_intro" class="form-control" 
					 name="briefIntro" rows="5" required="required">${blog.briefIntro }</textarea>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group">
				<label for="keyword">关键字</label>
				<input id="ipt_keyword" type="text" class="form-control" pattern="^([\u4E00-\u9FFFA-Za-z0-9]+\s*)+$"
					name="keywords" placeholder="以空格分割" required="required" value="${blog:listCombine(blog.keyword,' ') }">
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group">
			<div class="btn-toolbar" data-role="editor-toolbar"
				data-target="#editor">
				<div class="btn-group">
					<a class="btn btn-default dropdown-toggle" data-toggle="dropdown" title="字体大小"><i class="fa fa-text-height"></i>&nbsp;<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a data-edit="fontSize 5" class="fs-Five">大</a></li>
						<li><a data-edit="fontSize 3" class="fs-Three">一般</a></li>
						<li><a data-edit="fontSize 1" class="fs-One">小</a></li>
					</ul>
				</div>
				<div class="btn-group">
					<a class="btn btn-default dropdown-toggle" data-toggle="dropdown" title="文本高亮颜色"><i class="fa fa-paint-brush"></i>&nbsp;<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<p>&nbsp;&nbsp;&nbsp;文本高亮颜色:</p>
                        <li><a data-edit="backColor #00FFFF">蓝</a></li>
						<li><a data-edit="backColor #00FF00">绿</a></li>
						<li><a data-edit="backColor #FF7F00">橙</a></li>
						<li><a data-edit="backColor #FF0000">红</a></li>
						<li><a data-edit="backColor #FFFF00">黄</a></li>
					</ul>
				</div>
				<div class="btn-group">
					<a class="btn btn-default dropdown-toggle" data-toggle="dropdown" title="字体颜色"><i class="fa fa-font"></i>&nbsp;<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<p>&nbsp;&nbsp;&nbsp;字体颜色:</p>
						<li><a data-edit="foreColor #000000">黑</a></li>
                        <li><a data-edit="foreColor #0000FF">蓝</a></li>
                        <li><a data-edit="foreColor #30AD23">绿</a></li>
						<li><a data-edit="foreColor #FF7F00">橙</a></li>
						<li><a data-edit="foreColor #FF0000">红</a></li>
						<li><a data-edit="foreColor #FFFF00">黄</a></li>
					</ul>
				</div>
				<div class="btn-group">
					<a class="btn btn-default" data-edit="bold" title="加粗 (Ctrl/Cmd+B)"><i class="fa fa-bold"></i></a>
					<a class="btn btn-default" data-edit="italic" title="倾斜 (Ctrl/Cmd+I)"><i class="fa fa-italic"></i></a>
					<a class="btn btn-default" data-edit="strikethrough" title="删除线"><i class="fa fa-strikethrough"></i></a>
					<a class="btn btn-default" data-edit="underline" title="下划线 (Ctrl/Cmd+U)"><i class="fa fa-underline"></i></a>
				</div>
				<div class="btn-group">
					<a class="btn btn-default" data-edit="insertunorderedlist" title="符号列表"><i class="fa fa-list-ul"></i></a>
					<a class="btn btn-default" data-edit="insertorderedlist" title="数字列表"><i class="fa fa-list-ol"></i></a>
					<a class="btn btn-default" data-edit="outdent" title="减少缩进 (Shift+Tab)"><i class="fa fa-outdent"></i></a>
					<a class="btn btn-default" data-edit="indent" title="缩进 (Tab)"><i class="fa fa-indent"></i></a>
				</div>
				<div class="btn-group">
					<a class="btn btn-default" data-edit="justifyleft" title="左对齐 (Ctrl/Cmd+L)"><i class="fa fa-align-left"></i></a>
					<a class="btn btn-default" data-edit="justifycenter" title="居中 (Ctrl/Cmd+E)"><i class="fa fa-align-center"></i></a>
					<a class="btn btn-default" data-edit="justifyright" title="右对齐 (Ctrl/Cmd+R)"><i class="fa fa-align-right"></i></a>
					<a class="btn btn-default" data-edit="justifyfull" title="两端对其 (Ctrl/Cmd+J)"><i class="fa fa-align-justify"></i></a>
				</div>
				<div class="btn-group">
					<a class="btn btn-default dropdown-toggle" data-toggle="dropdown" title="设置链接"><i class="fa fa-link"></i></a>
					<div class="dropdown-menu input-append">
						<input placeholder="链接地址" type="text" data-edit="createLink" />
						<button class="btn" type="button">添加</button>
					</div>
				</div>
				<div class="btn-group">
					<a class="btn btn-default" data-edit="unlink" title="移除链接"><i class="fa fa-unlink"></i></a>
					<span class="btn btn-default" title="添加图片 (可拖拽)" id="pictureBtn"> <i class="fa fa-picture-o"></i>
						<input class="imgUpload" type="file" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" />
					</span>
				</div>
				<div class="btn-group">
					<a class="btn btn-default" data-edit="undo" title="撤销 (Ctrl/Cmd+Z)"><i class="fa fa-undo"></i></a>
					<a class="btn btn-default" data-edit="redo" title="取消撤销 (Ctrl/Cmd+Y)"><i class="fa fa-repeat"></i></a>
				</div>
			</div>
			
			<div id="editor"  data-placeholder="请在这里填写博客内容">${blog.context }</div>
			<input type="hidden" id="ipt_context"  name="context" value="${blog.context }">
			<div class="help-block with-errors"></div>
			</div>
			<button type="submit" class="btn btn-default">保存</button>
		</form>
		
	</div>
	<!-- /.container -->

	<!-- 页面的js，放置在页面底部 -->
	<backpagejs>
	<script src="<c:url value='/static/js/plunge/jquery/hotkey/jquery.hotkeys.js'/>"></script>
	<script src="<c:url value='/static/js/plunge/bootstrap/wysiwyg/bootstrap-wysiwyg.min.js'/>"></script>
	<script src="<c:url value='/static/js/plunge/bootstrap/validation/validator.js'/>"></script>
	<script>
	$(function(){
		$('#editor').wysiwyg();
		$('#editor').on('change', function(){
		    $("#ipt_context").val($(this).html());
		});
		$("#editor").on('blur', function(){
			var $context = $(this);
			var context = $context.html();
			if (context.trim().length != 0){
				$context.removeClass("has-error");
			}else{
				$context.addClass("has-error");
			}
		})
		$(".dropdown-menu > input").click(function (e) {
			e.stopPropagation();
		});
		function addBlog(){
			$.post("",$("#form").serialize(),function(data){
				callBackDialog(data.mes, function(){
					location.href = "${url_myBlog}";
				});
			})
		}

		$('#form').validator().on('submit', function (e) {
			if (e.isDefaultPrevented()) {
				check.checkAll();
			    return false;
			  } 
			if (!check.checkAll()){
				 return false;
			 }
			 addBlog();
			 //阻止默认的post行为，使用ajax post;
			 return false;
		})
	});
	
	
	</script> 
	<script>
	var check = {};
	check.checkAll = function (){
		if (!check.checkContent()){
			return false;
		}
		return true;
	}
	check.checkContent = function(){
		var content = $("#ipt_context").val();
		if (content.trim().length == 0){
			$("#editor").addClass("has-error");
			return false;
		}
		$("#editor").removeClass("has-error");
		return true;
	}
	</script>
	</backpagejs>
</body>