package com.kinhub.iap;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.annotation.NonNull;

import java.util.List;

public class IapManager {

    private static final int ADDRESS_LENGTH = 56;
    private static final String ACTION = "com.kinhub.kinhub.PURCHASE";
    private static final String PUBLIC_ADDRESS = "publicAddress";

    private String publicAddress;

    public IapManager(@NonNull String publicAddress) {
        this.publicAddress = publicAddress;
    }

    public void start(Context context) throws IapInitException {
        if (!isValidPublicAddress(publicAddress)) {
            throw new IapInitException();
        }
        Intent intent = getIntent(publicAddress);
        if (!isSafeIntent(context, intent)){
            DownloadKinhubDialog dialog = new DownloadKinhubDialog(context);
            dialog.show();
        } else {
            context.startActivity(intent);
        }
    }

    private static boolean isValidPublicAddress(@NonNull String address) {
        return address.length() == ADDRESS_LENGTH;
    }

    private static Intent getIntent(@NonNull String publicAddress) {
        Intent intent = new Intent();
        intent.setAction(ACTION);
        intent.putExtra(PUBLIC_ADDRESS, publicAddress);
        return intent;
    }

    private static boolean isSafeIntent(@NonNull Context context, @NonNull Intent intent){
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        return activities.size() > 0;
    }

}
