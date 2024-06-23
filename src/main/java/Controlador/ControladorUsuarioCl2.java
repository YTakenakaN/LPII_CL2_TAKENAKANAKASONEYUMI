package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassProductocl2Imp;
import Dao.ClassUsuariocl2Imp;
import model.TblProductocl2;
import model.TblUsuariocl2;

/**
 * Servlet implementation class ControladorUsuarioCl2
 */
public class ControladorUsuarioCl2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorUsuarioCl2() {
        super();
        // TODO Auto-generated constructor stub
    }//Fin del constructor


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}//Fin del método doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recuperamos los valores del formulario
		String usuariocl2 =request.getParameter("usuariocl2");
		String passwordcl2=request.getParameter("passwordcl2");
		
		//instanciar las respectivas entidades
		TblUsuariocl2 tblusuariocl2=new TblUsuariocl2();
		ClassUsuariocl2Imp validar= new ClassUsuariocl2Imp();
		ClassProductocl2Imp crud= new ClassProductocl2Imp();
		
		//asignamos valores 
		tblusuariocl2.setUsuariocl2(usuariocl2);
		tblusuariocl2.setPasswordcl2(passwordcl2);

		//invocamos al método registrar
		String resultado=validar.ValidarUsuario(tblusuariocl2);
		
		
		//Condicional según resultado
		if(resultado.equals("Credenciales correctas. Bienvenido.")){
			//actualizar listado de productos
			List<TblProductocl2> listadoproductocl2=crud.ListadoProductocl2();
			//invocamos al listado de productos para la vista
			request.setAttribute("listadodeproductos", listadoproductocl2);
			//redireccionamos
			request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);	
		}else{
			if(resultado.equals("Contraseña incorrecta.")){
				String mensaje ="Contraseña incorrecta";
				//seteamos el mensaje para enviar a la vista
				request.setAttribute("mensaje", mensaje);
				//redireccionamos
				request.getRequestDispatcher("/index.jsp").forward(request, response);	
			}else{
				String mensaje ="Usuario no encontrado";
				//seteamos el mensaje para enviar a la vista
				request.setAttribute("mensaje", mensaje);
				//redireccionamos
				request.getRequestDispatcher("/index.jsp").forward(request, response);	
			}
		}//Fin de condicional

	}//Fin del método doPost

}//Fin del controlador
