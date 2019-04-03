
package sap;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de p9100 complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="p9100">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Pernr" type="{urn:sap-com:document:sap:rfc:functions}numeric8"/>
 *         &lt;element name="Infty" type="{urn:sap-com:document:sap:rfc:functions}char4"/>
 *         &lt;element name="Subty" type="{urn:sap-com:document:sap:rfc:functions}char4"/>
 *         &lt;element name="Objps" type="{urn:sap-com:document:sap:rfc:functions}char2"/>
 *         &lt;element name="Sprps" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *         &lt;element name="Endda" type="{urn:sap-com:document:sap:rfc:functions}date10"/>
 *         &lt;element name="Begda" type="{urn:sap-com:document:sap:rfc:functions}date10"/>
 *         &lt;element name="Seqnr" type="{urn:sap-com:document:sap:rfc:functions}numeric3"/>
 *         &lt;element name="Aedtm" type="{urn:sap-com:document:sap:rfc:functions}date10"/>
 *         &lt;element name="Uname" type="{urn:sap-com:document:sap:rfc:functions}char12"/>
 *         &lt;element name="Histo" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *         &lt;element name="Itxex" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *         &lt;element name="Refex" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *         &lt;element name="Ordex" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *         &lt;element name="Itbld" type="{urn:sap-com:document:sap:rfc:functions}char2"/>
 *         &lt;element name="Preas" type="{urn:sap-com:document:sap:rfc:functions}char2"/>
 *         &lt;element name="Flag1" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *         &lt;element name="Flag2" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *         &lt;element name="Flag3" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *         &lt;element name="Flag4" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *         &lt;element name="Rese1" type="{urn:sap-com:document:sap:rfc:functions}char2"/>
 *         &lt;element name="Rese2" type="{urn:sap-com:document:sap:rfc:functions}char2"/>
 *         &lt;element name="Grpvl" type="{urn:sap-com:document:sap:rfc:functions}char4"/>
 *         &lt;element name="Abono" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *         &lt;element name="Addct" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *         &lt;element name="Numbr" type="{urn:sap-com:document:sap:rfc:functions}decimal10.5"/>
 *         &lt;element name="ZBegP1" type="{urn:sap-com:document:sap:rfc:functions}date10"/>
 *         &lt;element name="ZEndP1" type="{urn:sap-com:document:sap:rfc:functions}date10"/>
 *         &lt;element name="ZDiasP1" type="{urn:sap-com:document:sap:rfc:functions}numeric2"/>
 *         &lt;element name="ZBegP2" type="{urn:sap-com:document:sap:rfc:functions}date10"/>
 *         &lt;element name="ZEndP2" type="{urn:sap-com:document:sap:rfc:functions}date10"/>
 *         &lt;element name="ZDiasP2" type="{urn:sap-com:document:sap:rfc:functions}numeric2"/>
 *         &lt;element name="ZPrazoMax" type="{urn:sap-com:document:sap:rfc:functions}date10"/>
 *         &lt;element name="ZDiasDisp" type="{urn:sap-com:document:sap:rfc:functions}numeric2"/>
 *         &lt;element name="ZProcessado" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *         &lt;element name="ZBegP3" type="{urn:sap-com:document:sap:soap:functions:mc-style}date10"/>
 *         &lt;element name="ZEndP3" type="{urn:sap-com:document:sap:soap:functions:mc-style}date10"/>
 *         &lt;element name="ZDiasP3" type="{urn:sap-com:document:sap:soap:functions:mc-style}numeric2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "p9100", propOrder = {
    "pernr",
    "infty",
    "subty",
    "objps",
    "sprps",
    "endda",
    "begda",
    "seqnr",
    "aedtm",
    "uname",
    "histo",
    "itxex",
    "refex",
    "ordex",
    "itbld",
    "preas",
    "flag1",
    "flag2",
    "flag3",
    "flag4",
    "rese1",
    "rese2",
    "grpvl",
    "abono",
    "addct",
    "numbr",
    "zBegP1",
    "zEndP1",
    "zDiasP1",
    "zBegP2",
    "zEndP2",
    "zDiasP2",
    "zPrazoMax",
    "zDiasDisp",
    "zProcessado",
    "zBegP3",
    "zEndP3",
    "zDiasP3"
})
public class P9100 {

