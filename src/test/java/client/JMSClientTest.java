package client;

import com.jumpserver.sdk.v2.builder.ClientBuilder;
import com.jumpserver.sdk.v2.builder.JMSClient;
import org.junit.Test;

/**
 * @author yankaijun
 * @date 2018/10/15 下午4:26
 */
public class JMSClientTest {

    @Test
    public void token() {
        try {
            JMSClient os = new ClientBuilder().endpoint("http://localhost:8088")
                    .credentials("admin", "admin")
                    .header("x-jms-org","7c6955bc-f004-4573-b46a-4072b0dd0d03")
                    .authenticate();

            System.out.println(os.getToken());
            System.out.println(os.hasXpack());
            System.out.println(os.getToken());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
