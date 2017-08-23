<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Navigation -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style>
.navbar-brand {
  padding: 0px;
}
.navbar-brand>img {
  height: 100%;
  padding: 5px;
  width: auto;
}
</style>
<div id="wrapper">
	<nav id="navmenu"  style="border-bottom: 2px #1491D4 solid;"  class="fontePadrao navbar  navbar-inverse navbar-fixed-top navbar-dark" role="navigation">
	<div class="container" >
		<div class="navbar-header" >
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"> </span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<button type="button" onclick="aparecerOuEsconderPesquisa();" class="glyphicon glyphicon-search navbar-toggle">
			</button>
			<a class="navbar-brand" href="#">
				<img src="<c:url value="/imgs/LogoSunVibesNormalBrancoAzulStroke.png"  />"/>
			</a>
			<div style="padding-top: 1.1em;padding-left: 1em;">
			</div>
		</div>
			<style type="text/css">
				.semfoco a:focus{
					color:black !important;
					background-color: white !important;
				}
		
			</style>
		
		<div class="collapse navbar-collapse fonteMenu"
			id="bs-example-navbar-collapse-1">
			<ul id="nav-menu-vivi"  class="nav navbar-nav menuCarrinho2">
				<li>
					<a class="glyphicon glyphicon-home" href="<c:url value="/home" />"></a>
				</li>
				<li>
					<a href="<c:url value="/contas" />">
						Cadastramento de Contas
					</a>
				</li>
				<li>
					<a href="<c:url value="/agendamentos" />">
						Agendamento de Transferência
					</a>
				</li>
			</ul>
		</div>
	</div>
</nav>