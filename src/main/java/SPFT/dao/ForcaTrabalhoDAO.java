package SPFT.dao;

import SPFT.entity.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*; 


/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("ForcaTrabalhoDAO")
@Transactional(transactionManager="SPFT-TransactionManager")
public interface ForcaTrabalhoDAO extends JpaRepository<ForcaTrabalho, java.lang.Integer> {

  /**
   * Obtém a instância de ForcaTrabalho utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM ForcaTrabalho entity WHERE entity.id = :id")
  public ForcaTrabalho findOne(@Param(value="id") java.lang.Integer id);

  /**
   * Remove a instância de ForcaTrabalho utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM ForcaTrabalho entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.Integer id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM PeriodoConcessao entity WHERE entity.forcaTrabalho.id = :id")
  public Page<PeriodoConcessao> findPeriodoConcessao(@Param(value="id") java.lang.Integer id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM HistoricoAcaoSolicitacao entity WHERE entity.forcaTrabalho.id = :id")
  public Page<HistoricoAcaoSolicitacao> findHistoricoAcaoSolicitacao(@Param(value="id") java.lang.Integer id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Delegacao entity WHERE entity.forcaTrabalhoGerente.id = :id")
  public Page<Delegacao> findDelegacao(@Param(value="id") java.lang.Integer id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Delegacao entity WHERE entity.forcaTrabalhoDelegado.id = :id")
  public Page<Delegacao> findDelegacao_2(@Param(value="id") java.lang.Integer id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Delegacao entity WHERE entity.forcaTrabalhoDes.id = :id")
  public Page<Delegacao> findDelegacao_3(@Param(value="id") java.lang.Integer id, Pageable pageable);
  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.solicitacaoFerias FROM HistoricoAcaoSolicitacao entity WHERE entity.forcaTrabalho.id = :id")
  public Page<SolicitacaoFerias> listSolicitacaoFerias(@Param(value="id") java.lang.Integer id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM HistoricoAcaoSolicitacao entity WHERE entity.forcaTrabalho.id = :instanceId AND entity.solicitacaoFerias.id = :relationId")
  public int deleteSolicitacaoFerias(@Param(value="instanceId") java.lang.Integer instanceId, @Param(value="relationId") java.lang.Integer relationId);

  /**
   * Foreign Key orgao
   * @generated
   */
  @Query("SELECT entity FROM ForcaTrabalho entity WHERE entity.orgao.id = :id")
  public Page<ForcaTrabalho> findForcaTrabalhosByOrgao(@Param(value="id") java.lang.Integer id, Pageable pageable);

}
