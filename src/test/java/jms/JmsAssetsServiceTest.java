package jms;

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

    //资产组
    @Test
    public void zz1() {
        Assetgroup assetgroup = new Assetgroup();
        assetgroup.setName("SDK-Name");
        Map<String, String> map = jmsAssetsService.addAssetGroups(assetgroup);
        System.out.println(map);
    }

    @Test
    public void zz2() {
        Assetgroup assetgroup = new Assetgroup();
        assetgroup.setId("99028af4-8739-494b-8108-e80b6210bad4");
        assetgroup.setName("SDK-Name-Modify");
        Map<String, String> map = jmsAssetsService.updateAssetGroups(assetgroup);
        System.out.println(map);
    }



    //集群
    @Test
    public void t11() {
        JmsAssetsService  JmsAssetsService= new JmsAssetsService("http://localhost:8080", "admin", "admin");
        String token = JmsAssetsService.getToken();
        System.out.println(token);
        AssetsCluster assetsCluster = new AssetsCluster();
        assetsCluster.setName("SDK资产集群");
        assetsCluster.setAssets(new String[]{});
        Map<String, String> map = JmsAssetsService.addCluster(assetsCluster);
        System.out.println(map.toString());
    }

    @Test
    public void t12() {
        JmsAssetsService  JmsAssetsService= new JmsAssetsService("http://localhost:8080", "admin", "admin");
        String token = JmsAssetsService.getToken();
        System.out.println(token);
        AssetsCluster assetsCluster = new AssetsCluster();
        assetsCluster.setName("SDK资产集群-modify");
        assetsCluster.setId("7533698c-9754-4980-a887-8d90248685cf");
        Map<String, String> map = JmsAssetsService.updateCluster(assetsCluster);
        System.out.println(map.toString());
    }

    @Test
    public void t13() {
        JmsAssetsService  JmsAssetsService= new JmsAssetsService("http://localhost:8080", "admin", "admin");
        String token = JmsAssetsService.getToken();
        System.out.println(token);
        AssetsCluster assetsCluster = new AssetsCluster();
        assetsCluster.setId("7533698c-9754-4980-a887-8d90248685cf");
        Map<String, String> map = JmsAssetsService.deleteCluster(assetsCluster);
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



}
