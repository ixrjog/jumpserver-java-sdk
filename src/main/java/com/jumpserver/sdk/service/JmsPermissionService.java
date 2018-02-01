package com.jumpserver.sdk.service;

import com.jumpserver.sdk.base.ApiConstants;
import com.jumpserver.sdk.model.Assetpermission;

import java.util.Map;

public class JmsPermissionService extends JmsBaseService{

    public JmsPermissionService(String url, String username, String password) {
        super(url, username, password);
    }

    //资产授权规则
    public Map<String, String> addAssetpermission(Assetpermission assetpermission) {
        return super.add(assetpermission, ApiConstants.ASSET_PERMISSIONS);
    }

    public Map<String, String> updateAssetpermission(Assetpermission assetpermission) {
        return super.update(assetpermission,ApiConstants.ASSET_PERMISSIONS,assetpermission.getId());
    }

    public Map<String, String> deleteAssetpermission(Assetpermission assetpermission) {
        return super.delete(assetpermission,ApiConstants.ASSET_PERMISSIONS,assetpermission.getId());
    }
}
