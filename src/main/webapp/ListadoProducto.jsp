
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.util.*"  %>
<%@page import="model.TblProductocl2" %>

<!DOCTYPE htm>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Productos</title>
</head>
<body bgcolor="c5dec9">
<h1 align="center">Listado de Productos Registrados en BD</h1>

<h2 align="center">
<a href="FormRegistrarProductocl2.jsp" style="text-decoration:none; color=blue">Registrar Producto</a>
</h2>


<table border="2" align="center">

<tr>
	<td>Id</td>
	<td>Nombre</td>
	<td>Precio venta</td>
	<td>Precio compra</td>
	<td>Estado</td>
	<td>Descripción</td>
</tr>


<%
	List<TblProductocl2> listadoproducto=(List<TblProductocl2>)request.getAttribute("listadodeproductos");
	//Condición si el listado no es vacio
	if(listadoproducto!=null){
		//aplicammos un bucle for
		for(TblProductocl2 list:listadoproducto){
			%>
				<tr>
					<td><%=list.getIdproductocl2()%></td>
					<td><%=list.getNombrecl2()%></td>		
					<td><%=list.getPrecioventacl2()%></td>
					<td><%=list.getPreciocompcl2()%></td>
					<td><%=list.getEstadocl2()%></td>
					<td><%=list.getDescripcl2()%></td>
				</tr>
		<% 		
		}//fin del bucle for
		%>
		<%
	}//fin de la condición
	
%>

</table>
</body>
</html>

