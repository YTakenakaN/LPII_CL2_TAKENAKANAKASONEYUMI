package Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Interfaces.IProductocl2;
import model.TblProductocl2;

public class ClassProductocl2Imp implements IProductocl2 {

	public void RegistrarProductocl2(TblProductocl2 producto) {
		//establecer conexión con la unidad de persistencia
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_TAKENAKANAKASONEYUMI");
		//gestionar las entidades
		EntityManager em=fabr.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		//registramos
		em.persist(producto);
		//emitimos mensaje por consola
		System.out.print("Producto Registrado en la BD");
		//configuramos
		em.getTransaction().commit();
		//cerramos
		em.close();
	}

	public List<TblProductocl2> ListadoProductocl2() {
		//establecer conexión con la unidad de persistencia
		EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_TAKENAKANAKASONEYUMI");
		//gestionar las entidades
		EntityManager em=fabr.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		//recuperamos los productos de la bd
		//**** Utilizando JPQL
		List<TblProductocl2> listadoproductos = em.createQuery("select c from TblProductocl2 c", TblProductocl2.class).getResultList();
		//confirmamos
		em.getTransaction().commit();
		//cerramos
		em.close();
		return listadoproductos;
	}

}
