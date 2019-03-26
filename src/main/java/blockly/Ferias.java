package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.data.domain.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;


/** 
* 
* RestController @generated 
* 
*/ 

@RestController
@RequestMapping(value = "/api/rest/main/Ferias")
@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
public class Ferias {

public static final int TIMEOUT = 300;

/**
 *
 * @param param_login
 * @return Var
 */

@RequestMapping(method = RequestMethod.GET, value="/ObterPeriodosConcessivos/{param_login}")
// Ferias
public static Var ObterPeriodosConcessivos(@PathVariable("param_login") Var param_login ) throws Exception {
 return new Callable<Var>() {

   // param
   private Var login = param_login;
   // end
   private Var solicitacaoFerias = Var.VAR_NULL;
   private Var listaPeriodosConcessivos = Var.VAR_NULL;
   private Var usuarioBIDT = Var.VAR_NULL;
   private Var matricula = Var.VAR_NULL;
   private Var xmlPeriodoConcessivoSAP = Var.VAR_NULL;
   private Var totalPeriodo = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var periodoInicial = Var.VAR_NULL;
   private Var periodoFinal = Var.VAR_NULL;

   public Var call() throws Exception {
    if (cronapi.logic.Operations.isNullOrEmpty(login).getObjectAsBoolean()) {
        login = cronapi.util.Operations.getCurrentUserName();
    }
    listaPeriodosConcessivos = cronapi.list.Operations.newList();
    usuarioBIDT = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.ForcaTrabalho"),Var.valueOf("select f from ForcaTrabalho f where f.codigoLogin = :codigoLogin"),Var.valueOf("codigoLogin",login));
    matricula = cronapi.database.Operations.getField(usuarioBIDT, Var.valueOf("this[0].matricula"));
    xmlPeriodoConcessivoSAP = cronapi.xml.Operations.xmltoJson(blockly.SAP.ObterPeriodosConcessivos(matricula));
    totalPeriodo = cronapi.list.Operations.size(cronapi.json.Operations.getJsonOrMapField(xmlPeriodoConcessivoSAP, Var.valueOf("DocumentElement.Periodos")));
    j = Var.valueOf(0);
    while (Var.valueOf(j.compareTo(totalPeriodo) < 0).getObjectAsBoolean()) {
        periodoInicial = cronapi.json.Operations.getJsonOrMapField(xmlPeriodoConcessivoSAP, Var.valueOf(Var.valueOf("DocumentElement.Periodos[").toString() + j.toString() + Var.valueOf("].PeriodoInicial").toString()));
        periodoFinal = cronapi.json.Operations.getJsonOrMapField(xmlPeriodoConcessivoSAP, Var.valueOf(Var.valueOf("DocumentElement.Periodos[").toString() + j.toString() + Var.valueOf("].PeriodoFinal").toString()));
        solicitacaoFerias = cronapi.object.Operations.newObject(Var.valueOf("SPFT.entity.SolicitacaoFerias"),Var.valueOf("status",Var.valueOf(1)),Var.valueOf("dataPeriodo1Inicio",cronapi.conversion.Operations.stringToDate(periodoInicial, Var.valueOf("dd-MM-yyyy"))),Var.valueOf("dataPeriodo1Fim",cronapi.conversion.Operations.stringToDate(periodoFinal, Var.valueOf("dd-MM-yyyy"))));
        cronapi.list.Operations.addLast(listaPeriodosConcessivos,solicitacaoFerias);
        j = cronapi.math.Operations.sum(j,Var.valueOf(1));
    } // end while
    return listaPeriodosConcessivos;
   }
 }.call();
}

/**
 *
 * @param selectedRows
 * @return Var
 */

@RequestMapping(method = RequestMethod.GET, value="/AprovarSolicitacaoFerias/{selectedRows}")
// Descreva esta função...
public static Var AprovarSolicitacaoFerias(@PathVariable("selectedRows") Var selectedRows ) throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;
   private Var solicitacaoFerias = Var.VAR_NULL;
   private Var totalSolicitacao = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var historicoAcaoSolicitacao = Var.VAR_NULL;
   private Var i_start = Var.VAR_NULL;
   private Var i_inc = Var.VAR_NULL;
   private Var totalAprovadas = Var.VAR_NULL;
   private Var exportado = Var.VAR_NULL;

