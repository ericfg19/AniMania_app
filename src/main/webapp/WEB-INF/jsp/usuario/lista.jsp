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
	<title>AniMania © - </title>
	<link href="/main.css" rel="stylesheet">
	
<script>
function myFunction() {
  var x = document.getElementById("pass");
  if (x.id === "pass") {
    x.id = "";
  } else {
    x.id = "pass";
  }
}
</script>
</head>

<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
		<h2>Gerenciamento de usuários</h2>

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
			<form action="/usuario" method="get">
				<button type="submit" class="btn btn-default">Novo</button>
			</form>
		</c:if>
		
		<p>Total de usuários cadastrados: ${listagem.size()}</p>
		<c:if test="${user.admin}">
		<input type="checkbox" onclick="myFunction()"> Mostrar Senhas
		</c:if>
		            
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <c:if test="${user.admin}">
			    <th>ID</th>
		      </c:if>
		      <th>Nome</th>
		      <th>E-mail</th>
		      <th>Telefone</th>
		      <th>Administrador</th>
		      
		      <c:if test="${user.admin}">
				  <th>Senha</th>
			      <th>Endereço</th>
		      	  <th>Adotantes</th>
		      	  <th></th>
		      </c:if>
		      
		    </tr>
		  </thead>
		  
		  <tbody>
			<c:forEach var="u" items="${listagem}">
			   <tr>
			   <c:if test="${user.admin}">		       
			     <td>${u.id}</td>
		       </c:if>
			     <td>${u.nome}</td>
			     <td>${u.email}</td>
			     <td>${u.telefone}</td>
			     <td><c:if test="${u.admin == true}">Sim</c:if><c:if test="${u.admin == false}">Não</c:if></td>
			     <c:if test="${user.admin}">
			     
			     
				     <td><span id="pass">${u.senha}</span>
				     </td>
				     
				     <td>${u.endereco.bairro}-${u.endereco.uf}</td>       
			         <td>${u.tutores.size()}</td>
		         </c:if>
			        
			     <c:if test="${user.admin}">
			     	<td>
			     	<c:choose>
			     		<c:when test="${user.id != u.id}">
					     	<a href="/usuario/${u.id}/editar"><button class="btn btn-gray">Editar</button></a> 
				     		<a href="/usuario/${u.id}/excluir"><button class="btn btn-gray">Excluir</button></a>
			     		</c:when>
			     	</c:choose>
			     	</td>
			     </c:if>
			   </tr>
			</c:forEach>
		  </tbody>
		</table>
	</div>
	<script>

	</script>
	
	<!-- FOOTER -->
    <footer>
    <c:import url="/WEB-INF/jsp/footer.jsp"/>
    </footer>
    
</body>
</html>