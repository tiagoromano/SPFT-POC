package oauth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenIdAdapter {

	@RequestMapping(value="/signin/openid/", method = RequestMethod.GET)
    @ResponseBody
    public String postFacebook() {
        return "<body onload='document.openid.submit()'><form action='/oauth/authorize' method='POST' name='openid'><input type='hidden' name='scope' value='email,profile'></form></body>";
    }
}