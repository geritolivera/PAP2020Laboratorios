package exepciones;

public class CategoriaExcepcion extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CategoriaExcepcion(String string)  {
        super(string);
    }
}
