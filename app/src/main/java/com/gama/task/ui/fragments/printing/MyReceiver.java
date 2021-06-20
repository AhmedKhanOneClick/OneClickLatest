package com.gama.task.ui.fragments.printing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.surepay.integratemada.MadaResponseModel;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String result = intent.getExtras().getString("RESULT");
        Log.e("RESULT","==================> "+result);
        com.surepay.integratemada.MadaResponseModel topic = new Gson().fromJson(result, MadaResponseModel.class);
        if (topic!=null)
        Toast.makeText(context, "--> "+topic.getAMOUNT(), Toast.LENGTH_SHORT).show();

    }
}
