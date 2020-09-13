package presentacion.curso;

import datatypes.DTCurso;
import datatypes.DTEdicionCurso;
import datatypes.DTProgramaFormacion;
import exepciones.CursoExcepcion;
import exepciones.EdicionExcepcion;
import exepciones.ProgramaFormacionExcepcion;
import interfaces.IcontroladorCurso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ConsultaCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IcontroladorCurso icon;
	private JTextField textNomCurso;
	private JTextField textDescripcion;
	private JTextField textUrl;
	private JTextField textFechaAlta;
	private JTextField textCantCredito;
	private JTextField textCantHoras;
	private JTextField textDuracion;
	private JComboBox<String> comboBoxEdicionCurso;
	private JComboBox<String> comboBoxProAso;
	private JComboBox<String> comboBoxInstitutos;
	private JComboBox<String> comboBoxCursos;
	private JTextField textFieldFechaI;
	private JTextField textFieldFechaF;
	private JTextField textFieldFechP;
	private JTextField textFieldCupo;
	private JTextField textFieldDescripcionP;
	private JTextField textFieldFechaIP;
	private JTextField textFieldFechaFP;

	public ConsultaCurso(IcontroladorCurso icon) {
		
		this.icon = icon;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consulta de Curso");
		setBounds(100, 100, 426, 652);
		getContentPane().setLayout(null);
		
		JLabel LabelSelIns = new JLabel("Seleccionar Instituto");
		LabelSelIns.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelSelIns.setBounds(20, 25, 147, 20);
		getContentPane().add(LabelSelIns);

		comboBoxInstitutos = new JComboBox<String>();
		comboBoxInstitutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxInstitutosActionPerformed(arg0);
			}
		});
		comboBoxInstitutos.setBounds(169, 25, 200, 20);
		getContentPane().add(comboBoxInstitutos);

		JLabel LabelCursosAso = new JLabel("Cursos Asociados");
		LabelCursosAso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelCursosAso.setBounds(30, 59, 120, 20);
		getContentPane().add(LabelCursosAso);
		
		JLabel lblDatosDelCurso = new JLabel("Datos del Curso:");
		lblDatosDelCurso.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDatosDelCurso.setBounds(32, 91, 135, 20);
		getContentPane().add(lblDatosDelCurso);
		
		JLabel LabelNombreCurso = new JLabel("Nombre de Curso");
		LabelNombreCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelNombreCurso.setBounds(20, 123, 135, 20);
		getContentPane().add(LabelNombreCurso);
		
		textNomCurso = new JTextField();
		textNomCurso.setEnabled(false);
		textNomCurso.setColumns(10);
		textNomCurso.setBounds(169, 124, 200, 20);
		getContentPane().add(textNomCurso);
		
		JLabel LabelDesc = new JLabel("Descripcion");
		LabelDesc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelDesc.setBounds(53, 155, 88, 20);
		getContentPane().add(LabelDesc);
		
		textDescripcion = new JTextField();
		textDescripcion.setEnabled(false);
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(169, 156, 200, 51);
		getContentPane().add(textDescripcion);
		
		JLabel LabelDur = new JLabel("Duracion");
		LabelDur.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelDur.setBounds(53, 218, 58, 20);
		getContentPane().add(LabelDur);
		
		JLabel LabelMeses = new JLabel("Mes/Meses");
		LabelMeses.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelMeses.setBounds(214, 219, 88, 20);
		getContentPane().add(LabelMeses);
		
		JLabel LabelCantHoras = new JLabel("Cantidad de Horas");
		LabelCantHoras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelCantHoras.setBounds(15, 244, 135, 20);
		getContentPane().add(LabelCantHoras);
		
		JLabel LabelHoras = new JLabel("Por Dia");
		LabelHoras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelHoras.setBounds(214, 244, 50, 20);
		getContentPane().add(LabelHoras);
		
		JLabel lblCantidadDeCreditos = new JLabel("Cantidad de Creditos");
		lblCantidadDeCreditos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidadDeCreditos.setBounds(20, 276, 147, 20);
		getContentPane().add(lblCantidadDeCreditos);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUrl.setBounds(120, 308, 30, 20);
		getContentPane().add(lblUrl);
		
		textUrl = new JTextField();
		textUrl.setEnabled(false);
		textUrl.setColumns(10);
		textUrl.setBounds(169, 309, 200, 20);
		getContentPane().add(textUrl);
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de Alta");
		lblFechaDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaDeAlta.setBounds(66, 340, 90, 20);
		getContentPane().add(lblFechaDeAlta);
		
		textFechaAlta = new JTextField();
		textFechaAlta.setEnabled(false);
		textFechaAlta.setColumns(10);
		textFechaAlta.setBounds(169, 341, 200, 20);
		getContentPane().add(textFechaAlta);
		
		textCantCredito = new JTextField();
		textCantCredito.setEnabled(false);
		textCantCredito.setColumns(10);
		textCantCredito.setBounds(169, 277, 40, 20);
		getContentPane().add(textCantCredito);
		
		textCantHoras = new JTextField();
		textCantHoras.setEnabled(false);
		textCantHoras.setColumns(10);
		textCantHoras.setBounds(169, 245, 40, 20);
		getContentPane().add(textCantHoras);
		
		textDuracion = new JTextField();
		textDuracion.setEnabled(false);
		textDuracion.setColumns(10);
		textDuracion.setBounds(169, 219, 40, 20);
		getContentPane().add(textDuracion);
		
		JLabel lblEdicionesAsociadas = new JLabel("Ediciones Asociadas");
		lblEdicionesAsociadas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEdicionesAsociadas.setBounds(20, 372, 147, 20);
		getContentPane().add(lblEdicionesAsociadas);
		
		comboBoxEdicionCurso = new JComboBox<String>();
		comboBoxEdicionCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxEdicionCursoActionPerformed(arg0);
			}
		});
		comboBoxEdicionCurso.setEnabled(false);
		comboBoxEdicionCurso.setBounds(169, 373, 200, 20);
		getContentPane().add(comboBoxEdicionCurso);
		
		comboBoxProAso = new JComboBox<String>();
		comboBoxProAso.setEnabled(false);
		comboBoxProAso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			comboBoxProAsoActionPerformed(arg0);
			}
		});
		comboBoxProAso.setBounds(169, 503, 200, 20);
		getContentPane().add(comboBoxProAso);
		
		JLabel lblProgramasAsociadas = new JLabel("Programas Asociados");
		lblProgramasAsociadas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProgramasAsociadas.setBounds(20, 503, 147, 20);
		getContentPane().add(lblProgramasAsociadas);
		
		comboBoxCursos = new JComboBox<String>();
		comboBoxCursos.setEnabled(false);
		comboBoxCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxCursosActionPerformed(arg0);
			}
		});
		comboBoxCursos.setBounds(169, 57, 200, 24);
		getContentPane().add(comboBoxCursos);
		
		textFieldFechaI = new JTextField();
		textFieldFechaI.setEnabled(false);
		textFieldFechaI.setBounds(107, 431, 102, 19);
		getContentPane().add(textFieldFechaI);
		textFieldFechaI.setColumns(10);

		textFieldFechaF = new JTextField();
		textFieldFechaF.setEnabled(false);
		textFieldFechaF.setBounds(107, 462, 102, 19);
		getContentPane().add(textFieldFechaF);
		textFieldFechaF.setColumns(10);

		textFieldFechP = new JTextField();
		textFieldFechP.setEnabled(false);
		textFieldFechP.setBounds(302, 431, 102, 19);
		getContentPane().add(textFieldFechP);
		textFieldFechP.setColumns(10);

		textFieldCupo = new JTextField();
		textFieldCupo.setEnabled(false);
		textFieldCupo.setBounds(302, 462, 102, 19);
		getContentPane().add(textFieldCupo);
		textFieldCupo.setColumns(10);

		textFieldDescripcionP = new JTextField();
		textFieldDescripcionP.setEnabled(false);
		textFieldDescripcionP.setBounds(107, 556, 102, 52);
		getContentPane().add(textFieldDescripcionP);
		textFieldDescripcionP.setColumns(10);

		textFieldFechaIP = new JTextField();
		textFieldFechaIP.setEnabled(false);
		textFieldFechaIP.setBounds(302, 556, 102, 19);
		getContentPane().add(textFieldFechaIP);
		textFieldFechaIP.setColumns(10);

		textFieldFechaFP = new JTextField();
		textFieldFechaFP.setEnabled(false);
		textFieldFechaFP.setBounds(302, 589, 102, 19);
		getContentPane().add(textFieldFechaFP);
		textFieldFechaFP.setColumns(10);

		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblFechaInicio.setBounds(20, 433, 96, 15);
		getContentPane().add(lblFechaInicio);

		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblFechaFin.setBounds(20, 464, 70, 15);
		getContentPane().add(lblFechaFin);

		JLabel lblDatosDeEdicion = new JLabel("Datos de Edicion:");
		lblDatosDeEdicion.setBounds(42, 404, 147, 15);
		getContentPane().add(lblDatosDeEdicion);

		JLabel lblFechaPub = new JLabel("Fecha Publ");
		lblFechaPub.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblFechaPub.setBounds(214, 433, 88, 15);
		getContentPane().add(lblFechaPub);

		JLabel lblCupo = new JLabel("Cupo");
		lblCupo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCupo.setBounds(214, 464, 70, 15);
		getContentPane().add(lblCupo);

		JLabel lblDatosDePrograma = new JLabel("Datos de Programa:");
		lblDatosDePrograma.setBounds(53, 529, 147, 15);
		getContentPane().add(lblDatosDePrograma);

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblDescripcion.setBounds(15, 556, 126, 15);
		getContentPane().add(lblDescripcion);

		JLabel lblFechaInicio_1 = new JLabel("Fecha Inicio");
		lblFechaInicio_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblFechaInicio_1.setBounds(214, 556, 88, 15);
		getContentPane().add(lblFechaInicio_1);

		JLabel lblFechaFin_1 = new JLabel("Fecha Fin");
		lblFechaFin_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblFechaFin_1.setBounds(214, 591, 88, 15);
		getContentPane().add(lblFechaFin_1);


	}
	//aca llena el cb de los institutos(inicializar del principal view)
	public void inicializarComboBoxInstituto() {
		DefaultComboBoxModel<String> modelInstitutos = new DefaultComboBoxModel<String>(icon.listarInstitutos());
		comboBoxInstitutos.setModel(modelInstitutos);
	}
		//lleno el cb de ediciones
		protected void listarEdicionesAsociadas(String nomCurso) {
			ArrayList<String> listEdiciones = new ArrayList<String>();
			listEdiciones =	icon.listarEdicionesAux(nomCurso);
			DefaultComboBoxModel<String> modelEdiciones = new DefaultComboBoxModel<String>();
			for(String l : listEdiciones) {
				modelEdiciones.addElement(l);
			}
			comboBoxEdicionCurso.setModel(modelEdiciones);
		}
		//lleno el cb de programas
		protected void listarProgramasAsociados(String nomCurso){
			ArrayList<String> listProgramas = new ArrayList<String>();
			listProgramas =	icon.listarProgramasAux(nomCurso);
			DefaultComboBoxModel<String> modelProgramas = new DefaultComboBoxModel<String>();
			for(String l : listProgramas) {
				modelProgramas.addElement(l);
			}
			comboBoxProAso.setModel(modelProgramas);
		}
		protected void listarCursos(String nomInstituto) {
			String instituto = this.comboBoxInstitutos.getSelectedItem().toString();
			DefaultComboBoxModel<String> modelCursos = new DefaultComboBoxModel<String>();
			if(!nomInstituto.isEmpty() || !nomInstituto.contains("")) {
				ArrayList<String> listaCursos = icon.listarCursosAux(nomInstituto);
				for(String s : listaCursos) {
					modelCursos.addElement(s);
				}
				comboBoxCursos.setModel(modelCursos);
			} else if(nomInstituto.contains("")) {
				modelCursos.removeAllElements();
				comboBoxCursos.setModel(modelCursos);
			}
		}
		//aca lista los cursos
		private void comboBoxInstitutosActionPerformed(ActionEvent arg0) {
			String nomInstituto = this.comboBoxInstitutos.getSelectedItem().toString();
			if(nomInstituto.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Debe seleccionar un instituto" , "Consulta de Curso",JOptionPane.ERROR_MESSAGE);
			}else {//listo los cursos asociados
				comboBoxCursos.setEnabled(true);
				listarCursos(nomInstituto);
			}
		}
		//muestro los datos del curso elegido
		private void comboBoxCursosActionPerformed(ActionEvent arg0) {
			String nomCurso = this.comboBoxCursos.getSelectedItem().toString();
			if (nomCurso.isEmpty())
				JOptionPane.showMessageDialog(this, "Debe seleccionar un curso", "Consulta de Curso", JOptionPane.ERROR_MESSAGE);
			else {
				try {
					DTCurso infoCurso = icon.verInfo(nomCurso);
					textNomCurso.setEnabled(true);
					textDescripcion.setEnabled(true);
					textCantCredito.setEnabled(true);
					textDuracion.setEnabled(true);
					textCantHoras.setEnabled(true);
					textFechaAlta.setEnabled(true);
					textUrl.setEnabled(true);
					comboBoxEdicionCurso.setEnabled(true);
					comboBoxProAso.setEnabled(true);
					textNomCurso.setText(infoCurso.getNombre());
					textDuracion.setText(infoCurso.getDuracion());
					textDescripcion.setText(infoCurso.getDuracion());
					textCantCredito.setText(Integer.toString(infoCurso.getCreditos()));
					textCantHoras.setText(Integer.toString(infoCurso.getCantHoras()));
					textUrl.setText(infoCurso.getUrl());
					SimpleDateFormat fechaAlta = new SimpleDateFormat("yyyy/MM/dd");
					String fechaA = fechaAlta.format(infoCurso.getFechaR());
					textFechaAlta.setText(fechaA);
					listarEdicionesAsociadas(nomCurso);
					listarProgramasAsociados(nomCurso);
				} catch (CursoExcepcion e) {
					JOptionPane.showMessageDialog(this, e.getMessage(), "Consulta de Curso", JOptionPane.ERROR_MESSAGE);
				}
			}


		}

		//muestro los datos de la edicion
		protected void comboBoxEdicionCursoActionPerformed(ActionEvent arg0) {
			String nomEdicion= this.comboBoxEdicionCurso.getSelectedItem().toString();
			if(!nomEdicion.isEmpty()) {
				try {
					DTEdicionCurso infoEd = icon.verInfoEdicion(nomEdicion);
					textFieldFechaI.setEnabled(true);
					textFieldFechaF.setEnabled(true);
					textFieldFechP.setEnabled(true);
					textFieldCupo.setEnabled(true);
					SimpleDateFormat fechaInicio = new SimpleDateFormat("yyyy/MM/dd");
					String fechaI = fechaInicio.format(infoEd.getFechaI());
					textFieldFechaI.setText(fechaI);
					SimpleDateFormat fechaFin = new SimpleDateFormat("yyyy/MM/dd");
					String fechaF = fechaFin.format(infoEd.getFechaF());
					textFieldFechaF.setText(fechaF);
					SimpleDateFormat fechaPubli= new SimpleDateFormat("yyyy/MM/dd");
					String fechaP = fechaPubli.format(infoEd.getFechaPub());
					textFieldFechP.setText(fechaP);
					textFieldCupo.setText(Integer.toString(infoEd.getCupo()));
				}catch(EdicionExcepcion e){
					JOptionPane.showMessageDialog(this, e.getMessage(), "Consulta de Curso", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		//muestro los datos del prog de form
		protected void comboBoxProAsoActionPerformed(ActionEvent arg0) {
			String nomPrograma= this.comboBoxProAso.getSelectedItem().toString();
			if(!nomPrograma.isEmpty()) {
				try {
					DTProgramaFormacion infoPro = icon.verInfoPrograma(nomPrograma);
					textFieldDescripcionP.setEnabled(true);
					textFieldFechaIP.setEnabled(true);
					textFieldFechaFP.setEnabled(true);
					textFieldDescripcionP.setText(infoPro.getDescripcion());
					SimpleDateFormat fechaInicio = new SimpleDateFormat("yyyy/MM/dd");
					String fechaI = fechaInicio.format(infoPro.getFechaI());
					textFieldFechaIP.setText(fechaI);
					SimpleDateFormat fechaFin = new SimpleDateFormat("yyyy/MM/dd");
					String fechaF = fechaFin.format(infoPro.getFechaF());
					textFieldFechaFP.setText(fechaF);
				}catch(ProgramaFormacionExcepcion e) {
					JOptionPane.showMessageDialog(this, e.getMessage(), "Consulta de Curso", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		public void limpiarForm(){
			String[] vacio = new String[1];
			vacio[0] = "";
			inicializarComboBoxInstituto();
			DefaultComboBoxModel<String> vacioModel = new DefaultComboBoxModel<String>();
			vacioModel.addElement(vacio[0]);
			comboBoxCursos.setModel(vacioModel);
			comboBoxEdicionCurso.setModel(vacioModel);
			comboBoxProAso.setModel(vacioModel);


			textNomCurso.setText("");
			textDescripcion.setText("");
			textUrl.setText("");
			textFechaAlta.setText("");
		    textCantCredito.setText("");
			textCantHoras.setText("");
			textDuracion.setText("");
			textFieldFechaI.setText("");
			textFieldFechaF.setText("");
			textFieldFechP.setText("");
			textFieldCupo.setText("");
			textFieldDescripcionP.setText("");
			textFieldFechaIP.setText("");
			textFieldFechaFP.setText("");



		}
}