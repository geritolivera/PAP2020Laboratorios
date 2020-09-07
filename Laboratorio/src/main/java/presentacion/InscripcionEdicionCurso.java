package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import interfaces.IcontroladorCurso;
import interfaces.IcontroladorUsuario;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import exepciones.EdicionExcepcion;
import exepciones.UsuarioExcepcion;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class InscripcionEdicionCurso extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IcontroladorCurso iconC;
	private IcontroladorUsuario iusu;
	private JTextField tfEdVigente;
	private JComboBox<String> cbInstituto;
	private JComboBox<String> cbEstudiantes;
	private JComboBox<String> cbCursos;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {/*
					InscripcionEdicionCurso frame = new InscripcionEdicionCurso();
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
	public InscripcionEdicionCurso(IcontroladorCurso iconC,IcontroladorUsuario iusu) {
		this.iconC = iconC;
		this.iusu = iusu;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Inscripcion a Edicion de Curso");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblInstituto = new JLabel("Instituto");
		lblInstituto.setBounds(32, 11, 46, 14);
		getContentPane().add(lblInstituto);
		
		JLabel lblCursos = new JLabel("Cursos");
		lblCursos.setBounds(198, 11, 46, 14);
		getContentPane().add(lblCursos);
		
		cbCursos = new JComboBox<String>();
		cbCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbCursosActionPerformed(arg0);
			}
		});
		cbCursos.setEnabled(false);
		cbCursos.setBounds(242, 11, 92, 20);
		getContentPane().add(cbCursos);
		
		cbInstituto = new JComboBox<String>();
		cbInstituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbInstitutoActionPerformed(arg0);
			}
		});
		cbInstituto.setBounds(89, 11, 85, 20);
		getContentPane().add(cbInstituto);
		
		JLabel lblNewLabel = new JLabel("Seleccione el estudiante que desea inscribir");
		lblNewLabel.setBounds(10, 151, 212, 14);
		getContentPane().add(lblNewLabel);
		
		cbEstudiantes = new JComboBox<String>();
		cbEstudiantes.setEnabled(false);
		cbEstudiantes.setBounds(232, 148, 102, 20);
		getContentPane().add(cbEstudiantes);
		
		JLabel lblEdicionVigente = new JLabel("Edicion Vigente");
		lblEdicionVigente.setBounds(10, 104, 102, 14);
		getContentPane().add(lblEdicionVigente);
		
		tfEdVigente = new JTextField();
		tfEdVigente.setEnabled(false);
		tfEdVigente.setBounds(120, 101, 86, 20);
		getContentPane().add(tfEdVigente);
		tfEdVigente.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAceptarActionPerformed(arg0);
			}
		});
		btnAceptar.setBounds(53, 225, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCancelarActionPerformed(arg0);
			}
		});
		btnCancelar.setBounds(193, 225, 89, 23);
		getContentPane().add(btnCancelar);

	}

	public void inicializarComboBoxInstituto() {
		DefaultComboBoxModel<String> modelInstitutos = new DefaultComboBoxModel<String>(iconC.listarInstitutos());
		cbInstituto.setModel(modelInstitutos);
		cbCursos.setEnabled(true);
	}
	
	protected void cbInstitutoActionPerformed(ActionEvent arg0) {
		String nombreInstituto = this.cbInstituto.getSelectedItem().toString();
		if(nombreInstituto.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un instituto" , "Inscripcion a Edicion de Curso",JOptionPane.ERROR_MESSAGE);
		}else {
			DefaultComboBoxModel<String> modelCursos = new DefaultComboBoxModel<String>(iconC.listarCursosAux(nombreInstituto));
			cbCursos.setModel(modelCursos);
		}
	}
	
	protected void cbCursosActionPerformed(ActionEvent arg0) {
		String nombreCurso = this.cbCursos.getSelectedItem().toString();
		if(nombreCurso.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un curso" , "Inscripcion a Edicion de Curso",JOptionPane.ERROR_MESSAGE);
		}else {
			tfEdVigente.setEnabled(true);
			cbEstudiantes.setEnabled(true);
			cbEstudiantes.setEnabled(true);
			DefaultComboBoxModel<String> modelEstudiantes = new DefaultComboBoxModel<String>(iusu.listarEstudiantesAux());
			cbEstudiantes.setModel(modelEstudiantes);
		}
	}
	protected void btnAceptarActionPerformed(ActionEvent arg0) {
		String nomEdicion = this.tfEdVigente.getText();
		String nickEstudiante = this.cbEstudiantes.getSelectedItem().toString();
		Date fecha = Calendar.getInstance().getTime();
		if(nickEstudiante.isEmpty()||nomEdicion.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No pueden haber campos vacios" , "Inscripcion a Edicion de Curso",JOptionPane.ERROR_MESSAGE);
		}else {
			try {
				this.iconC.inscribirEstudianteEdicion(nomEdicion, nickEstudiante, fecha);
			}catch(EdicionExcepcion e){//ver como se ponen dos excepciones
				JOptionPane.showMessageDialog(this, e.getMessage(), "Inscripcion a Edicion de Curso", JOptionPane.ERROR_MESSAGE);
			}catch(UsuarioExcepcion e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Inscripcion a Edicion de Curso", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	protected void btnCancelarActionPerformed(ActionEvent arg0){
        setVisible(false);
        tfEdVigente.setText("");
	}
	
	
	
}
