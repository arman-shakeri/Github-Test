package armani.shakeri.hiddeniconapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class CallReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if(state ==null){

            String number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            if(number.equals("09364525113")){
                Intent i = new Intent(context,MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                context.startActivity(i);
            }
        }else if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){

            String number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Toast.makeText(context, "شماره "+number+" در حال تماس است", Toast.LENGTH_SHORT).show();
        }
    }

}
