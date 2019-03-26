package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class SAP {

public static final int TIMEOUT = 300;

/**
 *
 * @param matricula
 * @return Var
 */
// SAP
public static Var ObterPeriodosConcessivos(Var matricula) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return Var.valueOf("<DocumentElement>\n	<Periodos>\n		<Matricula>6188</Matricula>\n		<PeriodoInicial>01-01-2019</PeriodoInicial>\n		<PeriodoFinal>30-06-2019</PeriodoFinal>		\n	</Periodos>\n	<Periodos>\n		<Matricula>6188</Matricula>\n		<PeriodoInicial>01-07-2019</PeriodoInicial>\n		<PeriodoFinal>31-12-2019</PeriodoFinal>		\n	</Periodos>\n	\n</DocumentElement>");
   }
 }.call();
}

/**
 *
 * @param solicitacaoFerias
 * @return Var
 */
// Descreva esta função...
public static Var ExportarSolicitacao(Var solicitacaoFerias) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return Var.VAR_NULL;
   }
 }.call();
}

}

