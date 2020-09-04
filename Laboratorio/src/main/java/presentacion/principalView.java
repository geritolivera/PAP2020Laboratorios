package presentacion;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class principalView {

	private JFrame frame;
	private presentacion.usuario.AltaUsuario altaUsuarioInternalFrame;
	private presentacion.usuario.ConsultaUsuario consultaUsuarioInternalFrame;
	private presentacion.usuario.ModificarDatosUsuario modificarDatosUsuarioInternalFrame;
	private presentacion.programaFormacion.CrearProgramaFormacion crearPDFInternalFrame;
	private presentacion.programaFormacion.AgregarCursoPorgramaFormacion agregarCusroPDFInternalFrame;
	
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
		
		Dimension escritorioTam = frame.getSize();
		Dimension jIternalFrameSize;
		
		
		altaUsuarioInternalFrame = new presentacion.usuario.AltaUsuario();
		jIternalFrameSize = altaUsuarioInternalFrame.getSize();
		altaUsuarioInternalFrame.setLocation((escritorioTam.width - jIternalFrameSize.width)/2,(escritorioTam.height- jIternalFrameSize.height)/2);
		altaUsuarioInternalFrame.setVisible(false);
		frame.getContentPane().add(altaUsuarioInternalFrame);
		
		
		consultaUsuarioInternalFrame = new presentacion.usuario.ConsultaUsuario();
		consultaUsuarioInternalFrame.setBounds(0, -55, 513, 354);
		altaUsuarioInternalFrame.getContentPane().add(consultaUsuarioInternalFrame);
		jIternalFrameSize = consultaUsuarioInternalFrame.getSize();
		consultaUsuarioInternalFrame.setVisible(false);
		
		modificarDatosUsuarioInternalFrame = new presentacion.usuario.ModificarDatosUsuario();
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
		MenuEdicionCurso.add(MenuItemAltaEdicionCurso);
		
		JMenuItem MenuItemConsultaEdicionCurso = new JMenuItem("Consulta de Edicion de Curso");
		MenuEdicionCurso.add(MenuItemConsultaEdicionCurso);
		
		JMenuItem MenuItemInscripcionCurso = new JMenuItem("Inscripcion a Edicion de Curso");
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
		MenuInstituto.add(MenuItemAltaInstituto);
		
	}
}
