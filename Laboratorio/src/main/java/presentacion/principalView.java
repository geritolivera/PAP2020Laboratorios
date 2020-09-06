package presentacion;

import presentacion.usuario.*;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import interfaces.*;
import presentacion.usuario.*;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class principalView {

	private JFrame frame;
	private presentacion.usuario.AltaUsuario altaUsuarioInternalFrame;
	private presentacion.usuario.ConsultaUsuario consultaUsuarioInternalFrame;
	private presentacion.usuario.ModificarDatosUsuario modificarDatosUsuarioInternalFrame;
	private presentacion.programaFormacion.CrearProgramaFormacion crearPDFInternalFrame;
	private presentacion.programaFormacion.AgregarCursoPorgramaFormacion agregarCusroPDFInternalFrame;
	private AltaDeEdicionDeCurso altaEdicionCursoInternalFrame;
	private ConsultaDeEdicionDeCurso consultaEdicionCursoInternalFrame;
	private InscripcionEdicionCurso inscripcionEdicionCursoInternalFrame;
	private AltaInstituto altaInstitutoInternalFrame;	
	
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
		
		fabrica fab = fabrica.getInstancia();
		IcontroladorCurso iconC = fab.getIcontroladorCurso();
		IcontroladorUsuario iusu = fab.getIcontroladorUsuario();
		
		Dimension escritorioTam = frame.getSize();
		Dimension jIternalFrameSize;
		
		
		altaUsuarioInternalFrame = new presentacion.usuario.AltaUsuario(iusu);
		jIternalFrameSize = altaUsuarioInternalFrame.getSize();
		altaUsuarioInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		altaUsuarioInternalFrame.setVisible(false);
		frame.getContentPane().add(altaUsuarioInternalFrame);
		
		
		consultaUsuarioInternalFrame = new presentacion.usuario.ConsultaUsuario();
		consultaUsuarioInternalFrame.setBounds(0, -55, 513, 354);
		altaUsuarioInternalFrame.getContentPane().add(consultaUsuarioInternalFrame);
		jIternalFrameSize = consultaUsuarioInternalFrame.getSize();
		consultaUsuarioInternalFrame.setVisible(false);
		
		modificarDatosUsuarioInternalFrame = new presentacion.usuario.ModificarDatosUsuario(iusu);
		jIternalFrameSize = modificarDatosUsuarioInternalFrame.getSize();
		modificarDatosUsuarioInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		modificarDatosUsuarioInternalFrame.setVisible(false);
		frame.getContentPane().add(modificarDatosUsuarioInternalFrame);
		
		crearPDFInternalFrame = new presentacion.programaFormacion.CrearProgramaFormacion();
		jIternalFrameSize = crearPDFInternalFrame.getSize();
		crearPDFInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		crearPDFInternalFrame.setVisible(false);
		frame.getContentPane().add(crearPDFInternalFrame);
		
		agregarCusroPDFInternalFrame = new presentacion.programaFormacion.AgregarCursoPorgramaFormacion();
		jIternalFrameSize = agregarCusroPDFInternalFrame.getSize();
		agregarCusroPDFInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		agregarCusroPDFInternalFrame.setVisible(false);
		frame.getContentPane().add(agregarCusroPDFInternalFrame);
		
		
		altaEdicionCursoInternalFrame = new AltaDeEdicionDeCurso(iconC);
		jIternalFrameSize = altaEdicionCursoInternalFrame.getSize();
		altaEdicionCursoInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		altaEdicionCursoInternalFrame.setVisible(false);
		frame.getContentPane().add(altaEdicionCursoInternalFrame);
		
		consultaEdicionCursoInternalFrame = new ConsultaDeEdicionDeCurso(iconC);
		jIternalFrameSize = consultaEdicionCursoInternalFrame.getSize();
		consultaEdicionCursoInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		consultaEdicionCursoInternalFrame.setVisible(false);
		frame.getContentPane().add(consultaEdicionCursoInternalFrame);
		
		inscripcionEdicionCursoInternalFrame = new InscripcionEdicionCurso(iconC);
		jIternalFrameSize = inscripcionEdicionCursoInternalFrame.getSize();
		inscripcionEdicionCursoInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		inscripcionEdicionCursoInternalFrame.setVisible(false);
		frame.getContentPane().add(inscripcionEdicionCursoInternalFrame);
		
		altaInstitutoInternalFrame = new AltaInstituto(iconC);
		jIternalFrameSize = altaInstitutoInternalFrame.getSize();
		altaInstitutoInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		altaInstitutoInternalFrame.setVisible(false);
		frame.getContentPane().add(altaInstitutoInternalFrame);
		
		//Aca va todo la logica de los internal frames
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("edEXT");
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
				
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 684, 21);
		frame.getContentPane().add(menuBar);
		
		/*---------- Usuario ----------*/
		JMenu MenuUsuario = new JMenu("Usuario");
		menuBar.add(MenuUsuario);
		
		JMenuItem MenuItemAltaUsuario = new JMenuItem("Alta Usuario");
		MenuItemAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaUsuarioInternalFrame.setVisible(true);
			}
		});
		MenuUsuario.add(MenuItemAltaUsuario);
		
		JMenuItem MenuItemConsultaUsuario = new JMenuItem("Consulta de Usuario");
		MenuItemConsultaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultaUsuarioInternalFrame.setVisible(true);
			}
		});
		MenuUsuario.add(MenuItemConsultaUsuario);
		
		JMenuItem MenuItemMoficarDatosUsuario = new JMenuItem("Modificar Datos de Usuario");
		MenuItemMoficarDatosUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarDatosUsuarioInternalFrame.setVisible(true);
			}
		});
		MenuUsuario.add(MenuItemMoficarDatosUsuario);
		
		/*---------- Curso ----------*/
		JMenu MenuCurso = new JMenu("Curso");
		menuBar.add(MenuCurso);
		
		JMenuItem MenuItemAltaCurso = new JMenuItem("Alta Curso");
		MenuCurso.add(MenuItemAltaCurso);
		
		JMenuItem MenuItemConsultaCurso = new JMenuItem("Consulta de Curso");
		MenuCurso.add(MenuItemConsultaCurso);
		
		/*---------- Edicion de Curso ----------*/
		JMenu MenuEdicionCurso = new JMenu("Edicion de Curso");
		menuBar.add(MenuEdicionCurso);
		
		JMenuItem MenuItemAltaEdicionCurso = new JMenuItem("Alta de Edicion de Curso");
		MenuItemAltaEdicionCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaEdicionCursoInternalFrame.inicializarComboBoxInstituto();
				altaEdicionCursoInternalFrame.setVisible(true);
			}
		});
		MenuEdicionCurso.add(MenuItemAltaEdicionCurso);
		
		JMenuItem MenuItemConsultaEdicionCurso = new JMenuItem("Consulta de Edicion de Curso");
		MenuItemConsultaEdicionCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultaEdicionCursoInternalFrame.setVisible(true);
			}
		});
		MenuEdicionCurso.add(MenuItemConsultaEdicionCurso);
		
		JMenuItem MenuItemInscripcionCurso = new JMenuItem("Inscripcion a Edicion de Curso");
		MenuItemInscripcionCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inscripcionEdicionCursoInternalFrame.inicializarComboBoxInstituto();
				inscripcionEdicionCursoInternalFrame.setVisible(true);
			}
		});
		MenuEdicionCurso.add(MenuItemInscripcionCurso);
		
		/*---------- Programa de Formacion ----------*/
		JMenu MenuProgramaFormacion = new JMenu("Programa de Formacion");
		menuBar.add(MenuProgramaFormacion);
		
		JMenuItem MenuItemCrearProgForm = new JMenuItem("Crear Programa de Formacion");
		MenuItemCrearProgForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearPDFInternalFrame.setVisible(true);
			}
		});
		MenuProgramaFormacion.add(MenuItemCrearProgForm);
		
		JMenuItem MenuItemCursoProgForm = new JMenuItem("Agregar Curso a Programa de Formacion");
		MenuItemCursoProgForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarCusroPDFInternalFrame.setVisible(true);
			}
		});
		MenuProgramaFormacion.add(MenuItemCursoProgForm);
		
		JMenuItem MenuItemConsultaProgForm = new JMenuItem("Consulta de Programa de Formacion");
		MenuProgramaFormacion.add(MenuItemConsultaProgForm);
		
		/*---------- Instituto ----------*/
		JMenu MenuInstituto = new JMenu("Instituto");
		menuBar.add(MenuInstituto);
		
		JMenuItem MenuItemAltaInstituto = new JMenuItem("Alta de Instituto");
		MenuItemAltaInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaInstitutoInternalFrame.setVisible(true);
			}
		});
		MenuInstituto.add(MenuItemAltaInstituto);
		
	}
}
