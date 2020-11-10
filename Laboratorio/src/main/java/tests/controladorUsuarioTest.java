package tests;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.*;

import interfaces.*;
import manejadores.*;
import controladores.*;
import clases.*;
import datatypes.*;
import exepciones.*;

public class controladorUsuarioTest {
	

	@BeforeClass
	//Metodo que se ejecuta antes de todos los before, se debe conectar a la base de datos
	public void conexionBaseDatos() {
		
	}
	
	@Before
	public void inicializarControlador() {
		
	}
	
	@Test
	public void ingresarEstudiante() {

		
	}
	
	@AfterClass
	//Metodo que se ejecuta despues de todos los after, se cierra la conexion a la base de datos
	public void cerrarBaseDatos() {
		
	}
}
