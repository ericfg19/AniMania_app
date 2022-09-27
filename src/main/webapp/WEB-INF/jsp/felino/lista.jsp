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
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
		<h2>Cadastramento de Felinos</h2>

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
		
		<form action="/felino" method="get">
			<button type="submit" class="btn btn-default">Novo</button>
		</form>

		<p>Lista de animais felinos cadastrados: ${listagem.size()}</p>
		            
		<table class="table table-striped">
		  <thead>
		    <tr>
		    <c:if test="${user.admin}">			     
		      <th>ID</th>	     	
			</c:if>
		      <th>Nome</th>
		      <th>Custos</th>
		      <th>Idade</th>
		      <th>Castrado</th>
		      <th>Gênero</th>
		      <th>Peso(kg)</th>
		      <th>Raça</th>
		    </tr>
		  </thead>
		  
		  <tbody>
			<c:forEach var="f" items="${listagem}">
			   <tr>
			   <c:if test="${user.admin}">			     
			     <td>${f.id}</td>			     	
			   </c:if>
			     <td>${f.nome}</td>
			     <td>R$ ${f.valor}</td>
			     <td>${f.idade}</td>
			     <td><c:if test="${f.castrado == true}">Sim</c:if><c:if test="${f.castrado == false}">Não</c:if></td>
			     <td><c:if test="${f.genero == true}">Macho</c:if><c:if test="${f.genero == false}">Fêmea</c:if></td>
			     <td>${f.peso}</td>
			     <td>${f.raca}</td>
			     <td><a href="/felino/${f.id}/excluir"><button class="btn btn-gray">Excluir</button></a></td>
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