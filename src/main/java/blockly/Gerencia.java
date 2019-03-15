package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Gerencia {

public static final int TIMEOUT = 300;

/**
 *
 * @param Dados
 * @return Var
 */
// Gerencia
public static Var ObterGerenciasUsuarioLogado(Var Dados) throws Exception {
 return new Callable<Var>() {

   private Var Orgaos = Var.VAR_NULL;
   private Var usuarioBIDT = Var.VAR_NULL;
   private Var consultaOrgaos = Var.VAR_NULL;
   private Var consultaDelegacao = Var.VAR_NULL;

   public Var call() throws Exception {
    System.out.println(Var.valueOf("ObterGerenciasUsuarioLogado").getObjectAsString());
    Orgaos = cronapi.list.Operations.newList();
    usuarioBIDT = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.ForcaTrabalho"),Var.valueOf("select f from ForcaTrabalho f where f.codigoLogin = :codigoLogin"),Var.valueOf("codigoLogin",cronapi.util.Operations.getCurrentUserName()));
    consultaOrgaos = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.Orgao"),Var.valueOf("select o from Orgao o where o.codigoForcaTrabalho = :codigoForcaTrabalho"),Var.valueOf("codigoForcaTrabalho",cronapi.database.Operations.getField(usuarioBIDT, Var.valueOf("this[0].id"))));
    while (cronapi.database.Operations.hasElement(consultaOrgaos).getObjectAsBoolean()) {
        cronapi.list.Operations.addLast(Orgaos,cronapi.database.Operations.getActiveData(consultaOrgaos));
        cronapi.database.Operations.next(consultaOrgaos);
    } // end while
    consultaDelegacao = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.Delegacao"),Var.valueOf("select d.orgao from Delegacao d where d.forcaTrabalhoDelegado.id = :forcaTrabalhoDelegadoId"),Var.valueOf("forcaTrabalhoDelegadoId",cronapi.database.Operations.getField(usuarioBIDT, Var.valueOf("this[0].id"))));
    while (cronapi.database.Operations.hasElement(consultaDelegacao).getObjectAsBoolean()) {
        cronapi.list.Operations.addLast(Orgaos,cronapi.database.Operations.getActiveData(consultaDelegacao));
        cronapi.database.Operations.next(consultaDelegacao);
    } // end while
    return Orgaos;
   }
 }.call();
}

}

