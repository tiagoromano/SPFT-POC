package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Ferias {

public static final int TIMEOUT = 300;

/**
 *
 * @param param_login
 * @return Var
 */
// Ferias
public static Var ObterPeriodosConcessivos(Var param_login) throws Exception {
 return new Callable<Var>() {

   // param
   private Var login = param_login;
   // end
   private Var listaPeriodosConcessivos = Var.VAR_NULL;
   private Var usuarioBIDT = Var.VAR_NULL;
   private Var matricula = Var.VAR_NULL;
   private Var xmlPeriodoConcessivoSAP = Var.VAR_NULL;
   private Var totalPeriodo = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var periodoInicial = Var.VAR_NULL;
   private Var periodoFinal = Var.VAR_NULL;
   private Var solicitacaoFerias = Var.VAR_NULL;

   public Var call() throws Exception {
    if (cronapi.logic.Operations.isNullOrEmpty(login).getObjectAsBoolean()) {
        login = cronapi.util.Operations.getCurrentUserName();
    }
    listaPeriodosConcessivos = cronapi.list.Operations.newList();
    usuarioBIDT = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.ForcaTrabalho"),Var.valueOf("select f from ForcaTrabalho f where f.codigoLogin = :codigoLogin"),Var.valueOf("codigoLogin",login));
    matricula = cronapi.database.Operations.getField(usuarioBIDT, Var.valueOf("this[0].matricula"));
    xmlPeriodoConcessivoSAP = cronapi.xml.Operations.xmltoJson(Var.valueOf("<DocumentElement>\n	<Periodos>\n		<Matricula>6188</Matricula>\n		<PeriodoInicial>01-01-2019</PeriodoInicial>\n		<PeriodoFinal>30-06-2019</PeriodoFinal>		\n	</Periodos>\n	<Periodos>\n		<Matricula>6188</Matricula>\n		<PeriodoInicial>01-07-2019</PeriodoInicial>\n		<PeriodoFinal>31-12-2019</PeriodoFinal>		\n	</Periodos>\n	\n</DocumentElement>"));
    totalPeriodo = cronapi.list.Operations.size(cronapi.json.Operations.getJsonOrMapField(xmlPeriodoConcessivoSAP, Var.valueOf("DocumentElement.Periodos")));
    j = Var.valueOf(0);
    while (Var.valueOf(j.compareTo(totalPeriodo) < 0).getObjectAsBoolean()) {
        periodoInicial = cronapi.json.Operations.getJsonOrMapField(xmlPeriodoConcessivoSAP, Var.valueOf(Var.valueOf("DocumentElement.Periodos[").toString() + j.toString() + Var.valueOf("].PeriodoInicial").toString()));
        periodoFinal = cronapi.json.Operations.getJsonOrMapField(xmlPeriodoConcessivoSAP, Var.valueOf(Var.valueOf("DocumentElement.Periodos[").toString() + j.toString() + Var.valueOf("].PeriodoFinal").toString()));
        solicitacaoFerias = cronapi.object.Operations.newObject(Var.valueOf("SPFT.entity.SolicitacaoFerias"),Var.valueOf("status",Var.valueOf(1)),Var.valueOf("dataPeriodo1Inicio",cronapi.conversion.Operations.stringToDate(periodoInicial, Var.valueOf("dd-MM-yyyy"))),Var.valueOf("dataPeriodo1Fim",cronapi.conversion.Operations.stringToDate(periodoFinal, Var.valueOf("dd-MM-yyyy"))));
        cronapi.list.Operations.addLast(listaPeriodosConcessivos,solicitacaoFerias);
        j = cronapi.math.Operations.sum(j,Var.valueOf(1));
    } // end while
    return listaPeriodosConcessivos;
   }
 }.call();
}

}

