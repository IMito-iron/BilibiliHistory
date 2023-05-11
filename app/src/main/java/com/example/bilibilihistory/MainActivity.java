package com.example.bilibilihistory;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.bilibilihistory.util.FileManagementUtil;

public class MainActivity extends AppCompatActivity {

    /**
     * 定义所需权限列表
     * READ_EXTERNAL_STORAGE  读取权限
     * WRITE_EXTERNAL_STORAGE  写入权限
     */
    String[] permissions = new String[] {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();


    }


    /**
     * 获取权限
     * 创建空文件
     */
    private void initialization() {
        //获取权限
        chkPermissions();

        //创建文件
        FileManagementUtil FileManagementUtil = new FileManagementUtil();
        String fileDir = String.valueOf(getExternalCacheDir());
        if (!FileManagementUtil.checkFileExist(this)) {
            showToast("文件不存在 正在创建储存文件");
            FileManagementUtil.createTestFile(this);
            showToast("正在尝试向"+fileDir+"创建文件");
        } else {
            showToast("在"+fileDir+"已经存在文件");
        }



    }

    /**
     * 申请权限
     */
    private void chkPermissions() {
        // 如果系统大于6.0 进行动态权限申请
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int i = ContextCompat.checkSelfPermission(this, permissions[0]);
            int j = ContextCompat.checkSelfPermission(this, permissions[1]);
            // 权限是否已经获取 GRANTED————获取 DINIED————拒绝 判断权限列表中的权限是否有权限还没拥有
            if (i != PackageManager.PERMISSION_GRANTED ||
                    j != PackageManager.PERMISSION_GRANTED) {
                // 如果有权限没有授予，提示用户请求权限
                startRequestPermission();
            }
        }
    }

    /**
     * 通过权限列表，提示用户赋予或禁止当前还未拥有的权限
     */
    private void startRequestPermission() {
        ActivityCompat.requestPermissions(this, permissions, 321);
    }

    /**
     * 重写onRequestPermissionsResult，用户选择后回调
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 321) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // 如果用户选择禁止，此时程序没有相应权限，执行相应操作
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    //如果没有获取权限，提示用户去设置界面开启权限
                    showToast("请在设置界面获取权限");
                }
            }
        }//
    }

    /**
     *  显示Toast
     * @param str Toast内容
     */
    private void showToast(String str) {
        Toast toast = Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}