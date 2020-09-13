package presentacion.usuario;

import datatypes.*;
import exepciones.UsuarioExcepcion;
import interfaces.IcontroladorUsuario;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ConsultaUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IcontroladorUsuario icon;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldNick;
	private JTextField textFieldCorreo;
	private JTextField textFieldFechaNac;
	private JTextField textFieldEsDocente;
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
		setBounds(100, 100, 518, 462);
		getContentPane().setLayout(null);
		
		
		//Lista los usuarios
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(20, 65, 120, 316);
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
		ButtonSelccUsuario.setBounds(20, 392, 120, 25);
		getContentPane().add(ButtonSelccUsuario);
		
		//Panel datos Usuario
		JPanel DatosPanel = new JPanel();
		DatosPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Usuario", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		DatosPanel.setBounds(164, 4, 325, 226);
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
		LabelFechaNac.setBounds(10, 162, 114, 15);
		DatosPanel.add(LabelFechaNac);
		
		//Label Es Docente
		JLabel LabelEsDocente = new JLabel("Es Docente");
		LabelEsDocente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelEsDocente.setBounds(10, 197, 114, 15);
		DatosPanel.add(LabelEsDocente);

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
		
		//Text Es Docente
		textFieldEsDocente = new JTextField();
		textFieldEsDocente.setColumns(10);
		textFieldEsDocente.setBounds(120, 195, 180, 20);
		DatosPanel.add(textFieldEsDocente);

		//Label Docente
		JLabel LabelDocente = new JLabel("Usuario Docente");
		LabelDocente.setFont(new Font("Tahoma", Font.BOLD, 13));
		LabelDocente.setBounds(164, 241, 140, 15);
		getContentPane().add(LabelDocente);
		
		//Label Ediciones de Curso Registrados
		JLabel LabelEdiCurAsc = new JLabel("Ediciones de Curso Asociados: ");
		LabelEdiCurAsc.setBounds(164, 267, 160, 15);
		getContentPane().add(LabelEdiCurAsc);
		
		comboBoxCursoReg = new JComboBox<String>();
		comboBoxCursoReg.setBounds(350, 264, 140, 20);
		getContentPane().add(comboBoxCursoReg);
		
		//Label Usuario Estudiante
		JLabel LabelEstudiante = new JLabel("Usuario Estudiante");
		LabelEstudiante.setFont(new Font("Tahoma", Font.BOLD, 13));
		LabelEstudiante.setBounds(164, 301, 140, 15);
		getContentPane().add(LabelEstudiante);
		
		//Label Inscripto en Edicion de Curso
		JLabel lblCursoInscriptos = new JLabel("Inscripto en Edicion de Curso:");
		lblCursoInscriptos.setBounds(165, 327, 160, 15);
		getContentPane().add(lblCursoInscriptos);
		
		//Label Programa de Formacion inscripto
		JLabel ProgramaInscriptos = new JLabel("Programa de Formacion inscripto:");
		ProgramaInscriptos.setBounds(164, 366, 175, 15);
		getContentPane().add(ProgramaInscriptos);
		
		comboBoxInsEdCur = new JComboBox<String>();
		comboBoxInsEdCur.setBounds(350, 324, 140, 20);
		getContentPane().add(comboBoxInsEdCur);
		
		comboBoxProgForIns = new JComboBox<String>();
		comboBoxProgForIns.setBounds(349, 361, 140, 20);
		getContentPane().add(comboBoxProgForIns);
		
		JButton ButtonCancelar = new JButton("Cancelar");
		ButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelarConsultaUsuario(arg0);
			}
		});
		ButtonCancelar.setBounds(285, 392, 120, 25);
		getContentPane().add(ButtonCancelar);		

	}
	
	public void inicializarComboBoxEdicionesDocente() {

	}


	protected void cancelarConsultaUsuario(ActionEvent arg0) {
		limpiarFormulario();
		setVisible(false);
	}

	public void seleccionarUsuario(ActionEvent arg0){
		String usuarioElegidoNick = ListaUsu.getSelectedValue();
		listaUsuarios = icon.listarDTUsuarios();
		try {
			DTUsuario u = icon.verInfoUsuario(usuarioElegidoNick);
			this.textFieldNombre.setText(u.getNombre());
			this.textFieldApellido.setText(u.getApellido());
			this.textFieldNick.setText(usuarioElegidoNick);
			this.textFieldCorreo.setText(u.getCorreo());
			SimpleDateFormat fechaNac = new SimpleDateFormat("yyyy/MM/dd");
			String fechaN = fechaNac.format(u.getFechaNac());
			textFieldFechaNac.setText(fechaN);
			if(u instanceof DTDocente) {
				this.textFieldEsDocente.setText("Si");
				ArrayList<String> edicionesD = new ArrayList<>();
				for(DTEdicionCurso e : ((DTDocente)u).getEdiciones()) {
					edicionesD.add(e.getNombre());
				}
				DefaultComboBoxModel<String> listEdiDoc = new DefaultComboBoxModel<String>(edicionesD.toArray(new String[0]));
				comboBoxCursoReg.setModel(listEdiDoc);
			}
			else {
				this.textFieldEsDocente.setText("No");
				ArrayList<String> edicionesE = new ArrayList<>();
				for(DTEdicionCurso e : ((DTEstudiante)u).getEdiciones()) {
					edicionesE.add(e.getNombre());
				}
				ArrayList<String> programasE = new ArrayList<>();
				for(DTProgramaFormacion p : ((DTEstudiante)u).getProgramas()) {
					programasE.add(p.getNombre());
				}
				DefaultComboBoxModel<String> listEdiEst = new DefaultComboBoxModel<String>(edicionesE.toArray(new String[0]));
				comboBoxInsEdCur.setModel(listEdiEst);
				DefaultComboBoxModel<String> listProEst = new DefaultComboBoxModel<String>(programasE.toArray(new String[0]));
				comboBoxProgForIns.setModel(listProEst);
			}
		}catch(UsuarioExcepcion exe) {
			JOptionPane.showMessageDialog(this, exe.getMessage(), "Consulta de Usuario", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void listarUsuarios(ActionEvent arg0) {
		listaUsuarios = icon.listarDTUsuarios();
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for(DTUsuario s : listaUsuarios) {
			listModel.addElement(s.getNick());
		}
		//listModel.addElement("Gero");
		ListaUsu.setModel(listModel);
	}
	
	private void limpiarFormulario() {
		textFieldCorreo.setText("");
		textFieldNick.setText("");
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		textFieldFechaNac.setText("");
	}
}
