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
@Repository("SolicitacaoFeriasDAO")
@Transactional(transactionManager="SPFT-TransactionManager")
public interface SolicitacaoFeriasDAO extends JpaRepository<SolicitacaoFerias, java.lang.Integer> {

  /**
   * Obtém a instância de SolicitacaoFerias utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM SolicitacaoFerias entity WHERE entity.id = :id")
  public SolicitacaoFerias findOne(@Param(value="id") java.lang.Integer id);

  /**
   * Remove a instância de SolicitacaoFerias utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM SolicitacaoFerias entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.Integer id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM HistoricoAcaoSolicitacao entity WHERE entity.solicitacaoFerias.id = :id")
  public Page<HistoricoAcaoSolicitacao> findHistoricoAcaoSolicitacao(@Param(value="id") java.lang.Integer id, Pageable pageable);
  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.forcaTrabalho FROM HistoricoAcaoSolicitacao entity WHERE entity.solicitacaoFerias.id = :id")
  public Page<ForcaTrabalho> listForcaTrabalho(@Param(value="id") java.lang.Integer id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM HistoricoAcaoSolicitacao entity WHERE entity.solicitacaoFerias.id = :instanceId AND entity.forcaTrabalho.id = :relationId")
  public int deleteForcaTrabalho(@Param(value="instanceId") java.lang.Integer instanceId, @Param(value="relationId") java.lang.Integer relationId);

  /**
   * Foreign Key periodoConcessao
   * @generated
   */
  @Query("SELECT entity FROM SolicitacaoFerias entity WHERE entity.periodoConcessao.id = :id")
  public Page<SolicitacaoFerias> findSolicitacaoFeriassByPeriodoConcessao(@Param(value="id") java.lang.Integer id, Pageable pageable);

}
