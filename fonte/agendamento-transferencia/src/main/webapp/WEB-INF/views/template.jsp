<!DOCTYPE html>
<html lang="pt">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<sec:csrfMetaTags />
<title>
		${title}
</title>

<!-- Bootstrap Core CSS -->

<link rel="stylesheet" type="text/css" href="<c:url value="/css/theme-novo2.css" />" >
<link rel="stylesheet" type="text/css" href="<c:url value="/css/site/zoomImagem.css" />" >
<link rel="stylesheet" type="text/css" href="<c:url value="/css/site/scrollthumbsImage.css" />" >
<!-- Custom CSS -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/heroic-features.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/site/login-modal.css" />">
<script src="<c:url value="/js/site/sonic.js" />"></script>
<script src="<c:url value="/js/site/loading.js" />"></script>
<script src="<c:url value="/js/angular.min.js"  />"></script>
<script src="<c:url value="/js/jquery.js" />"></script>
<script src="<c:url value="/js/site/jquery-ui.js"/>"></script>
<script src="<c:url value="/js/jquery.elevatezoom.js"/>"></script>
<link rel="stylesheet" href="<c:url value="/css/site/jquery-ui.css" />">
<c:url var="home" value="/" scope="request" />
<link rel="stylesheet" type="text/css" href="<c:url value="/css/site/vivi-moda-praia.css" />" >
</head>
<body class="textoVivi">
<div id="resultadoLoading" class=""></div> 
<input id="home" type="hidden" value="${home}"/>
	<jsp:include page="header.jsp" />
	<!-- Page Content -->
	<div class="container">
		<div id="conteudo">
			<jsp:include page="${partial}" />
		</div>
		<jsp:include page="footer.jsp" />
		<hr>
	</div>
	<script src="<c:url value="/js/site/agendamento-transferencia.js" />"></script>
</body>
</html>
