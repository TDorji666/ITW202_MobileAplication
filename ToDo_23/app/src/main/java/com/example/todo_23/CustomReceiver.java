package com.example.todo_23;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        String intentAction=intent.getAction();
        if (intentAction!=null){
            String toastMessage="Unknown intent Action";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                toastMessage="Power Connected";
                        break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage="Power Disconnected";
                    break;
                case Intent.ACTION_CUSTOM_BROADCAST:
                    toastMessage="Custom Broadcast Received";
                            break;

            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT ).show();
        }


    }
}