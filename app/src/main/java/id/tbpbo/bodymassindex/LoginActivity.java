package id.tbpbo.bodymassindex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Space;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.androidexception.andexalertdialog.AndExAlertDialog;
import ir.androidexception.andexalertdialog.AndExAlertDialogListener;
import ir.androidexception.andexalertdialog.Font;
import ir.androidexception.andexalertdialog.InputType;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.flatdialoglibrary.dialog.FlatDialog;

import id.tbpbo.bodymassindex.Model.Login.LoginModel;
import id.tbpbo.bodymassindex.Network.RestServiceClass;
import id.tbpbo.bodymassindex.Network.RestServiceInterface;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    View bg;
    @BindView(R.id.unameL)
    EditText uname;

    @BindView(R.id.pnameL)
    EditText pname;
    private RestServiceInterface restServiceInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        restServiceInterface    = RestServiceClass.getClient().create(RestServiceInterface.class);
        // ADD SPACE TOP DRAWER ON LOLLIPOP AND UP
        ButterKnife.bind(this);
        bg = findViewById(R.id.loginsignup19_bg);

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.loginsignup_menu, menu);
//        return true;
//    }

    public void attemptLogin(String email, String password, Context context){
        Call<LoginModel> calls = restServiceInterface.loginApi(email, password);
        try {
            calls.enqueue(new Callback<LoginModel>() {
                @Override
                public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                    LoginModel model = response.body();
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                    // set title dialog
                    alertDialogBuilder.setTitle("Keluar dari aplikasi?");

                    // set pesan dari dialog
                    alertDialogBuilder
                            .setMessage("Klik Ya untuk keluar!")
                            .setIcon(R.mipmap.ic_launcher)
                            .setCancelable(false)
                            .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    // jika tombol diklik, maka akan menutup activity ini
                                    finish();
                                }
                            })
                            .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // jika tombol ini diklik, akan menutup dialog
                                    // dan tidak terjadi apa2
                                    dialog.cancel();
                                }
                            });

                    // membuat alert dialog dari builder
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // menampilkan alert dialog
                    alertDialog.show();
                }

                @Override
                public void onFailure(Call<LoginModel> call, Throwable t) {

                }
            });
        }catch (Exception e ){

        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
//            case R.id.btnCreateAccount:
//                Toast.makeText(this, "Create An Account button clicked!", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.btnSignIn:
                Toast.makeText(this, "Button Signin clicked!", Toast.LENGTH_SHORT).show();
                attemptLogin(uname.getText().toString(),pname.getText().toString(),getApplicationContext());
                break;
            case R.id.txtSignUp:
                Intent i = new Intent(this,RegisterActivity.class);
                startActivity(i);
                break;
            case R.id.btnAsGuest:
                Intent a = new Intent(this,NameActivity.class);
                startActivity(a);
                break;
            default:
                break;
        }
    }
}
