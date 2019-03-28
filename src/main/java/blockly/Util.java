package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Util {

public static final int TIMEOUT = 300;

/**
 *
 * @param para
 * @param assunto
 * @param corpo
 * @return Var
 */
// Util
public static Var EnviarEmail(Var para, Var assunto, Var corpo) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.email.Operations.sendEmail(Var.valueOf("testeemailcronos@gmail.com"), para, Var.VAR_NULL, Var.VAR_NULL, assunto, corpo, Var.VAR_NULL, Var.VAR_NULL, Var.valueOf("smtp.gmail.com"), Var.valueOf("587"), Var.valueOf("testeemailcronos@gmail.com"), Var.valueOf("testeemailcronos%%"), Var.valueOf("TLS"));
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param delegacaoId
 * @param acao
 * @return Var
 */
// Descreva esta função...
public static Var AdicionarHistoricoDelegacao(Var delegacaoId, Var acao) throws Exception {
 return new Callable<Var>() {

   private Var delegacao = Var.VAR_NULL;
   private Var conteudo = Var.VAR_NULL;

   public Var call() throws Exception {
    delegacao = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.Delegacao"),Var.valueOf("select d from Delegacao d where d.id = :id"),Var.valueOf("id",delegacaoId));
    conteudo = Var.valueOf(cronapi.util.Operations.getCurrentUserName().toString() + Var.valueOf(" ").toString() + cronapi.database.Operations.getField(delegacao, Var.valueOf("this[0].forcaTrabalhoGerente.nome")).toString() + Var.valueOf(" ").toString() + acao.toString() + Var.valueOf(" ").toString() + cronapi.database.Operations.getField(delegacao, Var.valueOf("this[0].forcaTrabalhoDelegado.codigoLogin")).toString() + Var.valueOf(" ").toString() + cronapi.database.Operations.getField(delegacao, Var.valueOf("this[0].forcaTrabalhoDelegado.nome")).toString() + Var.valueOf(" ").toString() + cronapi.database.Operations.getField(delegacao, Var.valueOf("this[0].orgao.nome")).toString());
    cronapi.database.Operations.insert(Var.valueOf("app.entity.Historico"),cronapi.database.Operations.newEntity(Var.valueOf("app.entity.Historico"),Var.valueOf("tabela",Var.valueOf("DELEGACAO")),Var.valueOf("idTabela",delegacaoId),Var.valueOf("descricao",conteudo),Var.valueOf("dataIn",cronapi.dateTime.Operations.getNow()),Var.valueOf("forcaTrabalhoChaveAcao",cronapi.util.Operations.getCurrentUserName())));
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param descricao
 * @param solicitacaoFerias
 * @return Var
 */
// Descreva esta função...
public static Var AdicionarHistoricoSolicitacao(Var descricao, Var solicitacaoFerias) throws Exception {
 return new Callable<Var>() {

   private Var conteudo = Var.VAR_NULL;
   private Var usuario = Var.VAR_NULL;
   private Var usuarioFerias = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    usuario = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.ForcaTrabalho"),Var.valueOf("select f from ForcaTrabalho f where f.codigoLogin = :codigoLogin"),Var.valueOf("codigoLogin",cronapi.util.Operations.getCurrentUserName()));
    System.out.println(usuario.getObjectAsString());
    usuarioFerias = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.SolicitacaoFerias"),Var.valueOf("select s.periodoConcessao.forcaTrabalho from SolicitacaoFerias s where s.id = :id"),Var.valueOf("id",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("id"))));
    System.out.println(usuarioFerias.getObjectAsString());
    conteudo = Var.valueOf(cronapi.util.Operations.getCurrentUserName().toString() + Var.valueOf(" ").toString() + descricao.toString() + Var.valueOf(" ").toString() + cronapi.database.Operations.getField(usuarioFerias, Var.valueOf("matricula")).toString() + Var.valueOf(" ").toString() + cronapi.database.Operations.getField(usuarioFerias, Var.valueOf("nome")).toString());
    System.out.println(conteudo.getObjectAsString());
    if (cronapi.logic.Operations.isNullOrEmpty(cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo1Inicio"))).negate().getObjectAsBoolean()) {
        conteudo = Var.valueOf(conteudo.toString() + Var.valueOf(" Período 1: ").toString() + cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo1Inicio")).toString() + Var.valueOf(" à ").toString() + cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo1Fim")).toString());
    }
    if (cronapi.logic.Operations.isNullOrEmpty(cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo2Inicio"))).negate().getObjectAsBoolean()) {
        conteudo = Var.valueOf(conteudo.toString() + Var.valueOf(" Período 2: ").toString() + cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo2Inicio")).toString() + Var.valueOf(" à ").toString() + cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo2Fim")).toString());
    }
    if (cronapi.logic.Operations.isNullOrEmpty(cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo3Inicio"))).negate().getObjectAsBoolean()) {
        conteudo = Var.valueOf(conteudo.toString() + Var.valueOf(" Período 3: ").toString() + cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo3Inicio")).toString() + Var.valueOf(" à ").toString() + cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("dataPeriodo3Fim")).toString());
    }
    item = cronapi.database.Operations.newEntity(Var.valueOf("app.entity.Historico"),Var.valueOf("tabela",Var.valueOf("SOLICITACAO_FERIAS")),Var.valueOf("idTabela",cronapi.object.Operations.getObjectField(solicitacaoFerias, Var.valueOf("id"))),Var.valueOf("descricao",conteudo),Var.valueOf("dataIn",cronapi.dateTime.Operations.getNow()),Var.valueOf("forcaTrabalhoChaveAcao",cronapi.util.Operations.getCurrentUserName()));
    cronapi.database.Operations.insert(Var.valueOf("app.entity.Historico"),item);
    System.out.println(conteudo.getObjectAsString());
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param param_id2
 * @return Var
 */
// Descreva esta função...
public static Var CriarId(Var param_id2) throws Exception {
 return new Callable<Var>() {

   // param
   private Var id2 = param_id2;
   // end

   public Var call() throws Exception {
    id2 = cronapi.math.Operations.sum(cronapi.logic.Operations.isNullOrEmpty(id2).getObjectAsBoolean() ? Var.valueOf(0) : id2,Var.valueOf(1));
    return id2;
   }
 }.call();
}

}

