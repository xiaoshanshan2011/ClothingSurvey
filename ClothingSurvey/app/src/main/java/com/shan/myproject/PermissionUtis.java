package com.shan.myproject;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

/**
 * Created by chenjunshan on 17-5-18.
 */

public class PermissionUtis {
    public static final int REQUESTCODE = 0;
    public static final int REQUESTCODEDOWNLOAD = 1;

    /**
     * 检查是否授权
     * @param context
     * @param permissions
     * @return
     */
    public static boolean checkPermissions(Context context, String... permissions) {
        return new PermissionsChecker(context).lacksPermissions(permissions);
    }


    /**
     * 请求授权
     * @param activity
     * @param requestCode
     * @param permissions
     */
    public static void requestPermissions(Activity activity, int requestCode, String... permissions) {
        if (checkPermissions(activity,permissions)){
            ActivityCompat.requestPermissions(activity, permissions, requestCode);
        }
    }

    /**
     * 检查所有权限是否授权
     * @param grantResults
     * @return
     */
    public static boolean hasAllPermissionsGranted(@NonNull int[] grantResults) {
        for (int grantResult : grantResults) {
            if (grantResult == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }
}
