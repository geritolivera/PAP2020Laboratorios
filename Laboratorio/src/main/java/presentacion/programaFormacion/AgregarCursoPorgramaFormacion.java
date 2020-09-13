
package presentacion.programaFormacion;

import exepciones.CursoExcepcion;
import exepciones.ProgramaFormacionExcepcion;
import interfaces.IcontroladorCurso;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblPdf = new JLabel("Seleccionar Programa de Formacion");
		lblPdf.setBounds(25, 45, 178, 14);
		getContentPane().add(lblPdf);
		
		JLabel lblCurso = new JLabel("Seleccionar Curso");
		lblCurso.setBounds(25, 96, 178, 14);
		getContentPane().add(lblCurso);
		
		programas=iconCurso.listarProgramas();
		programas.add(0,"Selecionar Programa");
		comboProgramasFormacion = new JComboBox(programas.toArray());

		comboProgramasFormacion.setBounds(232, 45, 178, 22);
		getContentPane().add(comboProgramasFormacion);
		

		cursos=iconCurso.listarCursos();
		cursos.add(0,"Selecionar Curso");
		//cursos= new ArrayList<>();
		//cursos.add("cursito 2 a�os");
		//cursos.add("curso 3 a�os de ruta");
		comboCursos = new JComboBox(cursos.toArray());

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


	public void inicializar(){
		programas = iconCurso.listarProgramas();
		DefaultComboBoxModel<String> modeloIni = new DefaultComboBoxModel<String>();
		for(String a:programas) {
			modeloIni.addElement(a);
		}
		comboProgramasFormacion.setModel(modeloIni);
		cursos = iconCurso.listarCursos();
		DefaultComboBoxModel<String> modeloIniCursos = new DefaultComboBoxModel<String>();
		for(String s:cursos){
			modeloIniCursos.addElement(s);
		}
		comboCursos.setModel(modeloIniCursos);

	}
	 protected void cmdAgregarCursoProgramaFormacionActionPerformed(ActionEvent arg0) {
         
		 programa=(String) comboProgramasFormacion.getSelectedItem();
		 curso = (String) comboCursos.getSelectedItem();
	       
	    if (programa.isEmpty() || curso.isEmpty())
	        JOptionPane.showMessageDialog(null, "Error campos vacios", "Agregar Curso a Programa de Formacion", JOptionPane.INFORMATION_MESSAGE);
	    else {
	    	try {
				this.iconCurso.agregarCursoPrograma(curso, programa);
				JOptionPane.showMessageDialog(null, "Agregado!", "Agregar Curso a Programa de Formacion", JOptionPane.INFORMATION_MESSAGE);
				inicializar();
				setVisible(false);
			} catch (ProgramaFormacionExcepcion e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error Programa Inexistente", JOptionPane.ERROR_MESSAGE);
			} catch (CursoExcepcion e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error Curso Inexistente", JOptionPane.ERROR_MESSAGE);
			}

	    }

	    }

	protected void cancelar(ActionEvent arg0) {
		comboProgramasFormacion.removeAllItems();
		comboCursos.removeAllItems();
		setVisible(false);
	}

}
