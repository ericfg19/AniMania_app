<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<meta charset="ISO-8859-1">
<title>AniMania © - Central de Controle de Adoções</title>

<link href="/main.css" rel="stylesheet">
<link href="/cssmenu.css" rel="stylesheet">

</head>

<body>
	<!-- MENU -->
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	
	<!-- TEXTO -->
	
	<!-- IMAGEM -->
	
	<div class="container">
		<div class="och">
		  <div class="area1">
			<img src="animais.png">
		  </div>
		  
		  
		  <div class="area2">
		  		<c:if test="${empty user}">
		  		<nav class="nav navbar-nav navbar-right">
			      	<li><a href="/usuario"><button class="btn btn-gray"><span class="glyphicon glyphicon-user"></span> Sign Up</button></a></li>
			      	<li><a href="/privacy"><button class="btn"><span class="glyphicon glyphicon-info-sign"></span> Sobre</button></a></li>
		  		</nav>
				</c:if>
				
				<c:if test="${not empty user}">
	      			<span>BEM VINDO, ${user.nome}</span>
	      		</c:if>
	      		
	      		
				  <h2>Painel de Controle</h2>
				  
				  <div class="panel-group">
				    <div class="panel panel-default">
				      <div class="panel-heading">
				        <h4 class="panel-title">
				          <a data-toggle="collapse" href="#collapse1">Informações</a>
				        </h4>
				      </div>
				      <div id="collapse1" class="panel-collapse collapse">
				        <div class="panel-body"><strong>Este projeto é apenas para fins acadêmicos.</strong></div>
				        <div class="panel-footer"><code>Idealizado para mostrar as competências de matérias da faculdade, seu uso comercial não é permitido.</code></div>
				      </div>
				    </div>
				  </div>
				
	      		
		  </div>
		  
		  <div class="area3">
		  </div>
		  
		</div>
	</div>
	

    <!-- FOOTER -->
    <footer>
    <c:import url="/WEB-INF/jsp/footer.jsp"/>
    </footer>
    
    
    <script src="~/lib/jquery/dist/jquery.min.js"></script>
    <script src="~/lib/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    
</body>
</html>