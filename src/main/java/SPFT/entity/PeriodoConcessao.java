package SPFT.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela PERIODO_CONCESSAO
 * @generated
 */
@Entity
@Table(name = "\"PERIODO_CONCESSAO\"", schema="\"SPFT\""  ,uniqueConstraints=@UniqueConstraint(columnNames={
"PECO_CD_PERIODO_CONCESSAO" }))
@XmlRootElement
@CronappSecurity
@JsonFilter("SPFT.entity.PeriodoConcessao")
public class PeriodoConcessao implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "PECO_CD_PERIODO_CONCESSAO", nullable = false, insertable=true, updatable=true)
  private java.lang.Integer id;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="FOTR_CD_FORCA_TRABALHO", nullable = false, referencedColumnName = "FOTR_CD_FORCA_TRABALHO", insertable=true, updatable=true)
  
  private ForcaTrabalho forcaTrabalho;

  /**
  * @generated
  */
  @Column(name = "PECO_IN_STATUS", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer status;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "PECO_DT_CONCESSAO_INICIAL", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataConcessaoInicial;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "PECO_DT_CONCESSAO_FINAL", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataConcessaoFinal;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "PECO_DT_AQUISICAO_INICIAL", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataAquisicaoInicial;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "PECO_DT_AQUISICAO_FINAL", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataAquisicaoFinal;

  /**
  * @generated
  */
  @Column(name = "PECO_NR_CONTIGENTE", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer totalDiasContigente;

  /**
   * Construtor
   * @generated
   */
  public PeriodoConcessao(){
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
  public PeriodoConcessao setId(java.lang.Integer id){
    this.id = id;
    return this;
  }

  /**
   * Obtém forcaTrabalho
   * return forcaTrabalho
   * @generated
   */
  
  public ForcaTrabalho getForcaTrabalho(){
    return this.forcaTrabalho;
  }

  /**
   * Define forcaTrabalho
   * @param forcaTrabalho forcaTrabalho
   * @generated
   */
  public PeriodoConcessao setForcaTrabalho(ForcaTrabalho forcaTrabalho){
    this.forcaTrabalho = forcaTrabalho;
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
  public PeriodoConcessao setStatus(java.lang.Integer status){
    this.status = status;
    return this;
  }

  /**
   * Obtém dataConcessaoInicial
   * return dataConcessaoInicial
   * @generated
   */
  
  public java.util.Date getDataConcessaoInicial(){
    return this.dataConcessaoInicial;
  }

  /**
   * Define dataConcessaoInicial
   * @param dataConcessaoInicial dataConcessaoInicial
   * @generated
   */
  public PeriodoConcessao setDataConcessaoInicial(java.util.Date dataConcessaoInicial){
    this.dataConcessaoInicial = dataConcessaoInicial;
    return this;
  }

  /**
   * Obtém dataConcessaoFinal
   * return dataConcessaoFinal
   * @generated
   */
  
  public java.util.Date getDataConcessaoFinal(){
    return this.dataConcessaoFinal;
  }

  /**
   * Define dataConcessaoFinal
   * @param dataConcessaoFinal dataConcessaoFinal
   * @generated
   */
  public PeriodoConcessao setDataConcessaoFinal(java.util.Date dataConcessaoFinal){
    this.dataConcessaoFinal = dataConcessaoFinal;
    return this;
  }

  /**
   * Obtém dataAquisicaoInicial
   * return dataAquisicaoInicial
   * @generated
   */
  
  public java.util.Date getDataAquisicaoInicial(){
    return this.dataAquisicaoInicial;
  }

  /**
   * Define dataAquisicaoInicial
   * @param dataAquisicaoInicial dataAquisicaoInicial
   * @generated
   */
  public PeriodoConcessao setDataAquisicaoInicial(java.util.Date dataAquisicaoInicial){
    this.dataAquisicaoInicial = dataAquisicaoInicial;
    return this;
  }

  /**
   * Obtém dataAquisicaoFinal
   * return dataAquisicaoFinal
   * @generated
   */
  
  public java.util.Date getDataAquisicaoFinal(){
    return this.dataAquisicaoFinal;
  }

  /**
   * Define dataAquisicaoFinal
   * @param dataAquisicaoFinal dataAquisicaoFinal
   * @generated
   */
  public PeriodoConcessao setDataAquisicaoFinal(java.util.Date dataAquisicaoFinal){
    this.dataAquisicaoFinal = dataAquisicaoFinal;
    return this;
  }

  /**
   * Obtém totalDiasContigente
   * return totalDiasContigente
   * @generated
   */
  
  public java.lang.Integer getTotalDiasContigente(){
    return this.totalDiasContigente;
  }

  /**
   * Define totalDiasContigente
   * @param totalDiasContigente totalDiasContigente
   * @generated
   */
  public PeriodoConcessao setTotalDiasContigente(java.lang.Integer totalDiasContigente){
    this.totalDiasContigente = totalDiasContigente;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    PeriodoConcessao object = (PeriodoConcessao)obj;
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
