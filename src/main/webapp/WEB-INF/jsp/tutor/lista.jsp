<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.Arrays"%>
<%@page import="br.edu.infnet.animaniaapp.model.domain.Tutor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>AniMania ©</title>
	<link href="/main.css" rel="stylesheet">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
		<h2>Cadastramento de Tutores</h2>

		<c:if test="${not empty msg}">	
		<div class="fade-out">
			<div class="alert alert-success">
				<strong>Successo!</strong> ${msg}
			</div>				
		</div>
		</c:if>
		
		<c:if test="${not empty msg2}">	
		<div class="fade-out">
			<div class="alert alert-warning">
				<strong>Falha!</strong> ${msg2}
			</div>				
		</div>	
		</c:if>
		
		<c:if test="${user.admin}">
			<form action="/tutor" method="get">
				<button type="submit" class="btn btn-default">Novo</button>
			</form>
		</c:if>

		<p>Tutores cadastrados: ${listagem.size()}</p>
		            
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th>ID</th>
		      <th>Nome</th>
		      <th>Cpf</th>
		      <th>Telefone</th>
		      <th>E-mail</th>
		      <th>Guarda</th>
			      <c:if test="${user.admin}">
			      	<th>Cadastrado por:</th>
			      	<th>Adoções</th>
			      </c:if>
		      <th></th>
		    </tr>
		  </thead>
		  
		  <tbody>
			<c:forEach var="t" items="${listagem}">
			   <tr>
			     <td>${t.id}</td>
			     <td>${t.nome}</td>
			     <td>${t.cpf}</td>
			     <td>${t.telefone}</td>
			     <td>${t.email}</td>
			     <td>${t.guarda}</td>
			     <c:if test="${user.admin}">
			     	<td>${t.usuario.nome}</td>
			     	
			     	<td></td>
			     </c:if>
			     <td><a href="/tutor/${t.id}/excluir"><button class="btn btn-gray">Excluir</button></a></td>
			   </tr>
			</c:forEach>
		  </tbody>
		</table>
	</div>
    <!-- FOOTER -->
    <footer>
    <c:import url="/WEB-INF/jsp/footer.jsp"/>
    </footer>
</body>
</html>