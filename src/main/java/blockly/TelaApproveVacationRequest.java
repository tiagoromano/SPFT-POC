package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class TelaApproveVacationRequest {

public static final int TIMEOUT = 300;

/**
 *
 * @param selectedRow
 * @return Var
 */
// TelaApproveVacationRequest
public static Var ExibirJustificativa(Var selectedRow) throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    item = cronapi.object.Operations.getObjectField(selectedRow, Var.valueOf("justificativa"));
    if (cronapi.logic.Operations.isNullOrEmpty(item).negate().getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("vars.justificativa"), item);
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.showModal"), Var.valueOf("modalJust"));
    } else {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Não existe justificativa para essa solicitação"));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

}

