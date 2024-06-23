<html>
<body bgcolor="#c5dec9">
<h2 align="center">Ingresar al Sistema</h2>
<br>

<form action="ControladorUsuarioCl2" method="post">
<table align="center" border="2" >

<tr>
<td>Usuario</td>
<td><input type="text" name="usuariocl2"></td>
</tr>

<tr>
<td>Password</td>
<td><input type="password" name="passwordcl2"></td>
</tr>

<td colspan="2" align="center">
<input type="submit" value="Ingresar">
</td>
</table>
</form>

<br>
<%
	String mensaje = (String)request.getAttribute("mensaje");
	if (mensaje == null) {
    	mensaje = "";
	}
			%>
<h3 align="center"><%=mensaje %></h3>			
</body>
</html>
