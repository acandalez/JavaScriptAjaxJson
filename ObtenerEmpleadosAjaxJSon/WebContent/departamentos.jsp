<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="modelo.dominio.dto.Departments"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="script.js"></script>
<style>
#tabla{
	border: 1px solid black;
	width:600px;
	text-align:center;
background: rgba(242,246,248,1);
background: -moz-linear-gradient(left, rgba(242,246,248,1) 0%, rgba(216,225,231,1) 50%, rgba(181,198,208,1) 51%, rgba(224,239,249,1) 100%);
background: -webkit-gradient(left top, right top, color-stop(0%, rgba(242,246,248,1)), color-stop(50%, rgba(216,225,231,1)), color-stop(51%, rgba(181,198,208,1)), color-stop(100%, rgba(224,239,249,1)));
background: -webkit-linear-gradient(left, rgba(242,246,248,1) 0%, rgba(216,225,231,1) 50%, rgba(181,198,208,1) 51%, rgba(224,239,249,1) 100%);
background: -o-linear-gradient(left, rgba(242,246,248,1) 0%, rgba(216,225,231,1) 50%, rgba(181,198,208,1) 51%, rgba(224,239,249,1) 100%);
background: -ms-linear-gradient(left, rgba(242,246,248,1) 0%, rgba(216,225,231,1) 50%, rgba(181,198,208,1) 51%, rgba(224,239,249,1) 100%);
background: linear-gradient(to right, rgba(242,246,248,1) 0%, rgba(216,225,231,1) 50%, rgba(181,198,208,1) 51%, rgba(224,239,249,1) 100%);
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f2f6f8', endColorstr='#e0eff9', GradientType=1 );
}

#divtabla{
	margin-top:30px;
}

tr:hover{
	background: white;
	cursor:pointer;
}

</style>
<title>Lista Departamentos!</title>
</head>
<body>

	<!-- 	Imprimimos la lista de departamentos recuperada de la request, enviada por ServletGetDepartmentsList -->

	<select id="eleccion" name="eleccion" onchange="rellenaCaja()">
		<option>Seleccionar</option>
		<c:forEach items="${departamentos}" var="depart">
			<option><c:out value="${depart.departmentName}" /></option>
		</c:forEach>
	</select>
	
	<div id="divtabla"></div>
	<div id="divtrabajadores"></div>
	


</body>
</html>