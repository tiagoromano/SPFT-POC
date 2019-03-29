package oauth;

import java.util.Arrays;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.AccessTokenProvider;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.security.oauth2.client.token.OAuth2AccessTokenSupport;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

@Order(1)
@Configuration
@EnableWebSecurity
public class OAuthSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    OAuth2ClientContext oauth2ClientContext;

    @Autowired
    OpenIdConnectConfig config;

    @Value("${security.oauth2.client.userinfo}")
    private String userInfoUri;

    @Value("${security.oauth2.client.clientId}")
    private String clientId;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/oauth/**")
            .csrf().disable()
            .addFilterAfter(new OAuth2ClientContextFilter(), AbstractPreAuthenticatedProcessingFilter.class)
            .addFilterAfter(openIdConnectFilter(), OAuth2ClientContextFilter.class)
            .addFilterBefore(new UpdateSavedRequestFilter(), OAuth2Filter.class);
    }

    @Bean
    public OAuth2Filter openIdConnectFilter() {
        OAuth2Filter filter = new OAuth2Filter("/oauth/**");
        OAuth2RestTemplate oauthTemplate = new OAuth2RestTemplate(config.protectedResourceDetails(), oauth2ClientContext);
        OAuth2AccessTokenSupport authAccessProvider = new AuthorizationCodeAccessTokenProvider(); 

        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = clientHttpRequestFactory();

        // Set request factory for '/oauth/token'
        authAccessProvider.setRequestFactory(clientHttpRequestFactory);

        AccessTokenProvider accessTokenProvider = new AccessTokenProviderChain(Arrays.<AccessTokenProvider> asList(
            (AuthorizationCodeAccessTokenProvider)authAccessProvider));

        oauthTemplate.setAccessTokenProvider(accessTokenProvider);

        // Set request factory for '/userinfo'
        oauthTemplate.setRequestFactory(clientHttpRequestFactory);
        filter.setRestTemplate(oauthTemplate);
        UserInfoTokenServices tokenServices = new UserInfoTokenServices(userInfoUri, clientId);
        tokenServices.setRestTemplate(oauthTemplate);
        filter.setTokenServices(tokenServices);
        return filter;
    }

    private HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {
        HttpClientBuilder clientBuilder = HttpClients.custom();
        SSLConnectionSocketFactory sslSocketFactory = null;

        try {
            SSLContext sslContext = SSLContextBuilder.create().loadTrustMaterial(TrustAllStrategy.INSTANCE).build();
            sslSocketFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        CloseableHttpClient httpClient = clientBuilder.setSSLSocketFactory(sslSocketFactory).build();

        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }
}