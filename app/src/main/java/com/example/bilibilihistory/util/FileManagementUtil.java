package com.example.bilibilihistory.util;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileManagementUtil implements FileManagementItf {

    //输出文件名
    private String fileName = "output.html";

    @Override
    public boolean checkFileExist(Context context) {
        // 检查文件是否存在 如果存在返回true 反之
        String fileDir = String.valueOf(context.getExternalCacheDir());
        File file = new File(fileDir, fileName);
        return file.exists();
    }

    @Override
    public void createTestFile(Context context) {
        //获取资源id
        int rawFileId = context.getResources().getIdentifier("testfile", "raw", context.getPackageName());
        //获取文件目录
        String fileDir = String.valueOf(context.getExternalCacheDir());
        File file = new File(fileDir, fileName);
        try{
            //通过IOstream逐字节将资源复制到输出文件中
            InputStream inputStream = context.getResources().openRawResource(rawFileId);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int read;
            while ((read = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
