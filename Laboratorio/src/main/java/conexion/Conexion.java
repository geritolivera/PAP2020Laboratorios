package conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion {
	private static Conexion instancia = null;
	private final EntityManagerFactory emf;
	private final EntityManager em;
	
	private Conexion(){
		emf=Persistence.createEntityManagerFactory("Conexion");
		em=emf.createEntityManager();
	}
	
	public EntityManager getEntityManager() {
		return this.em;
	}
	
	public static Conexion getInstancia() {
		if (instancia == null) {
			instancia = new Conexion();
		}
		//veririfcar instancia si esta cerrada por las dudas...
		return instancia;
	}

	public void cerrar(){
		instancia=null;
		emf.close();
		em.close();
	}
}
