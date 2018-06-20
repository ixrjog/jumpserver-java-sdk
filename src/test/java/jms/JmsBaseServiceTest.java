package jms;

import com.jumpserver.sdk.model.Asset;
import com.jumpserver.sdk.service.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class JmsBaseServiceTest {

    private JmsBaseService jmsBaseService;

    @Before
    public void getJmsAssetsService() {
        jmsBaseService = new JmsBaseService("http://localhost:8088", "admin", "admin");
        String token = jmsBaseService.getToken();
        System.out.println(token);
    }

    @Test
    public void t11() {
        JmsAssetsService jmsAssetsService = jmsBaseService.jmsAssetsService();
        Asset asset = new Asset();
        asset.setHostname("SDK-hostName-modify");
        Map<String, String> map = jmsAssetsService.addAsset(asset);
        System.out.println(map);
    }

}
