package id.tbpbo.bodymassindex;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import id.tbpbo.bodymassindex.Constanta.Constant;
import id.tbpbo.bodymassindex.Utils.DatabaseHandler;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;  //2 Seconds
    InternalStorage storage = new InternalStorage();
    SharedPreferences mSettings;
    private DatabaseHandler db;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
//        db = new DatabaseHandler(this);
        mSettings = getSharedPreferences("Storage", Context.MODE_PRIVATE);
        if(mSettings.getString(Constant.name_shared,null) !=null && mSettings.getString(Constant.gender_shared,null) !=null
        && mSettings.getString(Constant.umur_shared,null) !=null){
            Intent i = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(i);
            finish();
        }else{
            Log.d("CHECK", "onCreate: Name");
            Intent i = new Intent(SplashScreen.this, LoginActivity.class);
            startActivity(i);
            finish();
//            if(mSettings.getBoolean(Constant.walk_shared,false)==false){
//                Log.d("CHECK", "onCreate: Walktrouh");
//                Intent i = new Intent(SplashScreen.this, WalkthroughStyle1Activity.class);
//                startActivity(i);
//                finish();
//            }else{
//                Log.d("CHECK", "onCreate: Name");
//                Intent i = new Intent(SplashScreen.this, LoginActivity.class);
//                startActivity(i);
//            }
//            Log.d("ONSIS", "onCreate: "+db.getAllRecord().isEmpty());
        }



    }
}