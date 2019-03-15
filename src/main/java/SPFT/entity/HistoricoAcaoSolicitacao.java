package SPFT.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela HISTORICO_ACAO_SOLICITACAO
 * @generated
 */
@Entity
@Table(name = "\"HISTORICO_ACAO_SOLICITACAO\"", schema="\"SPFT\""  ,uniqueConstraints=@UniqueConstraint(columnNames={
"HIAS_CD_HISTORICO_ACAO_SOLICIT" }))
@XmlRootElement
@CronappSecurity
@JsonFilter("SPFT.entity.HistoricoAcaoSolicitacao")
public class HistoricoAcaoSolicitacao implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "HIAS_CD_HISTORICO_ACAO_SOLICIT", nullable = false, insertable=true, updatable=true)
  private java.lang.Integer id;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="SOFE_CD_SOLICITACAO_FERIAS", nullable = false, referencedColumnName = "SOFE_CD_SOLICITACAO_FERIAS", insertable=true, updatable=true)
  
  private SolicitacaoFerias solicitacaoFerias;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="FOTR_CD_FORCA_TRABALHO_EXEC", nullable = false, referencedColumnName = "FOTR_CD_FORCA_TRABALHO", insertable=true, updatable=true)
  
  private ForcaTrabalho forcaTrabalho;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "HIAS_DT_HISTORICO_ACAO_SOLICIT", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataHistorico;

  /**
  * @generated
  */
  @Column(name = "HIAS_DS_JUSTIFICATIVA", nullable = true, unique = false, length=4000, insertable=true, updatable=true)
  
  private java.lang.String justificativa;

  /**
  * @generated
  */
  @Column(name = "HIAS_IN_STATUS", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer status;

  /**
  * @generated
  */
  @Column(name = "HIAS_IN_UTILIZA_ABONO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer utilizaAbono;

  /**
  * @generated
  */
  @Column(name = "HIAS_IN_ADIANTA_DECIMO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer adiantaDecimo;

  /**
  * @generated
  */
  @Column(name = "HIAS_IN_DIVIDIR", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer dividir;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "HIAS_DT_PERIODO1_INICIO", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataPeriodo1Inicio;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "HIAS_DT_PERIODO1_FIM", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataPeriodo1Fim;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "HIAS_DT_PERIODO2_INICIO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataPeriodo2Inicio;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "HIAS_DT_PERIODO2_FIM", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataPeriodo2Fim;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "HIAS_DT_PERIODO3_INICIO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataPeriodo3Inicio;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "HIAS_DT_PERIODO3_FIM", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataPeriodo3Fim;

  /**
   * Construtor
   * @generated
   */
  public HistoricoAcaoSolicitacao(){
  }


  /**
   * Obtém solicitacaoFerias
   * return solicitacaoFerias
   * @generated
   */
  
  public SolicitacaoFerias getSolicitacaoFerias(){
    return this.solicitacaoFerias;
  }

  /**
   * Define solicitacaoFerias
   * @param solicitacaoFerias solicitacaoFerias
   * @generated
   */
  public HistoricoAcaoSolicitacao setSolicitacaoFerias(SolicitacaoFerias solicitacaoFerias){
    this.solicitacaoFerias = solicitacaoFerias;
    return this;
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
  public HistoricoAcaoSolicitacao setId(java.lang.Integer id){
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
  public HistoricoAcaoSolicitacao setForcaTrabalho(ForcaTrabalho forcaTrabalho){
    this.forcaTrabalho = forcaTrabalho;
    return this;
  }

  /**
   * Obtém dataHistorico
   * return dataHistorico
   * @generated
   */
  
  public java.util.Date getDataHistorico(){
    return this.dataHistorico;
  }

  /**
   * Define dataHistorico
   * @param dataHistorico dataHistorico
   * @generated
   */
  public HistoricoAcaoSolicitacao setDataHistorico(java.util.Date dataHistorico){
    this.dataHistorico = dataHistorico;
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
  public HistoricoAcaoSolicitacao setJustificativa(java.lang.String justificativa){
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
  public HistoricoAcaoSolicitacao setStatus(java.lang.Integer status){
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
  public HistoricoAcaoSolicitacao setUtilizaAbono(java.lang.Integer utilizaAbono){
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
  public HistoricoAcaoSolicitacao setAdiantaDecimo(java.lang.Integer adiantaDecimo){
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
  public HistoricoAcaoSolicitacao setDividir(java.lang.Integer dividir){
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
  public HistoricoAcaoSolicitacao setDataPeriodo1Inicio(java.util.Date dataPeriodo1Inicio){
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
  public HistoricoAcaoSolicitacao setDataPeriodo1Fim(java.util.Date dataPeriodo1Fim){
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
  public HistoricoAcaoSolicitacao setDataPeriodo2Inicio(java.util.Date dataPeriodo2Inicio){
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
  public HistoricoAcaoSolicitacao setDataPeriodo2Fim(java.util.Date dataPeriodo2Fim){
    this.dataPeriodo2Fim = dataPeriodo2Fim;
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
  public HistoricoAcaoSolicitacao setDataPeriodo3Inicio(java.util.Date dataPeriodo3Inicio){
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
  public HistoricoAcaoSolicitacao setDataPeriodo3Fim(java.util.Date dataPeriodo3Fim){
    this.dataPeriodo3Fim = dataPeriodo3Fim;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    HistoricoAcaoSolicitacao object = (HistoricoAcaoSolicitacao)obj;
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
