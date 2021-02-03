<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<jsp:include page="menu.html"></jsp:include>
<div class="card">
    <div class="card-header">
        <h2 class="mb-0">Veículos Cadastrados</h2>
    </div>
    <div class="card-body">
		<table class="table">
			<thead>
				<tr>
					<th>Marca</th>
					<th>Modelo</th>
					<th>Descrição</th>
					<th>Placa</th>
					<th>Ano</th>
					<th>Editar</th>
					<th>Excluir</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lstVeiculos}" var="item">
					<tr>
						<td>${item.marca}</td>
						<td>${item.modelo}</td>
						<td>${item.descricao}</td>
						<td>${item.placa}</td>
						<td>${item.ano}</td>
						<td><a href="VeiculoSV?action=editar&id=${item.id}">Editar</a></td>
						<td><a href="VeiculoSV?action=excluir&id=${item.id}">Excluir</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6">Quantidade de veículos cadastrados:
						${fn:length(lstVeiculos)}</td>

				</tr>
				<tr>
					<td colspan="6">
						<button class="btn btn-secondary" name="btn" value="Home" onclick="window.location.href='index.jsp'" >Home</button> 
						<button	class="btn btn-success" name="btn" value="Novo Veiculo" onclick="window.location.href='VeiculoSV?action=novo'" >Novo Veículo</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>