    @XmlElement(name = "Pernr", required = true)
    protected String pernr;
    @XmlElement(name = "Infty", required = true)
    protected String infty;
    @XmlElement(name = "Subty", required = true)
    protected String subty;
    @XmlElement(name = "Objps", required = true)
    protected String objps;
    @XmlElement(name = "Sprps", required = true)
    protected String sprps;
    @XmlElement(name = "Endda", required = true)
    protected String endda;
    @XmlElement(name = "Begda", required = true)
    protected String begda;
    @XmlElement(name = "Seqnr", required = true)
    protected String seqnr;
    @XmlElement(name = "Aedtm", required = true)
    protected String aedtm;
    @XmlElement(name = "Uname", required = true)
    protected String uname;
    @XmlElement(name = "Histo", required = true)
    protected String histo;
    @XmlElement(name = "Itxex", required = true)
    protected String itxex;
    @XmlElement(name = "Refex", required = true)
    protected String refex;
    @XmlElement(name = "Ordex", required = true)
    protected String ordex;
    @XmlElement(name = "Itbld", required = true)
    protected String itbld;
    @XmlElement(name = "Preas", required = true)
    protected String preas;
    @XmlElement(name = "Flag1", required = true)
    protected String flag1;
    @XmlElement(name = "Flag2", required = true)
    protected String flag2;
    @XmlElement(name = "Flag3", required = true)
    protected String flag3;
    @XmlElement(name = "Flag4", required = true)
    protected String flag4;
    @XmlElement(name = "Rese1", required = true)
    protected String rese1;
    @XmlElement(name = "Rese2", required = true)
    protected String rese2;
    @XmlElement(name = "Grpvl", required = true)
    protected String grpvl;
    @XmlElement(name = "Abono", required = true)
    protected String abono;
    @XmlElement(name = "Addct", required = true)
    protected String addct;
    @XmlElement(name = "Numbr", required = true)
    protected BigDecimal numbr;
    @XmlElement(name = "ZBegP1", required = true)
    protected String zBegP1;
    @XmlElement(name = "ZEndP1", required = true)
    protected String zEndP1;
    @XmlElement(name = "ZDiasP1", required = true)
    protected String zDiasP1;
    @XmlElement(name = "ZBegP2", required = true)
    protected String zBegP2;
    @XmlElement(name = "ZEndP2", required = true)
    protected String zEndP2;
    @XmlElement(name = "ZDiasP2", required = true)
    protected String zDiasP2;
    @XmlElement(name = "ZPrazoMax", required = true)
    protected String zPrazoMax;
    @XmlElement(name = "ZDiasDisp", required = true)
    protected String zDiasDisp;
    @XmlElement(name = "ZProcessado", required = true)
    protected String zProcessado;
    @XmlElement(name = "ZBegP3", required = true)
    protected String zBegP3;
    @XmlElement(name = "ZEndP3", required = true)
    protected String zEndP3;
    @XmlElement(name = "ZDiasP3", required = true)
    protected String zDiasP3;

