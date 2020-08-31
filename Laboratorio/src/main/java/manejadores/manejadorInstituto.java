package manejadores;

import java.util.List;

import javax.persistence.EntityManager;

import clases.Instituto;
import conexion.Conexion;

public class manejadorInstituto {
private static manejadorInstituto instancia = null;
	
	//private List<Instituto> institutos = new ArrayList<>();
	
	private manejadorInstituto() {}
	
	public static manejadorInstituto getInstancia() {
		if(instancia == null) {
			instancia = new manejadorInstituto();
		}
		return instancia;
	}
	
	public void agregarInstituto(Instituto nombre) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		em.getTransaction().begin();
		em.persist(nombre);
		em.getTransaction().commit();
	}
	
	public Instituto buscarInstituto(String nombre) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.find(Instituto.class, nombre);
	}
	
	public boolean existeInstituto(String nombre) {
		return this.buscarInstituto(nombre) instanceof Instituto;
	}
	
	public List<Instituto> getInstituto(){
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		List<Instituto> institutos = em.createQuery("SELECT u FROM Programa u", Instituto.class).getResultList();
		return institutos;
	}
	
	/*public void addInsituto(Instituto i) {
		institutos.add(i);
	}
	
	public Instituto findInstituto(String nombre) {
		Instituto iEnc = null;
		for(Instituto i : institutos) {
			if(i.getNombre().equals(nombre)) {
				iEnc = i;
			}
		}
		return iEnc;
	}
	
	public boolean existeInstituto(String nombre) {
		boolean existe = false;
		for(Instituto i : institutos) {
			if(i.getNombre().equals(nombre)) {
				existe = true;
			}
		}
		return existe;
	}
	
	public void deleteInstituto(String nombre) {
		Instituto aBorrar = null;
		for(Instituto i : institutos) {
			if(i.getNombre().equals(nombre)) {
				aBorrar = i;
			}
		}
		if(aBorrar != null) {
			aBorrar = null;
			System.gc();
		}
	}
	
	//Metodos Programa de Formacion
	
	public void addProgramaFormacion(ProgramaFormacion pg) {
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
