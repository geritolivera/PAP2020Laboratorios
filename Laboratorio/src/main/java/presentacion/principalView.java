package presentacion;

import interfaces.IcontroladorCurso;
import interfaces.IcontroladorUsuario;
import interfaces.fabrica;
import presentacion.edicionCurso.AltaDeEdicionDeCurso;
import presentacion.edicionCurso.ConsultaDeEdicionDeCurso;
import presentacion.edicionCurso.InscripcionEdicionCurso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class principalView {

	private JFrame frame;
	
	//JInternal Frame Usuario
	private presentacion.usuario.AltaUsuario altaUsuarioInternalFrame;
	private presentacion.usuario.ConsultaUsuario consultaUsuarioInternalFrame;
	private presentacion.usuario.ModificarDatosUsuario modificarDatosUsuarioInternalFrame;
	
	//JInternal Frame Curso
	private presentacion.curso.AltaCurso altaCursoInternalFrame;
	private presentacion.curso.ConsultaCurso consultaCursoInternalFrame;
	
	//JInternal Frame Edicion de Curso
	private presentacion.edicionCurso.AltaDeEdicionDeCurso altaEdicionCursoInternalFrame;
	private presentacion.edicionCurso.ConsultaDeEdicionDeCurso consultaEdicionCursoInternalFrame;
	private presentacion.edicionCurso.InscripcionEdicionCurso inscripcionEdicionCursoInternalFrame;
	
	//JInternal Frame Programa Formacion
	private presentacion.programaFormacion.CrearProgramaFormacion crearPDFInternalFrame;
	private presentacion.programaFormacion.AgregarCursoPorgramaFormacion agregarCusroPDFInternalFrame;
	private presentacion.programaFormacion.ConsultaProgramaFormacion consultaProgramaFormacionInternalFrame;

	//JInternal Frame Instituto
	private AltaInstituto altaInstitutoInternalFrame;
	
	//JInternal Frame Categoria
	private AltaCategoria  altaCategoriaInternalFrame;
	
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
		IcontroladorCurso icurso = fab.getIcontroladorCurso();
		
		Dimension escritorioTam = frame.getSize();
		Dimension jIternalFrameSize;
		
		//Aca va todo la logica de los internal frames
		
		/*----------------------------------------Usuario----------------------------------------*/
		//Alta Usuario
		altaUsuarioInternalFrame = new presentacion.usuario.AltaUsuario(iusu);
		jIternalFrameSize = altaUsuarioInternalFrame.getSize();
		altaUsuarioInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		altaUsuarioInternalFrame.setVisible(false);
		frame.getContentPane().add(altaUsuarioInternalFrame);
		
		//Consulta de Usuario
		consultaUsuarioInternalFrame = new presentacion.usuario.ConsultaUsuario(iusu,iconC);
		jIternalFrameSize = consultaUsuarioInternalFrame.getSize();
		consultaUsuarioInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		consultaUsuarioInternalFrame.setVisible(false);
		frame.getContentPane().add(consultaUsuarioInternalFrame);
		
		//Modificar Datos de Usuario
		modificarDatosUsuarioInternalFrame = new presentacion.usuario.ModificarDatosUsuario(iusu);
		jIternalFrameSize = modificarDatosUsuarioInternalFrame.getSize();
		modificarDatosUsuarioInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		modificarDatosUsuarioInternalFrame.setVisible(false);
		frame.getContentPane().add(modificarDatosUsuarioInternalFrame);
		
		/*----------------------------------------Curso----------------------------------------*/
		//Alta Curso
		altaCursoInternalFrame = new presentacion.curso.AltaCurso(iconC);
		jIternalFrameSize = altaCursoInternalFrame.getSize();
		altaCursoInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		altaCursoInternalFrame.setVisible(false);
		frame.getContentPane().add(altaCursoInternalFrame);
		
		//Consulta Curso
		consultaCursoInternalFrame = new presentacion.curso.ConsultaCurso(iconC);
		jIternalFrameSize = consultaCursoInternalFrame.getSize();
		consultaCursoInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		consultaCursoInternalFrame.setVisible(false);
		frame.getContentPane().add(consultaCursoInternalFrame);					
		
		/*----------------------------------------Edicion de Curso----------------------------------------*/
		//Alta de Edicion de Curso
		altaEdicionCursoInternalFrame = new AltaDeEdicionDeCurso(iconC);
		jIternalFrameSize = altaEdicionCursoInternalFrame.getSize();
		altaEdicionCursoInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		altaEdicionCursoInternalFrame.setVisible(false);
		frame.getContentPane().add(altaEdicionCursoInternalFrame);
		
		//Consulta de Edicion de Curso
		consultaEdicionCursoInternalFrame = new ConsultaDeEdicionDeCurso(iconC);
		jIternalFrameSize = consultaEdicionCursoInternalFrame.getSize();
		consultaEdicionCursoInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		consultaEdicionCursoInternalFrame.setVisible(false);
		frame.getContentPane().add(consultaEdicionCursoInternalFrame);
		
		//Inscripcion a edicion de Curso
		inscripcionEdicionCursoInternalFrame = new InscripcionEdicionCurso(iconC,iusu);
		jIternalFrameSize = inscripcionEdicionCursoInternalFrame.getSize();
		inscripcionEdicionCursoInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		inscripcionEdicionCursoInternalFrame.setVisible(false);
		frame.getContentPane().add(inscripcionEdicionCursoInternalFrame);
		
		/*----------------------------------------Programa de Formacion----------------------------------------*/
		//Crear Programa de Formacion
		crearPDFInternalFrame = new presentacion.programaFormacion.CrearProgramaFormacion(icurso);
		jIternalFrameSize = crearPDFInternalFrame.getSize();
		crearPDFInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		crearPDFInternalFrame.setVisible(false);
		frame.getContentPane().add(crearPDFInternalFrame);
		
		//Agregar Curso a Programa de Formacion
		agregarCusroPDFInternalFrame = new presentacion.programaFormacion.AgregarCursoPorgramaFormacion(icurso);
		jIternalFrameSize = agregarCusroPDFInternalFrame.getSize();
		agregarCusroPDFInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		agregarCusroPDFInternalFrame.setVisible(false);
		frame.getContentPane().add(agregarCusroPDFInternalFrame);
		
		//Consulta Programa Formacion

		consultaProgramaFormacionInternalFrame = new presentacion.programaFormacion.ConsultaProgramaFormacion(icurso);
		jIternalFrameSize = consultaProgramaFormacionInternalFrame.getSize();
		consultaProgramaFormacionInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		consultaProgramaFormacionInternalFrame.setVisible(false);
		frame.getContentPane().add(consultaProgramaFormacionInternalFrame);

		/*------------------------------Instituto------------------------------*/
		//Alta de Instituto
		altaInstitutoInternalFrame = new AltaInstituto(iusu);
		jIternalFrameSize = altaInstitutoInternalFrame.getSize();
		altaInstitutoInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		altaInstitutoInternalFrame.setVisible(false);
		frame.getContentPane().add(altaInstitutoInternalFrame);
		
		/*------------------------------Categoria------------------------------*/
		//Alta de Categoria
		altaCategoriaInternalFrame = new AltaCategoria(iusu);
		jIternalFrameSize = altaCategoriaInternalFrame.getSize();
		altaCategoriaInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		altaCategoriaInternalFrame.setVisible(false);
		frame.getContentPane().add(altaCategoriaInternalFrame);
		
			
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("edEXT");
		frame.setBounds(100, 100, 1300, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);	
				
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1300, 21);
		frame.getContentPane().add(menuBar);
		
		/*---------- Usuario ----------*/
		JMenu MenuUsuario = new JMenu("Usuario");
		menuBar.add(MenuUsuario);
		
		JMenuItem MenuItemAltaUsuario = new JMenuItem("Alta Usuario");
		MenuItemAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaUsuarioInternalFrame.setVisible(true);
				altaUsuarioInternalFrame.iniciarlizarComboBoxes();
			}
		});
		MenuUsuario.add(MenuItemAltaUsuario);
		
		JMenuItem MenuItemConsultaUsuario = new JMenuItem("Consulta de Usuario");
		MenuItemConsultaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultaUsuarioInternalFrame.setVisible(true);
				consultaUsuarioInternalFrame.inicializarComboBoxListaUsuarios();
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
		MenuItemAltaCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaCursoInternalFrame.setVisible(true);
				altaCursoInternalFrame.inicializarComboBoxInstituto();
			}
		});
		MenuCurso.add(MenuItemAltaCurso);
		
		JMenuItem MenuItemConsultaCurso = new JMenuItem("Consulta de Curso");
		MenuItemConsultaCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				consultaCursoInternalFrame.setVisible(true);
				consultaCursoInternalFrame.limpiarForm();
			}
		});
		MenuCurso.add(MenuItemConsultaCurso);
		
		/*---------- Edicion de Curso ----------*/
		JMenu MenuEdicionCurso = new JMenu("Edicion de Curso");
		menuBar.add(MenuEdicionCurso);
		
		JMenuItem MenuItemAltaEdicionCurso = new JMenuItem("Alta de Edicion de Curso");
		MenuItemAltaEdicionCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaEdicionCursoInternalFrame.setVisible(true);
				altaEdicionCursoInternalFrame.inicializarComboBoxInstituto();
			}
		});
		MenuEdicionCurso.add(MenuItemAltaEdicionCurso);
		
		JMenuItem MenuItemConsultaEdicionCurso = new JMenuItem("Consulta de Edicion de Curso");
		MenuItemConsultaEdicionCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultaEdicionCursoInternalFrame.inicializarComboBoxInstituto();
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
			public void actionPerformed(ActionEvent arg0) {
				agregarCusroPDFInternalFrame.setVisible(true);
				agregarCusroPDFInternalFrame.inicializar();
			}
		});
		MenuProgramaFormacion.add(MenuItemCursoProgForm);
		
		JMenuItem MenuItemConsultaProgForm = new JMenuItem("Consulta de Programa de Formacion");
		MenuItemConsultaProgForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaProgramaFormacionInternalFrame.setVisible(true);
				consultaProgramaFormacionInternalFrame.refreshCombo();
			}
		});
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
		
		/*---------- Categoria ----------*/
		JMenu MenuCategoria = new JMenu("Categoria");
		menuBar.add(MenuCategoria);
		
		JMenuItem MenuItemAltaCategoria = new JMenuItem("Alta de Categoria");
		MenuItemAltaCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaCategoriaInternalFrame.setVisible(true);
			}
		});
		MenuCategoria.add(MenuItemAltaCategoria);
		
	}
}
