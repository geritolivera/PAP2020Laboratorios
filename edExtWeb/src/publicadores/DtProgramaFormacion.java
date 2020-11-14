/**
 * DtProgramaFormacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class DtProgramaFormacion  implements java.io.Serializable {
    private java.lang.String nombre;

    private java.lang.String descripcion;

    private java.util.Calendar fechaI;

    private java.util.Calendar fechaF;

    private java.util.Calendar fechaA;

    private java.lang.String imagenURL;

    private java.lang.String[] cursos;

    private java.lang.String[] categorias;

    public DtProgramaFormacion() {
    }

    public DtProgramaFormacion(
           java.lang.String nombre,
           java.lang.String descripcion,
           java.util.Calendar fechaI,
           java.util.Calendar fechaF,
           java.util.Calendar fechaA,
           java.lang.String imagenURL,
           java.lang.String[] cursos,
           java.lang.String[] categorias) {
           this.nombre = nombre;
           this.descripcion = descripcion;
           this.fechaI = fechaI;
           this.fechaF = fechaF;
           this.fechaA = fechaA;
           this.imagenURL = imagenURL;
           this.cursos = cursos;
           this.categorias = categorias;
    }


    /**
     * Gets the nombre value for this DtProgramaFormacion.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this DtProgramaFormacion.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the descripcion value for this DtProgramaFormacion.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this DtProgramaFormacion.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the fechaI value for this DtProgramaFormacion.
     * 
     * @return fechaI
     */
    public java.util.Calendar getFechaI() {
        return fechaI;
    }


    /**
     * Sets the fechaI value for this DtProgramaFormacion.
     * 
     * @param fechaI
     */
    public void setFechaI(java.util.Calendar fechaI) {
        this.fechaI = fechaI;
    }


    /**
     * Gets the fechaF value for this DtProgramaFormacion.
     * 
     * @return fechaF
     */
    public java.util.Calendar getFechaF() {
        return fechaF;
    }


    /**
     * Sets the fechaF value for this DtProgramaFormacion.
     * 
     * @param fechaF
     */
    public void setFechaF(java.util.Calendar fechaF) {
        this.fechaF = fechaF;
    }


    /**
     * Gets the fechaA value for this DtProgramaFormacion.
     * 
     * @return fechaA
     */
    public java.util.Calendar getFechaA() {
        return fechaA;
    }


    /**
     * Sets the fechaA value for this DtProgramaFormacion.
     * 
     * @param fechaA
     */
    public void setFechaA(java.util.Calendar fechaA) {
        this.fechaA = fechaA;
    }


    /**
     * Gets the imagenURL value for this DtProgramaFormacion.
     * 
     * @return imagenURL
     */
    public java.lang.String getImagenURL() {
        return imagenURL;
    }


    /**
     * Sets the imagenURL value for this DtProgramaFormacion.
     * 
     * @param imagenURL
     */
    public void setImagenURL(java.lang.String imagenURL) {
        this.imagenURL = imagenURL;
    }


    /**
     * Gets the cursos value for this DtProgramaFormacion.
     * 
     * @return cursos
     */
    public java.lang.String[] getCursos() {
        return cursos;
    }


    /**
     * Sets the cursos value for this DtProgramaFormacion.
     * 
     * @param cursos
     */
    public void setCursos(java.lang.String[] cursos) {
        this.cursos = cursos;
    }

    public java.lang.String getCursos(int i) {
        return this.cursos[i];
    }

    public void setCursos(int i, java.lang.String _value) {
        this.cursos[i] = _value;
    }


    /**
     * Gets the categorias value for this DtProgramaFormacion.
     * 
     * @return categorias
     */
    public java.lang.String[] getCategorias() {
        return categorias;
    }


    /**
     * Sets the categorias value for this DtProgramaFormacion.
     * 
     * @param categorias
     */
    public void setCategorias(java.lang.String[] categorias) {
        this.categorias = categorias;
    }

    public java.lang.String getCategorias(int i) {
        return this.categorias[i];
    }

    public void setCategorias(int i, java.lang.String _value) {
        this.categorias[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DtProgramaFormacion)) return false;
        DtProgramaFormacion other = (DtProgramaFormacion) obj;
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
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.fechaI==null && other.getFechaI()==null) || 
             (this.fechaI!=null &&
              this.fechaI.equals(other.getFechaI()))) &&
            ((this.fechaF==null && other.getFechaF()==null) || 
             (this.fechaF!=null &&
              this.fechaF.equals(other.getFechaF()))) &&
            ((this.fechaA==null && other.getFechaA()==null) || 
             (this.fechaA!=null &&
              this.fechaA.equals(other.getFechaA()))) &&
            ((this.imagenURL==null && other.getImagenURL()==null) || 
             (this.imagenURL!=null &&
              this.imagenURL.equals(other.getImagenURL()))) &&
            ((this.cursos==null && other.getCursos()==null) || 
             (this.cursos!=null &&
              java.util.Arrays.equals(this.cursos, other.getCursos()))) &&
            ((this.categorias==null && other.getCategorias()==null) || 
             (this.categorias!=null &&
              java.util.Arrays.equals(this.categorias, other.getCategorias())));
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
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getFechaI() != null) {
            _hashCode += getFechaI().hashCode();
        }
        if (getFechaF() != null) {
            _hashCode += getFechaF().hashCode();
        }
        if (getFechaA() != null) {
            _hashCode += getFechaA().hashCode();
        }
        if (getImagenURL() != null) {
            _hashCode += getImagenURL().hashCode();
        }
        if (getCursos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCursos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCursos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCategorias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCategorias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCategorias(), i);
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
        new org.apache.axis.description.TypeDesc(DtProgramaFormacion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtProgramaFormacion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
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
        elemField.setFieldName("fechaA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("cursos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cursos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categorias");
        elemField.setXmlName(new javax.xml.namespace.QName("", "categorias"));
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
