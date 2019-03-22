package SPFT.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
/**
 * Classe que representa ...
 * 
 * @author tiago.romano@techne.com.br tiago.romano@techne.com.br
 * @version 1.0
 * @since 2019-03-22
 *
 */
@Entity
@XmlRootElement
@CronappSecurity
@JsonFilter("SPFT.entity.ObterSolicitacaoFeriasPorOrgaoEStatus")
public class ObterSolicitacaoFeriasPorOrgaoEStatus implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  private String nomeFuncionario;
  private String matriculaFuncionario;
  private Integer solicitacaoId;
  private String justificativa;
  private Integer status;
  private String statusDescricao;
  private Integer utilizaAbono;
  private Integer adiantaDecimo;
  private Integer dividir;
  private java.util.Date dataPeriodo1Inicio;
  private java.util.Date dataPeriodo1Fim;
  private java.util.Date dataPeriodo2Inicio;
  private java.util.Date dataPeriodo2Fim;
  private java.util.Date dataPeriodo3Inicio;
  private java.util.Date dataPeriodo3Fim;
  private String periodo1;
  private String periodo2;
  private String periodo3;

  public String getNomeFuncionario() {
    return this.nomeFuncionario;
  }

  public void setNomeFuncionario(String nomeFuncionario) {
    this.nomeFuncionario = nomeFuncionario;
  }

  public String getMatriculaFuncionario() {
    return this.matriculaFuncionario;
  }

  public void setMtriculaFuncionario(String matriculaFuncionario) {
    this.matriculaFuncionario = matriculaFuncionario;
  }

  public Integer getSolicitacaoId() {
    return this.solicitacaoId;
  }

  public void setSolicitacaoId(Integer solicitacaoId) {
    this.solicitacaoId = solicitacaoId;
  }

  public String getJustificativa() {
    return this.justificativa;
  }

  public void setJustificativa(String justificativa) {
    this.justificativa = justificativa;
  }
  
  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getStatusDescricao() {
    return this.statusDescricao;
  }

  public void setStatusDescricao(String statusDescricao) {
    this.statusDescricao = statusDescricao;
  }

  public Integer getUtilizaAbono() {
    return this.utilizaAbono;
  }

  public void setUtilizaAbono(Integer utilizaAbono) {
    this.utilizaAbono = utilizaAbono;
  }

  public Integer getAdiantaDecimo() {
    return this.adiantaDecimo;
  }

  public void setAdiantaDecimo(Integer adiantaDecimo) {
    this.adiantaDecimo = adiantaDecimo;
  }

  public Integer getDividir() {
    return this.dividir;
  }

  public void setDividir(Integer dividir) {
    this.dividir = dividir;
  }

  public java.util.Date getDataPeriodo1Inicio() {
    return this.dataPeriodo1Inicio;
  }

  public void setDataPeriodo1Inicio(java.util.Date dataPeriodo1Inicio) {
    this.dataPeriodo1Inicio = dataPeriodo1Inicio;
  }

  public java.util.Date getDataPeriodo2Inicio() {
    return this.dataPeriodo2Inicio;
  }

  public void setDataPeriodo2Inicio(java.util.Date dataPeriodo2Inicio) {
    this.dataPeriodo2Inicio = dataPeriodo2Inicio;
  }

  public java.util.Date getDataPeriodo3Inicio() {
    return this.dataPeriodo3Inicio;
  }

  public void setDataPeriodo3Inicio(java.util.Date dataPeriodo3Inicio) {
    this.dataPeriodo3Inicio = dataPeriodo3Inicio;
  }

  public java.util.Date getDataPeriodo1Fim() {
    return this.dataPeriodo1Fim;
  }

  public void setDataPeriodo1Fim(java.util.Date dataPeriodo1Fim) {
    this.dataPeriodo1Fim = dataPeriodo1Fim;
  }

  public java.util.Date getDataPeriodo2Fim() {
    return this.dataPeriodo2Fim;
  }

  public void setDataPeriodo2Fim(java.util.Date dataPeriodo2Fim) {
    this.dataPeriodo2Fim = dataPeriodo2Fim;
  }
  public java.util.Date getDataPeriodo3Fim() {
    return this.dataPeriodo3Fim;
  }

  public void setDataPeriodo3Fim(java.util.Date dataPeriodo3Fim) {
    this.dataPeriodo3Fim = dataPeriodo3Fim;
  }
  

  public String getPeriodo1() {
    return this.periodo1;
  }

  public void setPeriodo1(String periodo1) {
    this.periodo1 = periodo1;
  }

  public String getPeriodo2() {
    return this.periodo2;
  }

  public void setPeriodo2(String periodo2) {
    this.periodo2 = periodo2;
  }

  public String getPeriodo3() {
    return this.periodo3;
  }

  public void setPeriodo3(String periodo3) {
    this.periodo3 = periodo3;
  }
}
