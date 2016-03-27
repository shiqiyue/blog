<%@tag pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<script src="${ctx }/static/js/fakeLoader/js/fakeLoader.min.js"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="${ctx }/static/js/fakeLoader/css/fakeLoader.min.css">

<script type="text/javascript">
	function showLoading() {
		/**显示加载界面*/
		var $fakeLoader = $("#fakeLoader");
		if ($fakeLoader.data("loaded") !== true) {
			$fakeLoader.fakeLoader({
				bgColor : "#000",
				imagePath : "${ctx}/static/images/aloading.gif"
			});
			$fakeLoader.data("loaded", true);
		} else {
			$fakeLoader.show();
		}
	}
	function hideLoading() {
		$("#fakeLoader").fadeOut();
	}
	function showProgressBar(value) {
		value = value || 0;
		var $progressBar = $("#progressBar");
		var $progressBarContainer = $("#progressBarContainer");
		$progressBar.progressbar({
			value : value
		});
		if ($progressBarContainer.data("loaded") !== true) {
			$progressBarContainer.fakeLoader({
				bgColor : "#000"
			});
			$progressBarContainer.data("loaded", true);
		} else {
			$progressBarContainer.show();
			centerLoader();
		}
	}
	function hideProgressBar() {
		var $progressBarContainer = $("#progressBarContainer");
		$progressBarContainer.fadeOut();
	}
	function centerLoader() {
		var $progressBar = $("#progressBar");
		var winW = $(window).width();
		var winH = $(window).height();
		var spinnerW = 100;
		var spinnerH = 20;
		$progressBar.css({
			'position' : 'absolute',
			'left' : (winW / 2) - (spinnerW / 2),
			'top' : (winH / 2) - (spinnerH / 2),
			'width' : spinnerW,
			'height' : spinnerH
		});

	}

	$(function() {
		$(window).load(function() {
			centerLoader();
			$(window).resize(function() {
				centerLoader();
			});
		});
	});
</script>
<div id="fakeLoader"></div>
<div id="progressBarContainer">
	<div id="progressBar"></div>
</div>