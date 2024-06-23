package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IUsuariocl2;
import model.TblUsuariocl2;

public class ClassUsuariocl2Imp implements IUsuariocl2{

	public String ValidarUsuario(TblUsuariocl2 usuario) {
		//Establecemos conexión con unidad de persistencia
		EntityManagerFactory em=Persistence.createEntityManagerFactory("LPII_CL2_TAKENAKANAKASONEYUMI"); 
		//gestionar las entidades
		EntityManager emanager = em.createEntityManager();
		//iniciamos la transaccion
		emanager.getTransaction().begin();
		//Buscamos el usuario ingresado
		List<TblUsuariocl2> listado = emanager.createQuery("select c from TblUsuariocl2 c", TblUsuariocl2.class).getResultList();
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		
		TblUsuariocl2 usuarioEncontrado=null;
		for (TblUsuariocl2 usuarioDeLista: listado){
			if(usuarioDeLista.getUsuariocl2().equals(usuario.getUsuariocl2())){
				usuarioEncontrado = usuarioDeLista;
			}
		}

		String resultado;
		//Validamos la existencia del usuario
		if(usuarioEncontrado!=null){
			//Validamos la contraseña
			if(usuarioEncontrado.getPasswordcl2().equals(usuario.getPasswordcl2())){
				resultado="Credenciales correctas. Bienvenido.";
			}
			else{
				resultado="Contraseña incorrecta.";
			}
		}else{
			resultado="Usuario no encontrado.";			
		}

		return resultado;
		
	}
	}


