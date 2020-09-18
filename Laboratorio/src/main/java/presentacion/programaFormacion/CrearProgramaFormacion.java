package presentacion.programaFormacion;

import com.toedter.calendar.JDateChooser;
import exepciones.ProgramaFormacionExcepcion;
import interfaces.IcontroladorCurso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

@SuppressWarnings("serial")
public class CrearProgramaFormacion extends JInternalFrame {
	private JTextField inputNombre;
	private JTextArea inputDescripcion;
	private JDateChooser dateChooserInicio;
	private JDateChooser dateChooserFin;
	private IcontroladorCurso iconCurso;
	
	public CrearProgramaFormacion(IcontroladorCurso iconCurso) {
		
		this.iconCurso = iconCurso;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Crear Programa de Formacion");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel nombrePDF = new JLabel("Nombre: ");
		nombrePDF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nombrePDF.setBounds(10, 21, 72, 14);
		getContentPane().add(nombrePDF);
		
		JLabel fechaInicio = new JLabel("Fecha de Inicio:");
		fechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fechaInicio.setBounds(10, 57, 130, 14);
		getContentPane().add(fechaInicio);
		
		JLabel fechaFin = new JLabel("Fecha de Fin:");
		fechaFin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fechaFin.setBounds(10, 92, 82, 14);
		getContentPane().add(fechaFin);
		
		JLabel descripcion = new JLabel("Descripcion:");
		descripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		descripcion.setBounds(10, 131, 82, 14);
		getContentPane().add(descripcion);
		
		inputNombre = new JTextField();
		inputNombre.setBounds(244, 18, 130, 25);
		getContentPane().add(inputNombre);
		inputNombre.setColumns(10);

		inputDescripcion = new JTextArea();
		inputDescripcion.setBounds(102, 128, 296, 57);
		getContentPane().add(inputDescripcion);
		
		dateChooserInicio = new JDateChooser();
		dateChooserInicio.setDateFormatString("dd-MM-yyyy");
		dateChooserInicio.setBounds(244, 56, 130, 25);
		getContentPane().add(dateChooserInicio);
		
		dateChooserFin = new JDateChooser();
		dateChooserFin.setDateFormatString("dd-MM-yyyy");
		dateChooserFin.setBounds(244, 92, 130, 25);
		getContentPane().add(dateChooserFin);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdRegistroProgramaFormacionActionPerformed(e);
			}
		});
		btnAceptar.setBounds(86, 208, 115, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelarAltaProgramaFormacion(e);
			}
		});
		btnCancelar.setBounds(259, 208, 115, 23);
		getContentPane().add(btnCancelar);
		

	}


    protected void cmdRegistroProgramaFormacionActionPerformed(ActionEvent arg0) {
           
        String nombre = this.inputNombre.getText();
        Date fActual = Calendar.getInstance().getTime();
        Date fFin = this.dateChooserFin.getDate();
        String descripcion = this.inputDescripcion.getText();
        Date fInicio = this.dateChooserInicio.getDate();
       
        if (checkFormulario()) {
        	try {
	        	this.iconCurso.crearProgramaFormacion(nombre, descripcion, fInicio, fFin, fActual);
	        	JOptionPane.showMessageDialog(this, "El Programa de Formacion se ha creado con exito", "Crear Programa Formacion",
	            JOptionPane.INFORMATION_MESSAGE);
	            limpiarFormulario();
	            setVisible(false);
        	}catch (ProgramaFormacionExcepcion e) {
	                // Muestro error de registro
	                JOptionPane.showMessageDialog(this, e.getMessage(), "Crear Programa Formacion", JOptionPane.ERROR_MESSAGE);
        	}
        }
    }

    
    private boolean checkFormulario() {
    	String nombre = this.inputNombre.getText();
        Date fFin = this.dateChooserFin.getDate();
        Date fInicio = this.dateChooserInicio.getDate();
		Date today = Calendar.getInstance().getTime();
        if (nombre.isEmpty() || (fInicio == null) || (fFin == null)) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Crear Programa Formacion",
					JOptionPane.ERROR_MESSAGE);
		}else{
            if(fFin.before(fInicio)){
				JOptionPane.showMessageDialog(this, "La fecha de inicio debe ser previa \n a la de finalizacion", "Crear Programa Formacion",JOptionPane.ERROR_MESSAGE);
				dateChooserFin.setDate((Date)null);
				dateChooserInicio.setDate((Date)null);
				dateChooserFin.revalidate();
				dateChooserInicio.revalidate();
				return false;
            }
			return true;
		}

		return true;
	}

	protected void cancelarAltaProgramaFormacion(ActionEvent e) {
		limpiarFormulario();
		setVisible(false);
	}

	private void limpiarFormulario() {
		inputNombre.setText("");
		inputDescripcion.setText("");
		dateChooserInicio.setDate((Date)null);
		dateChooserFin.setDate((Date)null);
		dateChooserFin.revalidate();
		dateChooserInicio.revalidate();
		
	}
}
