package presentacion.usuario;

import datatypes.*;
import exepciones.EdicionExcepcion;
import exepciones.ProgramaFormacionExcepcion;
import exepciones.UsuarioExcepcion;
import interfaces.IcontroladorCurso;
import interfaces.IcontroladorUsuario;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ConsultaUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IcontroladorUsuario icon;
	private IcontroladorCurso iconC;

	private JTextField nombreUsuario;
	private JTextField apellidoUsuario;
	private JTextField nickname;
	private JTextField correo;
	private JTextField FechaNac;
	private JTextField EsDocente;
	private JTextField textNombreEdicion;
	private JTextField fechaInicio;
	private JTextField fechaFin;
	private JTextField fechaPublicacion;
	private JTextField vigente;
	private JTextField nombreProg;
	private JTextField fechaInicioProg;
	private JTextField fechaFinProg;
	private JTextField fechaIngresoProg;
	private JTextArea DescripcionProg;

	private JComboBox<String> comboBoxUsuarios;
	private JComboBox<String> comboBoxCursoReg;
	private JComboBox<String> comboBoxProgForIns;
	private JComboBox<String> comboCursosEnPrograma;

	private List<DTUsuario> listaUsuarios;


	public ConsultaUsuario(IcontroladorUsuario icon, IcontroladorCurso iconC) {
		this.iconC = iconC;
		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consulta de Usuario");
		setBounds(100, 100, 1221, 371);
		getContentPane().setLayout(null);
		

		
		/*---------------------------------------------------------------------------------------------------------*/
		//Panel datos Usuario
		JPanel DatosPanel = new JPanel();
		DatosPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Usuario", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		DatosPanel.setBounds(15, 70, 325, 226);
		getContentPane().add(DatosPanel);
		DatosPanel.setLayout(null);
		
		//Label Nombre
		JLabel LabelNombre = new JLabel("Nombre");
		LabelNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelNombre.setBounds(10, 25, 110, 15);
		DatosPanel.add(LabelNombre);
		
		//Label Apellido
		JLabel LabelApellido = new JLabel("Apellido");
		LabelApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelApellido.setBounds(10, 60, 110, 15);
		DatosPanel.add(LabelApellido);
		
		//Label Nickname
		JLabel LabelNickname = new JLabel("Nickname");
		LabelNickname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelNickname.setBounds(10, 95, 110, 15);
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
		/*----------------------------------------------------------------------------------------------------------------------------------*/



		//Label Docente
		JLabel LabelSeleccEdi = new JLabel("Seleccione Edicion Asociada al usuario");
		LabelSeleccEdi.setFont(new Font("Tahoma", Font.BOLD, 13));
		LabelSeleccEdi.setBounds(370, 15, 325, 15);
		getContentPane().add(LabelSeleccEdi);

		//Label Usuario Estudiante
		JLabel LabelEstudiante = new JLabel("Seleccione Progama de Formacion");
		LabelEstudiante.setFont(new Font("Tahoma", Font.BOLD, 13));
		LabelEstudiante.setBounds(810, 15, 325, 15);
		getContentPane().add(LabelEstudiante);

		JButton ButtonCancelar = new JButton("Cancelar");
		ButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelarConsultaUsuario(arg0);
			}
		});
		ButtonCancelar.setBounds(470, 300, 120, 25);
		getContentPane().add(ButtonCancelar);		

		JPanel panelEdicion = new JPanel();
		panelEdicion.setLayout(null);
		panelEdicion.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos de la Edicion", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		panelEdicion.setBounds(370, 70, 339, 199);
		getContentPane().add(panelEdicion);

		JLabel labelNombreEdicion = new JLabel("Nombre");
		labelNombreEdicion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelNombreEdicion.setBounds(10, 34, 100, 15);
		panelEdicion.add(labelNombreEdicion);

		JLabel labelFechaIEdicion = new JLabel("Fecha Inicio");
		labelFechaIEdicion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelFechaIEdicion.setBounds(10, 60, 100, 15);
		panelEdicion.add(labelFechaIEdicion);

		JLabel labelFechaFinEdcion = new JLabel("Fecha Fin");
		labelFechaFinEdcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelFechaFinEdcion.setBounds(10, 96, 100, 15);
		panelEdicion.add(labelFechaFinEdcion);

		JLabel lblFechaDePublicacion = new JLabel("Fecha Publicacion");
		lblFechaDePublicacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaDePublicacion.setBounds(10, 126, 120, 15);
		panelEdicion.add(lblFechaDePublicacion);

		JLabel Vigente = new JLabel("Vigente");
		Vigente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Vigente.setBounds(10, 158, 100, 15);
		panelEdicion.add(Vigente);


		JLabel lblUsuarios = new JLabel("Seleccionar Usuario");
		lblUsuarios.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuarios.setBounds(15, 15, 140, 15);
		getContentPane().add(lblUsuarios);

		JPanel PanelPrograma = new JPanel();
		PanelPrograma.setLayout(null);
		PanelPrograma.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos del Programa", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		PanelPrograma.setBounds(810, 70, 325, 245);
		getContentPane().add(PanelPrograma);

		JLabel LabelNombre_1 = new JLabel("Nombre");
		LabelNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelNombre_1.setBounds(10, 34, 100, 15);
		PanelPrograma.add(LabelNombre_1);

		JLabel LabelDescripcion = new JLabel("Descripcion");
		LabelDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelDescripcion.setBounds(10, 60, 100, 15);
		PanelPrograma.add(LabelDescripcion);

		JLabel LabelNickname_1 = new JLabel("Fecha Inicio");
		LabelNickname_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelNickname_1.setBounds(10, 129, 100, 15);
		PanelPrograma.add(LabelNickname_1);

		JLabel LabelCorreo_1 = new JLabel("Fecha Fin");
		LabelCorreo_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelCorreo_1.setBounds(10, 155, 100, 15);
		PanelPrograma.add(LabelCorreo_1);

		JLabel LabelFechaNac_1 = new JLabel("Fecha Ingreso");
		LabelFechaNac_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelFechaNac_1.setBounds(10, 181, 100, 15);
		PanelPrograma.add(LabelFechaNac_1);


		/*------------------------ Usuario Variables  ------------------------------------------*/
		//Combo box Usuarios
		comboBoxUsuarios = new JComboBox<String>();
		comboBoxUsuarios.setBounds(15, 40, 180, 25);
		getContentPane().add(comboBoxUsuarios);

		//Boton OK
		JButton ButtonOK = new JButton("OK");
		ButtonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					seleccionarUsuario(e);
				} catch (UsuarioExcepcion usuarioExcepcion) {
					usuarioExcepcion.printStackTrace();
				}
			}
		});
		ButtonOK.setBounds(230, 40, 73, 25);
		getContentPane().add(ButtonOK);

		//Text Nombre usuario
		nombreUsuario = new JTextField();
		nombreUsuario.setEditable(false);
		nombreUsuario.setBounds(140, 20, 160, 20);
		DatosPanel.add(nombreUsuario);
		nombreUsuario.setColumns(10);

		//Text Apellido
		apellidoUsuario = new JTextField();
		apellidoUsuario.setEditable(false);
		apellidoUsuario.setColumns(10);
		apellidoUsuario.setBounds(140, 55, 160, 20);
		DatosPanel.add(apellidoUsuario);

		//Text Nick
		nickname = new JTextField();
		nickname.setEditable(false);
		nickname.setColumns(10);
		nickname.setBounds(140, 90, 160, 20);
		DatosPanel.add(nickname);

		//Text Correo
		correo = new JTextField();
		correo.setEditable(false);
		correo.setColumns(10);
		correo.setBounds(140, 125, 160, 20);
		DatosPanel.add(correo);

		//Text Fecha Nacimiento
		FechaNac = new JTextField();
		FechaNac.setEditable(false);
		FechaNac.setColumns(10);
		FechaNac.setBounds(140, 160, 160, 20);
		DatosPanel.add(FechaNac);

		//Text Es Docente
		EsDocente = new JTextField();
		EsDocente.setEditable(false);
		EsDocente.setColumns(10);
		EsDocente.setBounds(140, 195, 160, 20);
		DatosPanel.add(EsDocente);

		/*----------------------------------- Variables Edicion ----------------------------------------------------------*/
		//Combo box edicion
		comboBoxCursoReg = new JComboBox<String>();
		comboBoxCursoReg.setBounds(370, 35, 200, 25);
		getContentPane().add(comboBoxCursoReg);

		//Nombre Edicion
		textNombreEdicion = new JTextField();
		textNombreEdicion.setEditable(false);
		textNombreEdicion.setColumns(10);
		textNombreEdicion.setBounds(140, 32, 160, 20);
		panelEdicion.add(textNombreEdicion);

		//fecha incio
		fechaInicio = new JTextField();
		fechaInicio.setEditable(false);
		fechaInicio.setColumns(10);
		fechaInicio.setBounds(140, 63, 160, 20);
		panelEdicion.add(fechaInicio);

		//fecha fin edicion
		fechaFin = new JTextField();
		fechaFin.setEditable(false);
		fechaFin.setColumns(10);
		fechaFin.setBounds(140, 94, 160, 20);
		panelEdicion.add(fechaFin);

		//Fecha publicacion edicion
		fechaPublicacion = new JTextField();
		fechaPublicacion.setEditable(false);
		fechaPublicacion.setColumns(10);
		fechaPublicacion.setBounds(140, 125, 160, 20);
		panelEdicion.add(fechaPublicacion);

		//Si es vigente edicion
		vigente = new JTextField();
		vigente.setEditable(false);
		vigente.setColumns(10);
		vigente.setBounds(140, 156, 160, 20);
		panelEdicion.add(vigente);

		JButton ButtonOKEdicion = new JButton("OK");
		ButtonOKEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listarEdicionDatos(arg0);
			}
		});
		ButtonOKEdicion.setBounds(600, 35, 100, 25);
		getContentPane().add(ButtonOKEdicion);

		/*----------------------------------- Variables Programa Formacion ----------------------------------------------------------*/
		//Combo box programa
		comboBoxProgForIns = new JComboBox<String>();
		comboBoxProgForIns.setBounds(810, 37, 190, 25);
		getContentPane().add(comboBoxProgForIns);

		//Nombre programa
		nombreProg = new JTextField();
		nombreProg.setEditable(false);
		nombreProg.setColumns(10);
		nombreProg.setBounds(120, 32, 180, 20);
		PanelPrograma.add(nombreProg);

		//Descripcion Programa
		JTextArea DescripcionProg = new JTextArea();
		DescripcionProg.setEditable(false);
		DescripcionProg.setColumns(10);
		DescripcionProg.setBounds(120, 63, 180, 53);
		PanelPrograma.add(DescripcionProg);

		//Fecha inicion programa
		fechaInicioProg = new JTextField();
		fechaInicioProg.setEditable(false);
		fechaInicioProg.setColumns(10);
		fechaInicioProg.setBounds(120, 127, 180, 20);
		PanelPrograma.add(fechaInicioProg);

		//Fecha fin programa
		fechaFinProg = new JTextField();
		fechaFinProg.setEditable(false);
		fechaFinProg.setColumns(10);
		fechaFinProg.setBounds(120, 153, 180, 20);
		PanelPrograma.add(fechaFinProg);

		//fecha ingreso programa
		fechaIngresoProg = new JTextField();
		fechaIngresoProg.setEditable(false);
		fechaIngresoProg.setColumns(10);
		fechaIngresoProg.setBounds(120, 179, 180, 20);
		PanelPrograma.add(fechaIngresoProg);

		JLabel LabelCursos = new JLabel("Cursos");
		LabelCursos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LabelCursos.setBounds(10, 213, 100, 15);
		PanelPrograma.add(LabelCursos);

		comboCursosEnPrograma = new JComboBox<String>();
		comboCursosEnPrograma.setBounds(120, 210, 180, 22);
		PanelPrograma.add(comboCursosEnPrograma);

		JButton ButtonOKPrograma = new JButton("OK");
		ButtonOKPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listarProgramas(arg0);
			}
		});
		ButtonOKPrograma.setBounds(1025, 37, 100, 25);
		getContentPane().add(ButtonOKPrograma);

	}

	//Inicia el combo box de usuarios
	public void inicializarComboBoxListaUsuarios() {
		DefaultComboBoxModel<String> modelUsuarios = new DefaultComboBoxModel<String>();
		ArrayList<String> listaUsuarios = this.icon.listarUsuarios();
		for(String s : listaUsuarios) {
			modelUsuarios.addElement(s);
		}
		comboBoxUsuarios.setModel(modelUsuarios);
	}

	protected void cancelarConsultaUsuario(ActionEvent arg0) {
		limpiarFormulario();
		setVisible(false);
	}

	//Selecciona el usuario y lista los demas comboboxes
	public void seleccionarUsuario(ActionEvent arg0) throws UsuarioExcepcion {
		String usuarioElegidoNick = this.comboBoxUsuarios.getSelectedItem().toString();
		List<DTUsuario> listaUsuarios = icon.listarDTUsuarios();
		DTUsuario usuario = icon.verInfoUsuario(usuarioElegidoNick);
		this.nombreUsuario.setText(usuario.getNombre());
		this.apellidoUsuario.setText(usuario.getApellido());
		this.nickname.setText(usuarioElegidoNick);
		this.correo.setText(usuario.getCorreo());
		SimpleDateFormat fechaNac = new SimpleDateFormat("yyyy/MM/dd");
		String fechaN = fechaNac.format(usuario.getFechaNac());
		FechaNac.setText(fechaN);

		if (usuario instanceof DTDocente) {
			this.EsDocente.setText("Si");
			String[] edicionesD = ((DTDocente) usuario).getEdiciones().toArray(new String[0]);
			DefaultComboBoxModel<String> listEdiDoc = new DefaultComboBoxModel<String>(edicionesD);
			comboBoxCursoReg.setModel(listEdiDoc);
		} else {
			this.EsDocente.setText("No");
			List<DTEdicionCurso> listaedis = ((DTEstudiante) usuario).getEdiciones();
			String[] edicionesE = new String[listaedis.size()];
			Integer i = 0;
			for (DTEdicionCurso dt : listaedis) {
				edicionesE[i] = dt.getNombre();
				i++;
			}
			List<DTProgramaFormacion> listapros = ((DTEstudiante) usuario).getProgramas();
			String[] programasE = new String[listapros.size()];
			i = 0;
			for (DTProgramaFormacion dtp : listapros) {
				edicionesE[i] = dtp.getNombre();
				i++;
			}
			DefaultComboBoxModel<String> listEdiEst = new DefaultComboBoxModel<String>(edicionesE);
			comboBoxCursoReg.setModel(listEdiEst);
			DefaultComboBoxModel<String> listProEst = new DefaultComboBoxModel<String>(programasE);
			comboBoxProgForIns.setModel(listProEst);
		}

	}
	
	protected void listarEdicionDatos(ActionEvent arg0){
		String edicionCursoElegida = this.comboBoxCursoReg.getSelectedItem().toString();
		DTEdicionCurso dtc = new DTEdicionCurso();
		try {
			dtc = this.iconC.verInfoEdicion(edicionCursoElegida);
			this.textNombreEdicion.setText(dtc.getNombre());
			SimpleDateFormat fechaInicio = new SimpleDateFormat("yyyy/MM/dd");
			String fechaI = fechaInicio.format(dtc.getFechaI());
			this.fechaInicio.setText(fechaI);
			SimpleDateFormat fechaF = new SimpleDateFormat("yyyy/MM/dd");
			String fechaFinal = fechaF.format(dtc.getFechaF());
			this.fechaFin.setText(fechaFinal);
			SimpleDateFormat fechaPubl = new SimpleDateFormat("yyyy/MM/dd");
			String fechaP = fechaPubl.format(dtc.getFechaPub());
			this.fechaPublicacion.setText(fechaP);
			Date todayDate = Calendar.getInstance().getTime();
			Date dateChooser = dtc.getFechaF();
			if(dateChooser.after(todayDate)) {
				this.vigente.setText("Si");
			} else {
				this.vigente.setText("No");
			}

		} catch (EdicionExcepcion e1) {
			e1.printStackTrace();
		}
	}

	protected void listarProgramas(ActionEvent arg0) {
		String programaElegido = this.comboBoxProgForIns.getSelectedItem().toString();
		DTProgramaFormacion dtp = new DTProgramaFormacion();
		try {
			dtp = this.iconC.verInfoPrograma(programaElegido);
			this.nombreProg.setText(dtp.getNombre());
			DescripcionProg.setText(dtp.getDescripcion());
			this.fechaInicioProg.setText(dtp.getFechaI().toString());
			this.fechaFinProg.setText(dtp.getFechaF().toString());
			this.fechaIngresoProg.setText(dtp.getFechaI().toString());
			DefaultComboBoxModel<String> cursosPrograma = new DefaultComboBoxModel<String>();
			ArrayList<String> listaCursosPrograma = dtp.getCursos();
			for (String s : listaCursosPrograma) {
				cursosPrograma.addElement(s);
			}
			comboCursosEnPrograma.setModel(cursosPrograma);

		} catch (ProgramaFormacionExcepcion p) {
			p.printStackTrace();
		}
	}

	private void limpiarFormulario() {
		correo.setText("");
		nickname.setText("");
		nombreUsuario.setText("");
		apellidoUsuario.setText("");
		FechaNac.setText("");
		EsDocente.setText("");
		textNombreEdicion.setText("");
		fechaInicio.setText("");
		fechaFin.setText("");
		fechaPublicacion.setText("");
		vigente.setText("");
		nombreProg.setText("");
		fechaInicioProg.setText("");
		fechaFinProg.setText("");
		fechaIngresoProg.setText("");
		//DescripcionProg.setText("");
		String[] vacio = new String[1];
		vacio[0] = "";
		DefaultComboBoxModel<String> vacioModel = new DefaultComboBoxModel<String>();
		vacioModel.addElement(vacio[0]);
		comboBoxCursoReg.setModel(vacioModel);
		comboBoxProgForIns.setModel(vacioModel);
		comboCursosEnPrograma.setModel(vacioModel);

	}
}
