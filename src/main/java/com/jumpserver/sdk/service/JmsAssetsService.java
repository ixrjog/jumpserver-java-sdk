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
        return super.add(asset, ApiConstants.ASSETS);
    }

    public Map<String, String> updateAsset(Asset asset) {
        return super.update(asset, ApiConstants.ASSETS, asset.getId());
    }

    public Map<String, String> deleteAsset(Asset asset) {
        return super.delete(asset, ApiConstants.ASSETS, asset.getId());
    }

    public Map<String, String> queryAsset(String id) {
        return super.query(id, ApiConstants.ASSETS);
    }

    //资产树
    public Map<String, String> addAssetsNodes(AssetsNodes assetsNodes) {
        return super.add(assetsNodes, ApiConstants.NODES);
    }

    public Map<String, String> updateAssetsNodes(AssetsNodes assetsNodes) {
        return super.update(assetsNodes, ApiConstants.NODES, assetsNodes.getId());
    }

    public Map<String, String> deleteAssetsNodes(AssetsNodes assetsNodes) {
        return super.delete(assetsNodes, ApiConstants.NODES, assetsNodes.getId());
    }

    public Map<String, String> queryAllAssetsNodes() {
        return super.query(null, ApiConstants.NODES);
    }

    //资产树下级
    public Map<String, String> addAssetsNodesChildren(String parentId, AssetsNodes assetsNodes) {
        String url = ApiConstants.NODES_CHILDREN.replaceAll("\\{" + "id" + "\\}", parentId);
        return super.add(assetsNodes, url);
    }

    public Map<String, String> queryAssetsNodesChildren(String parentId) {
        return super.query(parentId, ApiConstants.NODES_CHILDREN);
    }

    //资产树资产
    public Map<String, String> addAssetsNodesAsset(AssetsNodes assetsNodes, String nodeId) {
        return super.updateX(assetsNodes, ApiConstants.NODES_ASSETS_ADD, nodeId);
    }

    public Map<String, String> removeAssetsNodesAsset(AssetsNodes assetsNodes, String nodeId) {
        return super.updateX(assetsNodes, ApiConstants.NODES_ASSETS_REMOVE, nodeId);
    }

    //管理用户
    public Map<String, String> addAdminUser(AdminUser adminUser) {
        return super.add(adminUser, ApiConstants.ADMIN_USERS);
    }

    public Map<String, String> updateAdminUser(AdminUser adminUser) {
        return super.update(adminUser, ApiConstants.ADMIN_USERS, adminUser.getId());
    }

    public Map<String, String> updateAdminUserCluster(AdminUser adminUser) {
        return super.updateX(adminUser, ApiConstants.ADMIN_USERS_CLUSTER, adminUser.getId());
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


    public Map<String, String> systemUserPush(String id) {
        return super.query(id, ApiConstants.SYSTEM_USERS_PUSH);
    }

}
