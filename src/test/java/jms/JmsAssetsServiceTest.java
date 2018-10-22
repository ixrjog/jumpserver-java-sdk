package jms;

import com.jumpserver.sdk.service.JmsAssetsService;
import com.jumpserver.sdk.v2.builder.ClientBuilder;
import com.jumpserver.sdk.v2.builder.JMSClient;
import com.jumpserver.sdk.v2.common.ActionResponse;
import com.jumpserver.sdk.v2.model.*;
import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class JmsAssetsServiceTest {

    private JMSClient os;
    JmsAssetsService jmsAssetsService;

    @Before
    public void token() {
        os = new ClientBuilder()
                .endpoint("http://localhost:8088")
                .credentials("admin", "admin")
                .header("x-jms-org", "7c6955bc-f004-4573-b46a-4072b0dd0d03")
                .authenticate();
        System.out.println(os.getToken().getToken());
    }

    //=========================== 资产 =============================
    @Test
    public void assets() {
        List<Asset> assetList = os.assets().list();
        System.out.println(assetList.size());
        for (Asset asset : assetList) {
            System.out.println(asset.getId());
            System.out.println(asset.getHostname());
            System.out.println(StringUtils.join(asset.getNodes()));
        }
    }

    @Test
    public void addAsset() {
        Asset asset = new Asset();
        asset.setIp("192.168.20.102");
        asset.setHostname("欧洲十国游");
        Asset assetnew = os.assets().create(asset);
        System.out.println(assetnew.getId());
    }

    @Test
    public void updateAsset() {
        Asset asset = new Asset();
        asset.setId("86bff1f5-91c9-471b-a980-6cfcc8da944d");
        asset.setIp("192.168.20.102");
        asset.setHostname("欧洲十国游");
        Asset assetnew = os.assets().update(asset);
        System.out.println(assetnew.getId());
    }

    @Test
    public void deleteAsset() {
        ActionResponse delete = os.assets().delete("ceaaae1b-9432-4d50-afe5-586e47f319c0");
        System.out.println(delete);
    }

    @Test
    public void getAsset() {
        Asset asset = os.assets().get("ceaaae1b-9432-4d50-afe5-586e47f319c0");
        System.out.println(asset.getHostname());
        System.out.println(asset.getAdmin_user());
    }

    //=========================== 资产树 =============================
    //System.out.println(StringUtils.join(object.getNodes()));
    @Test
    public void AssetsNodes() {
        List<AssetsNode> list = os.assets().listAssetsNode();
        System.out.println(list.size());
        for (AssetsNode object : list) {
            System.out.println(object.getId());
            System.out.println(object.getTree_parent());
            System.out.println(object.getValue());
            System.out.println(object.getIs_node());
        }
    }

    @Test
    public void getAssetsNode() {
        AssetsNode object = os.assets().getAssetsNode("b3bc1599-8740-4f44-8cc6-e84a90afc2e8");
        System.out.println(object.getValue());
    }

    @Test
    public void addAssetsNode() {
        AssetsNode object = new AssetsNode();
        object.setValue("演示工作空间-son");
        AssetsNode objectBack = os.assets().createAssetsNode(object);
        System.out.println(objectBack.getId());
    }

    @Test
    public void updateAssetsNode() {
        AssetsNode object = new AssetsNode();
        object.setId("936681df-bbe7-4034-85bf-9336fcb5cf46");
        object.setValue("docker_tmp");
        AssetsNode objectBack = os.assets().updateAssetsNode(object);
        System.out.println(objectBack.getId());
    }

    @Test
    public void deleteAssetsNode() {
        ActionResponse delete = os.assets().deleteAssetsNode("97a53cdb-7600-45e4-908b-c9a90095dae9");
        System.out.println(delete);
    }









    @Test
    public void node2() {

    }

    @Test
    public void node3() {

    }

    @Test
    public void node4() {

    }

    @Test
    public void nodeChildren() {
    }

    @Test
    public void nodeChildren2() {
    }

    @Test
    public void nodeChildren3() {
    }

    @Test
    public void nodeAseets1() {
    }

    @Test
    public void nodeAseets2() {
    }

    //管理用户
    @Test
    public void au1() {
    }

    @Test
    public void au2() {
    }

    @Test
    public void au3() {
    }

    @Test
    public void au4() {
        AdminUser adminUser = new AdminUser();
        adminUser.setId("792732ce-9cd0-4cb9-af25-37cb843356f1");
        adminUser.setPassword("pssswofdd");
        adminUser.setPrivate_key("-----BEGIN RSA PRIVATE KEY-----\n" +
                "MIIEowIBAAKCAQEAjcSD0EGmfTyexO4jDMF8Orw/eXM4t+rSzXDmzP1n8iqahhVV\n" +
                "cHb/6keBgdbf2bFTZUpJJDHTLTNMzmCqfdOV//qDQ5gyO8ntz8VAPneqpB05qEgz\n" +
                "krTkpALEP/YmDKIXVp/iwdKf2kMI1neWWQ19eI0HIaxIZ9qhzbCAf49MyITEeif9\n" +
                "dN0kABF7MFpoFb258+u2I7zl92YkBTdzZieJsXjrTxqV9OmvacqS+U5F9SlYU+O3\n" +
                "nG1wjhPaq7nwmki9vLrfhpQpLs2I+imRl/KJxwiuzSMlkxUVfjEmlmntvDTptv3L\n" +
                "k5A+XD0aDeJNTdwfAlWQyhWZiWt555Pw1RGl1QIDAQABAoIBAQCK8mWi8wVjz8tp\n" +
                "BmHx+Z1xz9mChoy7rfroglSj62Y6ssj6y+QOs4OGMolbIagKrEMpjpJ7WB47OgF4\n" +
                "cMQJSRzGY9jNoljxwqtDrXeXAiCMc1x0dDef/Y3utgt1CSMn1KJ9M33DLFWiTXtX\n" +
                "AKSqKY+lXMv1k+7vYxidCfYXj/LYv9XdBaI/dLDembFfayyudIQ6CaV6uVRHVV8W\n" +
                "4cQxsY4yw16Y6Mebpfrs5EJLH9l1cUX0bA/qdL1pr+N7B2a5j1RAndCn5SFGiD3N\n" +
                "axZYRl6gdn0Ea5t76SueKpQXzE1JjAFjpilB8a0iveuCnwRXflAf7RjX5S4UuW9p\n" +
                "KbH8hR2hAoGBAN8UusO1lzQBCG2OJ6xazSFfUMV63fuXGPYUrQpDdb9WN7/aEpEF\n" +
                "elZZt+30wwE+8NkoWzDYoNbIu7DKmrMnyrHy6iW13BQKpUOo5Fv466VbrNCEvTzI\n" +
                "3S7Cdsuao+X30g76due4FFSASjR5XuA/oMmFWU76sEC9fGjJwH8YXMSdAoGBAKKw\n" +
                "CHac+3ab5urqYJDpXrhqFJ99W6IrHM5NgsIcGXkx1ciEKKNxy0RXvTsXARXMJFcu\n" +
                "TJZYlkBFYIdJo1QAU+mFdLg/BbkmRYPUy8O48A9NzVA4ae1V1eBFgGfEdyAROKPv\n" +
                "9BfGot4MaohA9JokM3//G1U2J1g9MQOkppM13XSZAoGAe2o7fQScdx/PKtUHa9n8\n" +
                "PGdAB1DXOFY6cAG2TcROgyFOzGv385VFPjp6gEH2FF1e37Ts5lQif1EkTUV5Wn48\n" +
                "LECIe35mGAxfq9PnKl7G93+FVwLospUpkLHzCOcvn41//9tfJwj27lzfMLKo44Uw\n" +
                "De0hIImeMuLhzhM31NiEkh0CgYBiooOfFnJHaSJJzywY78Sj3nz+bYx+99CRK+FZ\n" +
                "OpwfJJ3O4oGZBscMen2aM8pOouRtjv6UMMV31hg+LeE+bqxxap5njp4zsQZ4dS3N\n" +
                "TnUNckhGmM1wPZhcTwcY4r6uzIIgsry1JZNdOP3l+ivSwJwQwGSb9ydHkmIDKXJs\n" +
                "0j2gEQKBgFXM7mldHEhiTDFByjzRZV9GHcZTi+6V+5ckzA9j3aCzTvKEYOg6U4b3\n" +
                "0znw0cNna5ACZZ7hKWwFXXGqjoJmn6KmwMhRM/l0g6BqBi7Cpkfaqyl3SgvLA0zu\n" +
                "ipUckOJc2ik7ZwLqe3IzjK0kaxcN1sr0zmWtLF+Hcdy7RwMkZF25\n" +
                "-----END RSA PRIVATE KEY-----");
        Map<String, String> map = jmsAssetsService.updateAdminUserAuth(adminUser);
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

    @Test
    public void su3() {
        Map<String, String> map = jmsAssetsService.querySystemUserAuthInfo("8caf675e-d341-48e3-b00f-24206fb3c208");
        System.out.println(map);
    }

    @Test
    public void su4() {
        SystemUser systemUser = new SystemUser();
        systemUser.setId("ece3101e-317e-459e-a315-c92283c4d146");
        systemUser.setUsername("username");
        systemUser.setPassword("password");
        systemUser.setPrivate_key("-----BEGIN RSA PRIVATE KEY-----\n" +
                "MIIEowIBAAKCAQEAjcSD0EGmfTyexO4jDMF8Orw/eXM4t+rSzXDmzP1n8iqahhVV\n" +
                "cHb/6keBgdbf2bFTZUpJJDHTLTNMzmCqfdOV//qDQ5gyO8ntz8VAPneqpB05qEgz\n" +
                "krTkpALEP/YmDKIXVp/iwdKf2kMI1neWWQ19eI0HIaxIZ9qhzbCAf49MyITEeif9\n" +
                "dN0kABF7MFpoFb258+u2I7zl92YkBTdzZieJsXjrTxqV9OmvacqS+U5F9SlYU+O3\n" +
                "nG1wjhPaq7nwmki9vLrfhpQpLs2I+imRl/KJxwiuzSMlkxUVfjEmlmntvDTptv3L\n" +
                "k5A+XD0aDeJNTdwfAlWQyhWZiWt555Pw1RGl1QIDAQABAoIBAQCK8mWi8wVjz8tp\n" +
                "BmHx+Z1xz9mChoy7rfroglSj62Y6ssj6y+QOs4OGMolbIagKrEMpjpJ7WB47OgF4\n" +
                "cMQJSRzGY9jNoljxwqtDrXeXAiCMc1x0dDef/Y3utgt1CSMn1KJ9M33DLFWiTXtX\n" +
                "AKSqKY+lXMv1k+7vYxidCfYXj/LYv9XdBaI/dLDembFfayyudIQ6CaV6uVRHVV8W\n" +
                "4cQxsY4yw16Y6Mebpfrs5EJLH9l1cUX0bA/qdL1pr+N7B2a5j1RAndCn5SFGiD3N\n" +
                "axZYRl6gdn0Ea5t76SueKpQXzE1JjAFjpilB8a0iveuCnwRXflAf7RjX5S4UuW9p\n" +
                "KbH8hR2hAoGBAN8UusO1lzQBCG2OJ6xazSFfUMV63fuXGPYUrQpDdb9WN7/aEpEF\n" +
                "elZZt+30wwE+8NkoWzDYoNbIu7DKmrMnyrHy6iW13BQKpUOo5Fv466VbrNCEvTzI\n" +
                "3S7Cdsuao+X30g76due4FFSASjR5XuA/oMmFWU76sEC9fGjJwH8YXMSdAoGBAKKw\n" +
                "CHac+3ab5urqYJDpXrhqFJ99W6IrHM5NgsIcGXkx1ciEKKNxy0RXvTsXARXMJFcu\n" +
                "TJZYlkBFYIdJo1QAU+mFdLg/BbkmRYPUy8O48A9NzVA4ae1V1eBFgGfEdyAROKPv\n" +
                "9BfGot4MaohA9JokM3//G1U2J1g9MQOkppM13XSZAoGAe2o7fQScdx/PKtUHa9n8\n" +
                "PGdAB1DXOFY6cAG2TcROgyFOzGv385VFPjp6gEH2FF1e37Ts5lQif1EkTUV5Wn48\n" +
                "LECIe35mGAxfq9PnKl7G93+FVwLospUpkLHzCOcvn41//9tfJwj27lzfMLKo44Uw\n" +
                "De0hIImeMuLhzhM31NiEkh0CgYBiooOfFnJHaSJJzywY78Sj3nz+bYx+99CRK+FZ\n" +
                "OpwfJJ3O4oGZBscMen2aM8pOouRtjv6UMMV31hg+LeE+bqxxap5njp4zsQZ4dS3N\n" +
                "TnUNckhGmM1wPZhcTwcY4r6uzIIgsry1JZNdOP3l+ivSwJwQwGSb9ydHkmIDKXJs\n" +
                "0j2gEQKBgFXM7mldHEhiTDFByjzRZV9GHcZTi+6V+5ckzA9j3aCzTvKEYOg6U4b3\n" +
                "0znw0cNna5ACZZ7hKWwFXXGqjoJmn6KmwMhRM/l0g6BqBi7Cpkfaqyl3SgvLA0zu\n" +
                "ipUckOJc2ik7ZwLqe3IzjK0kaxcN1sr0zmWtLF+Hcdy7RwMkZF25\n" +
                "-----END RSA PRIVATE KEY-----");
        Map<String, String> map = jmsAssetsService.updateSystemUserAuthInfo(systemUser);
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
