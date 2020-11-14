/**
 * DtUsuario.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class DtUsuario  implements java.io.Serializable {
    private java.lang.String nick;

    private java.lang.String nombre;

    private java.lang.String apellido;

    private java.lang.String correo;

    private java.util.Calendar fechaNac;

    private java.lang.String password;

    private java.lang.String image;

    private java.lang.String[] seguidores;

    private java.lang.String[] seguidos;

    public DtUsuario() {
    }

    public DtUsuario(
           java.lang.String nick,
           java.lang.String nombre,
           java.lang.String apellido,
           java.lang.String correo,
           java.util.Calendar fechaNac,
           java.lang.String password,
           java.lang.String image,
           java.lang.String[] seguidores,
           java.lang.String[] seguidos) {
           this.nick = nick;
           this.nombre = nombre;
           this.apellido = apellido;
           this.correo = correo;
           this.fechaNac = fechaNac;
           this.password = password;
           this.image = image;
           this.seguidores = seguidores;
           this.seguidos = seguidos;
    }


    /**
     * Gets the nick value for this DtUsuario.
     * 
     * @return nick
     */
    public java.lang.String getNick() {
        return nick;
    }


    /**
     * Sets the nick value for this DtUsuario.
     * 
     * @param nick
     */
    public void setNick(java.lang.String nick) {
        this.nick = nick;
    }


    /**
     * Gets the nombre value for this DtUsuario.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this DtUsuario.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the apellido value for this DtUsuario.
     * 
     * @return apellido
     */
    public java.lang.String getApellido() {
        return apellido;
    }


    /**
     * Sets the apellido value for this DtUsuario.
     * 
     * @param apellido
     */
    public void setApellido(java.lang.String apellido) {
        this.apellido = apellido;
    }


    /**
     * Gets the correo value for this DtUsuario.
     * 
     * @return correo
     */
    public java.lang.String getCorreo() {
        return correo;
    }


    /**
     * Sets the correo value for this DtUsuario.
     * 
     * @param correo
     */
    public void setCorreo(java.lang.String correo) {
        this.correo = correo;
    }


    /**
     * Gets the fechaNac value for this DtUsuario.
     * 
     * @return fechaNac
     */
    public java.util.Calendar getFechaNac() {
        return fechaNac;
    }


    /**
     * Sets the fechaNac value for this DtUsuario.
     * 
     * @param fechaNac
     */
    public void setFechaNac(java.util.Calendar fechaNac) {
        this.fechaNac = fechaNac;
    }


    /**
     * Gets the password value for this DtUsuario.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this DtUsuario.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the image value for this DtUsuario.
     * 
     * @return image
     */
    public java.lang.String getImage() {
        return image;
    }


    /**
     * Sets the image value for this DtUsuario.
     * 
     * @param image
     */
    public void setImage(java.lang.String image) {
        this.image = image;
    }


    /**
     * Gets the seguidores value for this DtUsuario.
     * 
     * @return seguidores
     */
    public java.lang.String[] getSeguidores() {
        return seguidores;
    }


    /**
     * Sets the seguidores value for this DtUsuario.
     * 
     * @param seguidores
     */
    public void setSeguidores(java.lang.String[] seguidores) {
        this.seguidores = seguidores;
    }

    public java.lang.String getSeguidores(int i) {
        return this.seguidores[i];
    }

    public void setSeguidores(int i, java.lang.String _value) {
        this.seguidores[i] = _value;
    }


    /**
     * Gets the seguidos value for this DtUsuario.
     * 
     * @return seguidos
     */
    public java.lang.String[] getSeguidos() {
        return seguidos;
    }


    /**
     * Sets the seguidos value for this DtUsuario.
     * 
     * @param seguidos
     */
    public void setSeguidos(java.lang.String[] seguidos) {
        this.seguidos = seguidos;
    }

    public java.lang.String getSeguidos(int i) {
        return this.seguidos[i];
    }

    public void setSeguidos(int i, java.lang.String _value) {
        this.seguidos[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DtUsuario)) return false;
        DtUsuario other = (DtUsuario) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nick==null && other.getNick()==null) || 
             (this.nick!=null &&
              this.nick.equals(other.getNick()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.apellido==null && other.getApellido()==null) || 
             (this.apellido!=null &&
              this.apellido.equals(other.getApellido()))) &&
            ((this.correo==null && other.getCorreo()==null) || 
             (this.correo!=null &&
              this.correo.equals(other.getCorreo()))) &&
            ((this.fechaNac==null && other.getFechaNac()==null) || 
             (this.fechaNac!=null &&
              this.fechaNac.equals(other.getFechaNac()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.image==null && other.getImage()==null) || 
             (this.image!=null &&
              this.image.equals(other.getImage()))) &&
            ((this.seguidores==null && other.getSeguidores()==null) || 
             (this.seguidores!=null &&
              java.util.Arrays.equals(this.seguidores, other.getSeguidores()))) &&
            ((this.seguidos==null && other.getSeguidos()==null) || 
             (this.seguidos!=null &&
              java.util.Arrays.equals(this.seguidos, other.getSeguidos())));
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
        if (getNick() != null) {
            _hashCode += getNick().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getApellido() != null) {
            _hashCode += getApellido().hashCode();
        }
        if (getCorreo() != null) {
            _hashCode += getCorreo().hashCode();
        }
        if (getFechaNac() != null) {
            _hashCode += getFechaNac().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getImage() != null) {
            _hashCode += getImage().hashCode();
        }
        if (getSeguidores() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSeguidores());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSeguidores(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSeguidos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSeguidos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSeguidos(), i);
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
        new org.apache.axis.description.TypeDesc(DtUsuario.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtUsuario"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nick");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nick"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apellido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "apellido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "correo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaNac");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaNac"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("image");
        elemField.setXmlName(new javax.xml.namespace.QName("", "image"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seguidores");
        elemField.setXmlName(new javax.xml.namespace.QName("", "seguidores"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seguidos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "seguidos"));
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
