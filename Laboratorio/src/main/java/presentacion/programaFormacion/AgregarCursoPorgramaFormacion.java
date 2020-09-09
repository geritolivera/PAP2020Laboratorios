
package presentacion.programaFormacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import interfaces.IcontroladorCurso;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AgregarCursoPorgramaFormacion extends JInternalFrame {
	
	private IcontroladorCurso iconCurso;
	private ArrayList<String> cursos; //esto es para hacer el populate del comboBox
	private ArrayList<String> programas; //esto es para hacer el populate del comboBox
	private JComboBox<String> comboCursos;
	private JComboBox<String>  comboProgramasFormacion;
	private String curso;
	private String programa;

	
	
	public AgregarCursoPorgramaFormacion(IcontroladorCurso iconCurso) {
		
		this.iconCurso = iconCurso;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Agregar Curso a Programa de Formacion");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblPdf = new JLabel("Seleccionar Programa de Formacion");
		lblPdf.setBounds(25, 45, 178, 14);
		getContentPane().add(lblPdf);
		
		JLabel lblCurso = new JLabel("Seleccionar Curso");
		lblCurso.setBounds(25, 96, 178, 14);
		getContentPane().add(lblCurso);
		
		comboProgramasFormacion = new JComboBox<String>();
		comboProgramasFormacion.setBounds(232, 45, 178, 22);
		getContentPane().add(comboProgramasFormacion);
		
		comboCursos = new JComboBox<String>();
		comboCursos.setBounds(232, 92, 178, 22);
		getContentPane().add(comboCursos);
		
		JButton button = new JButton("Aceptar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdAgregarCursoProgramaFormacionActionPerformed(e);
			}
		});
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
	
	 protected void cmdAgregarCursoProgramaFormacionActionPerformed(ActionEvent arg0) {
         
		 programa=(String) comboProgramasFormacion.getSelectedItem();
		 curso = (String) comboCursos.getSelectedItem();
	       
	    if (programa.isBlank() || curso.isBlank())
	        JOptionPane.showMessageDialog(null, "Error campos vacios", "Agregar Curso a Programa de Formacion", JOptionPane.INFORMATION_MESSAGE);
	    else 
	        JOptionPane.showMessageDialog(null, "Agregado!", "Agregar Curso a Programa de Formacion", JOptionPane.INFORMATION_MESSAGE); 
	    }
	

	
	public void cargarCombos() {
    	cursos=iconCurso.listarCursos();
    	programas=iconCurso.listarProgramas();
				
    	comboCursos.setModel(new DefaultComboBoxModel(cursos.toArray()));
		comboProgramasFormacion.setModel(new DefaultComboBoxModel(programas.toArray()));
	
		
    }
    
	protected void cancelar(ActionEvent arg0) {
		comboProgramasFormacion.removeAllItems();
		comboCursos.removeAllItems();
		setVisible(false);
	}

}