   public Var call() throws Exception {
    totalSolicitacao = cronapi.list.Operations.size(selectedRows);
    totalAprovadas = Var.valueOf(0);
    i_start = Var.valueOf(1);
    i_inc = Var.valueOf(1);
    if (i_start.greaterThan(totalSolicitacao)) {
        i_inc.multiply(-1);
    }
    for (i = Var.valueOf(i_start);
        i_inc.getObjectAsInt() >= 0 ? i.getObjectAsLong() <= totalSolicitacao.getObjectAsLong() : i.getObjectAsLong()  >= totalSolicitacao.getObjectAsLong();
    i.inc(i_inc))  {
        item = cronapi.list.Operations.get(selectedRows, i);
        solicitacaoFerias = cronapi.list.Operations.getFirst((cronapi.database.Operations.query(Var.valueOf("SPFT.entity.SolicitacaoFerias"),Var.valueOf("select s from SolicitacaoFerias s where s.id = :id"),Var.valueOf("id",cronapi.object.Operations.getObjectField(item, Var.valueOf("solicitacaoId"))))));
        if (Var.valueOf(Var.valueOf(cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("status")).equals(Var.valueOf(1))).getObjectAsBoolean() || Var.valueOf(cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("status")).equals(Var.valueOf(4))).getObjectAsBoolean()).getObjectAsBoolean()) {
            cronapi.object.Operations.setObjectField(solicitacaoFerias, Var.valueOf("status"), Var.valueOf(2));
            cronapi.database.Operations.update(Var.valueOf("SPFT.entity.SolicitacaoFerias"),solicitacaoFerias);
            historicoAcaoSolicitacao = Var.valueOf(GerarHistoricoSolicitacao(cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("id")), cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("periodoConcessao.forcaTrabalho.id")), solicitacaoFerias));
            cronapi.database.Operations.insert(Var.valueOf("SPFT.entity.HistoricoAcaoSolicitacao"),historicoAcaoSolicitacao);
            exportado = blockly.SAP.ExportarSolicitacao(solicitacaoFerias);
            totalAprovadas = cronapi.math.Operations.sum(totalAprovadas,Var.valueOf(1));
        }
    } // end for
    return totalAprovadas;
   }
 }.call();
}

/**
 *
 * @param param_Id
 * @return Var
 */

@RequestMapping(method = RequestMethod.GET, value="/CriarId/{param_Id}")
// Descreva esta função...
public static Var CriarId(@PathVariable("param_Id") Var param_Id ) throws Exception {
 return new Callable<Var>() {

   // param
   private Var Id = param_Id;
   // end

   public Var call() throws Exception {
    Id = cronapi.math.Operations.sum(cronapi.logic.Operations.isNullOrEmpty(Id).getObjectAsBoolean() ? Var.valueOf(0) : Id,Var.valueOf(1));
    return Id;
   }
 }.call();
}

/**
 *
 * @param soliFerId
 * @param forcaTrabalhoId
 * @param solicitacaoFerias
 * @return Var
 */

