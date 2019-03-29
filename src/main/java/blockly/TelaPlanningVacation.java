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

   private Var rowData = Var.VAR_NULL;

   public Var call() throws Exception {
    rowData = cronapi.conversion.Operations.stringToDate(cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.periodoDataInicial")), Var.valueOf("yyy-MM-dd"));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("vars.periodoDataFinal"), cronapi.dateTime.Operations.incYear(rowData, Var.valueOf(1)));
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

/**
 *
 * @param rowData
 * @return Var
 */
// Descreva esta função...
public static Var getDaysQuantity1(Var rowData) throws Exception {
 return new Callable<Var>() {

   private Var finalDateField = Var.VAR_NULL;
   private Var initialDateField = Var.VAR_NULL;
   private Var totalDays = Var.VAR_NULL;

   public Var call() throws Exception {
    finalDateField = cronapi.object.Operations.getObjectField(rowData, Var.valueOf("dataPeriodo1Fim"));
    initialDateField = cronapi.object.Operations.getObjectField(rowData, Var.valueOf("dataPeriodo1Inicio"));
    if (Var.valueOf(cronapi.logic.Operations.isNull(finalDateField).getObjectAsBoolean() || cronapi.logic.Operations.isNull(initialDateField).getObjectAsBoolean()).getObjectAsBoolean()) {
        totalDays = Var.valueOf(0);
    } else {
        totalDays = cronapi.dateTime.Operations.getDaysBetweenDates(finalDateField, initialDateField);
    }
    return totalDays;
   }
 }.call();
}

/**
 *
 * @param rowData
 * @return Var
 */
// Descreva esta função...
public static Var getDaysQuantity2(Var rowData) throws Exception {
 return new Callable<Var>() {

   private Var finalDateField = Var.VAR_NULL;
   private Var initialDateField = Var.VAR_NULL;
   private Var totalDays = Var.VAR_NULL;

   public Var call() throws Exception {
    initialDateField = cronapi.object.Operations.getObjectField(rowData, Var.valueOf("dataPeriodo2Inicio"));
    finalDateField = cronapi.object.Operations.getObjectField(rowData, Var.valueOf("dataPeriodo2Fim"));
    if (Var.valueOf(cronapi.logic.Operations.isNull(finalDateField).getObjectAsBoolean() || cronapi.logic.Operations.isNull(initialDateField).getObjectAsBoolean()).getObjectAsBoolean()) {
        totalDays = Var.valueOf(0);
    } else {
        totalDays = cronapi.dateTime.Operations.getDaysBetweenDates(finalDateField, initialDateField);
    }
    return totalDays;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var obterEmpreadosSelecionados() throws Exception {
 return new Callable<Var>() {

   private Var selectedUsers = Var.VAR_NULL;

   public Var call() throws Exception {
    System.out.println(Var.valueOf("tabatenu").getObjectAsString());
    selectedUsers = cronapi.screen.Operations.getParam(Var.valueOf("users"));
    System.out.println(selectedUsers.getObjectAsString());
    return Var.VAR_NULL;
   }
 }.call();
}

}

