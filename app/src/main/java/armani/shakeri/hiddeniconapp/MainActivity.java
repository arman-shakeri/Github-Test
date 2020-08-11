package armani.shakeri.hiddeniconapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int REQUESTCODE_WRITEEXTERNAL = 526;
    //TextView txt;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    ArrayList<String> nameList;
    MyAapter myAapter;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        /*txt = findViewById(R.id.txt_mainActivity);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED
                    || checkSelfPermission(Manifest.permission.PROCESS_OUTGOING_CALLS) != PackageManager.PERMISSION_GRANTED){

                requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE,Manifest.permission.PROCESS_OUTGOING_CALLS},REQUESTCODE_WRITEEXTERNAL);


            }
        }

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // setIconHidden();
                Intent i = getPackageManager().getLaunchIntentForPackage("armani.shakeri.spinningbottle");
                if(i !=null){

                    startActivity(i);
                }
            }
        });*/
        for (int i = 0; i < 20 ; i++) {

            nameList.add("name "+i);
        }
        myAapter           =new MyAapter(nameList);
        recyclerView.setAdapter(myAapter);

        swipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(this,R.color.colorPrimary),ContextCompat.getColor(this,R.color.colorAccent));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                nameList.clear();
                for (int i = 0; i <20 ; i++) {


                    int randumNum = random.nextInt(20);
                    nameList.add("name "+randumNum);

                }
                //myAapter =new MyAapter(nameList);
                myAapter.notifyDataSetChanged();
               // swipeRefreshLayout.setRefreshing(false);

            }
        });
    }

    public void setupViews(){

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout_mainActivity);
        recyclerView       = findViewById(R.id.recyclerView_mainActivity);
        nameList           = new ArrayList<>();
        random             = new Random();


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setIconHidden() {

        PackageManager pm = getPackageManager();
        ComponentName cn  = new ComponentName(this,armani.shakeri.hiddeniconapp.MainActivity.class);
        pm.setComponentEnabledSetting(cn,PackageManager.COMPONENT_ENABLED_STATE_DISABLED,PackageManager.DONT_KILL_APP);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUESTCODE_WRITEEXTERNAL) {

            boolean allPermissionsGranted = false;

            for (int i = 0; i < grantResults.length; i++) {

                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {

                    allPermissionsGranted = true;

                } else {

                    allPermissionsGranted = false;
                    break;

                }

            }
            if (allPermissionsGranted) {

                Toast.makeText(MainActivity.this, "مجوزها تایید شدند", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(MainActivity.this, "مجوزها تایید نشدند", Toast.LENGTH_SHORT).show();

            }
        }
}

}
