package jms;

import com.jumpserver.sdk.v2.builder.ClientBuilder;
import com.jumpserver.sdk.v2.builder.JMSClient;
import com.jumpserver.sdk.v2.common.ActionResponse;
import com.jumpserver.sdk.v2.model.Org;
import com.jumpserver.sdk.v2.model.OrgUsers;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author yankaijun
 * @date 2018/10/26 12:00 PM
 */
public class JmsOrgServiceTest {
    private JMSClient os;
    private String orgId;

    @Before
    public void before() {
        os = new ClientBuilder()
                .endpoint("http://localhost:8088")
                .credentials("admin", "admin")
                .authenticate();
        System.out.println(os.getToken().getToken());
        orgId = "3de08ad8-6478-4c11-8c1e-4211151d9e32";
    }

    @Test
    public void Org() {
        List<Org> list = os.orgs().listOrg();
        System.out.println(list.size());
        for (Org object : list) {
            System.out.println(object.getId());
            System.out.println(object.getName());
        }
    }

    @Test
    public void addOrg() {
        Org object = new Org();
        object.setName("aadwa");
        Org objectBack = os.orgs().createOrg(object);
        System.out.println(objectBack.getId());
    }

    @Test
    public void updateOrg() {
        Org object = new Org();
        object.setId(orgId);
        object.setName("API");
        Org objectBack = os.orgs().updateOrg(object);
        System.out.println(objectBack.getId());
        System.out.println(objectBack.getName());
    }

    @Test
    public void deleteOrg() {
        ActionResponse delete = os.orgs().deleteOrg(orgId);
        System.out.println(delete);
    }

    @Test
    public void getOrg() {
        Org object = os.orgs().getOrg(orgId);
        System.out.println(object.getName());
    }

    @Test
    public void getOrgUses() {
        List<OrgUsers> object = os.orgs().getOrgUsers(orgId);
        for (OrgUsers users : object) {
            System.out.println(users.getUser());
        }
    }

    @Test
    public void deleteOrgUses() {
        String userId = "c45596ad-50d4-410e-acf1-3785a675fd9d";
        ActionResponse actionResponse = os.orgs().deleteOrgUsers(orgId, userId);
        System.out.println(actionResponse.toString());
    }

    @Test
    public void createOrgUsers() {
        OrgUsers object = new OrgUsers();
        object.setOrgId(orgId);
        object.setUser("0e049ec7-d905-466b-bcfb-5a66334cae0c1");
        OrgUsers objectBack = os.orgs().createOrgUsers(object);
        System.out.println(objectBack.getUser());
    }

    @Test
    public void getOrgAdmins() {
        List<OrgUsers> object = os.orgs().getOrgAdmins(orgId);
        for (OrgUsers users : object) {
            System.out.println(users.getUser());
        }
    }

    @Test
    public void createOrgAdmins() {
        OrgUsers object = new OrgUsers();
        object.setOrgId(orgId);
        object.setUser("0e049ec7-d905-466b-bcfb-5a66334cae0c");
        OrgUsers objectBack = os.orgs().createOrgAdmins(object);
        System.out.println(objectBack.getUser());
    }

    @Test
    public void deleteOrgAdmins() {
        String userId = "c45596ad-50d4-410e-acf1-3785a675fd9d";
        ActionResponse actionResponse = os.orgs().deleteOrgAdmins(orgId, userId);
        System.out.println(actionResponse.toString());
    }

}
