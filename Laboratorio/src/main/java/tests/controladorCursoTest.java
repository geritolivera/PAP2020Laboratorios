package tests;

import static org.junit.Assert.*;

import org.junit.*;

import interfaces.*;
import manejadores.*;
import controladores.*;
import clases.*;
import datatypes.*;
import exepciones.*;


public class controladorCursoTest {

	@BeforeClass
	//Metodo que se ejecuta antes de todos los before, se debe conectar a la base de datos
	public void conexionBaseDatos() {
				
	}
	
	
	@AfterClass
	//Metodo que se ejecuta despues de todos los after, se cierra la conexion a la base de datos
	public void despuesDeTodo() {
		
	}
}
