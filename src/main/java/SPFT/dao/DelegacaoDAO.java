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
@Repository("DelegacaoDAO")
@Transactional(transactionManager="SPFT-TransactionManager")
public interface DelegacaoDAO extends JpaRepository<Delegacao, java.lang.Integer> {

  /**
   * Obtém a instância de Delegacao utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Delegacao entity WHERE entity.id = :id")
  public Delegacao findOne(@Param(value="id") java.lang.Integer id);

  /**
   * Remove a instância de Delegacao utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Delegacao entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.Integer id);



  /**
   * Foreign Key orgao
   * @generated
   */
  @Query("SELECT entity FROM Delegacao entity WHERE entity.orgao.id = :id")
  public Page<Delegacao> findDelegacaosByOrgao(@Param(value="id") java.lang.Integer id, Pageable pageable);

  /**
   * Foreign Key forcaTrabalhoGerente
   * @generated
   */
  @Query("SELECT entity FROM Delegacao entity WHERE entity.forcaTrabalhoGerente.id = :id")
  public Page<Delegacao> findDelegacaosByForcaTrabalhoGerente(@Param(value="id") java.lang.Integer id, Pageable pageable);

  /**
   * Foreign Key forcaTrabalhoDelegado
   * @generated
   */
  @Query("SELECT entity FROM Delegacao entity WHERE entity.forcaTrabalhoDelegado.id = :id")
  public Page<Delegacao> findDelegacaosByForcaTrabalhoDelegado(@Param(value="id") java.lang.Integer id, Pageable pageable);

  /**
   * Foreign Key forcaTrabalhoDes
   * @generated
   */
  @Query("SELECT entity FROM Delegacao entity WHERE entity.forcaTrabalhoDes.id = :id")
  public Page<Delegacao> findDelegacaosByForcaTrabalhoDes(@Param(value="id") java.lang.Integer id, Pageable pageable);

}
