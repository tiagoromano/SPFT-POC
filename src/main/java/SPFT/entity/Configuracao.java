package SPFT.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela CONFIGURACAO
 * @generated
 */
@Entity
@Table(name = "\"CONFIGURACAO\"", schema="\"SPFT\""  ,uniqueConstraints=@UniqueConstraint(columnNames={
"CONF_CD_CONFIGURACAO" }))
@XmlRootElement
@CronappSecurity
@JsonFilter("SPFT.entity.Configuracao")
public class Configuracao implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "CONF_CD_CONFIGURACAO", nullable = false, insertable=true, updatable=true)
  private java.lang.Integer id;

  /**
  * @generated
  */
  @Column(name = "CONF_DS_CONFIGURACAO", nullable = true, unique = false, length=30, insertable=true, updatable=true)
  
  private java.lang.String descricao;

  /**
  * @generated
  */
  @Column(name = "CONF_VL_CONFIGURACAO", nullable = true, unique = false, length=10, insertable=true, updatable=true)
  
  private java.lang.String valorLivre;

  /**
   * Construtor
   * @generated
   */
  public Configuracao(){
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
  public Configuracao setId(java.lang.Integer id){
    this.id = id;
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
  public Configuracao setDescricao(java.lang.String descricao){
    this.descricao = descricao;
    return this;
  }

  /**
   * Obtém valorLivre
   * return valorLivre
   * @generated
   */
  
  public java.lang.String getValorLivre(){
    return this.valorLivre;
  }

  /**
   * Define valorLivre
   * @param valorLivre valorLivre
   * @generated
   */
  public Configuracao setValorLivre(java.lang.String valorLivre){
    this.valorLivre = valorLivre;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Configuracao object = (Configuracao)obj;
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
