package jms;

import com.jumpserver.sdk.v2.common.ActionResponse;
import com.jumpserver.sdk.v2.builder.ClientBuilder;
import com.jumpserver.sdk.v2.builder.JMSClient;
import com.jumpserver.sdk.v2.model.User;
import com.jumpserver.sdk.v2.model.UserGroup;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JmsUserServiceTest {

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
    public void users() {
        List<User> users = os.users().list();
        System.out.println(users.size());
        for (User user : users) {
            System.out.println(user.getName());
            System.out.println(user.getEmail());
        }
    }

    @Test
    public void getByName() {
        List<User> users = os.users().getByName("user01");
        System.out.println(users.size());
        for (User user : users) {
            System.out.println(user.getName());
            System.out.println(user.getEmail());
        }
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setGroups(new String[]{"570cd13a-84dd-4710-9385-99ea3ad698c9"});
        user.setName("bbb");
        user.setUsername("bbb");
        user.setEmail("bbb@fit2cloud.com");
        User user1 = os.users().create(user);
        System.out.println(user1.getId());
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId("f026e86d-e1d0-4b14-a461-26bb8912f369");
        user.setName("aaa");
        user.setUsername("aaa");
        user.setEmail("aaa@fit2cloud.com");
        User user1 = os.users().update(user);
        System.out.println(user1.getEmail());
        System.out.println(user1.getName());
        System.out.println(user1.getUsername());
    }

    @Test
    public void deleteUser() {
        ActionResponse delete = os.users().delete("7669b178-0fcb-4996-846d-2cea15ea50b8");
        System.out.println(delete.toString());
    }

    @Test
    public void changePassword() {
        ActionResponse admin = os.users().changePassword("a7342559-507b-4aaa-bef7-38edf2d98d3b", "admin123");
        System.out.println(admin);
    }

    @Test
    public void userGroups() {
        List<UserGroup> usergroups = os.users().userGroups();
        System.out.println(usergroups.size());
        for (UserGroup usergroup : usergroups) {
            System.out.println(usergroup.getName());
        }
    }

    @Test
    public void addUserGroups() {
        UserGroup usergroup = new UserGroup();
        usergroup.setName("孤狼B组");
        UserGroup userGroupBack = os.users().createUserGroup(usergroup);
        System.out.println(userGroupBack.getId());
        System.out.println(userGroupBack.getName());
    }

    @Test
    public void updateUserGroups() {
        UserGroup usergroup = new UserGroup();
        usergroup.setName("孤狼A组");
        usergroup.setId("90b20128-c92c-4d69-9a18-68d9636b7ac1");
        UserGroup userGroupBack = os.users().updateUserGroup(usergroup);
        System.out.println(userGroupBack.getId());
        System.out.println(userGroupBack.getName());
    }

    @Test
    public void deleteUserGroups() {
        ActionResponse actionResponse = os.users().deleteUserGroup("90b20128-c92c-4d69-9a18-68d9636b7ac1");
        System.out.println(actionResponse);
    }

}
