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
import java.awt.event.ActionEvent;

public class ConsultaDeEdicionDeCurso extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private final IcontroladorCurso iconC;
	private final JTextField tfNombre;
	private final JTextField tfFechaInicio;
	private final JTextField tfFechaFin;
	private final JTextField tfCupo;
	private final JComboBox<String> cbInstitutos;
	private final JComboBox<String> cbCursos;
	private final JComboBox<String> cbEdicion;
	private final JTextPane tpDocentes;
	private final JTextField tfPublicacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {/*
					ConsultaDeEdicionDeCurso frame = new ConsultaDeEdicionDeCurso(null);
					frame.setVisible(true);*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @param iconC 
	 */
	public ConsultaDeEdicionDeCurso(IcontroladorCurso iconC) {
		this.iconC = iconC;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consulta de Edicion de Curso");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Instituto");
		lblNewLabel.setBounds(32, 22, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCursos = new JLabel("Cursos");
		lblCursos.setBounds(186, 22, 46, 14);
		getContentPane().add(lblCursos);
		
		cbCursos = new JComboBox<String>();
		cbCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbCursosActionPerformed(arg0);
			}
		});
		cbCursos.setBounds(230, 19, 86, 20);
		getContentPane().add(cbCursos);
		
		JLabel lblEdicionesDeCurso = new JLabel("Ediciones de Curso");
		lblEdicionesDeCurso.setBounds(32, 77, 126, 14);
		getContentPane().add(lblEdicionesDeCurso);
		
		cbEdicion = new JComboBox<String>();
		cbEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbEdicionActionPerformed(arg0);
			}
		});
		cbEdicion.setBounds(181, 74, 109, 20);
		getContentPane().add(cbEdicion);
		
		cbInstitutos = new JComboBox<String>();
		cbInstitutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbInstitutosActionPerformed(arg0);
			}
		});
		cbInstitutos.setBounds(85, 19, 73, 20);
		getContentPane().add(cbInstitutos);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(32, 133, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio");
		lblFechaDeInicio.setBounds(32, 159, 89, 14);
		getContentPane().add(lblFechaDeInicio);
		
		JLabel lblFechaDeFin = new JLabel("Fecha de fin");
		lblFechaDeFin.setBounds(32, 184, 89, 14);
		getContentPane().add(lblFechaDeFin);
		
		JLabel lblCupo = new JLabel("Cupo");
		lblCupo.setBounds(32, 209, 46, 14);
		getContentPane().add(lblCupo);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(146, 130, 86, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfFechaInicio = new JTextField();
		tfFechaInicio.setBounds(146, 156, 86, 20);
		getContentPane().add(tfFechaInicio);
		tfFechaInicio.setColumns(10);
		
		tfFechaFin = new JTextField();
		tfFechaFin.setBounds(146, 181, 86, 20);
		getContentPane().add(tfFechaFin);
		tfFechaFin.setColumns(10);
		
		tfCupo = new JTextField();
		tfCupo.setBounds(146, 206, 86, 20);
		getContentPane().add(tfCupo);
		tfCupo.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(289, 147, 109, 112);
		getContentPane().add(scrollPane);
		
		tpDocentes = new JTextPane();
		scrollPane.setViewportView(tpDocentes);
		
		JLabel lblDocentes = new JLabel("Docentes");
		lblDocentes.setBounds(312, 108, 46, 14);
		getContentPane().add(lblDocentes);
		
		JLabel lblFechaDePublicacion = new JLabel("Fecha de publicacion");
		lblFechaDePublicacion.setBounds(32, 234, 109, 14);
		getContentPane().add(lblFechaDePublicacion);
		
		tfPublicacion = new JTextField();
		tfPublicacion.setBounds(146, 231, 86, 20);
		getContentPane().add(tfPublicacion);
		tfPublicacion.setColumns(10);

	}
	public void inicializarComboBoxInstituto() {
		DefaultComboBoxModel<String> modelInstitutos = new DefaultComboBoxModel<String>(iconC.listarInstitutos());
		cbInstitutos.setModel(modelInstitutos);
	}
	protected void inicializarComboBoxCursos(String nombreInstituto) {
		DefaultComboBoxModel<String> modelCursos = new DefaultComboBoxModel<String>(iconC.listarCursosAux(nombreInstituto));
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
