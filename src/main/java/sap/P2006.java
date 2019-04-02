package sap;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de p2006 complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="p2006">
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
 *         &lt;element name="Beguz" type="{urn:sap-com:document:sap:rfc:functions}time"/>
 *         &lt;element name="Enduz" type="{urn:sap-com:document:sap:rfc:functions}time"/>
 *         &lt;element name="Vtken" type="{urn:sap-com:document:sap:rfc:functions}char1"/>
 *         &lt;element name="Ktart" type="{urn:sap-com:document:sap:rfc:functions}numeric2"/>
 *         &lt;element name="Anzhl" type="{urn:sap-com:document:sap:rfc:functions}decimal10.5"/>
 *         &lt;element name="Kverb" type="{urn:sap-com:document:sap:rfc:functions}decimal10.5"/>
 *         &lt;element name="Quonr" type="{urn:sap-com:document:sap:rfc:functions}numeric20"/>
 *         &lt;element name="Desta" type="{urn:sap-com:document:sap:rfc:functions}date10"/>
 *         &lt;element name="Deend" type="{urn:sap-com:document:sap:rfc:functions}date10"/>
 *         &lt;element name="Quosy" type="{urn:sap-com:document:sap:rfc:functions}char10"/>
 *         &lt;element name="Tdlangu" type="{urn:sap-com:document:sap:rfc:functions}char10"/>
 *         &lt;element name="Tdsubla" type="{urn:sap-com:document:sap:rfc:functions}char3"/>
 *         &lt;element name="Tdtype" type="{urn:sap-com:document:sap:rfc:functions}char4"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "p2006", propOrder = {
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
    "beguz",
    "enduz",
    "vtken",
    "ktart",
    "anzhl",
    "kverb",
    "quonr",
    "desta",
    "deend",
    "quosy",
    "tdlangu",
    "tdsubla",
    "tdtype"
})
public class P2006 {

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
    @XmlElement(name = "Beguz", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar beguz;
    @XmlElement(name = "Enduz", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar enduz;
    @XmlElement(name = "Vtken", required = true)
    protected String vtken;
    @XmlElement(name = "Ktart", required = true)
    protected String ktart;
    @XmlElement(name = "Anzhl", required = true)
    protected BigDecimal anzhl;
    @XmlElement(name = "Kverb", required = true)
    protected BigDecimal kverb;
    @XmlElement(name = "Quonr", required = true)
    protected String quonr;
    @XmlElement(name = "Desta", required = true)
    protected String desta;
    @XmlElement(name = "Deend", required = true)
    protected String deend;
    @XmlElement(name = "Quosy", required = true)
    protected String quosy;
    @XmlElement(name = "Tdlangu", required = true)
    protected String tdlangu;
    @XmlElement(name = "Tdsubla", required = true)
    protected String tdsubla;
    @XmlElement(name = "Tdtype", required = true)
    protected String tdtype;

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
     * Obtém o valor da propriedade beguz.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBeguz() {
        return beguz;
    }

    /**
     * Define o valor da propriedade beguz.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBeguz(XMLGregorianCalendar value) {
        this.beguz = value;
    }

    /**
     * Obtém o valor da propriedade enduz.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnduz() {
        return enduz;
    }

    /**
     * Define o valor da propriedade enduz.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnduz(XMLGregorianCalendar value) {
        this.enduz = value;
    }

    /**
     * Obtém o valor da propriedade vtken.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVtken() {
        return vtken;
    }

    /**
     * Define o valor da propriedade vtken.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVtken(String value) {
        this.vtken = value;
    }

    /**
     * Obtém o valor da propriedade ktart.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKtart() {
        return ktart;
    }

    /**
     * Define o valor da propriedade ktart.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKtart(String value) {
        this.ktart = value;
    }

    /**
     * Obtém o valor da propriedade anzhl.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAnzhl() {
        return anzhl;
    }

    /**
     * Define o valor da propriedade anzhl.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAnzhl(BigDecimal value) {
        this.anzhl = value;
    }

    /**
     * Obtém o valor da propriedade kverb.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getKverb() {
        return kverb;
    }

    /**
     * Define o valor da propriedade kverb.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setKverb(BigDecimal value) {
        this.kverb = value;
    }

    /**
     * Obtém o valor da propriedade quonr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuonr() {
        return quonr;
    }

    /**
     * Define o valor da propriedade quonr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuonr(String value) {
        this.quonr = value;
    }

    /**
     * Obtém o valor da propriedade desta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesta() {
        return desta;
    }

    /**
     * Define o valor da propriedade desta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesta(String value) {
        this.desta = value;
    }

    /**
     * Obtém o valor da propriedade deend.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeend() {
        return deend;
    }

    /**
     * Define o valor da propriedade deend.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeend(String value) {
        this.deend = value;
    }

    /**
     * Obtém o valor da propriedade quosy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuosy() {
        return quosy;
    }

    /**
     * Define o valor da propriedade quosy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuosy(String value) {
        this.quosy = value;
    }

    /**
     * Obtém o valor da propriedade tdlangu.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTdlangu() {
        return tdlangu;
    }

    /**
     * Define o valor da propriedade tdlangu.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTdlangu(String value) {
        this.tdlangu = value;
    }

    /**
     * Obtém o valor da propriedade tdsubla.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTdsubla() {
        return tdsubla;
    }

    /**
     * Define o valor da propriedade tdsubla.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTdsubla(String value) {
        this.tdsubla = value;
    }

    /**
     * Obtém o valor da propriedade tdtype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTdtype() {
        return tdtype;
    }

    /**
     * Define o valor da propriedade tdtype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTdtype(String value) {
        this.tdtype = value;
    }

}
