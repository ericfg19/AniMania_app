<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	
  	<link href="/main.css" rel="stylesheet">
	<link href="/cssmenu.css" rel="stylesheet">

<!-- MENU -->
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
		<div class="text-center">
		    <h1>Instituto Infnet</h1>
		    <h2>Análise e Desenvolvimento de Sistemas</h2>
		    <img src="/logo.png" alt="logo.png"/>
		    <hr />
		    <h3>Eric Fagundes Guimarães</h3>
		
		    <h3>ASSESSMENT</h3>
		    <h4>Desenvolvimento Java [22E2-22E3]</h4>
		    <h3>Professores</h3>
		    <h3>Elberth Soares</h3>
		    <h3>Luiz Paulo</h3>
		    <h3>Rubens Oliveira</h3>
		    <h6>23/09/2022 - Rio de Janeiro</h6>
		    
		</div>
		
		<center>
		<div class="panel-group">
				    <div class="panel panel-default">
				      <div class="panel-heading">
				        <h4 class="panel-title">
				          <a data-toggle="collapse" href="#collapse1">Diagrama de Classes</a>
				        </h4>
				      </div>
				      <div id="collapse1" class="panel-collapse collapse">
				        <div class="panel-body">
				        	
								<img src="/diagrama_classes.jpg" alt="diagrama_classes.jpg"/>
				        	
				        </div>
				        <div class="panel-body"><strong>Este projeto é apenas para fins acadêmicos.</strong>
				        </div>
				        <div class="panel-footer"><code>Idealizado para mostrar as competências de matérias da faculdade, seu uso comercial não é permitido.</code></div>
				      </div>
				    </div>
				  </div>
		</div>
		</center>
	
	<!-- FOOTER -->
    <footer>
    <c:import url="/WEB-INF/jsp/footer.jsp"/>
    </footer>