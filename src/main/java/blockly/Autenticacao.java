package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Autenticacao {

public static final int TIMEOUT = 300;

/**
 *
 * @param chave
 * @param senha
 * @return Var
 */
// Autenticacao
public static Var FazerLogin(Var chave, Var senha) throws Exception {
 return new Callable<Var>() {

   private Var existeChaveBIDT = Var.VAR_NULL;
   private Var autenticadoOpenID = Var.VAR_NULL;
   private Var consultaBIDT = Var.VAR_NULL;
   private Var consultaUsuarioApp = Var.VAR_NULL;
   private Var existeUsuarioApp = Var.VAR_NULL;
   private Var userId = Var.VAR_NULL;

   public Var call() throws Exception {
    existeChaveBIDT = Var.VAR_FALSE;
    if (Var.valueOf(Var.valueOf(chave.equals(Var.valueOf("admin"))).getObjectAsBoolean() && Var.valueOf(senha.equals(Var.valueOf("admin"))).getObjectAsBoolean()).getObjectAsBoolean()) {
        existeChaveBIDT = Var.VAR_TRUE;
    } else {
        autenticadoOpenID = Var.valueOf(FazerLoginOpenIDConnect(chave, senha));
        if (autenticadoOpenID.getObjectAsBoolean()) {
            consultaBIDT = cronapi.database.Operations.query(Var.valueOf("SPFT.entity.ForcaTrabalho"),Var.valueOf("select f.codigoLogin, f.email, f.nome from ForcaTrabalho f where f.codigoLogin = :codigoLogin"),Var.valueOf("codigoLogin",chave));
            existeChaveBIDT = cronapi.database.Operations.hasElement(consultaBIDT);
            if (existeChaveBIDT.getObjectAsBoolean()) {
                consultaUsuarioApp = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u.login from User u where u.login = :login"),Var.valueOf("login",chave));
                existeUsuarioApp = cronapi.database.Operations.hasElement(consultaUsuarioApp);
                if (existeUsuarioApp.negate().getObjectAsBoolean()) {
                    userId = cronapi.util.Operations.generateUUID();
                    cronapi.database.Operations.insert(Var.valueOf("app.entity.User"),cronapi.database.Operations.newEntity(Var.valueOf("app.entity.User"),Var.valueOf("id",userId),Var.valueOf("email",cronapi.database.Operations.getField(consultaBIDT, Var.valueOf("this[1]"))),Var.valueOf("name",cronapi.database.Operations.getField(consultaBIDT, Var.valueOf("this[2]"))),Var.valueOf("login",cronapi.database.Operations.getField(consultaBIDT, Var.valueOf("this[0]"))),Var.valueOf("password",cronapi.util.Operations.generateUUID())));
                    cronapi.database.Operations.insert(Var.valueOf("app.entity.Role"),cronapi.database.Operations.newEntity(Var.valueOf("app.entity.Role"),Var.valueOf("id",Var.valueOf("Employee")),Var.valueOf("user",cronapi.database.Operations.newEntity(Var.valueOf("app.entity.User"),Var.valueOf("id",userId)))));
                }
                cronapi.database.Operations.close(consultaUsuarioApp);
            } else {
                cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), cronapi.i18n.Operations.translate(Var.valueOf("AutenticacaoBlockly")));
            }
            cronapi.database.Operations.close(consultaBIDT);
        }
    }
    return existeChaveBIDT;
   }
 }.call();
}

/**
 *
 * @param chave
 * @param senha
 * @return Var
 */
// Descreva esta função...
public static Var FazerLoginOpenIDConnect(Var chave, Var senha) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return Var.VAR_TRUE;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var ObterUsuarioLogado() throws Exception {
 return new Callable<Var>() {

   private Var existeChaveBIDT = Var.VAR_NULL;
   private Var chave = Var.VAR_NULL;
   private Var senha = Var.VAR_NULL;
   private Var autenticadoOpenID = Var.VAR_NULL;
   private Var consultaBIDT = Var.VAR_NULL;
   private Var consultaUsuarioApp = Var.VAR_NULL;
   private Var existeUsuarioApp = Var.VAR_NULL;
   private Var userId = Var.VAR_NULL;

   public Var call() throws Exception {
    return cronapi.util.Operations.getCurrentUserName();
   }
 }.call();
}

}

