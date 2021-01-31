package id.tbpbo.bodymassindex;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;  //2 Seconds
    InternalStorage storage = new InternalStorage();
    SharedPreferences mSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mSettings = getSharedPreferences("Storage", Context.MODE_PRIVATE);
        if(mSettings.getString(Constant.name_shared,null) !=null && mSettings.getString(Constant.gender_shared,null) !=null
        && mSettings.getString(Constant.umur_shared,null) !=null){
            Intent i = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(i);
        }else{
            Intent i = new Intent(SplashScreen.this, NameActivity.class);
            startActivity(i);
        }



    }
}