@RequestMapping(method = RequestMethod.GET, value="/GerarHistoricoSolicitacao/{soliFerId}/{forcaTrabalhoId}/{solicitacaoFerias}")
// Descreva esta função...
public static Var GerarHistoricoSolicitacao(@PathVariable("soliFerId") Var soliFerId ,@PathVariable("forcaTrabalhoId") Var forcaTrabalhoId ,@PathVariable("solicitacaoFerias") Var solicitacaoFerias ) throws Exception {
 return new Callable<Var>() {

   private Var historicoAcaoSolicitacao = Var.VAR_NULL;

   public Var call() throws Exception {
    historicoAcaoSolicitacao = cronapi.database.Operations.newEntity(Var.valueOf("SPFT.entity.HistoricoAcaoSolicitacao"),Var.valueOf("id",Var.valueOf(CriarId(cronapi.database.Operations.getField(cronapi.database.Operations.query(Var.valueOf("SPFT.entity.HistoricoAcaoSolicitacao"),Var.valueOf("select MAX(h.id) from HistoricoAcaoSolicitacao h")), Var.valueOf("this[0]"))))),Var.valueOf("solicitacaoFerias",cronapi.database.Operations.newEntity(Var.valueOf("SPFT.entity.SolicitacaoFerias"),Var.valueOf("id",soliFerId))),Var.valueOf("forcaTrabalho",cronapi.database.Operations.newEntity(Var.valueOf("SPFT.entity.ForcaTrabalho"),Var.valueOf("id",forcaTrabalhoId))),Var.valueOf("dataHistorico",cronapi.dateTime.Operations.getNow()),Var.valueOf("justificativa",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("justificativa"))),Var.valueOf("status",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("status"))),Var.valueOf("utilizaAbono",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("utilizaAbono"))),Var.valueOf("adiantaDecimo",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("adiantaDecimo"))),Var.valueOf("dividir",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dividir"))),Var.valueOf("dataPeriodo1Inicio",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo1Inicio"))),Var.valueOf("dataPeriodo1Fim",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo1Fim"))),Var.valueOf("dataPeriodo2Inicio",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo2Inicio"))),Var.valueOf("dataPeriodo2Fim",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo2Fim"))),Var.valueOf("dataPeriodo3Inicio",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo3Inicio"))),Var.valueOf("dataPeriodo3Fim",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo3Fim"))));
    return historicoAcaoSolicitacao;
   }
 }.call();
}

/**
 *
 * @param periodoConcessao
 * @param param_periodoConcessaoId
 * @param forcaTrabalhoId
 * @return Var
 */

@RequestMapping(method = RequestMethod.GET, value="/GerarPeriodoConcessao/{periodoConcessao}/{param_periodoConcessaoId}/{forcaTrabalhoId}")
// Descreva esta função...
public static Var GerarPeriodoConcessao(@PathVariable("periodoConcessao") Var periodoConcessao ,@PathVariable("param_periodoConcessaoId") Var param_periodoConcessaoId ,@PathVariable("forcaTrabalhoId") Var forcaTrabalhoId ) throws Exception {
 return new Callable<Var>() {

   // param
   private Var periodoConcessaoId = param_periodoConcessaoId;
   // end

   public Var call() throws Exception {
    if (cronapi.logic.Operations.isNullOrEmpty(periodoConcessaoId).getObjectAsBoolean()) {
        periodoConcessaoId = Var.valueOf(CriarId(cronapi.database.Operations.getField(cronapi.database.Operations.query(Var.valueOf("SPFT.entity.PeriodoConcessao"),Var.valueOf("select MAX(p.id) from PeriodoConcessao p")), Var.valueOf("this[0]"))));
    }
    cronapi.object.Operations.setObjectField(periodoConcessao, Var.valueOf("id"), periodoConcessaoId);
    cronapi.object.Operations.setObjectField(periodoConcessao, Var.valueOf("forcaTrabalho.id"), forcaTrabalhoId);
    return periodoConcessao;
   }
 }.call();
}

/**
 *
 * @param solicitacaoFerias
 * @param param_soliFerId
 * @param periodoConcessao
 * @param _C3_A9AdminOuGerente
 * @return Var
 */

