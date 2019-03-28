package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela HISTORICO
 * @generated
 */
@Entity
@Table(name = "\"HISTORICO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Historico")
public class Historico implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "id", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Column(name = "tabela", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String tabela;

  /**
  * @generated
  */
  @Column(name = "idTabela", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String idTabela;

  /**
  * @generated
  */
  @Column(name = "descricao", nullable = true, unique = false, length=4000, insertable=true, updatable=true)
  
  private java.lang.String descricao;

  /**
   * Construtor
   * @generated
   */
  public Historico(){
  }


  /**
   * Obtém id
   * return id
   * @generated
   */
  
  public java.lang.String getId(){
    return this.id;
  }

  /**
   * Define id
   * @param id id
   * @generated
   */
  public Historico setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém tabela
   * return tabela
   * @generated
   */
  
  public java.lang.String getTabela(){
    return this.tabela;
  }

  /**
   * Define tabela
   * @param tabela tabela
   * @generated
   */
  public Historico setTabela(java.lang.String tabela){
    this.tabela = tabela;
    return this;
  }

  /**
   * Obtém idTabela
   * return idTabela
   * @generated
   */
  
  public java.lang.String getIdTabela(){
    return this.idTabela;
  }

  /**
   * Define idTabela
   * @param idTabela idTabela
   * @generated
   */
  public Historico setIdTabela(java.lang.String idTabela){
    this.idTabela = idTabela;
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
  public Historico setDescricao(java.lang.String descricao){
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
    Historico object = (Historico)obj;
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
