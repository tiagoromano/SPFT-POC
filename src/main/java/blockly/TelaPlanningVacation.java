package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class TelaPlanningVacation {

public static final int TIMEOUT = 300;

/**
 *
 * @param param_login
 * @return Var
 */
// TelaRequestVacation
public static Var AoEntrar(Var param_login) throws Exception {
 return new Callable<Var>() {

   // param
   private Var login = param_login;
   // end
   private Var usuarioBIDT = Var.VAR_NULL;

   public Var call() throws Exception {
    if (cronapi.logic.Operations.isNullOrEmpty(login).getObjectAsBoolean()) {
        login = cronapi.util.Operations.getCurrentUserName();
    }
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
 */
// Descreva esta função...
public static void AlterarDataFinal() throws Exception {
  new Callable<Var>() {

   private Var dataInicial = Var.VAR_NULL;

   public Var call() throws Exception {
    dataInicial = cronapi.conversion.Operations.stringToDate(cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.periodoDataInicial")), Var.valueOf("yyy-MM-dd"));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("vars.periodoDataFinal"), cronapi.dateTime.Operations.incYear(dataInicial, Var.valueOf(1)));
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 */
// Descreva esta função...
public static void ObterDataAtual() throws Exception {
  new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("vars.periodoDataInicial"), cronapi.dateTime.Operations.getNowNoHour());
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 */
// Descreva esta função...
public static void ObterDataFinal() throws Exception {
  new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("vars.periodoDataFinal"), cronapi.dateTime.Operations.incYear(cronapi.dateTime.Operations.getNowNoHour(), Var.valueOf(1)));
   return Var.VAR_NULL;
   }
 }.call();
}

}

