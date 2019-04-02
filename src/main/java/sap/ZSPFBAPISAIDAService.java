package sap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ZSPF_BAPI_SAIDAService", targetNamespace = "urn:sap-com:document:sap:soap:functions:mc-style", wsdlLocation = "file:/opt/techne/cronoside/Downloads/SAP%20WSDL/wsdl_saida.xml")
public class ZSPFBAPISAIDAService
    extends Service
{

    private final static URL ZSPFBAPISAIDASERVICE_WSDL_LOCATION;
    private final static WebServiceException ZSPFBAPISAIDASERVICE_EXCEPTION;
    private final static QName ZSPFBAPISAIDASERVICE_QNAME = new QName("urn:sap-com:document:sap:soap:functions:mc-style", "ZSPF_BAPI_SAIDAService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/opt/techne/cronoside/Downloads/SAP%20WSDL/wsdl_saida.xml");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ZSPFBAPISAIDASERVICE_WSDL_LOCATION = url;
        ZSPFBAPISAIDASERVICE_EXCEPTION = e;
    }

    public ZSPFBAPISAIDAService() {
        super(__getWsdlLocation(), ZSPFBAPISAIDASERVICE_QNAME);
    }

    public ZSPFBAPISAIDAService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ZSPFBAPISAIDASERVICE_QNAME, features);
    }

    public ZSPFBAPISAIDAService(URL wsdlLocation) {
        super(wsdlLocation, ZSPFBAPISAIDASERVICE_QNAME);
    }

    public ZSPFBAPISAIDAService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ZSPFBAPISAIDASERVICE_QNAME, features);
    }

    public ZSPFBAPISAIDAService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ZSPFBAPISAIDAService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ZSPFBAPISAIDA
     */
    @WebEndpoint(name = "ZSPF_BAPI_SAIDA")
    public ZSPFBAPISAIDA getZSPFBAPISAIDA() {
        return super.getPort(new QName("urn:sap-com:document:sap:soap:functions:mc-style", "ZSPF_BAPI_SAIDA"), ZSPFBAPISAIDA.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ZSPFBAPISAIDA
     */
    @WebEndpoint(name = "ZSPF_BAPI_SAIDA")
    public ZSPFBAPISAIDA getZSPFBAPISAIDA(WebServiceFeature... features) {
        return super.getPort(new QName("urn:sap-com:document:sap:soap:functions:mc-style", "ZSPF_BAPI_SAIDA"), ZSPFBAPISAIDA.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ZSPFBAPISAIDASERVICE_EXCEPTION!= null) {
            throw ZSPFBAPISAIDASERVICE_EXCEPTION;
        }
        return ZSPFBAPISAIDASERVICE_WSDL_LOCATION;
    }

}
