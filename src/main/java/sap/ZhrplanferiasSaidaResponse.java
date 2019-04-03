
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
 *         &lt;element name="P2006" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZctHrBapiP2006"/>
 *         &lt;element name="P9100" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZctHrBapiP9100"/>
 *         &lt;element name="Return" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZBapireturn1"/>
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
    "p2006",
    "p9100",
    "_return"
})
@XmlRootElement(name = "ZhrplanferiasSaidaResponse")
public class ZhrplanferiasSaidaResponse {

    @XmlElement(name = "P2006", required = true)
    protected ZctHrBapiP2006 p2006;
    @XmlElement(name = "P9100", required = true)
    protected ZctHrBapiP9100 p9100;
    @XmlElement(name = "Return", required = true)
    protected ZBapireturn1 _return;

    /**
     * Obtém o valor da propriedade p2006.
     * 
     * @return
     *     possible object is
     *     {@link ZctHrBapiP2006 }
     *     
     */
    public ZctHrBapiP2006 getP2006() {
        return p2006;
    }

    /**
     * Define o valor da propriedade p2006.
     * 
     * @param value
     *     allowed object is
     *     {@link ZctHrBapiP2006 }
     *     
     */
    public void setP2006(ZctHrBapiP2006 value) {
        this.p2006 = value;
    }

    /**
     * Obtém o valor da propriedade p9100.
     * 
     * @return
     *     possible object is
     *     {@link ZctHrBapiP9100 }
     *     
     */
    public ZctHrBapiP9100 getP9100() {
        return p9100;
    }

    /**
     * Define o valor da propriedade p9100.
     * 
     * @param value
     *     allowed object is
     *     {@link ZctHrBapiP9100 }
     *     
     */
    public void setP9100(ZctHrBapiP9100 value) {
        this.p9100 = value;
    }

    /**
     * Obtém o valor da propriedade return.
     * 
     * @return
     *     possible object is
     *     {@link ZBapireturn1 }
     *     
     */
    public ZBapireturn1 getReturn() {
        return _return;
    }

    /**
     * Define o valor da propriedade return.
     * 
     * @param value
     *     allowed object is
     *     {@link ZBapireturn1 }
     *     
     */
    public void setReturn(ZBapireturn1 value) {
        this._return = value;
    }

}
