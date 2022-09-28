<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<h2>Gerenciamento de Adoções</h2>

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
		
		<form action="/adocao" method="get">
			<button type="submit" class="btn btn-default">Novo</button>
		</form>

		<p>Lista de adoções cadastradas: ${listagem.size()}</p>
		            
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <c:if test="${user.admin}">			     
		      	<th>ID</th>	     	
			  </c:if>
		      <th>Descrição</th>
		      <th>Data</th>
		      <th>Tutor</th>
		      <th>Animais</th>
		      <!--<th>Doação</th> -->
		      <th></th>
		      
		    </tr>
		  </thead>
		  
		  <tbody>
			<c:forEach var="ad" items="${listagem}">
			   <tr>
			   <c:if test="${user.admin}">			     
			     <td>${ad.id}</td>     	
			   </c:if>
			     <td>${ad.titulo}</td>
			     <td>
			     	<fmt:parseDate value="${ad.data}" pattern="yyyy-MM-dd" var="dataFormat" type="date"/>
					<fmt:formatDate pattern="dd/MM/yyyy" value="${dataFormat}"/>
				</td>
			     <td>${ad.tutor.nome}</td>
			     <td>${ad.animais.size()}</td>
			     <!--<td>Doação</td> -->
			     
			     <td><a href="/adocao/${ad.id}/excluir"><button class="btn btn-gray">Excluir</button></a></td>
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