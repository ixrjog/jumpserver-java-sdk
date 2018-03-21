package jms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jumpserver.sdk.model.*;
import com.jumpserver.sdk.service.JmsAssetsService;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class JmsAssetsServiceTest {

    private JmsAssetsService  jmsAssetsService;

    @Before
    public void getJmsAssetsService() {
        jmsAssetsService= new JmsAssetsService("http://localhost:8080", "admin", "admin");
        String token = jmsAssetsService.getToken();
        System.out.println(token);
    }

    //资产
    @Test
    public void z1() {
        Asset asset = new Asset();
        asset.setHostname("SDK-hostName");
        asset.setIp("192.168.20.101");
        asset.setType("VM");
        Map<String, String> map = jmsAssetsService.addAsset(asset);
        System.out.println(map);
    }

    @Test
    public void z2() {
        Asset asset = new Asset();
        asset.setHostname("SDK-hostName-modify");
        asset.setId("b003bdf1-d820-47e4-8b1b-2802528e3aca");
        Map<String, String> map = jmsAssetsService.updateAsset(asset);
        System.out.println(map);
    }

    @Test
    public void z3() {
        Asset asset = new Asset();
        asset.setId("b003bdf1-d820-47e4-8b1b-2802528e3aca");
        Map<String, String> map = jmsAssetsService.updateAsset(asset);
        System.out.println(map);
    }

    //资产树
    @Test
    public void node1() {
        JmsAssetsService  jmsAssetsService= new JmsAssetsService("http://localhost:8080", "admin", "admin");
        String token = jmsAssetsService.getToken();
        System.out.println(token);
        AssetsNodes assetsNodes = new AssetsNodes();
        assetsNodes.setValue("java");
        Map<String, String> map = jmsAssetsService.addAssetsNodes(assetsNodes);
        System.out.println(map.toString());
    }

    @Test
    public void node2() {
        JmsAssetsService  jmsAssetsService= new JmsAssetsService("http://localhost:8080", "admin", "admin");
        String token = jmsAssetsService.getToken();
        System.out.println(token);
        AssetsNodes assetsNodes = new AssetsNodes();
        assetsNodes.setValue("java-modify");
        assetsNodes.setId("d211fcdd-7f59-4b9f-815f-f2b2e4ec98d4");
        Map<String, String> map = jmsAssetsService.updateAssetsNodes(assetsNodes);
        System.out.println(map.toString());
    }

    @Test
    public void node3() {
        JmsAssetsService  jmsAssetsService= new JmsAssetsService("http://localhost:8080", "admin", "admin");
        String token = jmsAssetsService.getToken();
        System.out.println(token);
        Map<String, String> map = jmsAssetsService.queryAllAssetsNodes();
        System.out.println(map.toString());
    }

    @Test
    public void node4() {
        JmsAssetsService  jmsAssetsService= new JmsAssetsService("http://localhost:8080", "admin", "admin");
        String token = jmsAssetsService.getToken();
        System.out.println(token);
        AssetsNodes assetsNodes = new AssetsNodes();
        assetsNodes.setId("6d9bbc623ea344e1abdf3f75adce9d3f");
        Map<String, String> map = jmsAssetsService.deleteAssetsNodes(assetsNodes);
        System.out.println(map.toString());
    }

    @Test
    public void nodeChildren() {
        JmsAssetsService  jmsAssetsService= new JmsAssetsService("http://localhost:8080", "admin", "admin");
        String token = jmsAssetsService.getToken();
        System.out.println(token);
        Map<String, String> map = jmsAssetsService.queryAssetsNodesChildren("d211fcdd-7f59-4b9f-815f-f2b2e4ec98d4");
        System.out.println(map.toString());
    }

    @Test
    public void nodeChildren2() {
        JmsAssetsService  jmsAssetsService= new JmsAssetsService("http://localhost:8080", "admin", "admin");
        String token = jmsAssetsService.getToken();
        System.out.println(token);
        AssetsNodes assetsNodes = new AssetsNodes();
        assetsNodes.setValue("children");
        Map<String, String> map = jmsAssetsService.addAssetsNodesChildren("d211fcdd-7f59-4b9f-815f-f2b2e4ec98d4",assetsNodes);
        System.out.println(map.toString());
    }

    @Test
    public void nodeChildren3() {
        JmsAssetsService  jmsAssetsService= new JmsAssetsService("http://localhost:8080", "admin", "admin");
        AssetsNodes assetsNodes = new AssetsNodes();
        assetsNodes.setNodes(new String[]{"0e321c37-dd1a-446d-924b-773852f29cbf"});
        Map<String, String> map = jmsAssetsService.updateAssetsNodesChildren("af034e7e-a74c-4b2a-b473-21208eb0a48d",assetsNodes);
        System.out.println(map.toString());
    }

    @Test
    public void nodeAseets1() {
        JmsAssetsService  jmsAssetsService= new JmsAssetsService("http://localhost:8080", "admin", "admin");
        String token = jmsAssetsService.getToken();
        System.out.println(token);
        String [] ass = {"47cc75f8-2218-4ac3-9575-686f69989ce5"};
        AssetsNodes assetsNodes = new AssetsNodes();
        assetsNodes.setAssets(ass);
        assetsNodes.setValue("addAssetsNodesAsset");
        Map<String, String> map = jmsAssetsService.addAssetsNodesAsset(assetsNodes,"894daf04d7cc47928c7ad3d8ae82bcd0");
        System.out.println(map.toString());
    }

    @Test
    public void nodeAseets2() {
        JmsAssetsService  jmsAssetsService= new JmsAssetsService("http://localhost:8080", "admin", "admin");
        String token = jmsAssetsService.getToken();
        System.out.println(token);
        String [] ass = {"38db393c747f4237838cecd944975362"};
        AssetsNodes assetsNodes = new AssetsNodes();
        assetsNodes.setAssets(ass);
        Map<String, String> map = jmsAssetsService.removeAssetsNodesAsset(assetsNodes,"3e62f4e4-4902-4754-8916-c3b3b0503c19");
        System.out.println(map.toString());
    }



    //管理用户
    @Test
    public void au1() {
        AdminUser adminUser = new AdminUser();
        adminUser.setName("SDK-Name");
        adminUser.setUsername("SDK-Name");
        Map<String, String> map = jmsAssetsService.addAdminUser(adminUser);
        System.out.println(map);
    }

    @Test
    public void au2() {
        AdminUser adminUser = new AdminUser();
        adminUser.setId("e40d3bc6-544f-422d-bcb1-333993a71bd7");
        adminUser.setName("SDK-Name-Modify");
        adminUser.setUsername("SDK-Name-Modify");
        Map<String, String> map = jmsAssetsService.updateAdminUser(adminUser);
        System.out.println(map);
    }

    @Test
    public void au3() {
        AdminUser adminUser = new AdminUser();
        adminUser.setId("e40d3bc6-544f-422d-bcb1-333993a71bd7");
        adminUser.setClusters(new String[]{});
        Map<String, String> map = jmsAssetsService.updateAdminUserCluster(adminUser);
        System.out.println(map);
    }

    //系统用户
    @Test
    public void su1() {
        SystemUser systemUser = new SystemUser();
        systemUser.setName("SDK-Name");
        systemUser.setUsername("SDK-Name");
        Map<String, String> map = jmsAssetsService.addSystemUser(systemUser);
        System.out.println(map);
    }

    @Test
    public void su2() {
        SystemUser systemUser = new SystemUser();
        systemUser.setId("43ce643d-df31-4267-aadb-b9db3afec68b");
        systemUser.setName("SDK-Name-Modify");
        systemUser.setUsername("SDK-Name-Modify");
        Map<String, String> map = jmsAssetsService.updateSystemUser(systemUser);
        System.out.println(map);
    }



    //标签
    @Test
    public void lb1() {
        AssetsLabel assetsLabel = new AssetsLabel();
        assetsLabel.setName("SDK-Name");
        assetsLabel.setValue("SDK_value");
        Map<String, String> map = jmsAssetsService.addAssetsLabel(assetsLabel);
        System.out.println(map);
    }

    @Test
    public void lb2() {
        AssetsLabel assetsLabel = new AssetsLabel();
        assetsLabel.setName("SDK-Name-Modify");
        assetsLabel.setValue("SDK-Name-Value");
        assetsLabel.setId("43ce643d-df31-4267-aadb-b9db3afec68b");
        Map<String, String> map = jmsAssetsService.updateAssetsLabel(assetsLabel);
        System.out.println(map);
    }
    @Test
    public void systemUserPush() {
        Map<String, String> map = jmsAssetsService.systemUserPush("43ce643d-df31-4267-aadb-b9db3afec68b");
        System.out.println(map);
    }



}
