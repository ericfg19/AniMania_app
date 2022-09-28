<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>AniMania © - Cadastro de Adoção</title>
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
	<h2>Registrar nova Adoção</h2>

		<form action="/adocao/incluir" method="post">
		
			<div class="form-group">
				<label>Título:</label>		
				<input type="text" value="Primeira Adoção" name="titulo" class="form-control">
			</div>
			
			<div class="form-group">
				<label>Data:</label>		
				<input type="datetime-local" name="dtAdocao" class="form-control">
			</div>

			<div class="form-group">
				
				<c:if test="${not empty tutores}">

				<label>Tutor:</label>	
				
					  <select class="form-control" name="tutor">
						  <c:forEach var="t" items="${tutores}">
						    <option value="${t.id}">${t.nome}</option>
						  </c:forEach>
					  </select>
				</c:if>
				  
				  <c:if test="${empty tutores}">
					<label>Não existem tutores cadastrados!</label>
					<c:set var="botao" value="disabled" />
					
				  </c:if>

				
			</div>
			
			<div class="form-group">
				<c:if test="${not empty animais}">			
					<label>Animal:</label>		
						<c:forEach var="a" items="${animais}">
							<div class="checkbox">
							  <label><input type="checkbox" name="animais" value="${a.id}"> ${a.nome}</label>
							</div>	
						</c:forEach>
				</c:if>
					
					<c:if test="${empty animais}">
						<label>Não existem animais cadastrados!</label>
						<c:set var="botao" value="disabled" />
					</c:if>
			</div>

			

			<button ${botao} value="disabled" type="submit" class="btn btn-default">Cadastrar</button> <button class="btn btn-gray" onclick="goBack()">Voltar</button>
		</form>
		<br>
	</div>
	
    <!-- FOOTER -->
    <footer>
    <c:import url="/WEB-INF/jsp/footer.jsp"/>
    </footer>
</body>
</html>