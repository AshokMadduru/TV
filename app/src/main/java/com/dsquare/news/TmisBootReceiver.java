package com.dsquare.news;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TmisBootReceiver extends BroadcastReceiver {
    public TmisBootReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("on receive","yes");

        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
       // throw new UnsupportedOperationException("Not yet implemented");
        Intent intentt = new Intent(context.getApplicationContext(),News.class);
        intentt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intentt);
    }
}
