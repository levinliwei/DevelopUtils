package com.levin.developutils.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 *  @Description   判断网络工具类
 *  @Date   2017/9/26
 */
public class ConnectionUtil {

    /**
     *  @Description   位置类型
     *  @Date   2017/9/26
     */
    public static final String NETWORK_TYPE_NA = "Unknown";
    /**
     *  @Description   wifi连接
     *  @Date   2017/9/26
     */
    public static final String NETWORK_TYPE_WIFI = "Wifi";

    /**
     *  @Description   网络是否连接
     *  @Date   2017/9/26
     */
    public static boolean isConnectedToNetwork(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    /**
     *  @Description   获取联网类型
     *  @Date   2017/9/26
     */
    public static String getNetWorkTypeName(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                return NETWORK_TYPE_WIFI;
            }
            return activeNetwork.getSubtypeName();
        }
        return NETWORK_TYPE_NA;
    }

    /**
     *  @Description   获取provider
     *  @Date   2017/9/26
     */
    public static String getProvider(Context context) {
        TelephonyManager manager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        String carrierName = manager.getNetworkOperatorName();
        return carrierName;
    }

    /**
     * 判断WIFI网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isWifiConnected(Context context) {
        if (context != null) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork != null
                    && activeNetwork.isConnectedOrConnecting()
                    && activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
        }
        return false;
    }
}
