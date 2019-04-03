
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
 *         &lt;element name="FimValidade" type="{urn:sap-com:document:sap:rfc:functions}date10" minOccurs="0"/>
 *         &lt;element name="InicioValidade" type="{urn:sap-com:document:sap:rfc:functions}date10" minOccurs="0"/>
 *         &lt;element name="Matriculas" type="{urn:sap-com:document:sap:soap:functions:mc-style}ZctHrBapiPernr"/>
 *         &lt;element name="Usuario" type="{urn:sap-com:document:sap:rfc:functions}char12"/>
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
    "fimValidade",
    "inicioValidade",
    "matriculas",
    "usuario"
})
@XmlRootElement(name = "ZhrplanferiasSaida")
public class ZhrplanferiasSaida {

    @XmlElement(name = "FimValidade")
    protected String fimValidade;
    @XmlElement(name = "InicioValidade")
    protected String inicioValidade;
    @XmlElement(name = "Matriculas", required = true)
    protected ZctHrBapiPernr matriculas;
    @XmlElement(name = "Usuario", required = true)
    protected String usuario;

    /**
     * Obtém o valor da propriedade fimValidade.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFimValidade() {
        return fimValidade;
    }

    /**
     * Define o valor da propriedade fimValidade.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFimValidade(String value) {
        this.fimValidade = value;
    }

    /**
     * Obtém o valor da propriedade inicioValidade.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInicioValidade() {
        return inicioValidade;
    }

    /**
     * Define o valor da propriedade inicioValidade.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInicioValidade(String value) {
        this.inicioValidade = value;
    }

    /**
     * Obtém o valor da propriedade matriculas.
     * 
     * @return
     *     possible object is
     *     {@link ZctHrBapiPernr }
     *     
     */
    public ZctHrBapiPernr getMatriculas() {
        return matriculas;
    }

    /**
     * Define o valor da propriedade matriculas.
     * 
     * @param value
     *     allowed object is
     *     {@link ZctHrBapiPernr }
     *     
     */
    public void setMatriculas(ZctHrBapiPernr value) {
        this.matriculas = value;
    }

    /**
     * Obtém o valor da propriedade usuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Define o valor da propriedade usuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

}
