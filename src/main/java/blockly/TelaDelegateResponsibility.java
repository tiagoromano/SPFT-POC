package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class TelaDelegateResponsibility {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// TelaRequestVacation
public static Var AoEntrar() throws Exception {
 return new Callable<Var>() {

   private Var login = Var.VAR_NULL;
   private Var usuarioBIDT = Var.VAR_NULL;

   public Var call() throws Exception {
    login = cronapi.util.Operations.getCurrentUserName();
    usuarioBIDT = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.ForcaTrabalho"),Var.valueOf("select f from ForcaTrabalho f where f.codigoLogin = :codigoLogin"),Var.valueOf("codigoLogin",login));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeContent"), Var.valueOf("valorMatricula"), cronapi.database.Operations.getField(usuarioBIDT, Var.valueOf("this[0].matricula")));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeContent"), Var.valueOf("valorChave"), cronapi.database.Operations.getField(usuarioBIDT, Var.valueOf("this[0].codigoLogin")));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeContent"), Var.valueOf("valorEmpregado"), cronapi.database.Operations.getField(usuarioBIDT, Var.valueOf("this[0].nome")));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeContent"), Var.valueOf("valorGerencia"), cronapi.database.Operations.getField(usuarioBIDT, Var.valueOf("this[0].orgao.nome")));
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param chave
 * @return Var
 */
