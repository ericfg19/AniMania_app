<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<link href="/cssmenu.css" rel="stylesheet">

<div id="menuDemo">
<!--start CssMenu-->
<div id="cssmenu">
    <ul>
        <a class="navbar-brand" href="/">AniMania ©</a>
        <li class="active"><a href="/">Home</a></li>
			<c:if test="${not empty user}">
		      <li><a href="/usuario/listar">Usuários</a></li>
			      <c:if test="${user.admin}">
			      	<li><a href="/tutor/listar">Tutores</a></li>
			      </c:if>
			   <li><a href="/animal/listar">Animais</a></li>
			   <li><a href="/canino/listar">Canino</a></li>
			   <li><a href="/felino/listar">Felino</a></li>
			   <li><a href="/roedor/listar">Roedor</a></li>
			   <li><a href="/adocao/listar">Adoções</a></li>
			</c:if>	      
        
	    	<c:if test="${empty user}">
		      	<li><a href="/usuario"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
		      	<li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</c:if>

			<c:if test="${not empty user}">
	      		<li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout - ${user.nome}</a></li>
	      	</c:if>
    </ul>
    
	 
</div>
<!--end CssMenu-->
</div>