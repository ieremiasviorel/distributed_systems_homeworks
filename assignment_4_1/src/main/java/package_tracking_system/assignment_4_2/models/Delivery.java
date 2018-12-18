/**
 * Delivery.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package package_tracking_system.assignment_4_2.models;

public class Delivery  implements java.io.Serializable {
    private package_tracking_system.assignment_4_2.models.City destinationCity;

    private java.lang.Integer id;

    private package_tracking_system.assignment_4_2.models.City originCity;

    private java.lang.String route;

    private java.lang.Boolean tracked;

    public Delivery() {
    }

    public Delivery(
           package_tracking_system.assignment_4_2.models.City destinationCity,
           java.lang.Integer id,
           package_tracking_system.assignment_4_2.models.City originCity,
           java.lang.String route,
           java.lang.Boolean tracked) {
           this.destinationCity = destinationCity;
           this.id = id;
           this.originCity = originCity;
           this.route = route;
           this.tracked = tracked;
    }


    /**
     * Gets the destinationCity value for this Delivery.
     * 
     * @return destinationCity
     */
    public package_tracking_system.assignment_4_2.models.City getDestinationCity() {
        return destinationCity;
    }


    /**
     * Sets the destinationCity value for this Delivery.
     * 
     * @param destinationCity
     */
    public void setDestinationCity(package_tracking_system.assignment_4_2.models.City destinationCity) {
        this.destinationCity = destinationCity;
    }


    /**
     * Gets the id value for this Delivery.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this Delivery.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the originCity value for this Delivery.
     * 
     * @return originCity
     */
    public package_tracking_system.assignment_4_2.models.City getOriginCity() {
        return originCity;
    }


    /**
     * Sets the originCity value for this Delivery.
     * 
     * @param originCity
     */
    public void setOriginCity(package_tracking_system.assignment_4_2.models.City originCity) {
        this.originCity = originCity;
    }


    /**
     * Gets the route value for this Delivery.
     * 
     * @return route
     */
    public java.lang.String getRoute() {
        return route;
    }


    /**
     * Sets the route value for this Delivery.
     * 
     * @param route
     */
    public void setRoute(java.lang.String route) {
        this.route = route;
    }


    /**
     * Gets the tracked value for this Delivery.
     * 
     * @return tracked
     */
    public java.lang.Boolean getTracked() {
        return tracked;
    }


    /**
     * Sets the tracked value for this Delivery.
     * 
     * @param tracked
     */
    public void setTracked(java.lang.Boolean tracked) {
        this.tracked = tracked;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Delivery)) return false;
        Delivery other = (Delivery) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.destinationCity==null && other.getDestinationCity()==null) || 
             (this.destinationCity!=null &&
              this.destinationCity.equals(other.getDestinationCity()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.originCity==null && other.getOriginCity()==null) || 
             (this.originCity!=null &&
              this.originCity.equals(other.getOriginCity()))) &&
            ((this.route==null && other.getRoute()==null) || 
             (this.route!=null &&
              this.route.equals(other.getRoute()))) &&
            ((this.tracked==null && other.getTracked()==null) || 
             (this.tracked!=null &&
              this.tracked.equals(other.getTracked())));
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
        if (getDestinationCity() != null) {
            _hashCode += getDestinationCity().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getOriginCity() != null) {
            _hashCode += getOriginCity().hashCode();
        }
        if (getRoute() != null) {
            _hashCode += getRoute().hashCode();
        }
        if (getTracked() != null) {
            _hashCode += getTracked().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Delivery.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://models.assignment_4_2.package_tracking_system", "Delivery"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destinationCity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.assignment_4_2.package_tracking_system", "destinationCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://models.assignment_4_2.package_tracking_system", "City"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.assignment_4_2.package_tracking_system", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originCity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.assignment_4_2.package_tracking_system", "originCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://models.assignment_4_2.package_tracking_system", "City"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("route");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.assignment_4_2.package_tracking_system", "route"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tracked");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.assignment_4_2.package_tracking_system", "tracked"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(true);
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
