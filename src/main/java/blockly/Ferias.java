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
@RequestMapping(value = "/api/rest/main/Captacao")
@CronapiMetaData(type = "blockly")
@CronappSecurity
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
    xmlPeriodoConcessivoSAP = cronapi.xml.Operations.xmltoJson(Var.valueOf("<DocumentElement>\n	<Periodos>\n		<Matricula>6188</Matricula>\n		<PeriodoInicial>01-01-2019</PeriodoInicial>\n		<PeriodoFinal>30-06-2019</PeriodoFinal>		\n	</Periodos>\n	<Periodos>\n		<Matricula>6188</Matricula>\n		<PeriodoInicial>01-07-2019</PeriodoInicial>\n		<PeriodoFinal>31-12-2019</PeriodoFinal>		\n	</Periodos>\n	\n</DocumentElement>"));
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
    System.out.println(Var.valueOf("solicitacaoFeriasId").getObjectAsString());
    System.out.println(soliFerId.getObjectAsString());
    System.out.println(Var.valueOf("HistoricoAcaoSolicitacao").getObjectAsString());
    System.out.println(historicoAcaoSolicitacao.getObjectAsString());
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

   public Var call() throws Exception {
    item = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.SolicitacaoFerias"),Var.valueOf("select s.periodoConcessao.forcaTrabalho.nome as nomeFuncionario, s.periodoConcessao.forcaTrabalho.matricula as matriculaFuncionario, s.id as solicitacaoId, s.justificativa as justificativa, \ns.status as status, \nCASE WHEN (s.status = 1) THEN \'Solicitado\' WHEN (s.status = 2) THEN \'Aprovado\' WHEN (s.status = 3) THEN \'Não Aprovado\' ELSE \'Efetivado\' END as statusDescricao,\ns.utilizaAbono as utilizaAbono, \ns.adiantaDecimo as adiantaDecimo, s.dividir as dividir, s.dataPeriodo1Inicio as dataPeriodo1Inicio, \ns.dataPeriodo1Fim as dataPeriodo1Fim, s.dataPeriodo2Inicio as dataPeriodo2Inicio, s.dataPeriodo2Fim as dataPeriodo2Fim, \ns.dataPeriodo3Inicio as dataPeriodo3Inicio, s.dataPeriodo3Fim as dataPeriodo3Fim, \nCONCAT(extract(day from s.dataPeriodo1Inicio),\'/\', extract(month from s.dataPeriodo1Inicio), \'/\', extract(year from s.dataPeriodo1Inicio),\n\' à \', extract(day from s.dataPeriodo1Fim),\'/\', extract(month from s.dataPeriodo1Fim), \'/\', extract(year from s.dataPeriodo1Fim)),\nCONCAT(extract(day from s.dataPeriodo2Inicio),\'/\', extract(month from s.dataPeriodo2Inicio), \'/\', extract(year from s.dataPeriodo2Inicio),\n\' à \', extract(day from s.dataPeriodo2Fim),\'/\', extract(month from s.dataPeriodo2Fim), \'/\', extract(year from s.dataPeriodo2Fim)),\nCONCAT(extract(day from s.dataPeriodo3Inicio),\'/\', extract(month from s.dataPeriodo3Inicio), \'/\', extract(year from s.dataPeriodo3Inicio),\n\' à \', extract(day from s.dataPeriodo3Fim),\'/\', extract(month from s.dataPeriodo3Fim), \'/\', extract(year from s.dataPeriodo3Fim))\nfrom SolicitacaoFerias s, Orgao o  \nwhere o.codigoForcaTrabalho = s.periodoConcessao.forcaTrabalho.id \nAND (:orgaoId IS NULL or o.id = :orgaoId)   \nAND (:statusId IS NULL or s.status = :statusId)"),Var.valueOf("orgaoId",orgao),Var.valueOf("orgaoId",orgao),Var.valueOf("statusId",status),Var.valueOf("statusId",status));
    return item;
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
            System.out.println(Var.valueOf("atualiza").getObjectAsString());
            periodoConcessaoIdCorrente = cronapi.database.Operations.getField(periodoConcessaoCorrente, Var.valueOf("this[0]"));
            solicitacaoFeriasIdCorrente = cronapi.database.Operations.getField(cronapi.database.Operations.query(Var.valueOf("SPFT.entity.SolicitacaoFerias"),Var.valueOf("select s.id from SolicitacaoFerias s where s.periodoConcessao.id = :periodoConcessaoId"),Var.valueOf("periodoConcessaoId",periodoConcessaoIdCorrente)), Var.valueOf("this[0]"));
            System.out.println(Var.valueOf("periodoConcessao").getObjectAsString());
            System.out.println(periodoConcessao.getObjectAsString());
            cronapi.database.Operations.update(Var.valueOf("SPFT.entity.PeriodoConcessao"),Var.valueOf(GerarPeriodoConcessao(periodoConcessao, periodoConcessaoIdCorrente, forcaTrabalhoId)));
            System.out.println(Var.valueOf("SolicitacaoFerias").getObjectAsString());
            System.out.println(solicitacaoFerias.getObjectAsString());
            cronapi.database.Operations.update(Var.valueOf("SPFT.entity.SolicitacaoFerias"),Var.valueOf(GerarSolicitacaoFerias(Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL, _C3_A9AdminOuGerente)));
            cronapi.database.Operations.insert(Var.valueOf("SPFT.entity.HistoricoAcaoSolicitacao"),Var.valueOf(GerarHistoricoSolicitacao(solicitacaoFeriasIdCorrente, forcaTrabalhoId, solicitacaoFerias)));
        } else {
            System.out.println(Var.valueOf("insere").getObjectAsString());
            System.out.println(Var.valueOf("PeriodoConcessao").getObjectAsString());
            System.out.println(periodoConcessao.getObjectAsString());
            cronapi.database.Operations.insert(Var.valueOf("SPFT.entity.PeriodoConcessao"),Var.valueOf(GerarPeriodoConcessao(periodoConcessao, Var.VAR_NULL, forcaTrabalhoId)));
            System.out.println(Var.valueOf("SolicitacaoFerias").getObjectAsString());
            System.out.println(solicitacaoFerias.getObjectAsString());
            solicitacaoFerias = Var.valueOf(GerarSolicitacaoFerias(Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL, _C3_A9AdminOuGerente));
            cronapi.database.Operations.insert(Var.valueOf("SPFT.entity.SolicitacaoFerias"),solicitacaoFerias);
            cronapi.database.Operations.insert(Var.valueOf("SPFT.entity.HistoricoAcaoSolicitacao"),Var.valueOf(GerarHistoricoSolicitacao(cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("id")), forcaTrabalhoId, solicitacaoFerias)));
        }
    }
    return item;
   }
 }.call();
}

}

