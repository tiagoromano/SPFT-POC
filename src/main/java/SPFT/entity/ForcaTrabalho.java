package SPFT.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela FORCA_TRABALHO
 * @generated
 */
@Entity
@Table(name = "\"FORCA_TRABALHO\"", schema="\"BIDTCORP\""  ,uniqueConstraints=@UniqueConstraint(columnNames={
"FOTR_CD_FORCA_TRABALHO" }))
@XmlRootElement
@CronappSecurity
@JsonFilter("SPFT.entity.ForcaTrabalho")
public class ForcaTrabalho implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "FOTR_CD_FORCA_TRABALHO", nullable = false, insertable=true, updatable=true)
  private java.lang.Integer id;

  /**
  * @generated
  */
  @Column(name = "FOTR_NM_FORCA_TRABALHO", nullable = false, unique = false, length=100, insertable=true, updatable=true)
  
  private java.lang.String nome;

  /**
  * @generated
  */
  @Column(name = "CARG_CD_CARGO", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer codigoCargo;

  /**
  * @generated
  */
  @Column(name = "APCA_CD_APLICACAO_CARGO", nullable = true, unique = false, length=3, insertable=true, updatable=true)
  
  private java.lang.String codigoAplicacaoCargo;

  /**
  * @generated
  */
  @Column(name = "GREM_CD_GRUPO_EMPREGADO", nullable = true, unique = false, length=1, insertable=true, updatable=true)
  
  private java.lang.String codigoGrupoEmpregado;

  /**
  * @generated
  */
  @Column(name = "FOTR_IN_TERRA_MAR", nullable = true, unique = false, length=1, insertable=true, updatable=true)
  
  private java.lang.String terraMar;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "FOTR_DT_CESSAO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataCessao;

  /**
  * @generated
  */
  @Column(name = "FUNC_CD_FUNCAO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer codigoFuncao;

  /**
  * @generated
  */
  @Column(name = "FOTR_CD_LOGIN", nullable = true, unique = false, length=4, insertable=true, updatable=true)
  
  private java.lang.String codigoLogin;

  /**
  * @generated
  */
  @Column(name = "FOTR_NR_CPF", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Long cpf;

  /**
  * @generated
  */
  @Column(name = "FOTR_TX_PASSAPORTE", nullable = true, unique = false, length=24, insertable=true, updatable=true)
  
  private java.lang.String passaporte;

  /**
  * @generated
  */
  @Column(name = "FOTR_NR_MATRICULA", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Long matricula;

  /**
  * @generated
  */
  @Column(name = "FOTR_IN_SEXO", nullable = true, unique = false, length=1, insertable=true, updatable=true)
  
  private java.lang.String sexo;

  /**
  * @generated
  */
  @Column(name = "FOTR_TX_EMAIL", nullable = true, unique = false, length=255, insertable=true, updatable=true)
  
  private java.lang.String email;

  /**
  * @generated
  */
  @Column(name = "IMOV_CD_IMOVEL", nullable = true, unique = false, length=15, insertable=true, updatable=true)
  
  private java.lang.String codigoImovel;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="ORGA_CD_ORGAO", nullable = true, referencedColumnName = "ORGA_CD_ORGAO", insertable=true, updatable=true)
  
  private Orgao orgao;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "FOTR_DT_NASCIMENTO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataNascimento;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "FOTR_DT_ADMISSAO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataAdmissao;

  /**
  * @generated
  */
  @Column(name = "FOTR_NR_RAMAL", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Long numeroRamal;

  /**
  * @generated
  */
  @Column(name = "FOTR_TX_ENDERECO", nullable = true, unique = false, length=100, insertable=true, updatable=true)
  
  private java.lang.String endereco;

  /**
  * @generated
  */
  @Column(name = "FOTR_TX_ENDERECO_COMPLEMENTO", nullable = true, unique = false, length=60, insertable=true, updatable=true)
  
  private java.lang.String enderecoComplemento;

  /**
  * @generated
  */
  @Column(name = "FOTR_TX_ENDERECO_BAIRRO", nullable = true, unique = false, length=40, insertable=true, updatable=true)
  
  private java.lang.String enderecoBairro;

  /**
  * @generated
  */
  @Column(name = "PAIS_CD_PAIS", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer codigoPais;

  /**
  * @generated
  */
  @Column(name = "UNFE_SG_UF", nullable = true, unique = false, length=2, insertable=true, updatable=true)
  
  private java.lang.String uf;

  /**
  * @generated
  */
  @Column(name = "CIDA_CD_CIDADE", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer codigoCidade;

  /**
  * @generated
  */
  @Column(name = "FOTR_TX_CEP", nullable = true, unique = false, length=100, insertable=true, updatable=true)
  
  private java.lang.String cep;

  /**
  * @generated
  */
  @Column(name = "FOTR_TX_TELEFONE", nullable = true, unique = false, length=14, insertable=true, updatable=true)
  
  private java.lang.String telefone;

  /**
  * @generated
  */
  @Column(name = "FOTR_TX_CELULAR", nullable = true, unique = false, length=14, insertable=true, updatable=true)
  
  private java.lang.String celular;

  /**
  * @generated
  */
  @Column(name = "FOTR_IN_TIPO_SANGUINEO", nullable = true, unique = false, length=3, insertable=true, updatable=true)
  
  private java.lang.String tipoSanguineo;

  /**
  * @generated
  */
  @Column(name = "RACA_CD_RACA", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer codigoRaca;

  /**
  * @generated
  */
  @Column(name = "RELI_CD_RELIGIAO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer codigoReligiao;

  /**
  * @generated
  */
  @Column(name = "ESCO_CD_ESCOLARIDADE", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer codigoEscolaridade;

  /**
  * @generated
  */
  @Column(name = "ESCI_CD_ESTADO_CIVIL", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer codigoEstadoCivil;

  /**
  * @generated
  */
  @Column(name = "FOTR_IN_SITUACAO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Integer situacao;

  /**
  * @generated
  */
  @Column(name = "FOTR_NM_FORCA_TRABALHO_GUERRA", nullable = true, unique = false, length=100, insertable=true, updatable=true)
  
  private java.lang.String nomeForcaTrabalhoGuerra;

  /**
  * @generated
  */
  @Column(name = "FOTR_SG_EMPRESA_ORIGEM", nullable = true, unique = false, length=15, insertable=true, updatable=true)
  
  private java.lang.String siglaEmpresaOrigem;

  /**
  * @generated
  */
  @Column(name = "FOTR_TX_EMAIL_PARTICULAR1", nullable = true, unique = false, length=100, insertable=true, updatable=true)
  
  private java.lang.String emailParticular1;

  /**
  * @generated
  */
  @Column(name = "FOTR_TX_EMAIL_PARTICULAR2", nullable = true, unique = false, length=100, insertable=true, updatable=true)
  
  private java.lang.String emailParticular2;

  /**
  * @generated
  */
  @Column(name = "FOTR_NR_EXTERNO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Long numeroExterno;

  /**
  * @generated
  */
  @Column(name = "FOTR_TX_MOTIVO_STATUS", nullable = true, unique = false, length=100, insertable=true, updatable=true)
  
  private java.lang.String motivoStatus;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "FOTR_DT_CADASTRO", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date dataCadastro;

  /**
  * @generated
  */
  @Column(name = "FOTR_DS_REQ_CED", nullable = true, unique = false, length=11, insertable=true, updatable=true)
  
  private java.lang.String reqCed;

  /**
  * @generated
  */
  @Column(name = "FOTR_DS_MOTIVO_REQ_CED", nullable = true, unique = false, length=30, insertable=true, updatable=true)
  
  private java.lang.String motivoReqCed;

  /**
  * @generated
  */
  @Column(name = "FOTR_CD_INATIVO", nullable = true, unique = false, length=18, insertable=true, updatable=true)
  
  private java.lang.String codigoInativo;

  /**
  * @generated
  */
  @Column(name = "FOTR_DS_MOTIVO_INATIVO", nullable = true, unique = false, length=30, insertable=true, updatable=true)
  
  private java.lang.String motivoInativo;

  /**
  * @generated
  */
  @Column(name = "SUEMP_CD_SUBGRUPO_EMPREGADO", nullable = true, unique = false, length=2, insertable=true, updatable=true)
  
  private java.lang.String codigoSubgrupoEmpregado;

  /**
  * @generated
  */
  @Column(name = "FOTR_TX_CENTRO_CUSTO", nullable = true, unique = false, length=100, insertable=true, updatable=true)
  
  private java.lang.String centroCusto;

  /**
   * Construtor
   * @generated
   */
  public ForcaTrabalho(){
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
  public ForcaTrabalho setId(java.lang.Integer id){
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
  public ForcaTrabalho setNome(java.lang.String nome){
    this.nome = nome;
    return this;
  }

  /**
   * Obtém codigoCargo
   * return codigoCargo
   * @generated
   */
  
  public java.lang.Integer getCodigoCargo(){
    return this.codigoCargo;
  }

  /**
   * Define codigoCargo
   * @param codigoCargo codigoCargo
   * @generated
   */
  public ForcaTrabalho setCodigoCargo(java.lang.Integer codigoCargo){
    this.codigoCargo = codigoCargo;
    return this;
  }

  /**
   * Obtém codigoAplicacaoCargo
   * return codigoAplicacaoCargo
   * @generated
   */
  
  public java.lang.String getCodigoAplicacaoCargo(){
    return this.codigoAplicacaoCargo;
  }

  /**
   * Define codigoAplicacaoCargo
   * @param codigoAplicacaoCargo codigoAplicacaoCargo
   * @generated
   */
  public ForcaTrabalho setCodigoAplicacaoCargo(java.lang.String codigoAplicacaoCargo){
    this.codigoAplicacaoCargo = codigoAplicacaoCargo;
    return this;
  }

  /**
   * Obtém codigoGrupoEmpregado
   * return codigoGrupoEmpregado
   * @generated
   */
  
  public java.lang.String getCodigoGrupoEmpregado(){
    return this.codigoGrupoEmpregado;
  }

  /**
   * Define codigoGrupoEmpregado
   * @param codigoGrupoEmpregado codigoGrupoEmpregado
   * @generated
   */
  public ForcaTrabalho setCodigoGrupoEmpregado(java.lang.String codigoGrupoEmpregado){
    this.codigoGrupoEmpregado = codigoGrupoEmpregado;
    return this;
  }

  /**
   * Obtém terraMar
   * return terraMar
   * @generated
   */
  
  public java.lang.String getTerraMar(){
    return this.terraMar;
  }

  /**
   * Define terraMar
   * @param terraMar terraMar
   * @generated
   */
  public ForcaTrabalho setTerraMar(java.lang.String terraMar){
    this.terraMar = terraMar;
    return this;
  }

  /**
   * Obtém dataCessao
   * return dataCessao
   * @generated
   */
  
  public java.util.Date getDataCessao(){
    return this.dataCessao;
  }

  /**
   * Define dataCessao
   * @param dataCessao dataCessao
   * @generated
   */
  public ForcaTrabalho setDataCessao(java.util.Date dataCessao){
    this.dataCessao = dataCessao;
    return this;
  }

  /**
   * Obtém codigoFuncao
   * return codigoFuncao
   * @generated
   */
  
  public java.lang.Integer getCodigoFuncao(){
    return this.codigoFuncao;
  }

  /**
   * Define codigoFuncao
   * @param codigoFuncao codigoFuncao
   * @generated
   */
  public ForcaTrabalho setCodigoFuncao(java.lang.Integer codigoFuncao){
    this.codigoFuncao = codigoFuncao;
    return this;
  }

  /**
   * Obtém codigoLogin
   * return codigoLogin
   * @generated
   */
  
  public java.lang.String getCodigoLogin(){
    return this.codigoLogin;
  }

  /**
   * Define codigoLogin
   * @param codigoLogin codigoLogin
   * @generated
   */
  public ForcaTrabalho setCodigoLogin(java.lang.String codigoLogin){
    this.codigoLogin = codigoLogin;
    return this;
  }

  /**
   * Obtém cpf
   * return cpf
   * @generated
   */
  
  public java.lang.Long getCpf(){
    return this.cpf;
  }

  /**
   * Define cpf
   * @param cpf cpf
   * @generated
   */
  public ForcaTrabalho setCpf(java.lang.Long cpf){
    this.cpf = cpf;
    return this;
  }

  /**
   * Obtém passaporte
   * return passaporte
   * @generated
   */
  
  public java.lang.String getPassaporte(){
    return this.passaporte;
  }

  /**
   * Define passaporte
   * @param passaporte passaporte
   * @generated
   */
  public ForcaTrabalho setPassaporte(java.lang.String passaporte){
    this.passaporte = passaporte;
    return this;
  }

  /**
   * Obtém matricula
   * return matricula
   * @generated
   */
  
  public java.lang.Long getMatricula(){
    return this.matricula;
  }

  /**
   * Define matricula
   * @param matricula matricula
   * @generated
   */
  public ForcaTrabalho setMatricula(java.lang.Long matricula){
    this.matricula = matricula;
    return this;
  }

  /**
   * Obtém sexo
   * return sexo
   * @generated
   */
  
  public java.lang.String getSexo(){
    return this.sexo;
  }

  /**
   * Define sexo
   * @param sexo sexo
   * @generated
   */
  public ForcaTrabalho setSexo(java.lang.String sexo){
    this.sexo = sexo;
    return this;
  }

  /**
   * Obtém email
   * return email
   * @generated
   */
  
  public java.lang.String getEmail(){
    return this.email;
  }

  /**
   * Define email
   * @param email email
   * @generated
   */
  public ForcaTrabalho setEmail(java.lang.String email){
    this.email = email;
    return this;
  }

  /**
   * Obtém codigoImovel
   * return codigoImovel
   * @generated
   */
  
  public java.lang.String getCodigoImovel(){
    return this.codigoImovel;
  }

  /**
   * Define codigoImovel
   * @param codigoImovel codigoImovel
   * @generated
   */
  public ForcaTrabalho setCodigoImovel(java.lang.String codigoImovel){
    this.codigoImovel = codigoImovel;
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
  public ForcaTrabalho setOrgao(Orgao orgao){
    this.orgao = orgao;
    return this;
  }

  /**
   * Obtém dataNascimento
   * return dataNascimento
   * @generated
   */
  
  public java.util.Date getDataNascimento(){
    return this.dataNascimento;
  }

  /**
   * Define dataNascimento
   * @param dataNascimento dataNascimento
   * @generated
   */
  public ForcaTrabalho setDataNascimento(java.util.Date dataNascimento){
    this.dataNascimento = dataNascimento;
    return this;
  }

  /**
   * Obtém dataAdmissao
   * return dataAdmissao
   * @generated
   */
  
  public java.util.Date getDataAdmissao(){
    return this.dataAdmissao;
  }

  /**
   * Define dataAdmissao
   * @param dataAdmissao dataAdmissao
   * @generated
   */
  public ForcaTrabalho setDataAdmissao(java.util.Date dataAdmissao){
    this.dataAdmissao = dataAdmissao;
    return this;
  }

  /**
   * Obtém numeroRamal
   * return numeroRamal
   * @generated
   */
  
  public java.lang.Long getNumeroRamal(){
    return this.numeroRamal;
  }

  /**
   * Define numeroRamal
   * @param numeroRamal numeroRamal
   * @generated
   */
  public ForcaTrabalho setNumeroRamal(java.lang.Long numeroRamal){
    this.numeroRamal = numeroRamal;
    return this;
  }

  /**
   * Obtém endereco
   * return endereco
   * @generated
   */
  
  public java.lang.String getEndereco(){
    return this.endereco;
  }

  /**
   * Define endereco
   * @param endereco endereco
   * @generated
   */
  public ForcaTrabalho setEndereco(java.lang.String endereco){
    this.endereco = endereco;
    return this;
  }

  /**
   * Obtém enderecoComplemento
   * return enderecoComplemento
   * @generated
   */
  
  public java.lang.String getEnderecoComplemento(){
    return this.enderecoComplemento;
  }

  /**
   * Define enderecoComplemento
   * @param enderecoComplemento enderecoComplemento
   * @generated
   */
  public ForcaTrabalho setEnderecoComplemento(java.lang.String enderecoComplemento){
    this.enderecoComplemento = enderecoComplemento;
    return this;
  }

  /**
   * Obtém enderecoBairro
   * return enderecoBairro
   * @generated
   */
  
  public java.lang.String getEnderecoBairro(){
    return this.enderecoBairro;
  }

  /**
   * Define enderecoBairro
   * @param enderecoBairro enderecoBairro
   * @generated
   */
  public ForcaTrabalho setEnderecoBairro(java.lang.String enderecoBairro){
    this.enderecoBairro = enderecoBairro;
    return this;
  }

  /**
   * Obtém codigoPais
   * return codigoPais
   * @generated
   */
  
  public java.lang.Integer getCodigoPais(){
    return this.codigoPais;
  }

  /**
   * Define codigoPais
   * @param codigoPais codigoPais
   * @generated
   */
  public ForcaTrabalho setCodigoPais(java.lang.Integer codigoPais){
    this.codigoPais = codigoPais;
    return this;
  }

  /**
   * Obtém uf
   * return uf
   * @generated
   */
  
  public java.lang.String getUf(){
    return this.uf;
  }

  /**
   * Define uf
   * @param uf uf
   * @generated
   */
  public ForcaTrabalho setUf(java.lang.String uf){
    this.uf = uf;
    return this;
  }

  /**
   * Obtém codigoCidade
   * return codigoCidade
   * @generated
   */
  
  public java.lang.Integer getCodigoCidade(){
    return this.codigoCidade;
  }

  /**
   * Define codigoCidade
   * @param codigoCidade codigoCidade
   * @generated
   */
  public ForcaTrabalho setCodigoCidade(java.lang.Integer codigoCidade){
    this.codigoCidade = codigoCidade;
    return this;
  }

  /**
   * Obtém cep
   * return cep
   * @generated
   */
  
  public java.lang.String getCep(){
    return this.cep;
  }

  /**
   * Define cep
   * @param cep cep
   * @generated
   */
  public ForcaTrabalho setCep(java.lang.String cep){
    this.cep = cep;
    return this;
  }

  /**
   * Obtém telefone
   * return telefone
   * @generated
   */
  
  public java.lang.String getTelefone(){
    return this.telefone;
  }

  /**
   * Define telefone
   * @param telefone telefone
   * @generated
   */
  public ForcaTrabalho setTelefone(java.lang.String telefone){
    this.telefone = telefone;
    return this;
  }

  /**
   * Obtém celular
   * return celular
   * @generated
   */
  
  public java.lang.String getCelular(){
    return this.celular;
  }

  /**
   * Define celular
   * @param celular celular
   * @generated
   */
  public ForcaTrabalho setCelular(java.lang.String celular){
    this.celular = celular;
    return this;
  }

  /**
   * Obtém tipoSanguineo
   * return tipoSanguineo
   * @generated
   */
  
  public java.lang.String getTipoSanguineo(){
    return this.tipoSanguineo;
  }

  /**
   * Define tipoSanguineo
   * @param tipoSanguineo tipoSanguineo
   * @generated
   */
  public ForcaTrabalho setTipoSanguineo(java.lang.String tipoSanguineo){
    this.tipoSanguineo = tipoSanguineo;
    return this;
  }

  /**
   * Obtém codigoRaca
   * return codigoRaca
   * @generated
   */
  
  public java.lang.Integer getCodigoRaca(){
    return this.codigoRaca;
  }

  /**
   * Define codigoRaca
   * @param codigoRaca codigoRaca
   * @generated
   */
  public ForcaTrabalho setCodigoRaca(java.lang.Integer codigoRaca){
    this.codigoRaca = codigoRaca;
    return this;
  }

  /**
   * Obtém codigoReligiao
   * return codigoReligiao
   * @generated
   */
  
  public java.lang.Integer getCodigoReligiao(){
    return this.codigoReligiao;
  }

  /**
   * Define codigoReligiao
   * @param codigoReligiao codigoReligiao
   * @generated
   */
  public ForcaTrabalho setCodigoReligiao(java.lang.Integer codigoReligiao){
    this.codigoReligiao = codigoReligiao;
    return this;
  }

  /**
   * Obtém codigoEscolaridade
   * return codigoEscolaridade
   * @generated
   */
  
  public java.lang.Integer getCodigoEscolaridade(){
    return this.codigoEscolaridade;
  }

  /**
   * Define codigoEscolaridade
   * @param codigoEscolaridade codigoEscolaridade
   * @generated
   */
  public ForcaTrabalho setCodigoEscolaridade(java.lang.Integer codigoEscolaridade){
    this.codigoEscolaridade = codigoEscolaridade;
    return this;
  }

  /**
   * Obtém codigoEstadoCivil
   * return codigoEstadoCivil
   * @generated
   */
  
  public java.lang.Integer getCodigoEstadoCivil(){
    return this.codigoEstadoCivil;
  }

  /**
   * Define codigoEstadoCivil
   * @param codigoEstadoCivil codigoEstadoCivil
   * @generated
   */
  public ForcaTrabalho setCodigoEstadoCivil(java.lang.Integer codigoEstadoCivil){
    this.codigoEstadoCivil = codigoEstadoCivil;
    return this;
  }

  /**
   * Obtém situacao
   * return situacao
   * @generated
   */
  
  public java.lang.Integer getSituacao(){
    return this.situacao;
  }

  /**
   * Define situacao
   * @param situacao situacao
   * @generated
   */
  public ForcaTrabalho setSituacao(java.lang.Integer situacao){
    this.situacao = situacao;
    return this;
  }

  /**
   * Obtém nomeForcaTrabalhoGuerra
   * return nomeForcaTrabalhoGuerra
   * @generated
   */
  
  public java.lang.String getNomeForcaTrabalhoGuerra(){
    return this.nomeForcaTrabalhoGuerra;
  }

  /**
   * Define nomeForcaTrabalhoGuerra
   * @param nomeForcaTrabalhoGuerra nomeForcaTrabalhoGuerra
   * @generated
   */
  public ForcaTrabalho setNomeForcaTrabalhoGuerra(java.lang.String nomeForcaTrabalhoGuerra){
    this.nomeForcaTrabalhoGuerra = nomeForcaTrabalhoGuerra;
    return this;
  }

  /**
   * Obtém siglaEmpresaOrigem
   * return siglaEmpresaOrigem
   * @generated
   */
  
  public java.lang.String getSiglaEmpresaOrigem(){
    return this.siglaEmpresaOrigem;
  }

  /**
   * Define siglaEmpresaOrigem
   * @param siglaEmpresaOrigem siglaEmpresaOrigem
   * @generated
   */
  public ForcaTrabalho setSiglaEmpresaOrigem(java.lang.String siglaEmpresaOrigem){
    this.siglaEmpresaOrigem = siglaEmpresaOrigem;
    return this;
  }

  /**
   * Obtém emailParticular1
   * return emailParticular1
   * @generated
   */
  
  public java.lang.String getEmailParticular1(){
    return this.emailParticular1;
  }

  /**
   * Define emailParticular1
   * @param emailParticular1 emailParticular1
   * @generated
   */
  public ForcaTrabalho setEmailParticular1(java.lang.String emailParticular1){
    this.emailParticular1 = emailParticular1;
    return this;
  }

  /**
   * Obtém emailParticular2
   * return emailParticular2
   * @generated
   */
  
  public java.lang.String getEmailParticular2(){
    return this.emailParticular2;
  }

  /**
   * Define emailParticular2
   * @param emailParticular2 emailParticular2
   * @generated
   */
  public ForcaTrabalho setEmailParticular2(java.lang.String emailParticular2){
    this.emailParticular2 = emailParticular2;
    return this;
  }

  /**
   * Obtém numeroExterno
   * return numeroExterno
   * @generated
   */
  
  public java.lang.Long getNumeroExterno(){
    return this.numeroExterno;
  }

  /**
   * Define numeroExterno
   * @param numeroExterno numeroExterno
   * @generated
   */
  public ForcaTrabalho setNumeroExterno(java.lang.Long numeroExterno){
    this.numeroExterno = numeroExterno;
    return this;
  }

  /**
   * Obtém motivoStatus
   * return motivoStatus
   * @generated
   */
  
  public java.lang.String getMotivoStatus(){
    return this.motivoStatus;
  }

  /**
   * Define motivoStatus
   * @param motivoStatus motivoStatus
   * @generated
   */
  public ForcaTrabalho setMotivoStatus(java.lang.String motivoStatus){
    this.motivoStatus = motivoStatus;
    return this;
  }

  /**
   * Obtém dataCadastro
   * return dataCadastro
   * @generated
   */
  
  public java.util.Date getDataCadastro(){
    return this.dataCadastro;
  }

  /**
   * Define dataCadastro
   * @param dataCadastro dataCadastro
   * @generated
   */
  public ForcaTrabalho setDataCadastro(java.util.Date dataCadastro){
    this.dataCadastro = dataCadastro;
    return this;
  }

  /**
   * Obtém reqCed
   * return reqCed
   * @generated
   */
  
  public java.lang.String getReqCed(){
    return this.reqCed;
  }

  /**
   * Define reqCed
   * @param reqCed reqCed
   * @generated
   */
  public ForcaTrabalho setReqCed(java.lang.String reqCed){
    this.reqCed = reqCed;
    return this;
  }

  /**
   * Obtém motivoReqCed
   * return motivoReqCed
   * @generated
   */
  
  public java.lang.String getMotivoReqCed(){
    return this.motivoReqCed;
  }

  /**
   * Define motivoReqCed
   * @param motivoReqCed motivoReqCed
   * @generated
   */
  public ForcaTrabalho setMotivoReqCed(java.lang.String motivoReqCed){
    this.motivoReqCed = motivoReqCed;
    return this;
  }

  /**
   * Obtém codigoInativo
   * return codigoInativo
   * @generated
   */
  
  public java.lang.String getCodigoInativo(){
    return this.codigoInativo;
  }

  /**
   * Define codigoInativo
   * @param codigoInativo codigoInativo
   * @generated
   */
  public ForcaTrabalho setCodigoInativo(java.lang.String codigoInativo){
    this.codigoInativo = codigoInativo;
    return this;
  }

  /**
   * Obtém motivoInativo
   * return motivoInativo
   * @generated
   */
  
  public java.lang.String getMotivoInativo(){
    return this.motivoInativo;
  }

  /**
   * Define motivoInativo
   * @param motivoInativo motivoInativo
   * @generated
   */
  public ForcaTrabalho setMotivoInativo(java.lang.String motivoInativo){
    this.motivoInativo = motivoInativo;
    return this;
  }

  /**
   * Obtém codigoSubgrupoEmpregado
   * return codigoSubgrupoEmpregado
   * @generated
   */
  
  public java.lang.String getCodigoSubgrupoEmpregado(){
    return this.codigoSubgrupoEmpregado;
  }

  /**
   * Define codigoSubgrupoEmpregado
   * @param codigoSubgrupoEmpregado codigoSubgrupoEmpregado
   * @generated
   */
  public ForcaTrabalho setCodigoSubgrupoEmpregado(java.lang.String codigoSubgrupoEmpregado){
    this.codigoSubgrupoEmpregado = codigoSubgrupoEmpregado;
    return this;
  }

  /**
   * Obtém centroCusto
   * return centroCusto
   * @generated
   */
  
  public java.lang.String getCentroCusto(){
    return this.centroCusto;
  }

  /**
   * Define centroCusto
   * @param centroCusto centroCusto
   * @generated
   */
  public ForcaTrabalho setCentroCusto(java.lang.String centroCusto){
    this.centroCusto = centroCusto;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    ForcaTrabalho object = (ForcaTrabalho)obj;
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
