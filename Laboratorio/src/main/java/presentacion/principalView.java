package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class principalView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principalView window = new principalView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public principalView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("edEXT");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu MenuUsuario = new JMenu("Usuario");
		menuBar.add(MenuUsuario);
		
		JMenuItem MenuItemAltaUsuario = new JMenuItem("Alta Usuario");
		MenuUsuario.add(MenuItemAltaUsuario);
		
		JMenuItem MenuItemConsultaUsuario = new JMenuItem("Consulta de Usuario");
		MenuUsuario.add(MenuItemConsultaUsuario);
		
		JMenuItem MenuItemMoficarDatosUsuario = new JMenuItem("Modificar Datos de Usuario");
		MenuUsuario.add(MenuItemMoficarDatosUsuario);
		
		JMenu MenuCurso = new JMenu("Curso");
		menuBar.add(MenuCurso);
		
		JMenuItem MenuItemAltaCurso = new JMenuItem("Alta Curso");
		MenuCurso.add(MenuItemAltaCurso);
		
		JMenuItem MenuItemConsultaCurso = new JMenuItem("Consulta de Curso");
		MenuCurso.add(MenuItemConsultaCurso);
		
		JMenu MenuEdicionCurso = new JMenu("Edicion de Curso");
		menuBar.add(MenuEdicionCurso);
		
		JMenuItem MenuItemAltaEdicionCurso = new JMenuItem("Alta de Edicion de Curso");
		MenuEdicionCurso.add(MenuItemAltaEdicionCurso);
		
		JMenuItem MenuItemConsultaEdicionCurso = new JMenuItem("Consulta de Edicion de Curso");
		MenuEdicionCurso.add(MenuItemConsultaEdicionCurso);
		
		JMenuItem MenuItemInscripcionCurso = new JMenuItem("Inscripcion a Edicion de Curso");
		MenuEdicionCurso.add(MenuItemInscripcionCurso);
		
		JMenu MenuProgramaFormacion = new JMenu("Programa de Formacion");
		menuBar.add(MenuProgramaFormacion);
		
		JMenuItem MenuItemCrearProgForm = new JMenuItem("Crear Programa de Formacion");
		MenuProgramaFormacion.add(MenuItemCrearProgForm);
		
		JMenuItem MenuItemCursoProgForm = new JMenuItem("Agregar Curso a Programa de Formacion");
		MenuProgramaFormacion.add(MenuItemCursoProgForm);
		
		JMenuItem MenuItemConsultaProgForm = new JMenuItem("Consulta de Programa de Formacion");
		MenuProgramaFormacion.add(MenuItemConsultaProgForm);
		
		JMenu MenuInstituto = new JMenu("Instituto");
		menuBar.add(MenuInstituto);
		
		JMenuItem MenuItemAltaInstituto = new JMenuItem("Alta de Instituto");
		MenuInstituto.add(MenuItemAltaInstituto);
	}
}
