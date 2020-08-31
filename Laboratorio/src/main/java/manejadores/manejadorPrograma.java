package manejadores;

import java.util.List;

import javax.persistence.EntityManager;

import clases.ProgramaFormacion;
import conexion.Conexion;

public class manejadorPrograma {
private static manejadorPrograma instancia = null;
	
	//private List<ProgramaFormacion> programas = new ArrayList<>();
	
	private manejadorPrograma() {}
	
	public static manejadorPrograma getInstancia() {
		if(instancia == null) {
			instancia = new manejadorPrograma();
		}
		return instancia;
	}
	
	public void agregarPrograma(ProgramaFormacion nombre) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		em.getTransaction().begin();
		em.persist(nombre);
		em.getTransaction().commit();
	}
	
	public ProgramaFormacion buscarPrograma(String nombre) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.find(ProgramaFormacion.class, nombre);
	}
	
	public boolean existePrograma(String nombre) {
		return this.buscarPrograma(nombre) instanceof ProgramaFormacion;
	}
	
	public List<ProgramaFormacion> getProgramas(){
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		List<ProgramaFormacion> programas = em.createQuery("SELECT u FROM Programa u", ProgramaFormacion.class).getResultList();
		return programas;
	}

		
	/*public void addProgramaFormacion(ProgramaFormacion pg) {
		programas.add(pg);
	}
	
	public ProgramaFormacion findPrograma(String nombre) {
		ProgramaFormacion pgEnc = null;
		for(ProgramaFormacion pg : programas) {
			if(pg.getNombre().equals(nombre)) {
				pgEnc = pg;
			}
		}
		return pgEnc;
	}
	
	public boolean existePrograma(String nombre) {
		boolean existe = false;
		for(ProgramaFormacion pg : programas) {
			if(pg.getNombre().equals(nombre)) {
				existe = true;
			}
		}
		return existe;
	}
	
	public void deletePrograma(String nombre) {
		ProgramaFormacion aBorrar = null;
		for(ProgramaFormacion pg : programas) {
			if(pg.getNombre().equals(nombre)) {
				aBorrar = pg;
			}
		}
		if(aBorrar != null) {
			aBorrar = null;
			System.gc();
		}
	}*/
	
	
}
