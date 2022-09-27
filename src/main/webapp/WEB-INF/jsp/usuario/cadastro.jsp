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
		<form action="/cep" class="form-inline" method="post">
			<div class="form-group">
				<label>Cep:</label>		
				<input type="text" value="" name="cep" class="form-control">
			</div>
		
			<button type="submit" class="btn btn-dark">Buscar</button>
		</form>
		
		<hr>
	
		<form action="/usuario/incluir" method="post">
		
		<div class="container3">
		  <div class="cadastro1">
			<div class="form-group">
				<label>Nome:</label>		
				<input type="text" value="Teste Dev" name="nome" class="form-control">
			</div>

			<div class="form-group">			
				<label>E-mail:</label>			
				<input type="email" value="teste@dev.com" name="email" class="form-control">
			</div>
			
			<div class="form-group">			
				<label>Telefone:</label>			
				<input type="text" value="21-99797-3000" name="telefone" class="form-control">
			</div>

			<div class="form-group">
				<label>Senha:</label>		
				<input type="password" value="123" name="senha" class="form-control">
			</div>
			
			
			<c:if test="${user.admin}">
				<div class="form-group">				
					<label>Administrador:</label>				
					<input type="radio" name="admin" value="true" checked> Sim
					<input type="radio" name="admin" value="false"> Não
				</div>
			</c:if>
		  
		  </div>
		  <div class="cadastro2">
		  
			<c:import url="/WEB-INF/jsp/endereco.jsp"/>
		  
		  </div>
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