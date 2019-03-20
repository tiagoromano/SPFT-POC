package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Ferias {

public static final int TIMEOUT = 300;

/**
 *
 * @param param_login
 * @return Var
 */
// Ferias
public static Var ObterPeriodosConcessivos(Var param_login) throws Exception {
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
// Descreva esta função...
public static Var CriarId(Var param_Id) throws Exception {
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
 * @param solicitacaoFeriasId
 * @param forcaTrabalhoId
 * @param solicitacaoFerias
 * @return Var
 */
// Descreva esta função...
public static Var GerarHistoricoSolicitacao(Var solicitacaoFeriasId, Var forcaTrabalhoId, Var solicitacaoFerias) throws Exception {
 return new Callable<Var>() {

   private Var historicoAcaoSolicitacao = Var.VAR_NULL;

   public Var call() throws Exception {
    historicoAcaoSolicitacao = cronapi.database.Operations.newEntity(Var.valueOf("SPFT.entity.HistoricoAcaoSolicitacao"),Var.valueOf("id",Var.valueOf(CriarId(cronapi.database.Operations.getField(cronapi.database.Operations.query(Var.valueOf("SPFT.entity.HistoricoAcaoSolicitacao"),Var.valueOf("select MAX(h.id) from HistoricoAcaoSolicitacao h")), Var.valueOf("this[0]"))))),Var.valueOf("solicitacaoFerias<SPFT.entity.SolicitacaoFerias>",cronapi.database.Operations.newEntity(Var.valueOf("SPFT.entity.SolicitacaoFerias"),Var.valueOf("id",solicitacaoFeriasId))),Var.valueOf("forcaTrabalho",cronapi.database.Operations.newEntity(Var.valueOf("SPFT.entity.ForcaTrabalho"),Var.valueOf("id",forcaTrabalhoId))),Var.valueOf("dataHistorico",cronapi.dateTime.Operations.getNow()),Var.valueOf("justificativa",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("justificativa"))),Var.valueOf("status",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("status"))),Var.valueOf("utilizaAbono",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("utilizaAbono"))),Var.valueOf("adiantaDecimo",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("adiantaDecimo"))),Var.valueOf("dividir",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dividir"))),Var.valueOf("dataPeriodo1Inicio",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo1Inicio"))),Var.valueOf("dataPeriodo1Fim",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo1Fim"))),Var.valueOf("dataPeriodo2Inicio",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo2Inicio"))),Var.valueOf("dataPeriodo2Fim",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo2Fim"))),Var.valueOf("dataPeriodo3Inicio",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo3Inicio"))),Var.valueOf("dataPeriodo3Fim",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo3Fim"))));
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
// Descreva esta função...
public static Var GerarPeriodoConcessao(Var periodoConcessao, Var param_periodoConcessaoId, Var forcaTrabalhoId) throws Exception {
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
 * @param param_solicitacaoFeriasId
 * @param periodoConcessao
 * @param _C3_A9AdminOuGerente
 * @return Var
 */
// Descreva esta função...
public static Var GerarSolicitacaoFerias(Var solicitacaoFerias, Var param_solicitacaoFeriasId, Var periodoConcessao, Var _C3_A9AdminOuGerente) throws Exception {
 return new Callable<Var>() {

   // param
   private Var solicitacaoFeriasId = param_solicitacaoFeriasId;
   // end

   public Var call() throws Exception {
    if (cronapi.logic.Operations.isNullOrEmpty(solicitacaoFeriasId).getObjectAsBoolean()) {
        solicitacaoFeriasId = Var.valueOf(CriarId(cronapi.database.Operations.getField(cronapi.database.Operations.query(Var.valueOf("SPFT.entity.SolicitacaoFerias"),Var.valueOf("select MAX(s.id) from SolicitacaoFerias s")), Var.valueOf("this[0]"))));
    }
    cronapi.object.Operations.setObjectField(solicitacaoFerias, Var.valueOf("id"), solicitacaoFeriasId);
    cronapi.object.Operations.setObjectField(solicitacaoFerias, Var.valueOf("periodoConcessao"), periodoConcessao);
    cronapi.object.Operations.setObjectField(solicitacaoFerias, Var.valueOf("status"), _C3_A9AdminOuGerente.getObjectAsBoolean() ? Var.valueOf(2) : Var.valueOf(1));
    return solicitacaoFerias;
   }
 }.call();
}

/**
 *
 * @param solicitacaoFerias
 * @return Var
 */
// Descreva esta função...
public static Var SalvarSolicitacaoFerias(Var solicitacaoFerias) throws Exception {
 return new Callable<Var>() {

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
            cronapi.database.Operations.update(Var.valueOf("SPFT.entity.PeriodoConcessao"),Var.valueOf(GerarPeriodoConcessao(periodoConcessao, periodoConcessaoIdCorrente, forcaTrabalhoId)));
            System.out.println(Var.valueOf("periodoConcessao").getObjectAsString());
            System.out.println(periodoConcessao.getObjectAsString());
            cronapi.database.Operations.update(Var.valueOf("SPFT.entity.SolicitacaoFerias"),Var.valueOf(GerarSolicitacaoFerias(solicitacaoFerias, solicitacaoFeriasIdCorrente, periodoConcessao, _C3_A9AdminOuGerente)));
            System.out.println(Var.valueOf("SolicitacaoFerias").getObjectAsString());
            System.out.println(solicitacaoFerias.getObjectAsString());
            cronapi.database.Operations.insert(Var.valueOf("SPFT.entity.HistoricoAcaoSolicitacao"),Var.valueOf(GerarHistoricoSolicitacao(solicitacaoFeriasIdCorrente, forcaTrabalhoId, solicitacaoFerias)));
            System.out.println(Var.valueOf("HistoricoAcaoSolicitacao").getObjectAsString());
        } else {
            System.out.println(Var.valueOf("insere").getObjectAsString());
            cronapi.database.Operations.insert(Var.valueOf("SPFT.entity.PeriodoConcessao"),Var.valueOf(GerarPeriodoConcessao(periodoConcessao, Var.VAR_NULL, forcaTrabalhoId)));
            System.out.println(periodoConcessao.getObjectAsString());
            cronapi.database.Operations.insert(Var.valueOf("SPFT.entity.SolicitacaoFerias"),Var.valueOf(GerarSolicitacaoFerias(solicitacaoFerias, Var.VAR_NULL, periodoConcessao, _C3_A9AdminOuGerente)));
            System.out.println(solicitacaoFerias.getObjectAsString());
            cronapi.database.Operations.insert(Var.valueOf("SPFT.entity.HistoricoAcaoSolicitacao"),Var.valueOf(GerarHistoricoSolicitacao(cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("id")), forcaTrabalhoId, solicitacaoFerias)));
        }
    }
    return item;
   }
 }.call();
}

}

