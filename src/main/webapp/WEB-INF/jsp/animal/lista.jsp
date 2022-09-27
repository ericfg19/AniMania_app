<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>AniMania ©</title>
	<link href="/main.css" rel="stylesheet">
	<link href="/cssmenu.css" rel="stylesheet">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
		<h2>Gerenciamento de Animais</h2>

		<c:if test="${not empty msg}">		
			<div class="alert alert-success">
				<strong>Successo!</strong> ${msg}
			</div>				
		</c:if>
		
		<c:if test="${not empty msg2}">		
			<div class="alert alert-warning">
				<strong>Falha!</strong> ${msg2}
			</div>				
		</c:if>

		<p>Total de animais cadastrados: ${listagem.size()}</p>
		            
		<table class="table table-striped">
		  <thead>
		    <tr>
		    <c:if test="${user.admin}">			     
		      <th>ID</th>	     	
			</c:if>
		      <th>Nome</th>
		      <th>Custos</th>
		      <th>Raça</th>
		      <th></th>
		    </tr>
		  </thead>
		  
		  <tbody>
			<c:forEach var="p" items="${listagem}">
			   <tr>
			   <c:if test="${user.admin}">			     	     	
			     <td>${p.id}</td>
			   </c:if>
			     <td>${p.nome}</td>
			     <td>R$ ${p.valor}</td>
			     <td>${p.raca}</td>
			     <td><a href="/animal/${p.id}/excluir"><button class="btn btn-gray">Excluir</button></a></td>
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