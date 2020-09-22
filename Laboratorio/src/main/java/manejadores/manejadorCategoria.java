package manejadores;

import conexion.Conexion;
import clases.Categoria;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class manejadorCategoria {

	private static manejadorCategoria instancia = null;
	private List<Categoria> categorias = new ArrayList<>();
	private manejadorCategoria() {}
	
	public static manejadorCategoria getInstancia() {
		if(instancia == null) {
			instancia = new manejadorCategoria();
		}
		return instancia;
	}
	
	public void agregarCategoria(Categoria categoria) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		em.getTransaction().begin();
		em.persist(categoria);
		em.getTransaction().commit();
	}
	
	public Categoria buscarCategoria(String nombre) {
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		return em.find(Categoria.class, nombre);
	}
	
	public boolean existeCategoria(String nombre) {
		return this.buscarCategoria(nombre) instanceof Categoria;
	}
	
	public List<Categoria> getCategorias(){
		Conexion con = Conexion.getInstancia();
		EntityManager em = con.getEntityManager();
		@SuppressWarnings("unchecked")
		List<Categoria> categorias = em.createQuery("FROM Categoria").getResultList();
		return categorias;
	}
	
	public ArrayList<String> obtenerCategorias(){
		ArrayList<String> ret = new ArrayList<>();
		for(Categoria i: categorias) {
			ret.add(i.getNombre());
		}
		return ret;
	}
}
