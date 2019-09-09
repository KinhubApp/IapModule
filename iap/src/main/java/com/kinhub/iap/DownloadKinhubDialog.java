package com.kinhub.iap;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

public class DownloadKinhubDialog extends AlertDialog {

    private static String KINHUB_URL = "https://play.google.com/store/apps/details?id=com.kinhub.kinhub";

    public DownloadKinhubDialog(final Context context){
        super(context);
        View dialogView = View.inflate(context, R.layout.download_kinhub_dialog, null);
        setView(dialogView);
        TextView download = dialogView.findViewById(R.id.download);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = KINHUB_URL;
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                context.startActivity(browserIntent);
                dismiss();
            }
        });
    }

}
