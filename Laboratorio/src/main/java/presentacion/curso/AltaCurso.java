package presentacion.curso;

import com.toedter.calendar.JDateChooser;
import exepciones.CursoExcepcion;
import exepciones.InstitutoExcepcion;
import interfaces.IcontroladorCurso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AltaCurso extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;

	private IcontroladorCurso icon;
	private JComboBox<String> institutos;
	private JComboBox<Integer> duracion;
	private JComboBox<String> meses;
	private JTextField textNombreCur;
	private JTextField textDescripcion;
	private JTextField textCantCreditos;
	private JTextField textURL;
	private JList listCursos;
	private JDateChooser dateChooser;
	private Integer[] listDur = {0,1,2,3,4,5,6,7,8};
	private String[] listMeses = {"","2","3","4","5","6","7","8","9","10","11","12"};

	public AltaCurso(IcontroladorCurso icon) {
		
		this.icon = icon;
		this.institutos=inicializarComboBoxIns();
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta de Curso");
		setBounds(100, 100, 456, 621);
		getContentPane().setLayout(null);
		
		JLabel LabelSelIns = new JLabel("Seleccionar Instituto");
		LabelSelIns.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelSelIns.setBounds(20, 30, 120, 20);
		getContentPane().add(LabelSelIns);
		
		institutos = new JComboBox<String>();
		inicializarComboBoxInstituto();
		institutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbInstitutosActionPerformed(arg0);
			}
		});
		institutos.setBounds(155, 30, 200, 20);
		getContentPane().add(institutos);
		
		JLabel LabelNombreCurso = new JLabel("Nombre de Curso");
		LabelNombreCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelNombreCurso.setBounds(35, 70, 105, 20);
		getContentPane().add(LabelNombreCurso);
		
		JLabel LabelDesc = new JLabel("Descripcion");
		LabelDesc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelDesc.setBounds(70, 110, 70, 20);
		getContentPane().add(LabelDesc);
		
		textNombreCur = new JTextField();
		textNombreCur.setBounds(155, 70, 200, 20);
		getContentPane().add(textNombreCur);
		textNombreCur.setColumns(10);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(155, 110, 200, 80);
		getContentPane().add(textDescripcion);
		
		JLabel LabelDur = new JLabel("Duracion");
		LabelDur.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelDur.setBounds(80, 210, 58, 20);
		getContentPane().add(LabelDur);
		
		meses = new JComboBox<String>(listMeses);
		meses.setSelectedIndex(0);
		meses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbMesesActionPerformed(arg0);
			}
		});
		meses.setBounds(155, 210, 50, 20);
		getContentPane().add(meses);
		
		JLabel LabelMeses = new JLabel("Mes/Meses");
		LabelMeses.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelMeses.setBounds(215, 210, 70, 20);
		getContentPane().add(LabelMeses);
		
		JLabel LabelCantHoras = new JLabel("Cantidad de Horas");
		LabelCantHoras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelCantHoras.setBounds(25, 250, 118, 20);
		getContentPane().add(LabelCantHoras);

		duracion = new JComboBox<Integer>(listDur);
		duracion.setSelectedIndex(0);
		duracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			cbDuracionActionPerformed(arg0);
			}
		});
		duracion.setBounds(155, 250, 50, 20);
		getContentPane().add(duracion);
		
		JLabel LabelHoras = new JLabel("Por Dia");
		LabelHoras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		LabelHoras.setBounds(215, 250, 50, 20);
		getContentPane().add(LabelHoras);
		
		JLabel lblCantidadDeCreditos = new JLabel("Cantidad de Creditos");
		lblCantidadDeCreditos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidadDeCreditos.setBounds(20, 290, 121, 20);
		getContentPane().add(lblCantidadDeCreditos);
		
		textCantCreditos = new JTextField();
		textCantCreditos.setBounds(155, 290, 50, 20);
		getContentPane().add(textCantCreditos);
		textCantCreditos.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUrl.setBounds(100, 330, 30, 20);
		getContentPane().add(lblUrl);
		
		textURL = new JTextField();
		textURL.setColumns(10);
		textURL.setBounds(155, 330, 200, 20);
		getContentPane().add(textURL);
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de Alta");
		lblFechaDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaDeAlta.setBounds(50, 370, 90, 20);
		getContentPane().add(lblFechaDeAlta);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(155, 365, 200, 25);
		getContentPane().add(dateChooser);
		
		JLabel lblMateriasPrevias = new JLabel("Materias previas");
		lblMateriasPrevias.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMateriasPrevias.setBounds(35, 410, 105, 20);
		getContentPane().add(lblMateriasPrevias);

		listCursos = new JList();
		listCursos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listCursos.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		int[] selected = listCursos.getSelectedIndices();

		JScrollPane listScroller = new JScrollPane(listCursos);
		listScroller.setBounds(155, 415, 200, 100);
		getContentPane().add(listScroller);



		JButton ButtonAceptar = new JButton("Aceptar");
		ButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptarAltaCurso(e);
			}
		});
		ButtonAceptar.setBounds(70, 540, 100, 30);
		getContentPane().add(ButtonAceptar);
		
		JButton ButtonCancelar = new JButton("Cancelar");
		ButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelarAltaCurso(arg0);
			}
		});
		ButtonCancelar.setBounds(270, 540, 100, 30);
		getContentPane().add(ButtonCancelar);

	}

	private void cbInstitutosActionPerformed(ActionEvent arg0) {
		String nomInstituto = this.institutos.getSelectedItem().toString();
		List<String> listaCursosDeInst = icon.listarCursos(nomInstituto);
		this.listCursos.setListData(listaCursosDeInst.toArray());
		JOptionPane.showMessageDialog(this, nomInstituto + listaCursosDeInst );
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
		Integer cantCreditos = Integer.parseInt(this.textCantCreditos.getText());
		String descripcion = this.textDescripcion.getText();
		String instituto = this.institutos.getSelectedItem().toString();

		Date dateChooser = this.dateChooser.getDate();
		if(checkFormulario()){
			try{
				JOptionPane.showMessageDialog(this, nombreCurso + instituto);
				if(!instituto.isEmpty()){
					if(!nombreCurso.isEmpty()){
						this.icon.AltaCurso(nombreCurso,descripcion,meses,duracion,(Integer)cantCreditos, dateChooser,url,instituto);
						JOptionPane.showMessageDialog(this, "El Curso se ha creado con exito", "Alta Curso", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}catch(CursoExcepcion c){
				JOptionPane.showMessageDialog(this, c.getMessage(), "Alta Curso", JOptionPane.ERROR_MESSAGE);
			}catch(InstitutoExcepcion i){
				JOptionPane.showMessageDialog(this, i.getMessage(), "Alta Curso", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public void inicializarComboBoxInstituto() {
		DefaultComboBoxModel<String> listInst = new DefaultComboBoxModel<String>(icon.listarInstitutos());
		listInst.insertElementAt((new String("")),0);
		institutos.setModel(listInst);
		institutos.setSelectedIndex(0);
	}
	
	public JComboBox<String> inicializarComboBoxIns() {
		JComboBox<String> listInst = new JComboBox<String>(icon.listarInstitutos());
		listInst.insertItemAt((new String("")), 0);
		listInst.setSelectedIndex(0);
		return listInst;
	}

	protected void cancelarAltaCurso(ActionEvent arg0) {
		inicializarComboBoxInstituto();
		limpiarFormulario();
		setVisible(false);
	}


	private void limpiarFormulario() {
		textCantCreditos.setText("");
		textDescripcion.setText("");
		textNombreCur.setText("");
		textURL.setText("");
		dateChooser = null;
	}

	private boolean checkFormulario() {
		String nombre = this.textNombreCur.getText();
		String desc = this.textDescripcion.getText();
		String cantCred = this.textCantCreditos.getText();
		String url = this.textURL.getText();
		Date dateChooser = this.dateChooser.getDate();
		String fechaString = dateChooser.toString();

		Date today = Calendar.getInstance().getTime();
		if(nombre.isEmpty() || desc.isEmpty() || cantCred.isEmpty() || url.isEmpty() || fechaString.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vac�s", "Alta Curso", JOptionPane.ERROR_MESSAGE);
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
