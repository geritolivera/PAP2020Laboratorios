/**
 * DtEdicionCurso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class DtEdicionCurso  implements java.io.Serializable {
    private java.lang.String nombre;

    private java.util.Calendar fechaI;

    private java.util.Calendar fechaF;

    private int cupo;

    private java.util.Calendar fechaPub;

    private java.lang.String curso;

    private java.lang.String imagenURL;

    private java.lang.String[] docentes;

    public DtEdicionCurso() {
    }

    public DtEdicionCurso(
           java.lang.String nombre,
           java.util.Calendar fechaI,
           java.util.Calendar fechaF,
           int cupo,
           java.util.Calendar fechaPub,
           java.lang.String curso,
           java.lang.String imagenURL,
           java.lang.String[] docentes) {
           this.nombre = nombre;
           this.fechaI = fechaI;
           this.fechaF = fechaF;
           this.cupo = cupo;
           this.fechaPub = fechaPub;
           this.curso = curso;
           this.imagenURL = imagenURL;
           this.docentes = docentes;
    }


    /**
     * Gets the nombre value for this DtEdicionCurso.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this DtEdicionCurso.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the fechaI value for this DtEdicionCurso.
     * 
     * @return fechaI
     */
    public java.util.Calendar getFechaI() {
        return fechaI;
    }


    /**
     * Sets the fechaI value for this DtEdicionCurso.
     * 
     * @param fechaI
     */
    public void setFechaI(java.util.Calendar fechaI) {
        this.fechaI = fechaI;
    }


    /**
     * Gets the fechaF value for this DtEdicionCurso.
     * 
     * @return fechaF
     */
    public java.util.Calendar getFechaF() {
        return fechaF;
    }


    /**
     * Sets the fechaF value for this DtEdicionCurso.
     * 
     * @param fechaF
     */
    public void setFechaF(java.util.Calendar fechaF) {
        this.fechaF = fechaF;
    }


    /**
     * Gets the cupo value for this DtEdicionCurso.
     * 
     * @return cupo
     */
    public int getCupo() {
        return cupo;
    }


    /**
     * Sets the cupo value for this DtEdicionCurso.
     * 
     * @param cupo
     */
    public void setCupo(int cupo) {
        this.cupo = cupo;
    }


    /**
     * Gets the fechaPub value for this DtEdicionCurso.
     * 
     * @return fechaPub
     */
    public java.util.Calendar getFechaPub() {
        return fechaPub;
    }


    /**
     * Sets the fechaPub value for this DtEdicionCurso.
     * 
     * @param fechaPub
     */
    public void setFechaPub(java.util.Calendar fechaPub) {
        this.fechaPub = fechaPub;
    }


    /**
     * Gets the curso value for this DtEdicionCurso.
     * 
     * @return curso
     */
    public java.lang.String getCurso() {
        return curso;
    }


    /**
     * Sets the curso value for this DtEdicionCurso.
     * 
     * @param curso
     */
    public void setCurso(java.lang.String curso) {
        this.curso = curso;
    }


    /**
     * Gets the imagenURL value for this DtEdicionCurso.
     * 
     * @return imagenURL
     */
    public java.lang.String getImagenURL() {
        return imagenURL;
    }


    /**
     * Sets the imagenURL value for this DtEdicionCurso.
     * 
     * @param imagenURL
     */
    public void setImagenURL(java.lang.String imagenURL) {
        this.imagenURL = imagenURL;
    }


    /**
     * Gets the docentes value for this DtEdicionCurso.
     * 
     * @return docentes
     */
    public java.lang.String[] getDocentes() {
        return docentes;
    }


    /**
     * Sets the docentes value for this DtEdicionCurso.
     * 
     * @param docentes
     */
    public void setDocentes(java.lang.String[] docentes) {
        this.docentes = docentes;
    }

    public java.lang.String getDocentes(int i) {
        return this.docentes[i];
    }

    public void setDocentes(int i, java.lang.String _value) {
        this.docentes[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DtEdicionCurso)) return false;
        DtEdicionCurso other = (DtEdicionCurso) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.fechaI==null && other.getFechaI()==null) || 
             (this.fechaI!=null &&
              this.fechaI.equals(other.getFechaI()))) &&
            ((this.fechaF==null && other.getFechaF()==null) || 
             (this.fechaF!=null &&
              this.fechaF.equals(other.getFechaF()))) &&
            this.cupo == other.getCupo() &&
            ((this.fechaPub==null && other.getFechaPub()==null) || 
             (this.fechaPub!=null &&
              this.fechaPub.equals(other.getFechaPub()))) &&
            ((this.curso==null && other.getCurso()==null) || 
             (this.curso!=null &&
              this.curso.equals(other.getCurso()))) &&
            ((this.imagenURL==null && other.getImagenURL()==null) || 
             (this.imagenURL!=null &&
              this.imagenURL.equals(other.getImagenURL()))) &&
            ((this.docentes==null && other.getDocentes()==null) || 
             (this.docentes!=null &&
              java.util.Arrays.equals(this.docentes, other.getDocentes())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getFechaI() != null) {
            _hashCode += getFechaI().hashCode();
        }
        if (getFechaF() != null) {
            _hashCode += getFechaF().hashCode();
        }
        _hashCode += getCupo();
        if (getFechaPub() != null) {
            _hashCode += getFechaPub().hashCode();
        }
        if (getCurso() != null) {
            _hashCode += getCurso().hashCode();
        }
        if (getImagenURL() != null) {
            _hashCode += getImagenURL().hashCode();
        }
        if (getDocentes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocentes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocentes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DtEdicionCurso.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtEdicionCurso"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaI");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaF");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cupo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cupo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaPub");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaPub"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("curso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "curso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imagenURL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "imagenURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docentes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "docentes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
