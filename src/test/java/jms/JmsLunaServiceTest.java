package jms;

import com.jumpserver.sdk.model.Luna;
import com.jumpserver.sdk.service.JmsLunaService;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class JmsLunaServiceTest {

    private JmsLunaService jmsLunaService;

    @Before
    public void tb() {

        jmsLunaService= new JmsLunaService("http://ccoe-dev2.cmbchina.io", "admin", "admin");
        String token = jmsLunaService.getToken();
        System.out.println(token);
    }

    @Test
    public void t11() {
        Luna luna = new Luna();
        luna.setAsset("c4a815bb-9e91-49f5-b51b-18e746582b23");
        luna.setUser("30b7ec1e-867c-427d-8fe8-110028938369");
        luna.setSystem_user("4fba8153-bfd1-4de8-a1c0-a56b87371a33");
        Map<String, String> lunaToken = jmsLunaService.getLunaToken(luna);
        System.out.println(lunaToken);

    }
    @Test
    public void t12() {
        Map<String, String> lunaToken = jmsLunaService.validateToken("9e05eb85-2e8b-420d-8fc4-cee039ffa047");
        System.out.println(lunaToken);

    }
    @Test
    public void t13() {
        Map<String, String> lunaToken = jmsLunaService.connectLunaLinux("9e05eb85-2e8b-420d-8fc4-cee039ffa047");
        System.out.println(lunaToken);

    }
}