@RequestMapping(method = RequestMethod.GET, value="/GerarSolicitacaoFerias/{solicitacaoFerias}/{param_soliFerId}/{periodoConcessao}/{_C3_A9AdminOuGerente}")
// Descreva esta função...
public static Var GerarSolicitacaoFerias(@PathVariable("solicitacaoFerias") Var solicitacaoFerias ,@PathVariable("param_soliFerId") Var param_soliFerId ,@PathVariable("periodoConcessao") Var periodoConcessao ,@PathVariable("_C3_A9AdminOuGerente") Var _C3_A9AdminOuGerente ) throws Exception {
 return new Callable<Var>() {

   // param
   private Var soliFerId = param_soliFerId;
   // end

   public Var call() throws Exception {
    if (cronapi.logic.Operations.isNullOrEmpty(soliFerId).getObjectAsBoolean()) {
        soliFerId = Var.valueOf(CriarId(cronapi.database.Operations.getField(cronapi.database.Operations.query(Var.valueOf("SPFT.entity.SolicitacaoFerias"),Var.valueOf("select MAX(s.id) from SolicitacaoFerias s")), Var.valueOf("this[0]"))));
    }
    cronapi.object.Operations.setObjectField(solicitacaoFerias, Var.valueOf("id"), soliFerId);
    cronapi.object.Operations.setObjectField(solicitacaoFerias, Var.valueOf("periodoConcessao"), periodoConcessao);
    cronapi.object.Operations.setObjectField(solicitacaoFerias, Var.valueOf("status"), _C3_A9AdminOuGerente.getObjectAsBoolean() ? Var.valueOf(2) : Var.valueOf(1));
    if (cronapi.logic.Operations.isNullOrEmpty(cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("justificativa"))).negate().getObjectAsBoolean()) {
        cronapi.object.Operations.setObjectField(solicitacaoFerias, Var.valueOf("justificativa"), Var.valueOf(Var.valueOf("Justificativa da solicitação:\n").toString() + cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("justificativa")).toString()));
    }
    return solicitacaoFerias;
   }
 }.call();
}

/**
 *
 * @param param_login
 * @param dataConcessaoInicial
 * @param dataConcessaoFinal
 * @return Var
 */

@RequestMapping(method = RequestMethod.GET, value="/ObterFeriasExistenteDoPeriodoConcessivo/{param_login}/{dataConcessaoInicial}/{dataConcessaoFinal}")
// Descreva esta função...
public static Var ObterFeriasExistenteDoPeriodoConcessivo(@PathVariable("param_login") Var param_login ,@PathVariable("dataConcessaoInicial") Var dataConcessaoInicial ,@PathVariable("dataConcessaoFinal") Var dataConcessaoFinal ) throws Exception {
 return new Callable<Var>() {

   // param
   private Var login = param_login;
   // end
   private Var solicitacaoFerias = Var.VAR_NULL;
   private Var periodoConcessaoCorrente = Var.VAR_NULL;
   private Var periodoConcessaoIdCorrente = Var.VAR_NULL;

   public Var call() throws Exception {
    if (cronapi.logic.Operations.isNullOrEmpty(login).getObjectAsBoolean()) {
        login = cronapi.util.Operations.getCurrentUserName();
    }
    periodoConcessaoCorrente = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.PeriodoConcessao"),Var.valueOf("select p.id from PeriodoConcessao p where p.forcaTrabalho.codigoLogin = :forcaTrabalhoCodigoLogin AND p.dataConcessaoInicial = :dataConcessaoInicial AND p.dataConcessaoFinal = :dataConcessaoFinal"),Var.valueOf("forcaTrabalhoCodigoLogin",login),Var.valueOf("dataConcessaoInicial",dataConcessaoInicial),Var.valueOf("dataConcessaoFinal",dataConcessaoFinal));
    if (cronapi.database.Operations.hasElement(periodoConcessaoCorrente).getObjectAsBoolean()) {
        periodoConcessaoIdCorrente = cronapi.database.Operations.getField(periodoConcessaoCorrente, Var.valueOf("this[0]"));
        solicitacaoFerias = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.SolicitacaoFerias"),Var.valueOf("select s from SolicitacaoFerias s where s.periodoConcessao.id = :periodoConcessaoId"),Var.valueOf("periodoConcessaoId",periodoConcessaoIdCorrente));
    }
    return solicitacaoFerias;
   }
 }.call();
}

/**
 *
 * @param orgao
 * @param status
 * @return Var
 */

