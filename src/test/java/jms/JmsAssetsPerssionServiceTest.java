package jms;

import com.jumpserver.sdk.model.Assetpermission;
import com.jumpserver.sdk.service.JmsPermissionService;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class JmsAssetsPerssionServiceTest {

    private JmsPermissionService jmsPermissionService;

    @Before
    public void getJmsAssetsService() {
        jmsPermissionService= new JmsPermissionService("http://localhost:8080", "admin", "admin");
        String token = jmsPermissionService.getToken();
        System.out.println(token);
    }

    @Test
    public void t11() {
        Assetpermission assetpermission = new Assetpermission();
        assetpermission.setName("SDK授权规则");
        assetpermission.setSystem_users(new String[]{"43ce643d-df31-4267-aadb-b9db3afec68b"});
        assetpermission.setUser_groups(new String[]{"a9eb1158-ee23-4b62-815f-91f342bc66f3"});
        assetpermission.setAsset_groups(new String[]{"99028af4-8739-494b-8108-e80b6210bad4"});
        Map<String, String> map = jmsPermissionService.addAssetpermission(assetpermission);
        System.out.println(map);
    }

    @Test
    public void t12() {
        Assetpermission assetpermission = new Assetpermission();
        assetpermission.setId("5becc8d4-fbfd-4ad0-b2f5-07c806b9359b");
        assetpermission.setName("SDK授权规则-modify");
        Map<String, String> map = jmsPermissionService.updateAssetpermission(assetpermission);
        System.out.println(map);
    }

    @Test
    public void t13() {
        String id = "5becc8d4-fbfd-4ad0-b2f5-07c806b9359b";
        Map<String, String> map = jmsPermissionService.queryAssetpermission(id);
        System.out.println(map);
    }




}
