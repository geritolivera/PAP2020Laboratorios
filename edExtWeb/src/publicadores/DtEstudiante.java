/**
 * DtEstudiante.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class DtEstudiante  extends publicadores.DtUsuario  implements java.io.Serializable {
    private publicadores.DtEdicionCurso[] ediciones;

    private publicadores.DtProgramaFormacion[] programas;

    public DtEstudiante() {
    }

    public DtEstudiante(
           java.lang.String nick,
           java.lang.String nombre,
           java.lang.String apellido,
           java.lang.String correo,
           java.util.Calendar fechaNac,
           java.lang.String password,
           java.lang.String image,
           java.lang.String[] seguidores,
           java.lang.String[] seguidos,
           publicadores.DtEdicionCurso[] ediciones,
           publicadores.DtProgramaFormacion[] programas) {
        super(
            nick,
            nombre,
            apellido,
            correo,
            fechaNac,
            password,
            image,
            seguidores,
            seguidos);
        this.ediciones = ediciones;
        this.programas = programas;
    }


    /**
     * Gets the ediciones value for this DtEstudiante.
     * 
     * @return ediciones
     */
    public publicadores.DtEdicionCurso[] getEdiciones() {
        return ediciones;
    }


    /**
     * Sets the ediciones value for this DtEstudiante.
     * 
     * @param ediciones
     */
    public void setEdiciones(publicadores.DtEdicionCurso[] ediciones) {
        this.ediciones = ediciones;
    }

    public publicadores.DtEdicionCurso getEdiciones(int i) {
        return this.ediciones[i];
    }

    public void setEdiciones(int i, publicadores.DtEdicionCurso _value) {
        this.ediciones[i] = _value;
    }


    /**
     * Gets the programas value for this DtEstudiante.
     * 
     * @return programas
     */
    public publicadores.DtProgramaFormacion[] getProgramas() {
        return programas;
    }


    /**
     * Sets the programas value for this DtEstudiante.
     * 
     * @param programas
     */
    public void setProgramas(publicadores.DtProgramaFormacion[] programas) {
        this.programas = programas;
    }

    public publicadores.DtProgramaFormacion getProgramas(int i) {
        return this.programas[i];
    }

    public void setProgramas(int i, publicadores.DtProgramaFormacion _value) {
        this.programas[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DtEstudiante)) return false;
        DtEstudiante other = (DtEstudiante) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.ediciones==null && other.getEdiciones()==null) || 
             (this.ediciones!=null &&
              java.util.Arrays.equals(this.ediciones, other.getEdiciones()))) &&
            ((this.programas==null && other.getProgramas()==null) || 
             (this.programas!=null &&
              java.util.Arrays.equals(this.programas, other.getProgramas())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getEdiciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEdiciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEdiciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getProgramas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProgramas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProgramas(), i);
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
        new org.apache.axis.description.TypeDesc(DtEstudiante.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtEstudiante"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ediciones");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ediciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtEdicionCurso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("programas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "programas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtProgramaFormacion"));
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
