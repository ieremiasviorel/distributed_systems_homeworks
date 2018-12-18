/**
 * Parcel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package package_tracking_system.assignment_4_2.models;

public class Parcel  implements java.io.Serializable {
    private package_tracking_system.assignment_4_2.models.Delivery delivery;

    private java.lang.String description;

    private java.lang.Integer id;

    private java.lang.String name;

    private package_tracking_system.assignment_4_2.models.User receiver;

    private package_tracking_system.assignment_4_2.models.User sender;

    public Parcel() {
    }

    public Parcel(
           package_tracking_system.assignment_4_2.models.Delivery delivery,
           java.lang.String description,
           java.lang.Integer id,
           java.lang.String name,
           package_tracking_system.assignment_4_2.models.User receiver,
           package_tracking_system.assignment_4_2.models.User sender) {
           this.delivery = delivery;
           this.description = description;
           this.id = id;
           this.name = name;
           this.receiver = receiver;
           this.sender = sender;
    }


    /**
     * Gets the delivery value for this Parcel.
     * 
     * @return delivery
     */
    public package_tracking_system.assignment_4_2.models.Delivery getDelivery() {
        return delivery;
    }


    /**
     * Sets the delivery value for this Parcel.
     * 
     * @param delivery
     */
    public void setDelivery(package_tracking_system.assignment_4_2.models.Delivery delivery) {
        this.delivery = delivery;
    }


    /**
     * Gets the description value for this Parcel.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Parcel.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the id value for this Parcel.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this Parcel.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the name value for this Parcel.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Parcel.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the receiver value for this Parcel.
     * 
     * @return receiver
     */
    public package_tracking_system.assignment_4_2.models.User getReceiver() {
        return receiver;
    }


    /**
     * Sets the receiver value for this Parcel.
     * 
     * @param receiver
     */
    public void setReceiver(package_tracking_system.assignment_4_2.models.User receiver) {
        this.receiver = receiver;
    }


    /**
     * Gets the sender value for this Parcel.
     * 
     * @return sender
     */
    public package_tracking_system.assignment_4_2.models.User getSender() {
        return sender;
    }


    /**
     * Sets the sender value for this Parcel.
     * 
     * @param sender
     */
    public void setSender(package_tracking_system.assignment_4_2.models.User sender) {
        this.sender = sender;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Parcel)) return false;
        Parcel other = (Parcel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.delivery==null && other.getDelivery()==null) || 
             (this.delivery!=null &&
              this.delivery.equals(other.getDelivery()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.receiver==null && other.getReceiver()==null) || 
             (this.receiver!=null &&
              this.receiver.equals(other.getReceiver()))) &&
            ((this.sender==null && other.getSender()==null) || 
             (this.sender!=null &&
              this.sender.equals(other.getSender())));
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
        if (getDelivery() != null) {
            _hashCode += getDelivery().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getReceiver() != null) {
            _hashCode += getReceiver().hashCode();
        }
        if (getSender() != null) {
            _hashCode += getSender().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Parcel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://models.assignment_4_2.package_tracking_system", "Parcel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("delivery");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.assignment_4_2.package_tracking_system", "delivery"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://models.assignment_4_2.package_tracking_system", "Delivery"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.assignment_4_2.package_tracking_system", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.assignment_4_2.package_tracking_system", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.assignment_4_2.package_tracking_system", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiver");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.assignment_4_2.package_tracking_system", "receiver"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://models.assignment_4_2.package_tracking_system", "User"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sender");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.assignment_4_2.package_tracking_system", "sender"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://models.assignment_4_2.package_tracking_system", "User"));
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
