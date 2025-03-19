package com.openlab.util;

/**
 * @author xjx
 * @create$2025-01 19-下午1:41
 */
public class FileUtil {
    public static String getExt(String header) {
        if (header.isEmpty()) {
            throw new RuntimeException("上传文件为空");
        }
        int index = header.lastIndexOf(".");
        String ext = header.substring(index, header.length()-1);
        return ext;
//        header.substring(header.indexOf("filename=")+"filename=".length()+1, header.length()-1);
    }
}
