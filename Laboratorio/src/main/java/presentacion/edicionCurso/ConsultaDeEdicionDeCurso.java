package presentacion.edicionCurso;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import datatypes.DTEdicionCurso;
import exepciones.EdicionExcepcion;
import interfaces.IcontroladorCurso;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class ConsultaDeEdicionDeCurso extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private IcontroladorCurso iconC;
	
	private JTextField tfNombre;
	private JTextField tfFechaInicio;
	private JTextField tfFechaFin;
	private JTextField tfCupo;
	
	private JComboBox<String> cbInstitutos;
	private JComboBox<String> cbCursos;
	private JComboBox<String> cbEdicion;
	
	private JTextPane tpDocentes;
	
	private JTextField tfPublicacion;

	
	public ConsultaDeEdicionDeCurso(IcontroladorCurso iconC) {
		
		this.iconC = iconC;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consulta de Edicion de Curso");
		setBounds(100, 100, 520, 335);
		getContentPane().setLayout(null);
		
		//Label Instituto
		JLabel lblNewLabel = new JLabel("Instituto");
		lblNewLabel.setBounds(35, 25, 50, 15);
		getContentPane().add(lblNewLabel);
		
		//Label Cursos
		JLabel lblCursos = new JLabel("Cursos");
		lblCursos.setBounds(265, 25, 50, 15);
		getContentPane().add(lblCursos);
		
		//Label Edicion de curso
		JLabel lblEdicionesDeCurso = new JLabel("Ediciones de Curso");
		lblEdicionesDeCurso.setBounds(35, 77, 126, 14);
		getContentPane().add(lblEdicionesDeCurso);
		
		//Combobox cursos de la edicion
		cbCursos = new JComboBox<String>();
		cbCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbCursosActionPerformed(arg0);
			}
		});
		cbCursos.setBounds(315, 20, 150, 20);
		getContentPane().add(cbCursos);
				
		//Combobox Ediciones de curso
		cbEdicion = new JComboBox<String>();
		cbEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbEdicionActionPerformed(arg0);
			}
		});
		cbEdicion.setBounds(145, 70, 150, 20);
		getContentPane().add(cbEdicion);
		
		//Combobox de Instituto
		cbInstitutos = new JComboBox<String>();
		cbInstitutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbInstitutosActionPerformed(arg0);
			}
		});
		cbInstitutos.setBounds(85, 20, 150, 20);
		getContentPane().add(cbInstitutos);
		
		//Label nombre
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(35, 119, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio");
		lblFechaDeInicio.setBounds(35, 145, 89, 14);
		getContentPane().add(lblFechaDeInicio);
		
		JLabel lblFechaDeFin = new JLabel("Fecha de fin");
		lblFechaDeFin.setBounds(35, 170, 89, 14);
		getContentPane().add(lblFechaDeFin);
		
		JLabel lblCupo = new JLabel("Cupo");
		lblCupo.setBounds(35, 195, 46, 14);
		getContentPane().add(lblCupo);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(145, 116, 150, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfFechaInicio = new JTextField();
		tfFechaInicio.setBounds(145, 142, 150, 20);
		getContentPane().add(tfFechaInicio);
		tfFechaInicio.setColumns(10);
		
		tfFechaFin = new JTextField();
		tfFechaFin.setBounds(145, 167, 150, 20);
		getContentPane().add(tfFechaFin);
		tfFechaFin.setColumns(10);
		
		tfCupo = new JTextField();
		tfCupo.setBounds(145, 192, 150, 20);
		getContentPane().add(tfCupo);
		tfCupo.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(315, 102, 150, 135);
		getContentPane().add(scrollPane);
		
		tpDocentes = new JTextPane();
		scrollPane.setViewportView(tpDocentes);
		
		JLabel lblDocentes = new JLabel("Docentes");
		lblDocentes.setBounds(360, 75, 46, 14);
		getContentPane().add(lblDocentes);
		
		JLabel lblFechaDePublicacion = new JLabel("Fecha de publicacion");
		lblFechaDePublicacion.setBounds(35, 220, 109, 14);
		getContentPane().add(lblFechaDePublicacion);
		
		tfPublicacion = new JTextField();
		tfPublicacion.setBounds(145, 217, 150, 20);
		getContentPane().add(tfPublicacion);
		tfPublicacion.setColumns(10);
		
		JButton ButtonCancelar = new JButton("Cancelar");
		ButtonCancelar.setBounds(180, 250, 100, 30);
		getContentPane().add(ButtonCancelar);

	}
	public void inicializarComboBoxInstituto() {
		DefaultComboBoxModel<String> modelInstitutos = new DefaultComboBoxModel<String>(iconC.listarInstitutos());
		cbInstitutos.setModel(modelInstitutos);
	}
	protected void inicializarComboBoxCursos(String nombreInstituto) {
		ArrayList<String> listaCursos = new ArrayList<String>();
		listaCursos = iconC.listarCursosAux(nombreInstituto);
		DefaultComboBoxModel<String> modelCursos = new DefaultComboBoxModel<String>();
		for(String s : listaCursos) {
			modelCursos.addElement(s);
		}
		cbCursos.setModel(modelCursos);
	}
	protected void inicializarComboBoxEdicion(String nombreCurso) {
		DefaultComboBoxModel<String> modelCursos = new DefaultComboBoxModel<String>(iconC.listarEdicionesAux(nombreCurso));
		cbEdicion.setModel(modelCursos);
	}
	private void cbInstitutosActionPerformed(ActionEvent arg0) {
		String nombreInstituto = this.cbInstitutos.getSelectedItem().toString();
		if(nombreInstituto.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No pueden haber campos vacios" , "Consulta de Edicion de Curso",JOptionPane.ERROR_MESSAGE);
		}else {
			inicializarComboBoxCursos(nombreInstituto);
		}	
	}
	private void cbCursosActionPerformed(ActionEvent arg0) {
		String nombreCurso = this.cbCursos.getSelectedItem().toString();
		if(nombreCurso.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No pueden haber campos vacios" , "Consulta Edicion de Curso",JOptionPane.ERROR_MESSAGE);
		}else {
			inicializarComboBoxEdicion(nombreCurso);
		}
	}
	protected void cbEdicionActionPerformed(ActionEvent arg0) {
		String nomEdicion = this.cbCursos.getSelectedItem().toString();
		if(nomEdicion.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No pueden haber campos vacios" , "Consulta de Edicion de Curso",JOptionPane.ERROR_MESSAGE);
		}else {
			try{
				DTEdicionCurso infoEd = iconC.verInfoEdicion(nomEdicion);
				tfNombre.setText(infoEd.getNombre());
				SimpleDateFormat fechaI = new SimpleDateFormat("yyyy/MM/dd");
				String fechaItext = fechaI.format(infoEd.getFechaI());
				SimpleDateFormat fechaF = new SimpleDateFormat("yyyy/MM/dd");
				String fechaFtext = fechaF.format(infoEd.getFechaF());
				SimpleDateFormat fechaP = new SimpleDateFormat("yyyy/MM/dd");
				String fechaPtext = fechaP.format(infoEd.getFechaPub());
				tfFechaInicio.setText(fechaItext);
				tfFechaFin.setText(fechaFtext);
				tfPublicacion.setText(fechaPtext);
				tfCupo.setText(Integer.toString(infoEd.getCupo()));
				cargarDocentesDeEdicion(nomEdicion);
			}catch(EdicionExcepcion e){
				JOptionPane.showMessageDialog(this, e.getMessage(), "Consulta de Edicion de Curso", JOptionPane.ERROR_MESSAGE);
			}	
		}
	}
	protected void cargarDocentesDeEdicion(String nomEdicion) {
		String[] infoDoc = iconC.listarDocentesAux(nomEdicion);
		tpDocentes.setText("");
		String info = "LISTADO_DE_DOCENTES";
		for (int j = 0; j < infoDoc.length; j++) {
			info = info + "\n\n" + infoDoc;
		}
		tpDocentes.setText(info);
	}
}
