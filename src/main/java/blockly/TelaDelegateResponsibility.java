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

}

