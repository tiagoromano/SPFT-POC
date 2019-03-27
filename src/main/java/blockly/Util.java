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

/**
 *
 * @param param_Id
 * @return Var
 */
// Descreva esta função...
public static Var CriarId(Var param_Id) throws Exception {
 return new Callable<Var>() {

   // param
   private Var Id = param_Id;
   // end

   public Var call() throws Exception {
    Id = cronapi.math.Operations.sum(cronapi.logic.Operations.isNullOrEmpty(Id).getObjectAsBoolean() ? Var.valueOf(0) : Id,Var.valueOf(1));
    return Id;
   }
 }.call();
}

}

