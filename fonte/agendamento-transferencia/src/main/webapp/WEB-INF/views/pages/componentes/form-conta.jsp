<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form:form method="post" id="formConta" modelAttribute="formConta" action="${action}" onsubmit="onSubmitFormCadastroCliente();">
<spring:url var="action" value="/contas" />
  <c:url var="home" value="/" scope="request" />	
  <input id="home" type="hidden" value="${home}"/>
  <spring:bind path="conta.numero">
	  <div class="form-group ${status.error?'has-error':''} ">
	    <label for="conta.numero">Numero</label>
	    <form:input class="form-control" onkeyup="formataValorConta(this)" path="conta.numero"/>
	    <c:if test="${status.error}">
		    <label class="control-label" for="conta.numero"><form:errors path="conta.numero"/></label>
	    </c:if>
	  </div>
  </spring:bind>
  <spring:bind path="conta.dono">
	  <div class="form-group ${status.error?'has-error':''} ">
	    <label for="conta.dono">Nome Completo</label>
	    <form:input class="form-control" path="conta.dono"/>
	    <c:if test="${status.error}">
		    <label class="control-label" for="conta.dono"><form:errors path="conta.dono"/></label>
	    </c:if>
	  </div>
  </spring:bind>
  <spring:bind path="saldo">
	  <div class="form-group ${status.error?'has-error':''} ">
	    <label for="conta.dono">Saldo</label>
	    <form:input class="form-control" onkeyup="formataValor(this)"  path="saldo"/>
	    <c:if test="${status.error}">
		    <label class="control-label" for="saldo"><form:errors path="saldo"/></label>
	    </c:if>
	  </div>
  </spring:bind>
  <form:button>Cadastrar</form:button>
</form:form>
<c:if test="${not empty resultado}">
	<br/>
	<div class="alert ${resultado eq 'SUCESSO'?'alert-success':'alert-danger'}">
	 	${mensagem}
	</div>
</c:if>
<script>



</script>  