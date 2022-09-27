<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="ISO-8859-1">
	<title>App - Cadastro</title>
	<link href="/main.css" rel="stylesheet">
</head>
<style>
body {
  background-image: url('https://efg-infnetbuckets3.s3.amazonaws.com/wall.jpg');
}

</style>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<div class="container">
		<h2>Autenticação</h2>

		<c:if test="${not empty msg}">
			<div class="alert alert-warning">
				<strong>Atenção!</strong> ${msg}
			</div>		
		</c:if>
		<hr>
	  <form action="/login" method="post">
	    <div class="col-mt-5">
	      <label>E-mail:</label>
	      <input type="email" class="form-control" placeholder="Entre com o seu e-mail" name="email" value="master@animania.com">
	    </div>
		
	    <div class="col-mt-5">
	      <label>Senha:</label>
	      <input type="password" class="form-control" placeholder="Entre com a sua senha" name="senha" value="12345">
	    </div>
		<br>
	    <button type="submit" class="btn btn-primary">Acessar</button>
	  </form>
	</div>

	<!-- FOOTER -->
    <footer>
    <c:import url="/WEB-INF/jsp/footer.jsp"/>
    </footer>	

</body>
</html>