@RequestMapping(method = RequestMethod.GET, value="/ObterSolicitacaoFeriasPorOrgaoEStatus/{orgao}/{status}")
// Descreva esta função...
public static Var ObterSolicitacaoFeriasPorOrgaoEStatus(@PathVariable("orgao") Var orgao ,@PathVariable("status") Var status ) throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;
   private Var lista = Var.VAR_NULL;

   public Var call() throws Exception {
    lista = cronapi.list.Operations.newList();
    item = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.SolicitacaoFerias"),Var.valueOf("select s.periodoConcessao.forcaTrabalho.nome as nomeFuncionario, s.periodoConcessao.forcaTrabalho.matricula as matriculaFuncionario, s.id as solicitacaoId, s.justificativa as justificativa, \ns.status as status, \nCASE WHEN (s.status = 1) THEN \'Solicitado\' WHEN (s.status = 2) THEN \'Aprovado\' WHEN (s.status = 3) THEN \'Não Aprovado\' ELSE \'Efetivado\' END as statusDescricao,\ns.utilizaAbono as utilizaAbono, \ns.adiantaDecimo as adiantaDecimo, s.dividir as dividir, s.dataPeriodo1Inicio as dataPeriodo1Inicio, \ns.dataPeriodo1Fim as dataPeriodo1Fim, s.dataPeriodo2Inicio as dataPeriodo2Inicio, s.dataPeriodo2Fim as dataPeriodo2Fim, \ns.dataPeriodo3Inicio as dataPeriodo3Inicio, s.dataPeriodo3Fim as dataPeriodo3Fim, \nCONCAT(extract(day from s.dataPeriodo1Inicio),\'/\', extract(month from s.dataPeriodo1Inicio), \'/\', extract(year from s.dataPeriodo1Inicio),\n\' à \', extract(day from s.dataPeriodo1Fim),\'/\', extract(month from s.dataPeriodo1Fim), \'/\', extract(year from s.dataPeriodo1Fim)),\nCONCAT(extract(day from s.dataPeriodo2Inicio),\'/\', extract(month from s.dataPeriodo2Inicio), \'/\', extract(year from s.dataPeriodo2Inicio),\n\' à \', extract(day from s.dataPeriodo2Fim),\'/\', extract(month from s.dataPeriodo2Fim), \'/\', extract(year from s.dataPeriodo2Fim)),\nCONCAT(extract(day from s.dataPeriodo3Inicio),\'/\', extract(month from s.dataPeriodo3Inicio), \'/\', extract(year from s.dataPeriodo3Inicio),\n\' à \', extract(day from s.dataPeriodo3Fim),\'/\', extract(month from s.dataPeriodo3Fim), \'/\', extract(year from s.dataPeriodo3Fim))\nfrom SolicitacaoFerias s, Orgao o  \nwhere o.codigoForcaTrabalho = s.periodoConcessao.forcaTrabalho.id \nAND (:orgaoId IS NULL or o.id = :orgaoId)   \nAND (:statusId IS NULL or s.status = :statusId)"),Var.valueOf("orgaoId",orgao),Var.valueOf("orgaoId",orgao),Var.valueOf("statusId",status),Var.valueOf("statusId",status));
    while (cronapi.database.Operations.hasElement(item).getObjectAsBoolean()) {
        System.out.println(cronapi.database.Operations.getActiveData(item).getObjectAsString());
        cronapi.database.Operations.next(item);
    } // end while
    return lista;
   }
 }.call();
}

/**
 *
 * @param selectedRows
 * @param justificativa
 * @return Var
 */

