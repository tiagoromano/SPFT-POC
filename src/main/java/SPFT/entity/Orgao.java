package SPFT.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela ORGAO
 * @generated
 */
@Entity
@Table(name = "\"ORGAO\"", schema="\"BIDTCORP\""  ,uniqueConstraints=@UniqueConstraint(columnNames={
"ORGA_CD_ORGAO" }))
@XmlRootElement
@CronappSecurity
@JsonFilter("SPFT.entity.Orgao")
public class Orgao implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "ORGA_CD_ORGAO", nullable = false, insertable=true, updatable=true)
  private java.lang.Integer id;

  /**
  * @generated
  */
  @Column(name = "ORGA_NM_ORGAO", nullable = false, unique = false, length=120, insertable=true, updatable=true)
  
  private java.lang.String nome;

  /**
  * @generated
  */
  @Column(name = "ORGA_CD_ORGAO_SUP", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer orgaoSuperior;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "ORGA_DT_INICIO_VALIDADE", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataInicioValidade;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "ORGA_DT_FIM_VALIDADE", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataFimValidade;

  /**
  * @generated
  */
  @Column(name = "FOTR_CD_FORCA_TRABALHO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer codigoForcaTrabalho;

  /**
  * @generated
  */
  @Column(name = "ARAT_CD_AREA_ATUACAO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer areaAtuacao;

  /**
  * @generated
  */
  @Column(name = "ORGA_TX_DESCRICAO", nullable = true, unique = false, length=400, insertable=true, updatable=true)
  
  private java.lang.String descricao;

  /**
   * Construtor
   * @generated
   */
  public Orgao(){
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
  public Orgao setId(java.lang.Integer id){
    this.id = id;
    return this;
  }

  /**
   * Obtém nome
   * return nome
   * @generated
   */
  
  public java.lang.String getNome(){
    return this.nome;
  }

  /**
   * Define nome
   * @param nome nome
   * @generated
   */
  public Orgao setNome(java.lang.String nome){
    this.nome = nome;
    return this;
  }

  /**
   * Obtém orgaoSuperior
   * return orgaoSuperior
   * @generated
   */
  
  public java.lang.Integer getOrgaoSuperior(){
    return this.orgaoSuperior;
  }

  /**
   * Define orgaoSuperior
   * @param orgaoSuperior orgaoSuperior
   * @generated
   */
  public Orgao setOrgaoSuperior(java.lang.Integer orgaoSuperior){
    this.orgaoSuperior = orgaoSuperior;
    return this;
  }

  /**
   * Obtém dataInicioValidade
   * return dataInicioValidade
   * @generated
   */
  
  public java.util.Date getDataInicioValidade(){
    return this.dataInicioValidade;
  }

  /**
   * Define dataInicioValidade
   * @param dataInicioValidade dataInicioValidade
   * @generated
   */
  public Orgao setDataInicioValidade(java.util.Date dataInicioValidade){
    this.dataInicioValidade = dataInicioValidade;
    return this;
  }

  /**
   * Obtém dataFimValidade
   * return dataFimValidade
   * @generated
   */
  
  public java.util.Date getDataFimValidade(){
    return this.dataFimValidade;
  }

  /**
   * Define dataFimValidade
   * @param dataFimValidade dataFimValidade
   * @generated
   */
  public Orgao setDataFimValidade(java.util.Date dataFimValidade){
    this.dataFimValidade = dataFimValidade;
    return this;
  }

  /**
   * Obtém codigoForcaTrabalho
   * return codigoForcaTrabalho
   * @generated
   */
  
  public java.lang.Integer getCodigoForcaTrabalho(){
    return this.codigoForcaTrabalho;
  }

  /**
   * Define codigoForcaTrabalho
   * @param codigoForcaTrabalho codigoForcaTrabalho
   * @generated
   */
  public Orgao setCodigoForcaTrabalho(java.lang.Integer codigoForcaTrabalho){
    this.codigoForcaTrabalho = codigoForcaTrabalho;
    return this;
  }

  /**
   * Obtém areaAtuacao
   * return areaAtuacao
   * @generated
   */
  
  public java.lang.Integer getAreaAtuacao(){
    return this.areaAtuacao;
  }

  /**
   * Define areaAtuacao
   * @param areaAtuacao areaAtuacao
   * @generated
   */
  public Orgao setAreaAtuacao(java.lang.Integer areaAtuacao){
    this.areaAtuacao = areaAtuacao;
    return this;
  }

  /**
   * Obtém descricao
   * return descricao
   * @generated
   */
  
  public java.lang.String getDescricao(){
    return this.descricao;
  }

  /**
   * Define descricao
   * @param descricao descricao
   * @generated
   */
  public Orgao setDescricao(java.lang.String descricao){
    this.descricao = descricao;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Orgao object = (Orgao)obj;
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
