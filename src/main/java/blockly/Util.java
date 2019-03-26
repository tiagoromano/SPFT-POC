package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Util {

public static final int TIMEOUT = 300;

/**
 *
 * @param para
 * @param assunto
 * @param corpo
 * @return Var
 */
// Util
public static Var EnviarEmail(Var para, Var assunto, Var corpo) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.email.Operations.sendEmail(Var.valueOf("testeemailcronos@gmail.com"), para, Var.VAR_NULL, Var.VAR_NULL, assunto, corpo, Var.VAR_NULL, Var.VAR_NULL, Var.valueOf("smtp.gmail.com"), Var.valueOf("587"), Var.valueOf("testeemailcronos@gmail.com"), Var.valueOf("testeemailcronos%%"), Var.valueOf("TLS"));
    return Var.VAR_NULL;
   }
 }.call();
}

}