@RequestMapping(method = RequestMethod.GET, value="/ReprovarSolicitacaoFerias/{selectedRows}/{justificativa}")
// Descreva esta função...
public static Var ReprovarSolicitacaoFerias(@PathVariable("selectedRows") Var selectedRows ,@PathVariable("justificativa") Var justificativa ) throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;
   private Var solicitacaoFerias = Var.VAR_NULL;
   private Var totalSolicitacao = Var.VAR_NULL;
   private Var totalSolicitacaoReprovada = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var historicoAcaoSolicitacao = Var.VAR_NULL;
   private Var i_start = Var.VAR_NULL;
   private Var i_inc = Var.VAR_NULL;

   public Var call() throws Exception {
    totalSolicitacao = cronapi.list.Operations.size(selectedRows);
    totalSolicitacaoReprovada = Var.valueOf(0);
    i_start = Var.valueOf(1);
    i_inc = Var.valueOf(1);
    if (i_start.greaterThan(totalSolicitacao)) {
        i_inc.multiply(-1);
    }
    for (i = Var.valueOf(i_start);
        i_inc.getObjectAsInt() >= 0 ? i.getObjectAsLong() <= totalSolicitacao.getObjectAsLong() : i.getObjectAsLong()  >= totalSolicitacao.getObjectAsLong();
    i.inc(i_inc))  {
        item = cronapi.list.Operations.get(selectedRows, i);
        solicitacaoFerias = cronapi.list.Operations.getFirst((cronapi.database.Operations.query(Var.valueOf("SPFT.entity.SolicitacaoFerias"),Var.valueOf("select s from SolicitacaoFerias s where s.id = :id"),Var.valueOf("id",cronapi.object.Operations.getObjectField(item, Var.valueOf("solicitacaoId"))))));
        if (Var.valueOf(Var.valueOf(cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("status")).equals(Var.valueOf(1))).getObjectAsBoolean() || Var.valueOf(cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("status")).equals(Var.valueOf(4))).getObjectAsBoolean()).getObjectAsBoolean()) {
            cronapi.object.Operations.setObjectField(solicitacaoFerias, Var.valueOf("status"), Var.valueOf(3));
            cronapi.object.Operations.setObjectField(solicitacaoFerias, Var.valueOf("justificativa"), Var.valueOf(cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("justificativa")).toString() + Var.valueOf("\nJustificativa da reprovação:\n").toString() + justificativa.toString()));
            cronapi.database.Operations.update(Var.valueOf("SPFT.entity.SolicitacaoFerias"),solicitacaoFerias);
            historicoAcaoSolicitacao = Var.valueOf(GerarHistoricoSolicitacao(cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("id")), cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("periodoConcessao.forcaTrabalho.id")), solicitacaoFerias));
            cronapi.database.Operations.insert(Var.valueOf("SPFT.entity.HistoricoAcaoSolicitacao"),historicoAcaoSolicitacao);
            totalSolicitacaoReprovada = cronapi.math.Operations.sum(totalSolicitacaoReprovada,Var.valueOf(1));
        }
    } // end for
    System.out.println(selectedRows.getObjectAsString());
    return totalSolicitacaoReprovada;
   }
 }.call();
}

/**
 *
 * @param param_solicitacaoFerias
 * @return Var
 */

