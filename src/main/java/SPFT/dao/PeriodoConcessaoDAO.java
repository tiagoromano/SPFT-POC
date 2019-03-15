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
@Repository("PeriodoConcessaoDAO")
@Transactional(transactionManager="SPFT-TransactionManager")
public interface PeriodoConcessaoDAO extends JpaRepository<PeriodoConcessao, java.lang.Integer> {

  /**
   * Obtém a instância de PeriodoConcessao utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM PeriodoConcessao entity WHERE entity.id = :id")
  public PeriodoConcessao findOne(@Param(value="id") java.lang.Integer id);

  /**
   * Remove a instância de PeriodoConcessao utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM PeriodoConcessao entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.Integer id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM SolicitacaoFerias entity WHERE entity.periodoConcessao.id = :id")
  public Page<SolicitacaoFerias> findSolicitacaoFerias(@Param(value="id") java.lang.Integer id, Pageable pageable);

  /**
   * Foreign Key forcaTrabalho
   * @generated
   */
  @Query("SELECT entity FROM PeriodoConcessao entity WHERE entity.forcaTrabalho.id = :id")
  public Page<PeriodoConcessao> findPeriodoConcessaosByForcaTrabalho(@Param(value="id") java.lang.Integer id, Pageable pageable);

}
