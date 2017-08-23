<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<spring:url var="action" value="/agendamentos" />
<form:form method="post" id="formAgendamentoTransferencia" modelAttribute="formAgendamentoTransferencia" action="${action}" onsubmit="onSubmitFormCadastroCliente();">
  <c:url var="home" value="/" scope="request" />	
  <input id="home" type="hidden" value="${home}"/>
  <spring:bind path="numeroContaOrigem">
	  <div class="form-group ${status.error?'has-error':''} ">
	    <label for="numeroContaDestino">Conta de Origem </label>

	    <form:select path="numeroContaOrigem"  id="contaOrigem" class="form-control">
   			<option value=''>selecionar</option>
   			<form:options  items="${contas}" itemLabel="numero" itemValue="numero"  />
		</form:select>

	    <c:if test="${status.error}">
		    <label class="control-label" for="numeroContaOrigem">
		    	<form:errors path="numeroContaOrigem"/>
		    </label>
	    </c:if>
	  </div>
  </spring:bind>
  <spring:bind path="numeroContaDestino">
	  <div class="form-group ${status.error?'has-error':''} ">
	    <label for="numeroContaDestino">Conta de Destino </label>
   	    <form:select path="numeroContaDestino"  id="contaDestino" class="form-control">
   			<option value="">selecionar</option>
   			<form:options  items="${contas}" itemLabel="numero" itemValue="numero"  />
		</form:select>
	    <c:if test="${status.error}">
		    <label class="control-label" for="numeroContaDestino">
		    	<form:errors path="numeroContaDestino"/>
		    </label>
	    </c:if>
	  </div>
  </spring:bind>
  <spring:bind path="tipoTransferencia">
	  <div class="form-group ${status.error?'has-error':''} ">
	    <label for="tipoTransferencia">Tipo Transferencia </label>
	    <form:select path="tipoTransferencia"  id="tipoTransferencia" class="form-control">
   			<option value="">selecionar</option>
   			<form:options  items="${tipoTransacoes}"  />
		</form:select>
	    <c:if test="${status.error}">
		    <label class="control-label" for="tipoTransferencia">
		    	<form:errors path="tipoTransferencia"/>
		    </label>
	    </c:if>
	  </div>
  </spring:bind>
  <spring:bind path="dataAgendamento">
	  <div class="dataAgendamento ${status.error?'has-error':''} ">
	    <label for="tipoTransferencia">Data Agendamento </label>
	    <form:input class="form-control"  path="dataAgendamento" data-date-format="dd/mm/yyyy"  placeholder="dd/MM/aaaa" />
	    <c:if test="${status.error}">
		    <label class="control-label" for="dataAgendamento">
		    	<form:errors path="dataAgendamento"/>
		    </label>
	    </c:if>
	  </div>
  </spring:bind>
  <spring:bind path="valor">
	  <div class="form-group ${status.error?'has-error':''} ">
	    <label for="valor">Valor </label>
	    <form:input class="form-control" onkeyup="formataValor(this)"  path="valor"/>
	    <c:if test="${status.error}">
		    <label class="control-label" for="valor">
		    	<form:errors path="valor"/>
		    </label>
	    </c:if>
	  </div>
  </spring:bind>
  <form:button>Agendar</form:button>

</form:form>
<c:if test="${not empty resultado}">
	<br/>
	<div class="alert ${resultado eq 'SUCESSO'?'alert-success':'alert-danger'}">
	 	${mensagem}
	</div>
</c:if>
<script>
 $( function() {
   $( "#dataAgendamento" ).datepicker({
   	  dateFormat: "dd/mm/yy"
   });
 } );
 </script>