@RequestMapping(method = RequestMethod.GET, value="/SalvarSolicitacaoFerias/{param_solicitacaoFerias}")
// Descreva esta função...
public static Var SalvarSolicitacaoFerias(@PathVariable("param_solicitacaoFerias") Var param_solicitacaoFerias ) throws Exception {
 return new Callable<Var>() {

   // param
   private Var solicitacaoFerias = param_solicitacaoFerias;
   // end
   private Var item = Var.VAR_NULL;
   private Var periodoConcessao = Var.VAR_NULL;
   private Var forcaTrabalho = Var.VAR_NULL;
   private Var login = Var.VAR_NULL;
   private Var _C3_A9AdminOuGerente = Var.VAR_NULL;
   private Var forcaTrabalhoId = Var.VAR_NULL;
   private Var periodoConcessaoCorrente = Var.VAR_NULL;
   private Var periodoConcessaoIdCorrente = Var.VAR_NULL;
   private Var solicitacaoFeriasIdCorrente = Var.VAR_NULL;

   public Var call() throws Exception {
    item = Var.valueOf("Solicitação armazenada com sucesso!");
    if (cronapi.logic.Operations.isNullOrEmpty(solicitacaoFerias).getObjectAsBoolean()) {
        item = Var.valueOf("Erro ao armazenar a solicitação");
    } else {
        periodoConcessao = cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("periodoConcessao"));
        forcaTrabalho = cronapi.object.Operations.getObjectField(periodoConcessao, Var.valueOf("forcaTrabalho"));
        login = cronapi.object.Operations.getObjectField(forcaTrabalho, Var.valueOf("codigoLogin"));
        if (cronapi.logic.Operations.isNullOrEmpty(login).getObjectAsBoolean()) {
            login = cronapi.util.Operations.getCurrentUserName();
        }
        forcaTrabalho = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.ForcaTrabalho"),Var.valueOf("select f from ForcaTrabalho f where f.codigoLogin = :codigoLogin"),Var.valueOf("codigoLogin",login));
        _C3_A9AdminOuGerente = cronapi.database.Operations.hasElement(cronapi.database.Operations.query(Var.valueOf("app.entity.Role"),Var.valueOf("select r from Role r where r.user.login = :userLogin AND (r.id = \'Manager\' OR r.id = \'Administrators\' )"),Var.valueOf("userLogin",cronapi.util.Operations.getCurrentUserName())));
        forcaTrabalhoId = cronapi.database.Operations.getField(forcaTrabalho, Var.valueOf("this[0].id"));
        periodoConcessaoCorrente = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.PeriodoConcessao"),Var.valueOf("select p.id from PeriodoConcessao p where p.forcaTrabalho.codigoLogin = :forcaTrabalhoCodigoLogin AND p.dataConcessaoInicial = :dataConcessaoInicial AND p.dataConcessaoFinal = :dataConcessaoFinal"),Var.valueOf("forcaTrabalhoCodigoLogin",login),Var.valueOf("dataConcessaoInicial",cronapi.object.Operations.getObjectField(periodoConcessao, Var.valueOf("dataConcessaoInicial"))),Var.valueOf("dataConcessaoFinal",cronapi.object.Operations.getObjectField(periodoConcessao, Var.valueOf("dataConcessaoFinal"))));
        if (cronapi.database.Operations.hasElement(periodoConcessaoCorrente).getObjectAsBoolean()) {
            periodoConcessaoIdCorrente = cronapi.database.Operations.getField(periodoConcessaoCorrente, Var.valueOf("this[0]"));
            solicitacaoFeriasIdCorrente = cronapi.database.Operations.getField(cronapi.database.Operations.query(Var.valueOf("SPFT.entity.SolicitacaoFerias"),Var.valueOf("select s.id from SolicitacaoFerias s where s.periodoConcessao.id = :periodoConcessaoId"),Var.valueOf("periodoConcessaoId",periodoConcessaoIdCorrente)), Var.valueOf("this[0]"));
            cronapi.database.Operations.update(Var.valueOf("SPFT.entity.PeriodoConcessao"),Var.valueOf(GerarPeriodoConcessao(periodoConcessao, periodoConcessaoIdCorrente, forcaTrabalhoId)));
            cronapi.database.Operations.update(Var.valueOf("SPFT.entity.SolicitacaoFerias"),Var.valueOf(GerarSolicitacaoFerias(solicitacaoFerias, solicitacaoFeriasIdCorrente, periodoConcessao, _C3_A9AdminOuGerente)));
            cronapi.database.Operations.insert(Var.valueOf("SPFT.entity.HistoricoAcaoSolicitacao"),Var.valueOf(GerarHistoricoSolicitacao(solicitacaoFeriasIdCorrente, forcaTrabalhoId, solicitacaoFerias)));
        } else {
            cronapi.database.Operations.insert(Var.valueOf("SPFT.entity.PeriodoConcessao"),Var.valueOf(GerarPeriodoConcessao(periodoConcessao, Var.VAR_NULL, forcaTrabalhoId)));
            solicitacaoFerias = Var.valueOf(GerarSolicitacaoFerias(solicitacaoFerias, Var.VAR_NULL, periodoConcessao, _C3_A9AdminOuGerente));
            cronapi.database.Operations.insert(Var.valueOf("SPFT.entity.SolicitacaoFerias"),solicitacaoFerias);
            cronapi.database.Operations.insert(Var.valueOf("SPFT.entity.HistoricoAcaoSolicitacao"),Var.valueOf(GerarHistoricoSolicitacao(cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("id")), forcaTrabalhoId, solicitacaoFerias)));
        }
    }
    return item;
   }
 }.call();
}

}