// Descreva esta função...
public static Var ConsultarFuncionarioPelaChave(Var chave) throws Exception {
 return new Callable<Var>() {

   private Var funcionario = Var.VAR_NULL;

   public Var call() throws Exception {
    funcionario = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.ForcaTrabalho"),Var.valueOf("select f from ForcaTrabalho f where f.codigoLogin = :codigoLogin"),Var.valueOf("codigoLogin",chave));
    if (cronapi.database.Operations.hasElement(funcionario).getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("vars.nome"), cronapi.database.Operations.getField(funcionario, Var.valueOf("this[0].nome")));
    } else {
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("vars.nome"), Var.VAR_NULL);
    }
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param delegacao
 * @return Var
 */
// Descreva esta função...
public static Var ExcluirDelegacao(Var delegacao) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.database.Operations.execute(Var.valueOf("SPFT.entity.Delegacao"), Var.valueOf("update Delegacao set status = 0 where id = :id"),Var.valueOf("id",cronapi.object.Operations.getObjectField(delegacao, Var.valueOf("id"))));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"), Var.valueOf("ObterGerenciasDelegadasPeloUsuarioLogado"), Var.valueOf("true"));
    cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"), Var.valueOf("Delegação excluida com sucesso!"));
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param chave
 * @param tipoDelegacao
 * @param orgaoLista
 * @return Var
 */
// Descreva esta função...
public static Var IncluirDelegacao(Var chave, Var tipoDelegacao, Var orgaoLista) throws Exception {
 return new Callable<Var>() {

   private Var totalOrgaoDelegado = Var.VAR_NULL;
   private Var totalOrgao = Var.VAR_NULL;
   private Var funcionario = Var.VAR_NULL;
   private Var usuarioLogado = Var.VAR_NULL;
   private Var delegacaoIdCorrente = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var orgao = Var.VAR_NULL;
   private Var i_start = Var.VAR_NULL;
   private Var i_inc = Var.VAR_NULL;

   public Var call() throws Exception {
    totalOrgaoDelegado = Var.valueOf(0);
    totalOrgao = cronapi.list.Operations.size(orgaoLista);
    funcionario = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.ForcaTrabalho"),Var.valueOf("select f from ForcaTrabalho f where f.codigoLogin = :codigoLogin"),Var.valueOf("codigoLogin",chave));
    usuarioLogado = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.ForcaTrabalho"),Var.valueOf("select f from ForcaTrabalho f where f.codigoLogin = :codigoLogin"),Var.valueOf("codigoLogin",cronapi.util.Operations.getCurrentUserName()));
    delegacaoIdCorrente = blockly.Util.CriarId(cronapi.database.Operations.getField(cronapi.database.Operations.query(Var.valueOf("SPFT.entity.Delegacao"),Var.valueOf("select MAX(d.id) from Delegacao d")), Var.valueOf("this[0]")));
    i_start = Var.valueOf(1);
    i_inc = Var.valueOf(1);
    if (i_start.greaterThan(totalOrgao)) {
        i_inc.multiply(-1);
    }
    for (i = Var.valueOf(i_start);
        i_inc.getObjectAsInt() >= 0 ? i.getObjectAsLong() <= totalOrgao.getObjectAsLong() : i.getObjectAsLong()  >= totalOrgao.getObjectAsLong();
    i.inc(i_inc))  {
        orgao = cronapi.list.Operations.get(orgaoLista, i);
        System.out.println(orgao.getObjectAsString());
        if (cronapi.database.Operations.hasElement(cronapi.database.Operations.query(Var.valueOf("SPFT.entity.Delegacao"),Var.valueOf("select d from Delegacao d where d.forcaTrabalhoDelegado.id = :forcaTrabalhoDelegadoId AND d.orgao.id = :orgaoId AND d.status = 1"),Var.valueOf("forcaTrabalhoDelegadoId",cronapi.database.Operations.getField(funcionario, Var.valueOf("this[0].id"))),Var.valueOf("orgaoId",cronapi.object.Operations.getObjectField(orgao, Var.valueOf("id"))))).negate().getObjectAsBoolean()) {
            cronapi.database.Operations.insert(Var.valueOf("SPFT.entity.Delegacao"),cronapi.database.Operations.newEntity(Var.valueOf("SPFT.entity.Delegacao"),Var.valueOf("id",delegacaoIdCorrente),Var.valueOf("orgao",orgao),Var.valueOf("status",Var.valueOf(1)),Var.valueOf("dataCriacao",cronapi.dateTime.Operations.getNow()),Var.valueOf("dataInativo",Var.VAR_NULL),Var.valueOf("forcaTrabalhoGerente",cronapi.database.Operations.newEntity(Var.valueOf("SPFT.entity.ForcaTrabalho"),Var.valueOf("id",cronapi.database.Operations.getField(usuarioLogado, Var.valueOf("this[0].id"))))),Var.valueOf("forcaTrabalhoDelegado",cronapi.database.Operations.newEntity(Var.valueOf("SPFT.entity.ForcaTrabalho"),Var.valueOf("id",cronapi.database.Operations.getField(funcionario, Var.valueOf("this[0].id"))))),Var.valueOf("forcaTrabalhoDes",Var.VAR_NULL),Var.valueOf("tipoDelegacao",Var.valueOf(tipoDelegacao.equals(Var.valueOf("total"))).getObjectAsBoolean() ? Var.valueOf(1) : Var.valueOf(0))));
            delegacaoIdCorrente = cronapi.math.Operations.sum(delegacaoIdCorrente,Var.valueOf(1));
            totalOrgaoDelegado = cronapi.math.Operations.sum(totalOrgaoDelegado,Var.valueOf(1));
        }
    } // end for
    if (Var.valueOf(totalOrgaoDelegado.compareTo(Var.valueOf(0)) > 0).getObjectAsBoolean()) {
        if (Var.valueOf(Var.valueOf(tipoDelegacao.equals(Var.valueOf("total"))).getObjectAsBoolean() && cronapi.database.Operations.hasElement(cronapi.database.Operations.query(Var.valueOf("app.entity.Role"),Var.valueOf("select r from Role r where r.user.id = :userId AND r.id = \'Manager\'"),Var.valueOf("userId",cronapi.database.Operations.getField(usuarioLogado, Var.valueOf("this[0].id"))))).negate().getObjectAsBoolean()).getObjectAsBoolean()) {
            cronapi.database.Operations.insert(Var.valueOf("app.entity.Role"),cronapi.database.Operations.newEntity(Var.valueOf("app.entity.Role"),Var.valueOf("id",Var.valueOf("Manager")),Var.valueOf("user",cronapi.database.Operations.newEntity(Var.valueOf("app.entity.User"),Var.valueOf("id",cronapi.database.Operations.getField(usuarioLogado, Var.valueOf("this[0].id")))))));
        }
    }
    return totalOrgaoDelegado;
   }
 }.call();
}

}

