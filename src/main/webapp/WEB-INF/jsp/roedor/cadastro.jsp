<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>AniMania �</title>
	<link href="/main.css" rel="stylesheet">
</head>

<script>
function goBack() {
    window.history.back()
}
</script>

<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	<h2>Adicionar novo Roedor</h2>

		<form action="/roedor/incluir" method="post">
		
			<div class="form-group">
				<label>Nome:</label>		
				<input type="text" value="Ratatouille" name="nome" class="form-control">
			</div>

			<div class="form-group">
				<label>Custo de servi�os:</label>		
				<input type="text" value="300" name="valor" class="form-control"> 
			</div>

			<div class="form-group">
				<label>Idade:</label>		
				<input type="text" value="1" name="idade" class="form-control">
			</div>

			<div class="form-group">				
				<label>Castrado:</label>				
				<input type="radio" name="castrado" value="true" checked> Sim
				<input type="radio" name="castrado" value="false"> N�o
			</div>
			
			<div class="form-group">				
				<label>G�nero:</label>				
				<input type="radio" name="genero" value="true" checked> Macho
				<input type="radio" name="genero" value="false"> F�mea
			</div>

			<div class="form-group">
				<label>Peso (kg):</label>		
				<input type="text" value="0.6" name="peso" class="form-control">
			</div>

			<div class="form-group">
				<label>Ra�a:</label>			
				<select class="select" name="raca" class="form-control">
					<option selected>Hamster</option>
					<option>Chinchila</option>
					<option>Coelho</option>
					<option>Porquinho-da-India</option>
				</select>
			</div>

			<button type="submit" class="btn btn-default">Cadastrar</button> <button class="btn btn-gray" onclick="goBack()">Voltar</button>
		</form>
		<br>

	</div>
	
	<!-- FOOTER -->
    <footer>
    <c:import url="/WEB-INF/jsp/footer.jsp"/>
    </footer>
    
</body>
</html>