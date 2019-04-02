package blockly.Custom;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.xml.ws.BindingProvider;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cronapi.CronapiMetaData;
import cronapi.Var;
import cronapi.rest.security.CronappSecurity;
import sap.Bapiret2;
import sap.ZSPFBAPIENTRADA;
import sap.ZSPFBAPIENTRADAService;
import sap.ZSPFBAPISAIDA;
import sap.ZSPFBAPISAIDAService;
import sap.ZctHrBapiEntradaSpf;
import sap.ZctHrBapiPernr;
import sap.ZetHrBapiEntradaSpf;

@RestController
@RequestMapping(value = "/api/SAPWebservice")
@CronapiMetaData(type = "SAP")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
public class SAPWebservice {

	private static final String APROVAR_FERIAS_URL = "https://f02web.petrobras.biz/sap/bc/srt/rfc/sap/zspf_bapi_saida/400/zspf_bapi_saida/zspf_bapi_saida?sap-client=400";
	private static final String SOLICITAR_FERIAS_URL = "https://f02web.petrobras.biz/sap/bc/srt/rfc/sap/zspf_bapi_entrada/400/zspf_bapi_entrada/zspf_bapi_entrada?sap-client=400";
	private static final String USER_CREDENTIAL = "ZSPF";
	private static final String PASSWORD_CREDENTIAL = "zspf123";

	@RequestMapping(
		method = RequestMethod.GET, 
		value="/GetPeriodoConcessivo/{Matricula}/{Usuario}",
		consumes = MediaType.APPLICATION_JSON, 
		produces = MediaType.APPLICATION_JSON)
	public static Var GetPeriodoConcessivo(List<String> Matricula, String Usuario) {
		try {
			ZSPFBAPISAIDAService service = new ZSPFBAPISAIDAService(new URL(SOLICITAR_FERIAS_URL));

			ZSPFBAPISAIDA client = service.getPort(ZSPFBAPISAIDA.class);

			ZctHrBapiPernr pernr = new ZctHrBapiPernr();

			List<String> matriculas = new ArrayList<>(Matricula.size());

			for (String mat : Matricula) {
				matriculas.add(StringUtils.leftPad(mat, 8, '0'));
			}

			pernr.getItem().addAll(matriculas);

			SetCredentials(client);

			List<Bapiret2> retorno = client
				.zhrplanferiasSaida("9999-12-31", "1800-01-01", pernr, Usuario, null, null)
				.getItem();

			String toString = Arrays.deepToString(retorno.toArray(new Bapiret2[retorno.size()]));

			System.out.println(toString);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Var.VAR_NULL;
	}

	@RequestMapping(
		method = RequestMethod.GET, 
		value="/AprovarFerias/{Matricula}/{TipoParc}/{AbonoPecuni}/{DtIniPrimParc}/{DtFimPrimParc}/{DtIniSecParc}/{DtFimSecParc}/{DtIniTercParc}/{DtFimTercParc}/{Ind13sal}/{DtIniPerAquis}/{DtFimPerAquis}/{Bloqueio}",
		consumes = MediaType.APPLICATION_JSON, 
		produces = MediaType.APPLICATION_JSON)
	public static Var AprovarFerias(String Matricula, String TipoParc, String AbonoPecuni, String DtIniPrimParc, 
		String DtFimPrimParc, String DtIniSecParc, String DtFimSecParc, String DtIniTercParc, String DtFimTercParc, 
		String Ind13sal, String DtIniPerAquis, String DtFimPerAquis, String Bloqueio) {
		try {
			ZSPFBAPIENTRADAService service = new ZSPFBAPIENTRADAService(new URL(APROVAR_FERIAS_URL));

			ZSPFBAPIENTRADA client = service.getPort(ZSPFBAPIENTRADA.class);

			ZetHrBapiEntradaSpf parametros = new ZetHrBapiEntradaSpf();
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

			String toString = Arrays.deepToString(retorno.toArray(new Bapiret2[retorno.size()]));

			System.out.println(toString);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Var.VAR_NULL;
	}

	private static void SetCredentials(Object client) {
		BindingProvider prov = (BindingProvider)client;
		prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, USER_CREDENTIAL);
		prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, PASSWORD_CREDENTIAL);
	}
}