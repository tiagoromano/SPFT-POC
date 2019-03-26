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

/**
 *
 * @param selectedRows
 * @return Var
 */
// Descreva esta função...
public static Var AprovarSolicitacoes(Var selectedRows) throws Exception {
 return new Callable<Var>() {

   private Var totalSolicitacao = Var.VAR_NULL;
   private Var totalAprovadas = Var.VAR_NULL;

   public Var call() throws Exception {
    totalSolicitacao = cronapi.list.Operations.size(selectedRows);
    if (Var.valueOf(totalSolicitacao.equals(Var.valueOf(0))).getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("É necessário selecionar alguma solicitação para aprovar"));
    } else {
        totalAprovadas = blockly.Ferias.AprovarSolicitacaoFerias(selectedRows);
        if (Var.valueOf(totalAprovadas.equals(Var.valueOf(0))).getObjectAsBoolean()) {
            cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf("Não foi possível aprovar a(s) solicitação(ões) selecionada(s)"));
        } else {
            cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"), Var.valueOf(Var.valueOf("Foi(ram) aprovada(s)  ").toString() + totalAprovadas.toString() + Var.valueOf(" de ").toString() + totalSolicitacao.toString() + Var.valueOf(" solicitação(ções)").toString()));
            cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"), Var.valueOf("ObterSolicitacaoDeFeriasPorOrgaoEStatus"), Var.valueOf("true"));
        }
    }
    return Var.VAR_NULL;
   }
 }.call();
}

}

