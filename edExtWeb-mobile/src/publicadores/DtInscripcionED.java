/**
 * DtInscripcionED.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class DtInscripcionED  implements java.io.Serializable {
    private java.lang.String usuario;

    private java.lang.String edicion;

    private java.lang.String estado;

    private java.lang.String fechaIns;

    private float prioridad;

    public DtInscripcionED() {
    }

    public DtInscripcionED(
           java.lang.String usuario,
           java.lang.String edicion,
           java.lang.String estado,
           java.lang.String fechaIns,
           float prioridad) {
           this.usuario = usuario;
           this.edicion = edicion;
           this.estado = estado;
           this.fechaIns = fechaIns;
           this.prioridad = prioridad;
    }


    /**
     * Gets the usuario value for this DtInscripcionED.
     * 
     * @return usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this DtInscripcionED.
     * 
     * @param usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }


    /**
     * Gets the edicion value for this DtInscripcionED.
     * 
     * @return edicion
     */
    public java.lang.String getEdicion() {
        return edicion;
    }


    /**
     * Sets the edicion value for this DtInscripcionED.
     * 
     * @param edicion
     */
    public void setEdicion(java.lang.String edicion) {
        this.edicion = edicion;
    }


    /**
     * Gets the estado value for this DtInscripcionED.
     * 
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this DtInscripcionED.
     * 
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }


    /**
     * Gets the fechaIns value for this DtInscripcionED.
     * 
     * @return fechaIns
     */
    public java.lang.String getFechaIns() {
        return fechaIns;
    }


    /**
     * Sets the fechaIns value for this DtInscripcionED.
     * 
     * @param fechaIns
     */
    public void setFechaIns(java.lang.String fechaIns) {
        this.fechaIns = fechaIns;
    }


    /**
     * Gets the prioridad value for this DtInscripcionED.
     * 
     * @return prioridad
     */
    public float getPrioridad() {
        return prioridad;
    }


    /**
     * Sets the prioridad value for this DtInscripcionED.
     * 
     * @param prioridad
     */
    public void setPrioridad(float prioridad) {
        this.prioridad = prioridad;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DtInscripcionED)) return false;
        DtInscripcionED other = (DtInscripcionED) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario()))) &&
            ((this.edicion==null && other.getEdicion()==null) || 
             (this.edicion!=null &&
              this.edicion.equals(other.getEdicion()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.fechaIns==null && other.getFechaIns()==null) || 
             (this.fechaIns!=null &&
              this.fechaIns.equals(other.getFechaIns()))) &&
            this.prioridad == other.getPrioridad();
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
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        if (getEdicion() != null) {
            _hashCode += getEdicion().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getFechaIns() != null) {
            _hashCode += getFechaIns().hashCode();
        }
        _hashCode += new Float(getPrioridad()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DtInscripcionED.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtInscripcionED"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "usuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("edicion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "edicion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaIns");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaIns"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prioridad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prioridad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
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
