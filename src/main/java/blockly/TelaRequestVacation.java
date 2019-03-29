package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class TelaRequestVacation {

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
 *
 * @param param_login
 * @param periodo
 * @return Var
 */
// Descreva esta função...
public static Var SelecionarPeriodoConcessivo(Var param_login, Var periodo) throws Exception {
 return new Callable<Var>() {

   // param
   private Var login = param_login;
   // end

   public Var call() throws Exception {
    if (cronapi.logic.Operations.isNullOrEmpty(login).getObjectAsBoolean()) {
        login = cronapi.util.Operations.getCurrentUserName();
    }
    if (Var.valueOf(cronapi.object.Operations.getObjectField(periodo, Var.valueOf("status")).equals(Var.valueOf(0))).getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Não é possível selecionar esse período concessivo"));
    } else {
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeView"), Var.valueOf("#/home/logged/requestVacationDetail"), cronapi.list.Operations.newList(Var.valueOf("arquisicaoDataFinal",cronapi.object.Operations.getObjectField(periodo, Var.valueOf("dataPeriodo1Fim"))),Var.valueOf("arquisicaoDataInicial",cronapi.object.Operations.getObjectField(periodo, Var.valueOf("dataPeriodo1Inicio"))),Var.valueOf("login",login)));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param param_login
 * @param periodo
 * @return Var
 */
// Descreva esta função...
public static Var SelecionarPeriodoConcessivoMobile(Var param_login, Var periodo) throws Exception {
 return new Callable<Var>() {

   // param
   private Var login = param_login;
   // end

   public Var call() throws Exception {
    if (cronapi.logic.Operations.isNullOrEmpty(login).getObjectAsBoolean()) {
        login = cronapi.util.Operations.getCurrentUserName();
    }
    if (Var.valueOf(cronapi.object.Operations.getObjectField(periodo, Var.valueOf("status")).equals(Var.valueOf(0))).getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Não é possível selecionar esse período concessivo"));
    } else {
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.showIonicModal"), Var.valueOf("starter"));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeView"), Var.valueOf("#/app/logged/RequestVacationDetail"), cronapi.list.Operations.newList(Var.valueOf("arquisicaoDataFinal",cronapi.object.Operations.getObjectField(periodo, Var.valueOf("dataPeriodo1Fim"))),Var.valueOf("arquisicaoDataInicial",cronapi.object.Operations.getObjectField(periodo, Var.valueOf("dataPeriodo1Inicio"))),Var.valueOf("login",login)));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

}

