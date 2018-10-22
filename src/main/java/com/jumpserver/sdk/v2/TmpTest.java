package com.jumpserver.sdk.v2;

import java.io.*;

/**
 * @author yankaijun
 * @date 2018/10/22 下午3:45
 */
public class TmpTest {

    public static void main(String[] args) throws IOException {

        String targetObj = "AdminUser";
        String targetObjId = "userId";

//        File file = new File("/Users/yankaijun/sources/CMB/jumpserver-java-sdk/src/main/java/com/jumpserver/sdk/v2/jumpserver/1.tmp");
        File file = new File("/Users/yankaijun/sources/CMB/jumpserver-java-sdk/src/main/java/com/jumpserver/sdk/v2/jumpserver/2.tmp");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuffer buffer = new StringBuffer();
        String s = bufferedReader.readLine();
        buffer.append(s);
        while ((s = bufferedReader.readLine()) != null) {
            buffer.append(s);
            buffer.append("\n");

        }
        String target = buffer.toString();
        target = target.replace("Asset", targetObj)
                .replace("assetId", targetObjId)
                .replace("${xx}", targetObj)
                .replace("ASSETS", targetObj.toUpperCase());

        if (!file.getName().equalsIgnoreCase("2.tmp")) {
            target = target.replace("asset", targetObj.toLowerCase());
        }
        System.out.println(target);
    }
}
