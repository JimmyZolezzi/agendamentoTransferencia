<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="table-responsive">
 <!-- Default panel contents -->
 	<table  class="table table-hover table-striped">
 		<thead>
 			<tr>
 				<th>Conta Origem</th>
 				<th>Conta Destino</th>
 				<th>Tipo</th>
 				<th>Valor taxa</th>
 				<th>Valor Valor</th>
 				<th>Data de cadastro</th>
 				<th>Agendado para</th>
 				<th>Status</th>
 			</tr>
 		</thead>
 		<tbody>
	  		 <c:forEach var="agendamento" items="${agendamentos}">
			  <tr>
			     <td>
			     	${agendamento.contaOrigem.numero}
			     </td>
			     <td>
			     	${agendamento.contaDestino.numero}
			     </td>
			     <td>
					${agendamento.tipo}			     	
			     </td>
			     <td>
			     	<fmt:formatNumber value="${agendamento.taxa}" type="currency"/>
			     </td>
			     <td>
			     	<fmt:formatNumber value="${agendamento.valor}" type="currency"/>
			     </td>
			     <td>
				     <fmt:formatDate value="${agendamento.dataCadastro}" pattern="dd/MM/yyyy" />
			     </td>
			     <td>
				     <fmt:formatDate value="${agendamento.dataAgendamento}" pattern="dd/MM/yyyy" />
			     </td>
			     <td>
					${agendamento.status}			     	
			     </td>
			  </tr>
	  		 </c:forEach>
 		 </tbody>	
 	</table>
 </div>	