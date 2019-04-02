package sap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Entrada" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZctHrBapiEntradaSpf"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "entrada"
})
@XmlRootElement(name = "ZhrplanferiasEntrada")
public class ZhrplanferiasEntrada {

    @XmlElement(name = "Entrada", required = true)
    protected ZctHrBapiEntradaSpf entrada;

    /**
     * Obtém o valor da propriedade entrada.
     * 
     * @return
     *     possible object is
     *     {@link ZctHrBapiEntradaSpf }
     *     
     */
    public ZctHrBapiEntradaSpf getEntrada() {
        return entrada;
    }

    /**
     * Define o valor da propriedade entrada.
     * 
     * @param value
     *     allowed object is
     *     {@link ZctHrBapiEntradaSpf }
     *     
     */
    public void setEntrada(ZctHrBapiEntradaSpf value) {
        this.entrada = value;
    }

}
