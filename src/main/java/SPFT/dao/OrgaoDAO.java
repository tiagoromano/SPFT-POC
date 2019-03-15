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
@Repository("OrgaoDAO")
@Transactional(transactionManager="SPFT-TransactionManager")
public interface OrgaoDAO extends JpaRepository<Orgao, java.lang.Integer> {

  /**
   * Obtém a instância de Orgao utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Orgao entity WHERE entity.id = :id")
  public Orgao findOne(@Param(value="id") java.lang.Integer id);

  /**
   * Remove a instância de Orgao utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Orgao entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.Integer id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM ForcaTrabalho entity WHERE entity.orgao.id = :id")
  public Page<ForcaTrabalho> findForcaTrabalho(@Param(value="id") java.lang.Integer id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Delegacao entity WHERE entity.orgao.id = :id")
  public Page<Delegacao> findDelegacao(@Param(value="id") java.lang.Integer id, Pageable pageable);

}
