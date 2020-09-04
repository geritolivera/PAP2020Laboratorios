package presentacion.programaFormacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import controladores.controladorCurso;
import datatypes.DTCurso;
import datatypes.DTProgramaFormacion;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AgregarCursoPorgramaFormacion extends JInternalFrame {
	
	private JComboBox<DTCurso> cursos;
	private JComboBox<DTProgramaFormacion>  programasFormacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarCursoPorgramaFormacion frame = new AgregarCursoPorgramaFormacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AgregarCursoPorgramaFormacion() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblPdf = new JLabel("Seleccionar Programa de Formacion");
		lblPdf.setBounds(25, 45, 178, 14);
		getContentPane().add(lblPdf);
		
		JLabel lblCurso = new JLabel("Seleccionar Curso");
		lblCurso.setBounds(25, 96, 178, 14);
		getContentPane().add(lblCurso);
		
		JComboBox programasFormacion = new JComboBox();
		programasFormacion.setBounds(232, 45, 178, 22);
		getContentPane().add(programasFormacion);
		
		JComboBox  cursos = new JComboBox();
		cursos.setBounds(232, 92, 178, 22);
		getContentPane().add(cursos);
		
		JButton button = new JButton("Aceptar");
		button.setBounds(58, 171, 115, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelar(arg0);
			}
		});
		button_1.setBounds(232, 171, 115, 23);
		getContentPane().add(button_1);

	}
	
    public void cargarProgramasFormacion() {
    	/*
        DefaultComboBoxModel<DTProgramaFormacion> model;
        try {
            model = new DefaultComboBoxModel<DTProgramaFormacion>(controladorCurso.listarProgramas());
            programasFormacion.setModel(model);
        } catch (UsuarioNoExisteException e) {
            // No se imprime mensaje de error sino que simplemente no se muestra ningún elemento
        }
		*/
    }
	
    public void cargarCursos() {
    	/*
        DefaultComboBoxModel<DTCurso> model;
        try {
            model = new DefaultComboBoxModel<DTCurso>(controladorCurso.listarCursos());
            cursos.setModel(model);
        } catch (UsuarioNoExisteException e) {
            // No se imprime mensaje de error sino que simplemente no se muestra ningún elemento
        }
		*/
    }
    
	protected void cancelar(ActionEvent arg0) {
		//programasFormacion.removeAllItems();
		//cursos.removeAllItems();
		setVisible(false);
	}

}
