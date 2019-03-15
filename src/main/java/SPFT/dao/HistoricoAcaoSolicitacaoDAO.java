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
@Repository("HistoricoAcaoSolicitacaoDAO")
@Transactional(transactionManager="SPFT-TransactionManager")
public interface HistoricoAcaoSolicitacaoDAO extends JpaRepository<HistoricoAcaoSolicitacao, java.lang.Integer> {

  /**
   * Obtém a instância de HistoricoAcaoSolicitacao utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM HistoricoAcaoSolicitacao entity WHERE entity.id = :id")
  public HistoricoAcaoSolicitacao findOne(@Param(value="id") java.lang.Integer id);

  /**
   * Remove a instância de HistoricoAcaoSolicitacao utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM HistoricoAcaoSolicitacao entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.Integer id);



  /**
   * Foreign Key solicitacaoFerias
   * @generated
   */
  @Query("SELECT entity FROM HistoricoAcaoSolicitacao entity WHERE entity.solicitacaoFerias.id = :id")
  public Page<HistoricoAcaoSolicitacao> findHistoricoAcaoSolicitacaosBySolicitacaoFerias(@Param(value="id") java.lang.Integer id, Pageable pageable);

  /**
   * Foreign Key forcaTrabalho
   * @generated
   */
  @Query("SELECT entity FROM HistoricoAcaoSolicitacao entity WHERE entity.forcaTrabalho.id = :id")
  public Page<HistoricoAcaoSolicitacao> findHistoricoAcaoSolicitacaosByForcaTrabalho(@Param(value="id") java.lang.Integer id, Pageable pageable);

}
