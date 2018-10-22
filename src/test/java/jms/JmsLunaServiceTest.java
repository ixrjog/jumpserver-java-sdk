package jms;

import com.jumpserver.sdk.v2.builder.ClientBuilder;
import com.jumpserver.sdk.v2.builder.JMSClient;
import com.jumpserver.sdk.v2.model.Luna;
import org.junit.Before;
import org.junit.Test;

public class JmsLunaServiceTest {

    private JMSClient os;

    @Before
    public void before() {
        os = new ClientBuilder()
                .endpoint("http://localhost:8088")
                .credentials("admin", "admin")
                .header("x-jms-org", "7c6955bc-f004-4573-b46a-4072b0dd0d03")
                .authenticate();
        System.out.println(os.getToken().getToken());
    }

    @Test
    public void token() {
        Luna luna = new Luna();
        luna.setUser("728042cd-b3af-4dd4-b505-2f04366e4f71");
        luna.setAsset("e15ec285-c03a-418d-ab5a-e678346336b4");
        luna.setSystem_user("6ca16c2b-77ec-4757-a100-ddbde4c1a8c4");
        Luna lunaToken = os.luna().getLunaToken(luna);
        System.out.println(lunaToken.getToken());

    }
    @Test
    public void linux() {
        String s = os.luna().connectLunaLinux("9e05eb85-2e8b-420d-8fc4-cee039ffa047");
        System.out.println(s);

    }
    @Test
    public void windows() {
        String s = os.luna().connectLunaWindows("9e05eb85-2e8b-420d-8fc4-cee039ffa047");
        System.out.println(s);

    }
}
