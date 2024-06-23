package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassProductocl2Imp;
import model.TblProductocl2;

/**
 * Servlet implementation class ControladorProductoCl2
 */
public class ControladorProductoCl2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProductoCl2() {
        super();
        // TODO Auto-generated constructor stub
    }//Fin de constructor

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Hacer instancias
		TblProductocl2 producto=new TblProductocl2();
		ClassProductocl2Imp crud = new ClassProductocl2Imp();
		List<TblProductocl2> listadoproducto= crud.ListadoProductocl2();
		//invocamos el listado de productos para la vista
		request.setAttribute("listadodeproductos", listadoproducto);
		//redireccionamos
		request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);
	
	}//Fin de método doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperamos los valores del formulario
		String nombrecl2 =request.getParameter("nombrecl2");
		double precioventacl2 =Double.parseDouble(request.getParameter("precioventacl2"));
		double preciocompcl2= Double.parseDouble(request.getParameter("preciocompcl2"));	
		String estadocl2=request.getParameter("estadocl2");
		String descripcl2= request.getParameter("descripcl2");
				
		//instanciar las respectivas entidades
		TblProductocl2 productocl2=new TblProductocl2();
		ClassProductocl2Imp crud= new ClassProductocl2Imp();
		
		//asignamos valores 
		productocl2.setNombrecl2(nombrecl2);
		productocl2.setPrecioventacl2(precioventacl2);
		productocl2.setPreciocompcl2(preciocompcl2);
		productocl2.setEstadocl2(estadocl2);
		productocl2.setDescripcl2(descripcl2);
		
		//invocamos al método registrar
		crud.RegistrarProductocl2(productocl2);
		
		//actualizar listado de clientes
		List<TblProductocl2> listadoproductocl2=crud.ListadoProductocl2();
		//invocamos al listado de productos para la vista
		request.setAttribute("listadodeproductos", listadoproductocl2);
		
		//redireccionamos
		request.getRequestDispatcher("/ListadoProducto.jsp").forward(request, response);

	}//Fin de método doPost

}//Fin de controlador
