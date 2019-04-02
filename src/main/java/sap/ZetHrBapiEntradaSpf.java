package sap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ZetHrBapiEntradaSpf complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ZetHrBapiEntradaSpf">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Matricula" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/>
 *         &lt;element name="TipoParc" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *         &lt;element name="AbonoPecuni" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *         &lt;element name="DtIniPrimParc" type="{urn:sap-com:document:sap:rfc:functions}date10"/>
 *         &lt;element name="DtFimPrimParc" type="{urn:sap-com:document:sap:rfc:functions}date10"/>
 *         &lt;element name="DtIniSecParc" type="{urn:sap-com:document:sap:rfc:functions}date10"/>
 *         &lt;element name="DtFimSecParc" type="{urn:sap-com:document:sap:rfc:functions}date10"/>
 *         &lt;element name="DtIniTercParc" type="{urn:sap-com:document:sap:soap:functions:mc-style}date10"/>
 *         &lt;element name="DtFimTercParc" type="{urn:sap-com:document:sap:soap:functions:mc-style}date10"/>
 *         &lt;element name="Ind13sal" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *         &lt;element name="DtIniPerAquis" type="{urn:sap-com:document:sap:rfc:functions}date10"/>
 *         &lt;element name="DtFimPerAquis" type="{urn:sap-com:document:sap:rfc:functions}date10"/>
 *         &lt;element name="Bloqueio" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZetHrBapiEntradaSpf", propOrder = {
    "matricula",
    "tipoParc",
    "abonoPecuni",
    "dtIniPrimParc",
    "dtFimPrimParc",
    "dtIniSecParc",
    "dtFimSecParc",
    "dtIniTercParc",
    "dtFimTercParc",
    "ind13Sal",
    "dtIniPerAquis",
    "dtFimPerAquis",
    "bloqueio"
})
public class ZetHrBapiEntradaSpf {

    @XmlElement(name = "Matricula", required = true)
    protected String matricula;
    @XmlElement(name = "TipoParc", required = true)
    protected String tipoParc;
    @XmlElement(name = "AbonoPecuni", required = true)
    protected String abonoPecuni;
    @XmlElement(name = "DtIniPrimParc", required = true)
    protected String dtIniPrimParc;
    @XmlElement(name = "DtFimPrimParc", required = true)
    protected String dtFimPrimParc;
    @XmlElement(name = "DtIniSecParc", required = true)
    protected String dtIniSecParc;
    @XmlElement(name = "DtFimSecParc", required = true)
    protected String dtFimSecParc;
    @XmlElement(name = "DtIniTercParc", required = true)
    protected String dtIniTercParc;
    @XmlElement(name = "DtFimTercParc", required = true)
    protected String dtFimTercParc;
    @XmlElement(name = "Ind13sal", required = true)
    protected String ind13Sal;
    @XmlElement(name = "DtIniPerAquis", required = true)
    protected String dtIniPerAquis;
    @XmlElement(name = "DtFimPerAquis", required = true)
    protected String dtFimPerAquis;
    @XmlElement(name = "Bloqueio", required = true)
    protected String bloqueio;

    /**
     * Obtém o valor da propriedade matricula.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Define o valor da propriedade matricula.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatricula(String value) {
        this.matricula = value;
    }

    /**
     * Obtém o valor da propriedade tipoParc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoParc() {
        return tipoParc;
    }

    /**
     * Define o valor da propriedade tipoParc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoParc(String value) {
        this.tipoParc = value;
    }

    /**
     * Obtém o valor da propriedade abonoPecuni.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbonoPecuni() {
        return abonoPecuni;
    }

    /**
     * Define o valor da propriedade abonoPecuni.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbonoPecuni(String value) {
        this.abonoPecuni = value;
    }

    /**
     * Obtém o valor da propriedade dtIniPrimParc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtIniPrimParc() {
        return dtIniPrimParc;
    }

    /**
     * Define o valor da propriedade dtIniPrimParc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtIniPrimParc(String value) {
        this.dtIniPrimParc = value;
    }

    /**
     * Obtém o valor da propriedade dtFimPrimParc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtFimPrimParc() {
        return dtFimPrimParc;
    }

    /**
     * Define o valor da propriedade dtFimPrimParc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtFimPrimParc(String value) {
        this.dtFimPrimParc = value;
    }

    /**
     * Obtém o valor da propriedade dtIniSecParc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtIniSecParc() {
        return dtIniSecParc;
    }

    /**
     * Define o valor da propriedade dtIniSecParc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtIniSecParc(String value) {
        this.dtIniSecParc = value;
    }

    /**
     * Obtém o valor da propriedade dtFimSecParc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtFimSecParc() {
        return dtFimSecParc;
    }

    /**
     * Define o valor da propriedade dtFimSecParc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtFimSecParc(String value) {
        this.dtFimSecParc = value;
    }

    /**
     * Obtém o valor da propriedade dtIniTercParc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtIniTercParc() {
        return dtIniTercParc;
    }

    /**
     * Define o valor da propriedade dtIniTercParc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtIniTercParc(String value) {
        this.dtIniTercParc = value;
    }

    /**
     * Obtém o valor da propriedade dtFimTercParc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtFimTercParc() {
        return dtFimTercParc;
    }

    /**
     * Define o valor da propriedade dtFimTercParc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtFimTercParc(String value) {
        this.dtFimTercParc = value;
    }

    /**
     * Obtém o valor da propriedade ind13Sal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInd13Sal() {
        return ind13Sal;
    }

    /**
     * Define o valor da propriedade ind13Sal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInd13Sal(String value) {
        this.ind13Sal = value;
    }

    /**
     * Obtém o valor da propriedade dtIniPerAquis.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtIniPerAquis() {
        return dtIniPerAquis;
    }

    /**
     * Define o valor da propriedade dtIniPerAquis.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtIniPerAquis(String value) {
        this.dtIniPerAquis = value;
    }

    /**
     * Obtém o valor da propriedade dtFimPerAquis.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtFimPerAquis() {
        return dtFimPerAquis;
    }

    /**
     * Define o valor da propriedade dtFimPerAquis.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtFimPerAquis(String value) {
        this.dtFimPerAquis = value;
    }

    /**
     * Obtém o valor da propriedade bloqueio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBloqueio() {
        return bloqueio;
    }

    /**
     * Define o valor da propriedade bloqueio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBloqueio(String value) {
        this.bloqueio = value;
    }

}
