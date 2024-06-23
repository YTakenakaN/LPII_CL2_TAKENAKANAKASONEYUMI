package TestEntidades;

import java.util.List;

import Dao.ClassProductocl2Imp;
import model.TblProductocl2;

public class TestEntidadProducto {

	public static void main(String[] args) {
		//realizamos la respectiva instancia de las clases..
		TblProductocl2 productocl2 = new TblProductocl2();
		ClassProductocl2Imp crud = new ClassProductocl2Imp();
		
		/*Registrar producto
		//asignamos valores
		productocl2.setNombrecl2("Polo niño");
		productocl2.setPrecioventacl2(25);
		productocl2.setPreciocompcl2(17);
		productocl2.setEstadocl2("Vigente");
		productocl2.setDescripcl2("Descuento");
		//invocamos al método registrar
		crud.RegistrarProductocl2(productocl2);*/

		/*Listar producto*/
		List<TblProductocl2> listado = crud.ListadoProductocl2();
		
		for (TblProductocl2 list:listado){
			//imprimimos por pantalla
			System.out.println("Nombre: "+ list.getNombrecl2()+" Precio venta: " + list.getPrecioventacl2()+" Precio compra: "+list.getPreciocompcl2()+
			" Estado: "+list.getEstadocl2()+" Descripción: "+list.getDescripcl2());
		}//Fin del bucle for
		
	}//fin del metodo main

}//fin de la clase
