package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ForcaTrabalho {

public static final int TIMEOUT = 300;

/**
 *
 * @param chaveEmpregado
 * @param matriculaEmpregado
 * @param gerencia
 * @return Var
 */
// ForcaTrabalho
public static Var ObterPorChaveOuMatriculaOuOrgao(Var chaveEmpregado, Var matriculaEmpregado, Var gerencia) throws Exception {
 return new Callable<Var>() {

   private Var consultaForcaTrabalho = Var.VAR_NULL;

   public Var call() throws Exception {
    consultaForcaTrabalho = cronapi.list.Operations.newList();
    if (Var.valueOf(cronapi.logic.Operations.isNullOrEmpty(chaveEmpregado).negate().getObjectAsBoolean() || cronapi.logic.Operations.isNullOrEmpty(matriculaEmpregado).negate().getObjectAsBoolean() || cronapi.logic.Operations.isNullOrEmpty(gerencia).negate().getObjectAsBoolean()).getObjectAsBoolean()) {
        consultaForcaTrabalho = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.ForcaTrabalho"),Var.valueOf("select f from ForcaTrabalho f, Orgao o \nwhere o.codigoForcaTrabalho = f.id\nAND (:orgaoId IS NULL or o.id = :orgaoId) \nAND (:chaveEmpregado IS NULL or f.codigoLogin = :chaveEmpregado)\nAND (:matriculaEmpregado IS NULL or f.matricula = :matriculaEmpregado )"),Var.valueOf("orgaoId",gerencia),Var.valueOf("orgaoId",gerencia),Var.valueOf("chaveEmpregado",chaveEmpregado),Var.valueOf("chaveEmpregado",chaveEmpregado),Var.valueOf("matriculaEmpregado",matriculaEmpregado),Var.valueOf("matriculaEmpregado",matriculaEmpregado));
    }
    return consultaForcaTrabalho;
   }
 }.call();
}

}

