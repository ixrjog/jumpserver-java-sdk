package jms;

import com.jumpserver.sdk.v2.builder.ClientBuilder;
import com.jumpserver.sdk.v2.builder.JMSClient;
import com.jumpserver.sdk.v2.common.ActionResponse;
import com.jumpserver.sdk.v2.model.AssetsPermission;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JmsPermissionServiceTest {

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
    public void AssetsPermission() {
        List<AssetsPermission> list = os.permissions().list();
        System.out.println(list.size());
        for (AssetsPermission object : list) {
            System.out.println(object.getId());
            System.out.println(object.getName());
        }
    }

    @Test
    public void addAssetsPermission() {
        AssetsPermission object = new AssetsPermission();
        object.setSystem_users(new String[]{"6ca16c2b-77ec-4757-a100-ddbde4c1a8c4"});
        object.setName("API授权规则");
        AssetsPermission objectBack = os.permissions().createAssetsPermission(object);
        System.out.println(objectBack.getId());
    }

    @Test
    public void updateAssetsPermission() {
        AssetsPermission object = new AssetsPermission();
        object.setId("41864956-6d00-4e96-b7fd-33ae4adf2643");
        object.setName("niubi");
        AssetsPermission objectBack = os.permissions().updateAssetsPermission(object);
        System.out.println(objectBack.getId());
    }

    @Test
    public void deleteAssetsPermission() {
        ActionResponse delete = os.permissions().deleteAssetsPermission("41864956-6d00-4e96-b7fd-33ae4adf2643");
        System.out.println(delete);
    }

    @Test
    public void getAssetsPermission() {
        AssetsPermission object = os.permissions().getAssetsPermission("41864956-6d00-4e96-b7fd-33ae4adf2643");
        System.out.println(object.getName());
    }

}