    /**
     * Obtém o valor da propriedade pernr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPernr() {
        return pernr;
    }

    /**
     * Define o valor da propriedade pernr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPernr(String value) {
        this.pernr = value;
    }

    /**
     * Obtém o valor da propriedade infty.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfty() {
        return infty;
    }

    /**
     * Define o valor da propriedade infty.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfty(String value) {
        this.infty = value;
    }

    /**
     * Obtém o valor da propriedade subty.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubty() {
        return subty;
    }

    /**
     * Define o valor da propriedade subty.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubty(String value) {
        this.subty = value;
    }

    /**
     * Obtém o valor da propriedade objps.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjps() {
        return objps;
    }

    /**
     * Define o valor da propriedade objps.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjps(String value) {
        this.objps = value;
    }

    /**
     * Obtém o valor da propriedade sprps.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSprps() {
        return sprps;
    }

    /**
     * Define o valor da propriedade sprps.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSprps(String value) {
        this.sprps = value;
    }

    /**
     * Obtém o valor da propriedade endda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndda() {
        return endda;
    }

    /**
     * Define o valor da propriedade endda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndda(String value) {
        this.endda = value;
    }

    /**
     * Obtém o valor da propriedade begda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBegda() {
        return begda;
    }

    /**
     * Define o valor da propriedade begda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBegda(String value) {
        this.begda = value;
    }

    /**
     * Obtém o valor da propriedade seqnr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeqnr() {
        return seqnr;
    }

    /**
     * Define o valor da propriedade seqnr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeqnr(String value) {
        this.seqnr = value;
    }

    /**
     * Obtém o valor da propriedade aedtm.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAedtm() {
        return aedtm;
    }

    /**
     * Define o valor da propriedade aedtm.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAedtm(String value) {
        this.aedtm = value;
    }

    /**
     * Obtém o valor da propriedade uname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUname() {
        return uname;
    }

    /**
     * Define o valor da propriedade uname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUname(String value) {
        this.uname = value;
    }

    /**
     * Obtém o valor da propriedade histo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHisto() {
        return histo;
    }

    /**
     * Define o valor da propriedade histo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHisto(String value) {
        this.histo = value;
    }

    /**
     * Obtém o valor da propriedade itxex.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItxex() {
        return itxex;
    }

    /**
     * Define o valor da propriedade itxex.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItxex(String value) {
        this.itxex = value;
    }

    /**
     * Obtém o valor da propriedade refex.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefex() {
        return refex;
    }

    /**
     * Define o valor da propriedade refex.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefex(String value) {
        this.refex = value;
    }

    /**
     * Obtém o valor da propriedade ordex.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrdex() {
        return ordex;
    }

    /**
     * Define o valor da propriedade ordex.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrdex(String value) {
        this.ordex = value;
    }

    /**
     * Obtém o valor da propriedade itbld.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItbld() {
        return itbld;
    }

    /**
     * Define o valor da propriedade itbld.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItbld(String value) {
        this.itbld = value;
    }

    /**
     * Obtém o valor da propriedade preas.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreas() {
        return preas;
    }

    /**
     * Define o valor da propriedade preas.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreas(String value) {
        this.preas = value;
    }

    /**
     * Obtém o valor da propriedade flag1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlag1() {
        return flag1;
    }

    /**
     * Define o valor da propriedade flag1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlag1(String value) {
        this.flag1 = value;
    }

    /**
     * Obtém o valor da propriedade flag2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlag2() {
        return flag2;
    }

    /**
     * Define o valor da propriedade flag2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlag2(String value) {
        this.flag2 = value;
    }

    /**
     * Obtém o valor da propriedade flag3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlag3() {
        return flag3;
    }

    /**
     * Define o valor da propriedade flag3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlag3(String value) {
        this.flag3 = value;
    }

    /**
     * Obtém o valor da propriedade flag4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlag4() {
        return flag4;
    }

    /**
     * Define o valor da propriedade flag4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlag4(String value) {
        this.flag4 = value;
    }

    /**
     * Obtém o valor da propriedade rese1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRese1() {
        return rese1;
    }

    /**
     * Define o valor da propriedade rese1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRese1(String value) {
        this.rese1 = value;
    }

    /**
     * Obtém o valor da propriedade rese2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRese2() {
        return rese2;
    }

    /**
     * Define o valor da propriedade rese2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRese2(String value) {
        this.rese2 = value;
    }

    /**
     * Obtém o valor da propriedade grpvl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrpvl() {
        return grpvl;
    }

    /**
     * Define o valor da propriedade grpvl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrpvl(String value) {
        this.grpvl = value;
    }

    /**
     * Obtém o valor da propriedade abono.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbono() {
        return abono;
    }

    /**
     * Define o valor da propriedade abono.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbono(String value) {
        this.abono = value;
    }

    /**
     * Obtém o valor da propriedade addct.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddct() {
        return addct;
    }

    /**
     * Define o valor da propriedade addct.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddct(String value) {
        this.addct = value;
    }

    /**
     * Obtém o valor da propriedade numbr.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNumbr() {
        return numbr;
    }

    /**
     * Define o valor da propriedade numbr.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNumbr(BigDecimal value) {
        this.numbr = value;
    }

    /**
     * Obtém o valor da propriedade zBegP1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZBegP1() {
        return zBegP1;
    }

    /**
     * Define o valor da propriedade zBegP1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZBegP1(String value) {
        this.zBegP1 = value;
    }

    /**
     * Obtém o valor da propriedade zEndP1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZEndP1() {
        return zEndP1;
    }

    /**
     * Define o valor da propriedade zEndP1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZEndP1(String value) {
        this.zEndP1 = value;
    }

    /**
     * Obtém o valor da propriedade zDiasP1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZDiasP1() {
        return zDiasP1;
    }

    /**
     * Define o valor da propriedade zDiasP1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZDiasP1(String value) {
        this.zDiasP1 = value;
    }

    /**
     * Obtém o valor da propriedade zBegP2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZBegP2() {
        return zBegP2;
    }

    /**
     * Define o valor da propriedade zBegP2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZBegP2(String value) {
        this.zBegP2 = value;
    }

    /**
     * Obtém o valor da propriedade zEndP2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZEndP2() {
        return zEndP2;
    }

    /**
     * Define o valor da propriedade zEndP2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZEndP2(String value) {
        this.zEndP2 = value;
    }

    /**
     * Obtém o valor da propriedade zDiasP2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZDiasP2() {
        return zDiasP2;
    }

    /**
     * Define o valor da propriedade zDiasP2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZDiasP2(String value) {
        this.zDiasP2 = value;
    }

    /**
     * Obtém o valor da propriedade zPrazoMax.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZPrazoMax() {
        return zPrazoMax;
    }

    /**
     * Define o valor da propriedade zPrazoMax.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZPrazoMax(String value) {
        this.zPrazoMax = value;
    }

    /**
     * Obtém o valor da propriedade zDiasDisp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZDiasDisp() {
        return zDiasDisp;
    }

    /**
     * Define o valor da propriedade zDiasDisp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZDiasDisp(String value) {
        this.zDiasDisp = value;
    }

    /**
     * Obtém o valor da propriedade zProcessado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZProcessado() {
        return zProcessado;
    }

    /**
     * Define o valor da propriedade zProcessado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZProcessado(String value) {
        this.zProcessado = value;
    }

    /**
     * Obtém o valor da propriedade zBegP3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZBegP3() {
        return zBegP3;
    }

    /**
     * Define o valor da propriedade zBegP3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZBegP3(String value) {
        this.zBegP3 = value;
    }

    /**
     * Obtém o valor da propriedade zEndP3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZEndP3() {
        return zEndP3;
    }

    /**
     * Define o valor da propriedade zEndP3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZEndP3(String value) {
        this.zEndP3 = value;
    }

    /**
     * Obtém o valor da propriedade zDiasP3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZDiasP3() {
        return zDiasP3;
    }

    /**
     * Define o valor da propriedade zDiasP3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZDiasP3(String value) {
        this.zDiasP3 = value;
    }

}
