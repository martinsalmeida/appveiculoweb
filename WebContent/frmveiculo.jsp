<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Garagem</title>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<jsp:include page="menu.html"></jsp:include>
<div class="card">
    <div class="card-header">
        <h2 class="mb-0">Cadastrar Veículo</h2>
    </div>
    <div class="card-body">
		<form action="VeiculoSV" method="post">
			<input type="hidden" name="action" value="salvar"/>
			<input type="hidden" name="id" value="${objVeiculo.id}"/>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label>Marca</label> <input class="form-control" type="text" name="marca"  value="${objVeiculo.marca}"/>
				</div>
				<div class="form-group col-md-6">
					<label>Modelo</label> <input class="form-control" type="text" name="modelo"  value="${objVeiculo.modelo}"/>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-9">
					<label>Descrição</label> <input class="form-control" type="text" name="descricao"  value="${objVeiculo.descricao}"/>
				</div>
				<div class="form-group col-md-2">
					<label>Placa</label> <input class="form-control" type="text" name="placa"  value="${objVeiculo.placa}"/>
				</div>
				<div class="form-group col-md-1">
					<label>Ano</label> <input class="form-control" type="text" name="ano"  value="${objVeiculo.ano}"/>
				</div>
			</div>
			<hr />
			<button class="btn btn-primary ml-3" type="submit">Salvar</button>
			<button class="btn btn-danger ml-1" type="reset">Cancelar</button>
			<button class="btn btn-secondary ml-1" type="button" onclick="window.location.href='index.jsp'">Home</button>
		</form>
		<hr />
		<c:if test="${msg != null}">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
	  			<strong>${msg}</strong>
			</div>
		</c:if>
	</div>
</div>
</body>
</html>