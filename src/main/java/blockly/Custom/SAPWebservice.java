package blockly.Custom;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.BindingProvider;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cronapi.CronapiMetaData;
import cronapi.Var;
import cronapi.rest.security.CronappSecurity;
import sap.Bapiret2;
import sap.ZSPFBAPIENTRADA;
import sap.ZSPFBAPIENTRADA_Service;
import sap.ZSPFBAPISAIDA;
import sap.ZSPFBAPISAIDA_Service;
import sap.ZctHrBapiEntradaSpf;
import sap.ZctHrBapiPernr;
import sap.ZetHrBapiEntradaSpf;

@RestController
@RequestMapping(value = "/api/SAPWebservice")
@CronapiMetaData(type = "SAP")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
public class SAPWebservice {

	static {
		BypassSSL();
		
		java.net.Authenticator.setDefault(new java.net.Authenticator() {
			@Override
			protected java.net.PasswordAuthentication getPasswordAuthentication() {
				System.out.println("Executando getPasswordAuthentication");
				return new java.net.PasswordAuthentication(USER_CREDENTIAL, PASSWORD_CREDENTIAL.toCharArray());
			}
		});
	}

	private static final String APROVAR_FERIAS_URL = "http://f02web.petrobras.biz/sap/bc/srt/rfc/sap/zspf_bapi_saida/400/zspf_bapi_saida/zspf_bapi_saida";
	private static final String SOLICITAR_FERIAS_URL = "http://f02web.petrobras.biz/sap/bc/srt/rfc/sap/zspf_bapi_entrada/400/zspf_bapi_entrada/zspf_bapi_entrada";
	private static final String USER_CREDENTIAL = "ZSPF";
	private static final String PASSWORD_CREDENTIAL = "zspf123";

	@RequestMapping(
		method = RequestMethod.GET, 
		value="/GetPeriodoConcessivo/{Matricula}",
		consumes = MediaType.APPLICATION_JSON, 
		produces = MediaType.APPLICATION_JSON)
	public static Var GetPeriodoConcessivo(String Matricula) {
		String toString = "";
		try {
			ZSPFBAPISAIDA_Service service = new ZSPFBAPISAIDA_Service(new URL(SOLICITAR_FERIAS_URL));

			ZSPFBAPISAIDA client = service.getPort(ZSPFBAPISAIDA.class);

			ZctHrBapiPernr pernr = new ZctHrBapiPernr();

			Matricula = StringUtils.leftPad(Matricula, 8, '0');

			pernr.getItem().add(Matricula);

			SetCredentials(client);

			List<Bapiret2> retorno = client
				.zhrplanferiasSaida("9999-12-31", "1800-01-01", pernr, USER_CREDENTIAL, null, null)
				.getItem();

			toString = Arrays.deepToString(retorno.toArray(new Bapiret2[retorno.size()]));

			System.out.println(toString);
		} catch (Exception e) {
			System.out.println("Erro no método GetPeriodoConcessivo");
			toString = e.getMessage();
			e.printStackTrace();
		}

		return Var.valueOf(toString);
	}

	@RequestMapping(
		method = RequestMethod.GET, 
		value="/AprovarFerias/{Matricula}/{TipoParc}/{AbonoPecuni}/{DtIniPrimParc}/{DtFimPrimParc}/{DtIniSecParc}/{DtFimSecParc}/{DtIniTercParc}/{DtFimTercParc}/{Ind13sal}/{DtIniPerAquis}/{DtFimPerAquis}/{Bloqueio}",
		consumes = MediaType.APPLICATION_JSON, 
		produces = MediaType.APPLICATION_JSON)
	public static Var AprovarFerias(String Matricula, String TipoParc, String AbonoPecuni, String DtIniPrimParc, 
		String DtFimPrimParc, String DtIniSecParc, String DtFimSecParc, String DtIniTercParc, String DtFimTercParc, 
		String Ind13sal, String DtIniPerAquis, String DtFimPerAquis, String Bloqueio) {
			String toString= "";
		try {
			ZSPFBAPIENTRADA_Service service = new ZSPFBAPIENTRADA_Service(new URL(APROVAR_FERIAS_URL));

			ZSPFBAPIENTRADA client = service.getPort(ZSPFBAPIENTRADA.class);

			ZetHrBapiEntradaSpf parametros = new ZetHrBapiEntradaSpf();

			Matricula = StringUtils.leftPad(Matricula, 8, '0');

			parametros.setMatricula(Matricula);
			parametros.setTipoParc(TipoParc);
			parametros.setAbonoPecuni(AbonoPecuni);
			parametros.setDtIniPrimParc(DtIniPrimParc);
			parametros.setDtFimPrimParc(DtFimPrimParc);
			parametros.setDtIniSecParc(DtIniSecParc);
			parametros.setDtFimSecParc(DtFimSecParc);
			
			parametros.setDtIniTercParc(DtIniTercParc);
			parametros.setDtFimTercParc(DtFimTercParc);

			parametros.setAbonoPecuni(Ind13sal);
			parametros.setDtIniPerAquis(DtIniPerAquis);
			parametros.setDtFimPerAquis(DtFimPerAquis);
			parametros.setBloqueio(Bloqueio);

			SetCredentials(client);
			
			ZctHrBapiEntradaSpf entradaSpf = new ZctHrBapiEntradaSpf();
			entradaSpf.getItem().add(parametros);

			List<Bapiret2> retorno = client.zhrplanferiasEntrada(entradaSpf).getItem();

			toString = Arrays.deepToString(retorno.toArray(new Bapiret2[retorno.size()]));

			System.out.println(toString);
		} catch (Exception e) {
			System.out.println("Erro no método AprovarFerias");
			toString = e.getMessage();
			e.printStackTrace();
		}

		return Var.valueOf(toString);
	}

	private static void SetCredentials(Object client) {
		try {
			BindingProvider prov = (BindingProvider)client;
			System.out.println("Setando credenciais no BindingProvider");
			prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, USER_CREDENTIAL);
			prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, PASSWORD_CREDENTIAL);
			System.out.println("Credenciais setadas com sucesso no BindingProvider");
		} catch (Exception e) {
			System.out.println("Erro no método SetCredentials");
			e.printStackTrace();
		}
	}

	private static void BypassSSL() {
        try {
            SSLContext sslContext = SSLContextBuilder.create().loadTrustMaterial(TrustAllStrategy.INSTANCE).build();
			HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
        } catch (Exception e) {
			System.out.println("Erro no método BypassSSL");
            e.printStackTrace();
        }
	}
}
