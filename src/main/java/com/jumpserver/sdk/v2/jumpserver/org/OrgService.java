package com.jumpserver.sdk.v2.jumpserver.org;

import com.jumpserver.sdk.v2.common.ActionResponse;
import com.jumpserver.sdk.v2.model.Org;
import com.jumpserver.sdk.v2.model.OrgUsers;
import com.jumpserver.sdk.v2.model.User;

import java.util.List;

public interface OrgService {

    List<Org> listOrg();

    Org getOrg(String orgId);

    Org updateOrg(Org org);

    Org createOrg(Org org);

    ActionResponse deleteOrg(String orgId);

    OrgUsers getOrgUsers(String orgId);

    OrgUsers updateOrgUsers(OrgUsers orgusers);

    OrgUsers createOrgUsers(OrgUsers orgusers);

    OrgUsers getOrgAdmins(String orgId);

    OrgUsers updateOrgAdmins(OrgUsers orgusers);

    OrgUsers createOrgAdmins(OrgUsers orgusers);

}
