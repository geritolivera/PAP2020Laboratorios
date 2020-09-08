package presentacion.usuario;

import java.awt.*;

import javax.swing.*;

import interfaces.IcontroladorUsuario;

import javax.swing.border.TitledBorder;

import datatypes.DTUsuario;

import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ConsultaUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IcontroladorUsuario icon;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldNick;
	private JTextField textFieldCorreo;
	private JTextField textFieldFechaNac;
	
	private JComboBox<String> comboBoxProgForReg;
	private JComboBox<String> comboBoxEdCurReg;
	private JComboBox<String> comboBoxCursoReg;
	private JComboBox<String> comboBoxInsEdCur;
	private JComboBox<String> comboBoxProgForIns;
	
	private JList<String> ListaUsu;
	
	private List<DTUsuario> listaUsuarios;
	
	public ConsultaUsuario(IcontroladorUsuario icon) {

		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consulta de Usuario");
		setBounds(100, 100, 518, 446);
		getContentPane().setLayout(null);
		
		
		//Lista los usuarios
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(20, 65, 120, 245);
		getContentPane().add(scrollPane);
		ListaUsu = new JList<String>();
		ListaUsu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(ListaUsu);
		
		//Boton Listar Usuarios
		JButton ButtonListarUsuarios = new JButton("Listar Usuarios");
		ButtonListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listarUsuarios(arg0);
			}
		});
		ButtonListarUsuarios.setBounds(20, 20, 120, 25);
		getContentPane().add(ButtonListarUsuarios);
		
		//Boton Seleccionar Usuarios
		JButton ButtonSelccUsuario = new JButton("Seleccionar");
		ButtonSelccUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarUsuario(e);
			}
		});
		ButtonSelccUsuario.setBounds(20, 330, 120, 25);
		getContentPane().add(ButtonSelccUsuario);
		
		//Panel datos Usuario
		JPanel DatosPanel = new JPanel();
		DatosPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Usuario", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		DatosPanel.setBounds(164, 4, 325, 190);
		getContentPane().add(DatosPanel);
		DatosPanel.setLayout(null);
		
		//Label Nombre
		JLabel LabelNombre = new JLabel("Nombre");
		LabelNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelNombre.setBounds(10, 25, 45, 15);
		DatosPanel.add(LabelNombre);
		
		//Label Apellido
		JLabel LabelApellido = new JLabel("Apellido");
		LabelApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelApellido.setBounds(10, 60, 45, 15);
		DatosPanel.add(LabelApellido);
		
		//Label Nickname
		JLabel LabelNickname = new JLabel("Nickname");
		LabelNickname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelNickname.setBounds(10, 95, 57, 15);
		DatosPanel.add(LabelNickname);
		
		//Label Correo
		JLabel LabelCorreo = new JLabel("Correo");
		LabelCorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelCorreo.setBounds(10, 130, 45, 15);
		DatosPanel.add(LabelCorreo);
		
		//Label Fecha Nacimiento
		JLabel LabelFechaNac = new JLabel("Fecha Nacimiento");
		LabelFechaNac.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelFechaNac.setBounds(10, 162, 100, 15);
		DatosPanel.add(LabelFechaNac);
		
		//Text Nombre
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(120, 20, 180, 20);
		DatosPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		//Text Apellido
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(120, 55, 180, 20);
		DatosPanel.add(textFieldApellido);
		
		//Text Nick
		textFieldNick = new JTextField();
		textFieldNick.setColumns(10);
		textFieldNick.setBounds(120, 90, 180, 20);
		DatosPanel.add(textFieldNick);
		
		//Text Correo
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(120, 125, 180, 20);
		DatosPanel.add(textFieldCorreo);
		
		//Text Fecha Nacimiento
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setColumns(10);
		textFieldFechaNac.setBounds(120, 160, 180, 20);
		DatosPanel.add(textFieldFechaNac);
		
		//Label Docente
		JLabel LabelDocente = new JLabel("Usuario Docente");
		LabelDocente.setFont(new Font("Tahoma", Font.BOLD, 13));
		LabelDocente.setBounds(165, 210, 110, 15);
		getContentPane().add(LabelDocente);
		
		//Label Curso Registrado
		JLabel LabelCursosRegistrados = new JLabel("Curso Registrados:");
		LabelCursosRegistrados.setBounds(165, 235, 100, 15);
		getContentPane().add(LabelCursosRegistrados);
		
		//Label Ediciones de Curso Registrados
		JLabel LabelEdiCurReg = new JLabel("Ediciones de Curso Registrados: ");
		LabelEdiCurReg.setBounds(165, 260, 160, 15);
		getContentPane().add(LabelEdiCurReg);
		
		//Label Programa de Formacion Registrados
		JLabel LabelProgForm = new JLabel("Programa de Formacion Registrados:");
		LabelProgForm.setBounds(165, 285, 185, 15);
		getContentPane().add(LabelProgForm);
		
		comboBoxProgForReg = new JComboBox<String>();
		comboBoxProgForReg.setBounds(350, 280, 140, 20);
		getContentPane().add(comboBoxProgForReg);
		
		comboBoxEdCurReg = new JComboBox<String>();
		comboBoxEdCurReg.setBounds(350, 255, 140, 20);
		getContentPane().add(comboBoxEdCurReg);
		
		comboBoxCursoReg = new JComboBox<String>();
		comboBoxCursoReg.setBounds(350, 230, 140, 20);
		getContentPane().add(comboBoxCursoReg);
		
		//Label Usuario Estudiante
		JLabel LabelEstudiante = new JLabel("Usuario Estudiante");
		LabelEstudiante.setFont(new Font("Tahoma", Font.BOLD, 13));
		LabelEstudiante.setBounds(165, 315, 110, 15);
		getContentPane().add(LabelEstudiante);
		
		//Label Inscripto en Edicion de Curso
		JLabel lblCursoInscriptos = new JLabel("Inscripto en Edicion de Curso:");
		lblCursoInscriptos.setBounds(165, 340, 160, 15);
		getContentPane().add(lblCursoInscriptos);
		
		//Label Programa de Formacion inscripto
		JLabel ProgramaInscriptos = new JLabel("Programa de Formacion inscripto:");
		ProgramaInscriptos.setBounds(165, 365, 160, 15);
		getContentPane().add(ProgramaInscriptos);
		
		comboBoxInsEdCur = new JComboBox<String>();
		comboBoxInsEdCur.setBounds(350, 335, 140, 20);
		getContentPane().add(comboBoxInsEdCur);
		
		comboBoxProgForIns = new JComboBox<String>();
		comboBoxProgForIns.setBounds(350, 363, 140, 20);
		getContentPane().add(comboBoxProgForIns);
		
		JButton ButtonCancelar = new JButton("Cancelar");
		ButtonCancelar.setBounds(20, 375, 120, 25);
		getContentPane().add(ButtonCancelar);		

	}
	
	public void seleccionarUsuario(ActionEvent arg0){
		String usuarioElegidoNick = ListaUsu.getSelectedValue();
		listaUsuarios = icon.listarDTUsuarios();
		DTUsuario u = null;
		for(DTUsuario dtu : listaUsuarios) {
			if(dtu.getNick().contentEquals(usuarioElegidoNick));
			u = dtu;
		}
		this.textFieldNombre.setText(u.getNombre());
		this.textFieldApellido.setText(u.getApellido());
		this.textFieldNick.setText(usuarioElegidoNick);
		this.textFieldCorreo.setText(u.getCorreo());
		this.textFieldFechaNac.setText(u.getFechaNac().toString());
	}
	
	public void listarUsuarios(ActionEvent arg0) {
		listaUsuarios = icon.listarDTUsuarios();
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for(DTUsuario s : listaUsuarios) {
			listModel.addElement(s.getNick());
		}
		listModel.addElement("Gero");
		ListaUsu.setModel(listModel);
	}
	
	private void limpiarFormulario() {
		
	}
}
