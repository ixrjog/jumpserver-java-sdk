package com.jumpserver.sdk.service;

import com.jumpserver.sdk.base.ApiConstants;
import com.jumpserver.sdk.model.*;

import java.util.Map;

public class JmsAssetsService extends JmsBaseService {

    public JmsAssetsService(String url, String username, String password) {
        super(url, username, password);
    }

    //资产
    public Map<String, String> addAsset(Asset asset) {
        return super.add(asset,ApiConstants.ASSETS);
    }

    public Map<String, String> updateAsset(Asset asset) {
        return super.update(asset,ApiConstants.ASSETS,asset.getId());
    }

    public Map<String, String> deleteAsset(Asset asset) {
        return super.delete(asset,ApiConstants.ASSETS,asset.getId());
    }

    public Map<String, String> queryAsset(String id) {
        return super.query(id, ApiConstants.ASSETS);
    }

    //资产组
    public Map<String, String> addAssetGroups(Assetgroup assetgroup) {
        return super.add(assetgroup, ApiConstants.ASSETGROUPS);
    }

    public Map<String, String> updateAssetGroups(Assetgroup assetgroup) {
        return  super.update(assetgroup,ApiConstants.ASSETGROUPS,assetgroup.getId());
    }

    public Map<String, String> deleteAssetGroups(Assetgroup assetgroup) {
        return  super.delete(assetgroup,ApiConstants.ASSETGROUPS,assetgroup.getId());
    }

    public Map<String, String> queryAssetGroups(String id) {
        return super.query(id, ApiConstants.ASSETGROUPS);
    }

    // 集群
    public Map<String, String> addAssetCluster(AssetsCluster assetsCluster) {
        return super.add(assetsCluster, ApiConstants.CLUSTERS);
    }

    public Map<String, String> updateAssetCluster(AssetsCluster assetsCluster) {
        return super.update(assetsCluster, ApiConstants.CLUSTERS, assetsCluster.getId());
    }

    public Map<String, String> deleteAssetCluster(AssetsCluster assetsCluster) {
        return super.delete(assetsCluster, ApiConstants.CLUSTERS, assetsCluster.getId());
    }

    public Map<String, String> queryAssetCluster(String id) {
        return super.query(id, ApiConstants.CLUSTERS);
    }

    //管理用户
    public Map<String, String> addAdminUser(AdminUser adminUser) {
        return super.add(adminUser, ApiConstants.ADMIN_USERS);
    }

    public Map<String, String> updateAdminUser(AdminUser adminUser) {
        return super.update(adminUser, ApiConstants.ADMIN_USERS, adminUser.getId());
    }

    public Map<String, String> deleteAdminUser(AdminUser adminUser) {
        return super.delete(adminUser, ApiConstants.ADMIN_USERS, adminUser.getId());
    }

    public Map<String, String> queryAdminUser(String id) {
        return super.query(id, ApiConstants.ADMIN_USERS);
    }

    //系统用户
    public Map<String, String> addSystemUser(SystemUser systemUser) {
        return super.add(systemUser, ApiConstants.SYSTEM_USERS);
    }

    public Map<String, String> updateSystemUser(SystemUser systemUser) {
        return super.update(systemUser, ApiConstants.SYSTEM_USERS, systemUser.getId());
    }

    public Map<String, String> deleteSystemUser(SystemUser systemUser) {
        return super.delete(systemUser, ApiConstants.SYSTEM_USERS, systemUser.getId());
    }

    public Map<String, String> querySystemUser(String id) {
        return super.query(id, ApiConstants.SYSTEM_USERS);
    }

    //标签
    public Map<String, String> addAssetsLabel(AssetsLabel assetsLabel) {
        return super.add(assetsLabel, ApiConstants.LABLES);
    }

    public Map<String, String> updateAssetsLabel(AssetsLabel assetsLabel) {
        return super.update(assetsLabel, ApiConstants.LABLES, assetsLabel.getId());
    }

    public Map<String, String> deleteAssetsLabel(AssetsLabel assetsLabel) {
        return super.delete(assetsLabel, ApiConstants.LABLES, assetsLabel.getId());
    }

    public Map<String, String> queryAssetsLabel(String id) {
        return super.query(id, ApiConstants.LABLES);
    }

}
