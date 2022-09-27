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

		<form action="/tutor/incluir" method="post">
		
			<div class="form-group">
				<label>Nome:</label>		
				<input type="text" value="Tom Hanks" name="nome" class="form-control">
			</div>

			<div class="form-group">
				<label>CPF:</label>		
				<input type="text" value="098765432-11" name="cpf" class="form-control">
			</div>

			<div class="form-group">			
				<label>Email:</label>			
				<input type="email" value="th2022@gmail.com" name="email" class="form-control">
			</div>
			
			<div class="form-group">			
				<label>Telefone:</label>			
				<input type="text" value="21-99797-5000" name="telefone" class="form-control">
			</div>
			  
			<div class="form-group">
				<label>Guarda:</label>			
				<select class="select" name="guarda" class="form-control">
					<option>Lar temporário</option>
					<option selected>Adoção Definitiva</option>
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