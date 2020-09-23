package presentacion.curso;

import com.toedter.calendar.JDateChooser;
import exepciones.CursoExcepcion;
import exepciones.InstitutoExcepcion;
import interfaces.IcontroladorCurso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.*;

public class AltaCurso extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;

	private IcontroladorCurso iconC;
	private JComboBox<String> comboBoxInstituto;
	private JComboBox<Integer> duracion;
	private JComboBox<String> meses;
	private JTextField textNombreCur;
	private JTextField textDescripcion;
	private JTextField textCantCreditos;
	private JTextField textURL;
	private Integer[] listDur = {0,1,2,3,4,5,6,7,8};
	private String[] listMeses = {"","2","3","4","5","6","7","8","9","10","11","12"};
	private JDateChooser dateChooser;
	private JList listCursos;
	private ArrayList<String> lisCursos ;
	private ArrayList<String> previas = new ArrayList<String>();
	private JTextArea output;
	private JList<String> listCategorias;

	public AltaCurso(IcontroladorCurso icon) {


		this.iconC = icon;
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Alta de Curso");
		setBounds(100, 100, 410, 727);
		getContentPane().setLayout(null);

		/*----LABELS---------------------------------------------*/

		JLabel LabelSelIns = new JLabel("Seleccionar Instituto");
		LabelSelIns.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelSelIns.setBounds(20, 30, 120, 20);
		getContentPane().add(LabelSelIns);

		JLabel LabelNombreCurso = new JLabel("Nombre de Curso");
		LabelNombreCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelNombreCurso.setBounds(35, 70, 105, 20);
		getContentPane().add(LabelNombreCurso);

		JLabel LabelDesc = new JLabel("Descripcion");
		LabelDesc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelDesc.setBounds(70, 110, 70, 20);
		getContentPane().add(LabelDesc);

		JLabel LabelDur = new JLabel("Duracion");
		LabelDur.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelDur.setBounds(80, 210, 58, 20);
		getContentPane().add(LabelDur);

		JLabel LabelMeses = new JLabel("Mes/Meses");
		LabelMeses.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelMeses.setBounds(215, 210, 70, 20);
		getContentPane().add(LabelMeses);

		JLabel LabelCantHoras = new JLabel("Cantidad de Horas");
		LabelCantHoras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelCantHoras.setBounds(25, 250, 118, 20);
		getContentPane().add(LabelCantHoras);

		JLabel LabelHoras = new JLabel("Por Dia");
		LabelHoras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelHoras.setBounds(215, 250, 50, 20);
		getContentPane().add(LabelHoras);

		JLabel lblCantidadDeCreditos = new JLabel("Cantidad de Creditos");
		lblCantidadDeCreditos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidadDeCreditos.setBounds(20, 290, 121, 20);
		getContentPane().add(lblCantidadDeCreditos);

		JLabel lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUrl.setBounds(100, 330, 30, 20);
		getContentPane().add(lblUrl);

		JLabel lblFechaDeAlta = new JLabel("Fecha de Alta");
		lblFechaDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaDeAlta.setBounds(50, 370, 90, 20);
		getContentPane().add(lblFechaDeAlta);

		JLabel lblCategorias = new JLabel("Categorias");
		lblCategorias.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCategorias.setBounds(50, 420, 90, 20);
		getContentPane().add(lblCategorias);
		
		JLabel lblMateriasPrevias = new JLabel("Materias previas");
		lblMateriasPrevias.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMateriasPrevias.setBounds(35, 531, 105, 20);
		getContentPane().add(lblMateriasPrevias);

		/*---------------------variables-----------------------*/
		comboBoxInstituto = new JComboBox<String>();
		comboBoxInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarCursos(e);
				habilitarIngresarDatos(e);
				inicializarListaCategoria(e);
			}
		});
		comboBoxInstituto.setBounds(155, 30, 150, 20);
		getContentPane().add(comboBoxInstituto);

		textNombreCur = new JTextField();
		textNombreCur.setBounds(155, 70, 200, 20);
		getContentPane().add(textNombreCur);
		textNombreCur.setColumns(10);

		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(155, 110, 200, 80);
		getContentPane().add(textDescripcion);

		meses = new JComboBox<String>();
		DefaultComboBoxModel<String> comboBoxModelMeses = new DefaultComboBoxModel<String>(listMeses);
		meses.setModel(comboBoxModelMeses);
		meses.setSelectedIndex(0);
		meses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbMesesActionPerformed(arg0);
			}
		});
		meses.setBounds(155, 210, 50, 20);
		getContentPane().add(meses);

		duracion = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> comboBoxModelDuracion = new DefaultComboBoxModel<>(listDur);
		duracion.setModel(comboBoxModelDuracion);
		duracion.setSelectedIndex(0);
		duracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			cbDuracionActionPerformed(arg0);
			}
		});
		duracion.setBounds(155, 250, 50, 20);
		getContentPane().add(duracion);

		textCantCreditos = new JTextField();
		textCantCreditos.setBounds(155, 290, 50, 20);
		getContentPane().add(textCantCreditos);
		textCantCreditos.setColumns(10);

		textURL = new JTextField();
		textURL.setColumns(10);
		textURL.setBounds(155, 330, 200, 20);
		getContentPane().add(textURL);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(155, 365, 200, 25);
		Date today = Calendar.getInstance().getTime();
		dateChooser.setDate(today);
		dateChooser.setSelectableDateRange(today, today);
		getContentPane().add(dateChooser);

		JScrollPane scrollPaneCategorias = new JScrollPane();
		scrollPaneCategorias.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneCategorias.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneCategorias.setBounds(155, 420, 200, 100);
		getContentPane().add(scrollPaneCategorias);		
		listCategorias = new JList<String>();
		scrollPaneCategorias.setViewportView(listCategorias);
		listCategorias.setEnabled(false);
				
		JScrollPane scrollPaneCursos = new JScrollPane();
		scrollPaneCursos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneCursos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneCursos.setBounds(155, 536, 200, 100);
		getContentPane().add(scrollPaneCursos);
		listCursos = new JList<String>();
		scrollPaneCursos.setViewportView(listCursos);
		listCursos.setEnabled(false);

		JButton ButtonAceptar = new JButton("Aceptar");
		ButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptarAltaCurso(e);
			}
		});
		ButtonAceptar.setBounds(70, 656, 100, 30);
		getContentPane().add(ButtonAceptar);

		JButton ButtonCancelar = new JButton("Cancelar");
		ButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelarAltaCurso(arg0);
			}
		});
		ButtonCancelar.setBounds(270, 656, 100, 30);
		getContentPane().add(ButtonCancelar);
		
		
	}

	/*-----------------------------------------------------------------------*/
	//Lista de Cursos con scroll pane

	protected void habilitarIngresarDatos(ActionEvent e) {
		String nomInstituto = this.comboBoxInstituto.getSelectedItem().toString();
		if(!nomInstituto.isEmpty() || !nomInstituto.contains("")) {
			duracion.setEnabled(true);
			meses.setEnabled(true);
			dateChooser.setEnabled(true);
		} else {
			JOptionPane.showMessageDialog(this, "Seleccione un instituto" , "Alta Curso", JOptionPane.ERROR_MESSAGE);
		}
	}


	//Lista los cursos

	protected void listarCursos(ActionEvent e) {
		String nomInstituto = this.comboBoxInstituto.getSelectedItem().toString();
		DefaultListModel<String> modelCursos = new DefaultListModel<String>();
		if(!nomInstituto.isEmpty() || !nomInstituto.contains("")) {
			listCursos.setEnabled(true);
			lisCursos = iconC.listarCursosAux(nomInstituto);
			for(String s : lisCursos) {
				modelCursos.addElement(s);
			}
			listCursos.setModel(modelCursos);
		}
	}

	/*-----------------------------------------------------------------------*/


	private void cbInstitutosActionPerformed(ActionEvent arg0) {
		String nomInstituto = this.comboBoxInstituto.getSelectedItem().toString();
		try{
			List<String> listaCursosDeInst = iconC.listarCursos(nomInstituto);
			if(!listaCursosDeInst.isEmpty()) {
				Vector<String> list = new Vector<String>();
				for (String s : listaCursosDeInst) {
					list.addElement(s);
				}
			this.listCursos.setListData(list);
		}}catch (InstitutoExcepcion institutoExcepcion) {
			JOptionPane.showMessageDialog(this, "El instituto no existe");
		}
	}

	private void cbDuracionActionPerformed(ActionEvent arg0) {
		Integer duracion = (Integer) this.duracion.getSelectedItem();
	}



	private void cbMesesActionPerformed(ActionEvent arg0) {
		String meses = this.meses.getSelectedItem().toString();

	}

	private void aceptarAltaCurso(ActionEvent e) {
		String nombreCurso = this.textNombreCur.getText();
		String url = this.textURL.getText();
		Integer duracion = (Integer) this.duracion.getSelectedItem();
		String meses = (String) this.meses.getSelectedItem();
		Integer cantCreditos= null;
		String descripcion = this.textDescripcion.getText();
		String instituto = this.comboBoxInstituto.getSelectedItem().toString();
		if(!listCursos.getSelectedValuesList().isEmpty()) {
			this.previas = (ArrayList<String>) listCursos.getSelectedValuesList();
		}

		Date dateChooser = this.dateChooser.getDate();
		try {
			cantCreditos = Integer.parseInt(this.textCantCreditos.getText());
			if (checkFormulario()) {
				try {
					if (!instituto.isEmpty()) {
						if (!nombreCurso.isEmpty()) {
							this.iconC.AltaCurso(nombreCurso, descripcion, meses, duracion, cantCreditos, dateChooser, url, instituto, previas);
							JOptionPane.showMessageDialog(this, "El Curso se ha creado con exito", "Alta Curso", JOptionPane.INFORMATION_MESSAGE);
							inicializarComboBoxInstituto();
							limpiarFormulario();
							setVisible(false);
						}
					}
				} catch (CursoExcepcion | InstitutoExcepcion c) {
					JOptionPane.showMessageDialog(this, c.getMessage(), "Alta Curso", JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (RuntimeException exep) {
			JOptionPane.showMessageDialog(this, "La cantidad de creditos ingresada no es valida", "Alta Curso", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void inicializarComboBoxInstituto() {
		DefaultComboBoxModel<String> listInst = new DefaultComboBoxModel<String>(iconC.listarInstitutos());
		comboBoxInstituto.setModel(listInst);
	}
	
	public void inicializarListaCategoria(ActionEvent arg0) {
		DefaultListModel<String> listCate = new DefaultListModel<String>();
		ArrayList<String> categorias = iconC.listarCategorias();
		for(String s : categorias) {
			listCate.addElement(s);
		}
		listCategorias.setModel(listCate);
	}
	
	protected void cancelarAltaCurso(ActionEvent arg0) {
		limpiarFormulario();
		setVisible(false);
	}


	private void limpiarFormulario() {
		textCantCreditos.setText("");
		textDescripcion.setText("");
		textNombreCur.setText("");
		textURL.setText("");
		dateChooser.setDate((Date)null);
		dateChooser.revalidate();
		listCategorias.removeAll();
	}

	private boolean checkFormulario() {
		String nombre = this.textNombreCur.getText();
		String desc = this.textDescripcion.getText();
		Integer cantCred= Integer.parseInt(this.textCantCreditos.getText());
		String url = this.textURL.getText();
		Date dateChooser = this.dateChooser.getDate();
		String fechaString = dateChooser.toString();
		Integer duracion = (Integer) this.duracion.getSelectedItem();
		String meses = (String) this.meses.getSelectedItem();

		Date today = Calendar.getInstance().getTime();
		if(nombre.isEmpty() || desc.isEmpty() || url.isEmpty() || fechaString.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vac�s", "Alta Curso", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if((duracion == 0) || (meses == "")){
			JOptionPane.showMessageDialog(this, "Ingrese duracion de curso", "Alta Curso", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(dateChooser.compareTo(today) > 0) {
			JOptionPane.showMessageDialog(this, "Debe ingresar una fecha valida", "Alta Curso", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(!url.contains(".com")) {
			JOptionPane.showMessageDialog(this, "Debe ingresar un url valido", "Alta Curso", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}
