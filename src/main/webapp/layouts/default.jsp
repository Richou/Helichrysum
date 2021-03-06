<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ page isELIgnored ="false" %>
<!doctype html>
<html lang="fr" data-ng-app="heanoriaApp">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<head>
	<meta charset="UTF-8" />
    <title><decorator:title /></title>
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
	
	<link rel="stylesheet" type="text/css" href="${contextPath}/styles/base.css" />
	
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="${contextPath}/js/libs/ui-bootstrap-tpls-0.11.0.min.js"></script>
	<script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.10.0.js"></script>
	
	<script src="${contextPath}/js/heanoria/Core.js"></script>
	<decorator:head></decorator:head>
	<script type="text/javascript">
		heanoria.constant('ROOT_URL', '${contextPath}');
	</script>
</head>

<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="container-fluid">
			<div class="navbar-header">
				<img src="${contextPath}/img/spring.jpg" alt="img" />
				<label>Google Appengine - Spring MVC - AngularJS</label>
			</div>
		</div>
	</div>
</nav>
<div class="container">
<decorator:body></decorator:body>
</div>
</body>
</html>