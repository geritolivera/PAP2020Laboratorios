package presentacion.curso;

import com.toedter.calendar.JDateChooser;
import interfaces.IcontroladorCurso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class AltaCurso extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;

	private IcontroladorCurso icon;
	private JComboBox<String> institutos;
	private JTextField textNombreCur;
	private JTextField textDescripcion;
	private JTextField textCantCreditos;
	private JTextField textURL;
	private JDateChooser dateChooser;
	private Integer[] listDur = {1,2,3,4,5,6,7,8};
	private Integer[] listMeses = {2,3,4,5,6,7,8,9,10,11,12};

	public AltaCurso(IcontroladorCurso icon) {
		
		this.icon = icon;
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
		
		JComboBox<Integer> meses = new JComboBox<Integer>(listMeses);
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

		JComboBox<Integer> duracion = new JComboBox<Integer>(listDur);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(155, 415, 200, 100);
		getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
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

	private void aceptarAltaCurso(ActionEvent e) {
		String nombreCurso = this.textNombreCur.getText();
		String url = this.textURL.getText();

		String cantCreditos = this.textCantCreditos.getText();
		String descripcion = this.textDescripcion.getText();
		Date dateChooser = this.dateChooser.getDate();
		if(checkFormulario()){
			/*try{
				String curso = this.textNombreCur.getSelectedText();
				if(!curso.isEmpty()){
					//this.icon.AltaCurso(nombreCurso,descripcion,);
				}
			}catch(CursoExcepcion c){

			}*/
		}

	}

	public void inicializarComboBoxInstituto() {
		DefaultComboBoxModel<String> listInst = new DefaultComboBoxModel<String>(icon.listarInstitutos());
		listInst.insertElementAt((new String("")),0);
		institutos.setModel(listInst);
		institutos.setSelectedIndex(0);
	}

	protected void cancelarAltaCurso(ActionEvent arg0) {
		limpiarFormulario();
		setVisible(false);
	}

	private void limpiarFormulario() {
		inicializarComboBoxInstituto();
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
