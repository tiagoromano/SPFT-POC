package SPFT.entity;

import java.io.Serializable;

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

  /**
   * @generated
   */
  @Id
  @Column(name = "SOFE_CD_SOLICITACAO_FERIAS", nullable = false, insertable=true, updatable=true)
  private java.lang.Integer id;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="PECO_CD_PERIODO_CONCESSAO", nullable = false, referencedColumnName = "PECO_CD_PERIODO_CONCESSAO", insertable=true, updatable=true)
  
  private PeriodoConcessao periodoConcessao;

  /**
  * @generated
  */
  @Column(name = "SOFE_DS_JUSTIFICATIVA", nullable = true, unique = false, length=4000, insertable=true, updatable=true)
  
  private java.lang.String justificativa;

  /**
  * @generated
  */
  @Column(name = "SOFE_IN_STATUS", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer status;

  /**
  * @generated
  */
  @Column(name = "SOFE_IN_UTILIZA_ABONO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer utilizaAbono;

  /**
  * @generated
  */
  @Column(name = "SOFE_IN_ADIANTA_DECIMO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer adiantaDecimo;

  /**
  * @generated
  */
  @Column(name = "SOFE_IN_DIVIDIR", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer dividir;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "SOFE_DT_PERIODO1_INICIO", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataPeriodo1Inicio;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "SOFE_DT_PERIODO1_FIM", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataPeriodo1Fim;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "SOFE_DT_PERIODO2_INICIO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataPeriodo2Inicio;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "SOFE_DT_PERIODO2_FIM", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataPeriodo2Fim;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "SOFE_DT_ATUALIZACAO_DATE", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataAtualizacaoDate;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "SOFE_DT_PERIODO3_INICIO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataPeriodo3Inicio;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "SOFE_DT_PERIODO3_FIM", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataPeriodo3Fim;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "SOFE_DT_ATUALIZACAO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataAtualizacao;

  /**
   * Construtor
   * @generated
   */
  public ObterSolicitacaoFeriasPorOrgaoEStatus(){
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
  public ObterSolicitacaoFeriasPorOrgaoEStatus setId(java.lang.Integer id){
    this.id = id;
    return this;
  }

  /**
   * Obtém periodoConcessao
   * return periodoConcessao
   * @generated
   */
  
  public PeriodoConcessao getPeriodoConcessao(){
    return this.periodoConcessao;
  }

  /**
   * Define periodoConcessao
   * @param periodoConcessao periodoConcessao
   * @generated
   */
  public ObterSolicitacaoFeriasPorOrgaoEStatus setPeriodoConcessao(PeriodoConcessao periodoConcessao){
    this.periodoConcessao = periodoConcessao;
    return this;
  }

  /**
   * Obtém justificativa
   * return justificativa
   * @generated
   */
  
  public java.lang.String getJustificativa(){
    return this.justificativa;
  }

  /**
   * Define justificativa
   * @param justificativa justificativa
   * @generated
   */
  public ObterSolicitacaoFeriasPorOrgaoEStatus setJustificativa(java.lang.String justificativa){
    this.justificativa = justificativa;
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
  public ObterSolicitacaoFeriasPorOrgaoEStatus setStatus(java.lang.Integer status){
    this.status = status;
    return this;
  }

  /**
   * Obtém utilizaAbono
   * return utilizaAbono
   * @generated
   */
  
  public java.lang.Integer getUtilizaAbono(){
    return this.utilizaAbono;
  }

  /**
   * Define utilizaAbono
   * @param utilizaAbono utilizaAbono
   * @generated
   */
  public ObterSolicitacaoFeriasPorOrgaoEStatus setUtilizaAbono(java.lang.Integer utilizaAbono){
    this.utilizaAbono = utilizaAbono;
    return this;
  }

  /**
   * Obtém adiantaDecimo
   * return adiantaDecimo
   * @generated
   */
  
  public java.lang.Integer getAdiantaDecimo(){
    return this.adiantaDecimo;
  }

  /**
   * Define adiantaDecimo
   * @param adiantaDecimo adiantaDecimo
   * @generated
   */
  public ObterSolicitacaoFeriasPorOrgaoEStatus setAdiantaDecimo(java.lang.Integer adiantaDecimo){
    this.adiantaDecimo = adiantaDecimo;
    return this;
  }

  /**
   * Obtém dividir
   * return dividir
   * @generated
   */
  
  public java.lang.Integer getDividir(){
    return this.dividir;
  }

  /**
   * Define dividir
   * @param dividir dividir
   * @generated
   */
  public ObterSolicitacaoFeriasPorOrgaoEStatus setDividir(java.lang.Integer dividir){
    this.dividir = dividir;
    return this;
  }

  /**
   * Obtém dataPeriodo1Inicio
   * return dataPeriodo1Inicio
   * @generated
   */
  
  public java.util.Date getDataPeriodo1Inicio(){
    return this.dataPeriodo1Inicio;
  }

  /**
   * Define dataPeriodo1Inicio
   * @param dataPeriodo1Inicio dataPeriodo1Inicio
   * @generated
   */
  public ObterSolicitacaoFeriasPorOrgaoEStatus setDataPeriodo1Inicio(java.util.Date dataPeriodo1Inicio){
    this.dataPeriodo1Inicio = dataPeriodo1Inicio;
    return this;
  }

  /**
   * Obtém dataPeriodo1Fim
   * return dataPeriodo1Fim
   * @generated
   */
  
  public java.util.Date getDataPeriodo1Fim(){
    return this.dataPeriodo1Fim;
  }

  /**
   * Define dataPeriodo1Fim
   * @param dataPeriodo1Fim dataPeriodo1Fim
   * @generated
   */
  public ObterSolicitacaoFeriasPorOrgaoEStatus setDataPeriodo1Fim(java.util.Date dataPeriodo1Fim){
    this.dataPeriodo1Fim = dataPeriodo1Fim;
    return this;
  }

  /**
   * Obtém dataPeriodo2Inicio
   * return dataPeriodo2Inicio
   * @generated
   */
  
  public java.util.Date getDataPeriodo2Inicio(){
    return this.dataPeriodo2Inicio;
  }

  /**
   * Define dataPeriodo2Inicio
   * @param dataPeriodo2Inicio dataPeriodo2Inicio
   * @generated
   */
  public ObterSolicitacaoFeriasPorOrgaoEStatus setDataPeriodo2Inicio(java.util.Date dataPeriodo2Inicio){
    this.dataPeriodo2Inicio = dataPeriodo2Inicio;
    return this;
  }

  /**
   * Obtém dataPeriodo2Fim
   * return dataPeriodo2Fim
   * @generated
   */
  
  public java.util.Date getDataPeriodo2Fim(){
    return this.dataPeriodo2Fim;
  }

  /**
   * Define dataPeriodo2Fim
   * @param dataPeriodo2Fim dataPeriodo2Fim
   * @generated
   */
  public ObterSolicitacaoFeriasPorOrgaoEStatus setDataPeriodo2Fim(java.util.Date dataPeriodo2Fim){
    this.dataPeriodo2Fim = dataPeriodo2Fim;
    return this;
  }

  /**
   * Obtém dataAtualizacaoDate
   * return dataAtualizacaoDate
   * @generated
   */
  
  public java.util.Date getDataAtualizacaoDate(){
    return this.dataAtualizacaoDate;
  }

  /**
   * Define dataAtualizacaoDate
   * @param dataAtualizacaoDate dataAtualizacaoDate
   * @generated
   */
  public ObterSolicitacaoFeriasPorOrgaoEStatus setDataAtualizacaoDate(java.util.Date dataAtualizacaoDate){
    this.dataAtualizacaoDate = dataAtualizacaoDate;
    return this;
  }

  /**
   * Obtém dataPeriodo3Inicio
   * return dataPeriodo3Inicio
   * @generated
   */
  
  public java.util.Date getDataPeriodo3Inicio(){
    return this.dataPeriodo3Inicio;
  }

  /**
   * Define dataPeriodo3Inicio
   * @param dataPeriodo3Inicio dataPeriodo3Inicio
   * @generated
   */
  public ObterSolicitacaoFeriasPorOrgaoEStatus setDataPeriodo3Inicio(java.util.Date dataPeriodo3Inicio){
    this.dataPeriodo3Inicio = dataPeriodo3Inicio;
    return this;
  }

  /**
   * Obtém dataPeriodo3Fim
   * return dataPeriodo3Fim
   * @generated
   */
  
  public java.util.Date getDataPeriodo3Fim(){
    return this.dataPeriodo3Fim;
  }

  /**
   * Define dataPeriodo3Fim
   * @param dataPeriodo3Fim dataPeriodo3Fim
   * @generated
   */
  public ObterSolicitacaoFeriasPorOrgaoEStatus setDataPeriodo3Fim(java.util.Date dataPeriodo3Fim){
    this.dataPeriodo3Fim = dataPeriodo3Fim;
    return this;
  }

  /**
   * Obtém dataAtualizacao
   * return dataAtualizacao
   * @generated
   */
  
  public java.util.Date getDataAtualizacao(){
    return this.dataAtualizacao;
  }

  /**
   * Define dataAtualizacao
   * @param dataAtualizacao dataAtualizacao
   * @generated
   */
  public ObterSolicitacaoFeriasPorOrgaoEStatus setDataAtualizacao(java.util.Date dataAtualizacao){
    this.dataAtualizacao = dataAtualizacao;
    return this;
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
