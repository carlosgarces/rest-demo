<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>AngularJS Rest Service Demo</title>
<style>
.nombre.ng-valid {
	background-color: lightgreen;
}

.nombre.ng-dirty.ng-invalid-required {
	background-color: red;
}

.nombre.ng-dirty.ng-invalid-minlength {
	background-color: yellow;
}

.email.ng-valid {
	background-color: lightgreen;
}

.email.ng-dirty.ng-invalid-required {
	background-color: red;
}

.email.ng-dirty.ng-invalid-email {
	background-color: yellow;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body ng-app="myApp" class="ng-cloak">
	<div class="generic-container"
		ng-controller="EmpleadoController as ctrl">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Registro de Empleado</span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">
					<input type="hidden" ng-model="ctrl.empleado.id" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.empleado.nombre" name=uname
									class="nombre form-control input-sm"
									placeholder="Enter your name" required ng-minlength="3" />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.uname.$error.required">Campo requerido</span> 
									<span ng-show="myForm.uname.$error.minlength">Longitud minina es de 3</span> 
									<span ng-show="myForm.uname.$invalid">El valor es inváido</span>
								</div>
							</div>
						</div>
					</div>


					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Apellido 1</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.empleado.apellido1"
									class="form-control input-sm"
									placeholder="Indique el apellido 1. [This field is validation free]" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Apellido
								2</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.empleado.apellido2"
									name="apellido2" class="apellido2 form-control input-sm"
									placeholder="Enter your apellido2" required />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.apellido2.$error.required">This is
										a required field</span> <span ng-show="myForm.apellido2.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Fecha ingreso</label>
							<div class="col-md-7">
								<input type="date" ng-model="ctrl.empleado.ingreso"
									name="ingreso" class="ingreso form-control input-sm"
									placeholder="Enter your fecha ingreso" required />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.ingreso.$error.required">This is
										a required field</span> <span ng-show="myForm.ingreso.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Salario</label>
							<div class="col-md-7">
								<input type="number" ng-model="ctrl.empleado.sueldo"
									name="sueldo" class="sueldo form-control input-sm"
									placeholder="Enter your salario" required />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.sueldo.$error.required">This is
										a required field</span> <span ng-show="myForm.sueldo.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit"
								value="{{!ctrl.empleado.id ? 'Add' : 'Update'}}"
								class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
							<button type="button" ng-click="ctrl.reset()"
								class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset
								Form</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Empleados </span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID.</th>
							<th>Name</th>
							<th>Apellido 1</th>
							<th>Apellido 2</th>
							<th>Fecha ingreso</th>
							<th>Salario</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="u in ctrl.empleados">
							<td><span ng-bind="u.id"></span></td>
							<td><span ng-bind="u.nombre"></span></td>
							<td><span ng-bind="u.apellido1"></span></td>
							<td><span ng-bind="u.apellido2"></span></td>
							<td><span ng-bind="u.ingreso"></span></td>
							<td><span ng-bind="u.sueldo"></span></td>
							<td>
								<button type="button" ng-click="ctrl.edit(u.id)"
									class="btn btn-success custom-width">Edit</button>
								<button type="button" ng-click="ctrl.remove(u.id)"
									class="btn btn-danger custom-width">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/empleado_service.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/empleado_controller.js' />"></script>
</body>
</html>