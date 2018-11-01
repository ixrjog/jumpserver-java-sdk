package jms;

import com.jumpserver.sdk.v2.builder.ClientBuilder;
import com.jumpserver.sdk.v2.builder.JMSClient;
import com.jumpserver.sdk.v2.common.ActionResponse;
import com.jumpserver.sdk.v2.model.Org;
import com.jumpserver.sdk.v2.model.OrgUsers;
import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author yankaijun
 * @date 2018/10/26 12:00 PM
 */
public class JmsOrgServiceTest {
    private JMSClient os;

    @Before
    public void before() {
        os = new ClientBuilder()
                .endpoint("http://localhost:8088")
                .credentials("admin", "admin")
                .authenticate();
        System.out.println(os.getToken().getToken());
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
        object.setId("7c6955bc-f004-4573-b46a-4072b0dd0d03");
        object.setName("API");
        Org objectBack = os.orgs().updateOrg(object);
        System.out.println(objectBack.getId());
        System.out.println(objectBack.getName());
    }

    @Test
    public void deleteOrg() {
        ActionResponse delete = os.orgs().deleteOrg("6818cdee-0662-4bd5-abbc-7cdc4c65a5d4");
        System.out.println(delete);
    }

    @Test
    public void getOrg() {
        Org object = os.orgs().getOrg("6818cdee-0662-4bd5-abbc-7cdc4c65a5d4");
        System.out.println(object.getName());
    }

    @Test
    public void getOrgUses() {
        OrgUsers object = os.orgs().getOrgUsers("2ef813af-ac80-4c8c-8d36-2ac2803a0261");
        System.out.println(StringUtils.join(object.getUsers(), ","));
    }

    @Test
    public void createOrgUsers() {
        OrgUsers object = new OrgUsers();
        object.setOrgId("2ef813af-ac80-4c8c-8d36-2ac2803a0261");
        object.setUsers(new String[]{"6dab8bc7-4a7c-4ce2-8240-e22495f9795a"});
        OrgUsers objectBack = os.orgs().createOrgUsers(object);
        System.out.println(StringUtils.join(objectBack.getUsers()));
    }

    @Test
    public void updateOrgUses() {
        OrgUsers object = new OrgUsers();
        object.setOrgId("2ef813af-ac80-4c8c-8d36-2ac2803a0261");
        object.setUsers(new String[]{"6dab8bc7-4a7c-4ce2-8240-e22495f9795a"});
        OrgUsers objectBack = os.orgs().updateOrgUsers(object);
        System.out.println(StringUtils.join(objectBack.getUsers()));
    }

    @Test
    public void getOrgAdmins() {
        OrgUsers object = os.orgs().getOrgAdmins("2ef813af-ac80-4c8c-8d36-2ac2803a0261");
        System.out.println(StringUtils.join(object.getUsers()));
    }

    @Test
    public void createOrgAdmins() {
        OrgUsers object = new OrgUsers();
        object.setOrgId("5f3e3f73-2954-426a-bf3e-885072616abb");
        object.setAdmins(new String[]{"6dab8bc7-4a7c-4ce2-8240-e22495f9795a"});
        OrgUsers objectBack = os.orgs().createOrgAdmins(object);
        System.out.println(StringUtils.join(objectBack.getAdmins(), ","));
    }

    @Test
    public void updateOrgAdmins() {
        OrgUsers object = new OrgUsers();
        object.setOrgId("5f3e3f73-2954-426a-bf3e-885072616abb");
        object.setAdmins(new String[]{"6dab8bc7-4a7c-4ce2-8240-e22495f9795a"});
        OrgUsers objectBack = os.orgs().updateOrgAdmins(object);
        System.out.println(StringUtils.join(objectBack.getAdmins(), ","));
    }

}
