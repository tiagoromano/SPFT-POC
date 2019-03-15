package SPFT.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela DELEGACAO
 * @generated
 */
@Entity
@Table(name = "\"DELEGACAO\"", schema="\"SPFT\""  ,uniqueConstraints=@UniqueConstraint(columnNames={
"DELE_CD_DELEGACAO" }))
@XmlRootElement
@CronappSecurity
@JsonFilter("SPFT.entity.Delegacao")
public class Delegacao implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "DELE_CD_DELEGACAO", nullable = false, insertable=true, updatable=true)
  private java.lang.Integer id;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="ORGA_CD_ORGAO", nullable = false, referencedColumnName = "ORGA_CD_ORGAO", insertable=true, updatable=true)
  
  private Orgao orgao;

  /**
  * @generated
  */
  @Column(name = "DELE_IN_STATUS", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer status;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "DELE_DT_CRIACAO", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataCriacao;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "DELE_DT_DESATIVACAO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataInativo;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="FOTR_CD_FORCA_TRABALHO_GER", nullable = false, referencedColumnName = "FOTR_CD_FORCA_TRABALHO", insertable=true, updatable=true)
  
  private ForcaTrabalho forcaTrabalhoGerente;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="FOTR_CD_FORCA_TRABALHO_DEL", nullable = false, referencedColumnName = "FOTR_CD_FORCA_TRABALHO", insertable=true, updatable=true)
  
  private ForcaTrabalho forcaTrabalhoDelegado;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="FOTR_CD_FORCA_TRABALHO_DES", nullable = true, referencedColumnName = "FOTR_CD_FORCA_TRABALHO", insertable=true, updatable=true)
  
  private ForcaTrabalho forcaTrabalhoDes;

  /**
  * @generated
  */
  @Column(name = "DELE_IN_TIPO_DELEGACAO", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer tipoDelegacao;

  /**
   * Construtor
   * @generated
   */
  public Delegacao(){
  }


  /**
   * Obtém id
   * return id
   * @generated
   */
  
  public java.lang.Integer getId(){
    return this.id;
  }

  /**
   * Define id
   * @param id id
   * @generated
   */
  public Delegacao setId(java.lang.Integer id){
    this.id = id;
    return this;
  }

  /**
   * Obtém orgao
   * return orgao
   * @generated
   */
  
  public Orgao getOrgao(){
    return this.orgao;
  }

  /**
   * Define orgao
   * @param orgao orgao
   * @generated
   */
  public Delegacao setOrgao(Orgao orgao){
    this.orgao = orgao;
    return this;
  }

  /**
   * Obtém status
   * return status
   * @generated
   */
  
  public java.lang.Integer getStatus(){
    return this.status;
  }

  /**
   * Define status
   * @param status status
   * @generated
   */
  public Delegacao setStatus(java.lang.Integer status){
    this.status = status;
    return this;
  }

  /**
   * Obtém dataCriacao
   * return dataCriacao
   * @generated
   */
  
  public java.util.Date getDataCriacao(){
    return this.dataCriacao;
  }

  /**
   * Define dataCriacao
   * @param dataCriacao dataCriacao
   * @generated
   */
  public Delegacao setDataCriacao(java.util.Date dataCriacao){
    this.dataCriacao = dataCriacao;
    return this;
  }

  /**
   * Obtém dataInativo
   * return dataInativo
   * @generated
   */
  
  public java.util.Date getDataInativo(){
    return this.dataInativo;
  }

  /**
   * Define dataInativo
   * @param dataInativo dataInativo
   * @generated
   */
  public Delegacao setDataInativo(java.util.Date dataInativo){
    this.dataInativo = dataInativo;
    return this;
  }

  /**
   * Obtém forcaTrabalhoGerente
   * return forcaTrabalhoGerente
   * @generated
   */
  
  public ForcaTrabalho getForcaTrabalhoGerente(){
    return this.forcaTrabalhoGerente;
  }

  /**
   * Define forcaTrabalhoGerente
   * @param forcaTrabalhoGerente forcaTrabalhoGerente
   * @generated
   */
  public Delegacao setForcaTrabalhoGerente(ForcaTrabalho forcaTrabalhoGerente){
    this.forcaTrabalhoGerente = forcaTrabalhoGerente;
    return this;
  }

  /**
   * Obtém forcaTrabalhoDelegado
   * return forcaTrabalhoDelegado
   * @generated
   */
  
  public ForcaTrabalho getForcaTrabalhoDelegado(){
    return this.forcaTrabalhoDelegado;
  }

  /**
   * Define forcaTrabalhoDelegado
   * @param forcaTrabalhoDelegado forcaTrabalhoDelegado
   * @generated
   */
  public Delegacao setForcaTrabalhoDelegado(ForcaTrabalho forcaTrabalhoDelegado){
    this.forcaTrabalhoDelegado = forcaTrabalhoDelegado;
    return this;
  }

  /**
   * Obtém forcaTrabalhoDes
   * return forcaTrabalhoDes
   * @generated
   */
  
  public ForcaTrabalho getForcaTrabalhoDes(){
    return this.forcaTrabalhoDes;
  }

  /**
   * Define forcaTrabalhoDes
   * @param forcaTrabalhoDes forcaTrabalhoDes
   * @generated
   */
  public Delegacao setForcaTrabalhoDes(ForcaTrabalho forcaTrabalhoDes){
    this.forcaTrabalhoDes = forcaTrabalhoDes;
    return this;
  }

  /**
   * Obtém tipoDelegacao
   * return tipoDelegacao
   * @generated
   */
  
  public java.lang.Integer getTipoDelegacao(){
    return this.tipoDelegacao;
  }

  /**
   * Define tipoDelegacao
   * @param tipoDelegacao tipoDelegacao
   * @generated
   */
  public Delegacao setTipoDelegacao(java.lang.Integer tipoDelegacao){
    this.tipoDelegacao = tipoDelegacao;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Delegacao object = (Delegacao)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}
