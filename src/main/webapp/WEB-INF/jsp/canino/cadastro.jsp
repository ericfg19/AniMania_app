<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>AniMania ©</title>
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
	<h2>Adicionar novo Canino</h2>

		<form action="/canino/incluir" method="post">
		
			<div class="form-group">
				<label>Nome:</label>		
				<input type="text" value="Neymar" name="nome" class="form-control">
			</div>

			<div class="form-group">
				<label>Custo de serviços:</label>		
				<input type="text" value="500" name="valor" class="form-control"> 
			</div>

			<div class="form-group">
				<label>Idade:</label>		
				<input type="text" value="4" name="idade" class="form-control">
			</div>

			<div class="form-group">				
				<label>Castrado:</label>				
				<input type="radio" name="castrado" value="true" checked> Sim
				<input type="radio" name="castrado" value="false"> Não
			</div>
			
			<div class="form-group">				
				<label>Gênero:</label>				
				<input type="radio" name="genero" value="true" checked> Macho
				<input type="radio" name="genero" value="false"> Fêmea
			</div>

			<div class="form-group">
				<label>Peso (kg):</label>		
				<input type="text" value="28" name="peso" class="form-control">
			</div>

			<div class="form-group">
				<label>Raça:</label>		
				<select class="select" name="raca" class="form-control">
					<option selected>SRD</option>
					<option>Border Collie</option>
					<option>Boxer</option>
					<option>Bulldog Francês</option>
					<option>Bulldog Inglês</option>
					<option>Dobermann</option>
					<option>Dogue Alemão</option>
					<option>Golden Retriever</option>
					<option>Pastor Alemão</option>
					<option>Rottweiler</option>
					<option>Shih Tzu</option>
					<option>Yorkshire</option>
					<option>Outro</option>
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