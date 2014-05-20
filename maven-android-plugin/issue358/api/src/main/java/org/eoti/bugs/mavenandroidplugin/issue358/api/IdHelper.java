package org.eoti.bugs.mavenandroidplugin.issue358.api;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;

public class IdHelper
{
    public String getId(Context context) throws Exception
    {
        Info adInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
        return adInfo.getId();
    }
}
